# 讲解zuul网关基本使用


##	1、加入依赖


##	2、启动类加入注解 @EnableZuulProxy
###		默认集成断路器  @EnableCircuitBreaker

###		默认访问规则  
			http://gateway:port/service-id/**

				例子：默认 /order-service/api/v1/order/save?user_id=2&product_id=1
					 自定义 /xdclass_order/api/v1/order/save?user_id=2&product_id=1

###		自定义路由转发：
			zuul:
			 routes:
			 	order-service: /apigateway/**


###		环境隔离配置：
			需求 ：不想让默认的服务对外暴露接口
				/order-service/api/v1/order/save

			配置：
			zuul: 
				ignored-patterns:
					- /*-service/api/v1/order/save









## 3、高级篇幅之Zuul常用问题分析和网关过滤器原理分析

	> 简介：讲解Zuul网关原理和过滤器生命周期，
	 
###	1、路由名称定义问题
		路由映射重复覆盖问题
	
###	2、Http请求头过滤问题

###	3、过滤器执行顺序问题 ，过滤器的order值越小，越先执行
	

###	4、共享RequestContext，上下文对象









## 4、自定义Zuul过滤器实现登录鉴权实战
	> 简介：自定义Zuul过滤器实现登录鉴权实战

###	1、新建一个filter包

###	2、新建一个类，实现ZuulFilter，重写里面的方法

###	3、在类顶部加注解，@Component,让Spring扫描

![Zuul过滤器原理](https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1543161712318&di=1fc69589627538e83ed663bdadb01cee&imgtype=0&src=http%3A%2F%2Fwww.uml.org.cn%2Fwfw%2Fimages%2F2018030125.png)







## 5、高级篇幅之高并发情况下接口限流特技	
	简介：谷歌guava框架介绍，网关限流使用

###	1、nginx层限流

###	2、网关层限流





## 6、Zuul微服务网关集群搭建
	简介：微服务网关Zull集群搭建

###	1、nginx+lvs+keepalive 
	https://www.cnblogs.com/liuyisai/p/5990645.html
