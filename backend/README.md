# 项目预准备

## 1.启动zipkin服务
```
 docker run -d -p 9411:9411 openzipkin/zipkin
```


## 2.启动rabbitmq服务
>docker run -d --hostname my-rabbit --name rabbit -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin -p 15672:15672 -p 5672:5672 -p 25672:25672 -p 61613:61613 -p 1883:1883 rabbitmq:management

简化命令是：

```
docker run -d -p 5672:5672 -p 15672:15672 rabbitmq:management
```

15672：控制台端口号

5672：应用访问端口号

## 3.启动mysql服务

> docker run --name imooc-mysql -v $PWD/conf:/etc/mysql/conf.d -v $PWD/data:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=Huawei@123 -e MYSQL_DATABASE=imooc -d mysql:5.7.15

