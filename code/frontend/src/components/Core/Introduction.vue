<template>
  <div class="page-container" style="width:99%;margin-top:15px;">
    <el-carousel :interval="3000" type="card" height="450px" class="carousel">
      <el-carousel-item class="carousel-item-intro">
        <h2>项目介绍</h2>
        <ul>
          <li>基于Spring Cloud和Vue最近版本的权限管理系统</li>
          <li>Spring Security+JWT+Swagger+Vue+ElementUI最新版</li>
        </ul>
        <div><img src="@/assets/logo.png" style="width:120px;height:120px;padding-top:15px;"/></div>
      </el-carousel-item>
      <el-carousel-item class="carousel-item-func">
        <h2>功能计划(✔ 表示已完成，✘表示正在开发中)</h2>
        <ul>
          <li>✔ 系统登录：系统用户登录，系统登录认证（jwt token方式）</li>
          <li>✔ 用户管理：新建用户，修改用户，删除用户，查询用户</li>
          <li>✔ 机构管理：新建机构，修改机构，删除机构，查询机构</li>
          <li>✔ 角色管理：新建角色，修改角色，删除角色，查询角色</li>
          <li>✔ 菜单管理：新建菜单，修改菜单，删除菜单，查询菜单</li>
          <li>✔ 系统日志：记录用户操作日志，查看系统执行日志记录</li>
          <li>✔ 数据监控：定制Druid信息，提供简洁有效的SQL监控</li>
          <li>✔ 聚合文档：Swagger在线文档，提供简洁美观的API文档</li>
          <li>✔ 主题切换：支持主题切换，自定主题颜色，一键换肤</li>
          <li>✘ 服务治理：集成Spring Cloud，实现全方位服务治理</li>
          <li>✘ 服务监控：集成Spring Boot Admin，实现微服务监控</li>
          <li>......</li>
        </ul>
      </el-carousel-item>
      <el-carousel-item class="carousel-item-env">
        <h2>技术选型</h2>
        <ul>
          <li>服务开发和治理：Spring Boot 2.1.1.RELEASE + Spring Cloud Finchley.RELEASE</li>
          <li>数据库操作与监控：MyBatis 3.4.6 + Druid 1.1.10</li>
          <li>安全框架：Spring Security 5.1.2 + JWT 0.9.1</li>
          <li>接口文档：Swagger 2.9.2</li>
        </ul>
        <ul>
          <li>前端框架：Vue.js 2.6.10</li>
          <li>UI库：ElementUI 2.13.0</li>
          <li>状态和路由管理：Vuex 3.0.1 + Vue Router 3.1.3</li>
          <li>脚手架：Vue Cli 4.0.5</li>
          <li>后台交互：axios 0.19.0</li>
          <li>......</li>
        </ul>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  name: 'Introduction',
  components: {},
  methods: {}
}
</script>

<style>
  .carousel {
    padding-left: 20px;
    padding-right: 20px;
    margin-right: 20px;
  }

  .carousel h2 {
    color: #475669;
    font-size: 22px;
    opacity: 1.75;
    line-height: 100px;
    margin: 0;
  }

  .carousel ul {
    color: #475669;
    font-size: 15px;
    opacity: 1.75;
    line-height: 40px;
    margin: 0;
  }

  .carousel-item-intro h2 {
    color: #ffffff;
    font-size: 22px;
    opacity: 1.75;
    line-height: 80px;
    margin: 0;
  }

  .carousel-item-intro ul {
    color: #ffffff;
    font-size: 15px;
    opacity: 1.75;
    line-height: 65px;
    padding: 5px;
    margin: 0;
  }

  .carousel-item-func h2 {
    color: #3f393b;
    font-size: 22px;
    opacity: 1.75;
    line-height: 50px;
    margin: 0;
  }

  .carousel-item-func ul {
    color: #3f393b;
    font-size: 15px;
    opacity: 1.75;
    line-height: 30px;
    text-align: left;
    padding-left: 90px;
    margin: 0;
  }

  .carousel-item-env h2 {
    color: #475669;
    font-size: 22px;
    opacity: 1.75;
    line-height: 50px;
    margin: 0;
  }

  .carousel-item-env ul {
    color: #475669;
    font-size: 15px;
    opacity: 1.75;
    line-height: 35px;
    text-align: left;
    padding-left: 110px;
    margin: 0;
  }

  .carousel-item-intro {
    background-color: #19aaaf73;
    -webkit-border-radius: 25px;
    border-radius: 25px;
    -moz-border-radius: 15px;
    background-clip: padding-box;
    box-shadow: 0 0 25px #a3b3b965;
  }

  .carousel-item-func {
    background-color: #19aaaf73;
    -webkit-border-radius: 25px;
    border-radius: 25px;
    -moz-border-radius: 15px;
    background-clip: padding-box;
    box-shadow: 0 0 25px #a3b3b965;
  }

  .carousel-item-env {
    background-color: #19aaaf73;
    -webkit-border-radius: 25px;
    border-radius: 25px;
    -moz-border-radius: 15px;
    background-clip: padding-box;
    box-shadow: 0 0 25px #a3b3b965;
  }

  .carousel-item-intro {
    background-color: #b95e5e;
  }

  .carousel-item-func {
    background-color: #52c578;
  }

  .carousel-item-env {
    background-color: #41a7b9;
  }
</style>
