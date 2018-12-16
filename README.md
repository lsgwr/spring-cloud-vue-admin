# spring-cloud-exam
[考试星](https://www.kaoshixing.com) 的SpringCloud实现，业余搞着玩地

## 目录说明
+ backend:后端实现，采用SpringCloud实现，其中SpringBoot版本是1.5.3，SpringCloud版本是Dalston.RELEASE
+ frontend:前端实现，采用了前后端分离的方式进行地开发，所以前端可以单独部署
  + admin: 管理界面，采用Vue+iVew实现，可以管理人员、试题和考试
  + home:  用户考试的界面，采用React+Ant实现，供学生登录和考试

## 功能说明

+ 支持的题型：单选、多选、判断
+ 角色：超级管理员、老师、学生
+ 学生可以在线考试和查看分数;老师可以增加题目和组织考试、添加学生；超级管理员可以增删学生和老师
