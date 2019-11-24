<template>
  <div class="container">
    <!--  头部区域  -->
    <HeadBar></HeadBar>
    <!--  左侧导航栏  -->
    <NavBar></NavBar>
    <!--  中间主内容区  -->
    <MainContent></MainContent>
  </div>
</template>

<script>
// @ is an alias to /src

import HeadBar from './HeadBar'
import NavBar from './NavBar'
import MainContent from './MainContent'

export default {
  name: 'home',
  components: {
    MainContent,
    NavBar,
    HeadBar
  }
}
</script>

<style lang="scss" scoped>
  .container {
    position: absolute;
    top: 0px;
    left: 0px;
    right: 0px;
    bottom: 0px;
  }
</style>
