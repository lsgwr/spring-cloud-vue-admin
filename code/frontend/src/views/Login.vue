<template>
  <div class="page">
    <h2>Login Page</h2>
    <el-button type="primary" @click="login()">登录</el-button>
  </div>
</template>

<script>
import Cookies from 'js-cookie'
import router from '../router'

export default {
  name: 'Login',
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
    }
  }
}
</script>

<style scoped>

</style>
