/***********************************************************
 * @Description : 登录相关接口
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 23:14
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.admin.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.huawei.l00379880.admin.model.SysUser;
import com.huawei.l00379880.admin.security.JwtAuthenticationToken;
import com.huawei.l00379880.admin.security.SecurityUtils;
import com.huawei.l00379880.admin.service.SysUserService;
import com.huawei.l00379880.admin.vo.LoginBean;
import com.huawei.l00379880.common.utils.IOUtils;
import com.huawei.l00379880.common.utils.PasswordUtils;
import com.huawei.l00379880.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.Servlet;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@Api(tags = "登录和验证接口")
public class LoginController {
    @Autowired
    private Producer producer;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("captcha.jpg")
    @ApiOperation("获取验证码图片")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);
        // 保存验证码到session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    @PostMapping("/login")
    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws Exception {
        String username = loginBean.getAccount();
        String password = loginBean.getPassword();
        String captcha = loginBean.getCaptcha();
        // 从Session获取之前保存的验证码，跟前台传来的验证码进行匹配
        String kaptcha = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (kaptcha == null) {
            return HttpResult.error("验证码已失效");
        }
        if (!captcha.equalsIgnoreCase(kaptcha)) {
            return HttpResult.error("验证满不正确");
        }
        SysUser user = sysUserService.findByName(username);
        if (user == null) {
            return HttpResult.error("账号不存在");
        }
        if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
            return HttpResult.error("密码不正确");
        }
        // 账号锁定
        if (user.getStatus() == 0) {
            return HttpResult.error("账号已被锁定，请联系管理员");
        }
        // 系统登录认证
        JwtAuthenticationToken token = SecurityUtils.login(request, username, password, authenticationManager);
        return HttpResult.ok(token);
    }
}
