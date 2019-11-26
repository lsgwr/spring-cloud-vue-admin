<template>
  <div class="menu-bar-container">
    <!--  logo  -->
    <div class="logo" :style="{'background': themeColor}" :class="collapse?'menu-bar-collapse-width':'menu-bar-width'" @click="$router.push('/')">
      <img v-if="collapse" src="../assets/logo.png" alt=""/>
      <div>{{ collapse?'':appName }}</div>
    </div>
    <!-- 导航菜单 -->
    <el-menu ref="navmenu" default-active="1" :class="collapse?'menu-bar-collapse-width':'menu-bar-width'"
             :collapse="collapse" :collapse-transition="false" :unique-opened="true  "
             @open="handleopen" @close="handleclose" @select="handleselect">
      <!-- 导航菜单树组件，动态加载菜单 -->
      <MenuTree v-for="item in navTree" :key="item.id" :menu="item"></MenuTree>
    </el-menu>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import MenuTree from '../components/MenuTree/Index'

export default {
  name: 'NavBar',
  components: { MenuTree },
  methods: {
    handleopen () {
      console.log('handleopen')
    },
    handleclose () {
      console.log('handleclose')
    },
    handleselect (a, b) {
      console.log('handleselect')
    }
  },
  computed: {
    ...mapState({
      appName: state => state.app.appName,
      themeColor: state => state.app.themeColor,
      collapse: state => state.app.collapse,
      navTree: state => state.menu.navTree
    })
  }
}
</script>

<style lang="scss" scoped>
  .menu-bar-container {
    position: fixed;
    top: 0px;
    left: 0;
    bottom: 0;
    z-index: 1020;

    .logo {
      position: absolute;
      top: 0px;
      height: 60px;
      line-height: 60px;
      background: #545c64;
      cursor: pointer;

      img {
        width: 40px;
        height: 40px;
        border-radius: 0px;
        margin: 10px 10px 10px 10px;
        float: left;
      }

      div {
        font-size: 25px;
        color: white;
        text-align: left;
        padding-left: 20px;
      }
    }

    .menu-bar-width {
      width: 200px;
    }

    .menu-bar-collapse-width {
      width: 65px
    }
  }
</style>
