<template>
  <div class="headbar" :style="{'background': themeColor}" :class="collapse?'position-collapse-left':'position-left'">
    <!-- 导航收缩 -->
    <span class="hamburg">
      <el-menu :background-color="themeColor" text-color="#fff" :active-text-color="themeColor" mode="horizontal">
        <el-menu-item index="1" @click="onCollapse"><Hamburger :isActive="collapse"></Hamburger></el-menu-item>
      </el-menu>
    </span>
    <!-- 工具栏 -->
    <span class="toolbar">
      <el-menu :background-color="themeColor" :text-color="themeColor" :active-text-color="themeColor" mode="horizontal">
        <!-- 主题切换 -->
        <el-menu-item index="1">
          <ThemePicker class="theme-picker" :default="themeColor" @onThemeChange="onThemeChange"></ThemePicker>
        </el-menu-item>
        <el-menu-item index="2">
          <span class="user-info">
            <img :src="user.avatar" alt=""/>
            {{ user.name }}
          </span>
        </el-menu-item>
      </el-menu>
    </span>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import Hamburger from '../components/Hamburger/Index'
import ThemePicker from '../components/ThemePicker/Index'

export default {
  name: 'HeadBar',
  components: { ThemePicker, Hamburger },
  data () {
    return {
      user: {
        name: 'Louis',
        avatar: '',
        role: '超级管理员',
        registerInfo: '注册时间：2018-12-20'
      },
      activeIndex: '1',
      langVisible: false
    }
  },
  methods: {
    selectNavBar (key, keyPath) {
      console.log(key, keyPath)
    },
    // 折叠导航栏
    onCollapse () {
      this.$store.commit('onCollapse')
    },
    // 切换主题
    onThemeChange (themeColor) {
      this.$store.commit('setThemeColor', themeColor)
    }
  },
  mounted () {
    let user = sessionStorage.getItem('user')
    if (user) {
      this.user.name = user
      this.user.avatar = require('../assets/user.png')
    }
  },
  computed: {
    ...mapState({
      themeColor: state => state.app.themeColor,
      collapse: state => state.app.collapse
    })
  }
}
</script>

<style lang="scss" scoped>
  .headbar {
    position: fixed;
    top: 0;
    right: 0;
    z-index: 1030;
    height: 60px;
    line-height: 60px;
    border-color: rgba(180, 190, 190, 0.8);
    border-left-width: 1px;
    border-left-style: solid;
  }

  .hamburg, .navbar {
    float: left;
  }

  .toolbar {
    float: right;
  }

  .user-info {
    font-size: 20px;
    color: #fff;
    cursor: pointer;

    img {
      width: 40px;
      height: 40px;
      border-radius: 10px;
      margin: 10px 0px 10px 10px;
      float: right;
    }
  }

  .position-left {
    left: 200px;
  }

  .position-collapse-left {
    left: 65px;
  }
</style>
