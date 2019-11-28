/***********************************************************
 * @Description : DAO切面，插入创建人，创建时间，修改人，修改时间
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/29 0:05
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.admin.aspect;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.huawei.l00379880.admin.security.SecurityUtils;
import com.huawei.l00379880.common.utils.StringUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Configuration
public class MapperAspect {
    private static final String CREATE_BY = "createBy";
    private static final String CREATE_TIME = "createTime";
    private static final String LAST_UPDATE_BY = "lastUpdateBy";
    private static final String LAST_UPDATE_TIME = "lastUpdateTime";

    @Pointcut("execution(* com.huawei.l00379880.*.mapper.*.update*(..))")
    public void daoUpdate() {
    }

    @Pointcut("execution(* com.huawei.l00379880.*.mapper.*.insert*(..))")
    public void daoCreate() {
    }

    @Around("daoUpdate()")
    public Object doAroundUpdate(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return pjp.proceed();
        }
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader("token");
        String username = getUserName();
        if (token != null && username != null) {
            Object[] objects = pjp.getArgs();
            if (objects != null && objects.length > 0) {
                for (Object arg : objects) {
                    BeanUtils.setProperty(arg, LAST_UPDATE_BY, username);
                    BeanUtils.setProperty(arg, LAST_UPDATE_TIME, new Date());
                }
            }
        }
        Object object = pjp.proceed();
        return object;

    }

    @Around("daoCreate()")
    public Object doAroundCreate(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return pjp.proceed();
        }
        Object[] objects = pjp.getArgs();
        if (objects != null && objects.length > 0) {
            for (Object arg : objects) {
                String username = getUserName();
                if (username != null) {
                    if (StringUtils.isBlank(BeanUtils.getProperty(arg, CREATE_BY))) {
                        BeanUtils.setProperty(arg, CREATE_BY, username);
                    }
                    if (StringUtils.isBlank(BeanUtils.getProperty(arg, CREATE_TIME))) {
                        BeanUtils.setProperty(arg, CREATE_TIME, new Date());
                    }
                }
            }
        }
        Object object = pjp.proceed();
        return object;
    }

    private String getUserName() {
        return SecurityUtils.getUsername();
    }
}

