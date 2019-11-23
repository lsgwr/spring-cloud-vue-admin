<template>
  <div class="page">
    <el-form :model="loginForm" :rules="fieldRules" ref="loginForm" label-position="left" label-width="0px" class="login-container">
      <span class="tool-bar"></span>
      <h2 class="title">系统登录</h2>
      <el-form-item prop="account">
        <el-input type="text" v-model="loginForm.account" auto-complete="false" placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input type="password" v-model="loginForm.password" auto-complete="false" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item>
       <el-row :gutter="10">
         <el-col :span="13">
           <el-form-item prop="captcha">
             <el-input type="text" v-model="loginForm.captcha" auto-complete="false" placeholder="验证码，单击图片刷新" style="width: 100%"></el-input>
           </el-form-item>
         </el-col>
         <el-col class="line" :span="11">
           <el-form-item>
             <img :src="loginForm.src" style="width: 100%" class="pointer" @click="refreshCaptcha()" alt="">
           </el-form-item>
         </el-col>
       </el-row>
      </el-form-item>
      <el-form-item style="width: 100%;">
        <!-- click.native.prevent阻止默认事件很重要！ -->
        <el-button type="primary" style="width: 48%" @click.native.prevent="reset">重置</el-button>
        <el-button type="primary" style="width: 48%" @click.native.prevent="login" :loading="loading">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import Cookies from 'js-cookie'
import router from '../router'

export default {
  name: 'Login',
  data () {
    return {
      loginForm: {
        account: 'admin',
        password: 'admin',
        captcha: '',
        src: ''
      },
      fieldRules: {
        account: [
          { required: true, message: '请输入账号', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' }
        ]
      },
      checked: true,
      // 加载中的标志
      loading: false
    }
  },
  methods: {
    login () {
      const data = {}
      data.account = 'admin'
      data.captcha = 'an475'
      data.password = 'admin'
      this.$api.login.login(data).then(function (res) {
        alert(res.data.token)
        Cookies.set('token', res.data.token)
        router.push('/')
      }).catch(function (error) {
        alert(error)
      })
    },
    refreshCaptcha () {
      // Todo:验证码刷新
      this.loginForm.src = this.global.baseUrl + '/captcha.jpg?t=' + new Date().getTime()
    },
    reset () {
      this.$refs.loginForm.resetFields()
    }
  },
  mounted () {
    this.refreshCaptcha()
  }
}
</script>

<style lang="scss" scoped>
  .login-container {
    -webkit-border-radius: 5px;
    border-radius: 5px;
    -moz-border-radius: 5px;
    background-clip: padding-box;
    margin: 100px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;

    .title {
      margin: 0px auto 30px auto;
      text-align: center;
      color: #505458;
    }
  }
</style>
