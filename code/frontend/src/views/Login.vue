<template>
  <div class="page">
    <h2>Login Page</h2>
    <el-button type="primary" @click="login()">登录</el-button>
  </div>
</template>

<script>
export default {
  name: 'Login',
  methods: {
    login () {
      this.$router.push('/')
    }
  }
}
</script>

<style scoped>

</style>
