<template>
  <div class="headbar" :style="{'background': themeColor}" :class="collapse?'position-collapse-left':'position-left'">
    <!-- 导航收缩 -->
    <span class="hamburg">
      <el-menu :background-color="themeColor" text-color="#fff" :active-text-color="themeColor" mode="horizontal">
        <el-menu-item index="1" @click="onCollapse"><Hamburger :isActive="collapse"></Hamburger></el-menu-item>
      </el-menu>
    </span>
    <!--  导航菜单  -->
    <span class="navbar">
      <el-menu :default-active="activeIndex" :background-color="themeColor" text-color="#fff" active-text-color="#ffd04b" mode="horizontal"
               @select="selectNavBar()">
        <el-menu-item index="1" @click="$router.push('/')">{{ $t('common.home') }}</el-menu-item>
        <el-menu-item index="2" @click="openWindow('https://github.com/19920625lsg')">{{ $t('common.doc') }}</el-menu-item>
        <el-menu-item index="3" @click="openWindow('https://lsgwr.gitee.io')">{{ $t('common.doc') }}</el-menu-item>
      </el-menu>
    </span>
    <!--  工具栏  -->
    <span class="toolbar">
      <el-menu :background-color="themeColor" :text-color="themeColor" :active-text-color="themeColor" mode="horizontal">
        <!-- 主题切换 -->
        <el-menu-item index="1">
          <ThemePicker class="theme-picker" :default="themeColor" @onThemeChange="onThemeChange"></ThemePicker>
        </el-menu-item>
        <!--  语言切换  -->
        <el-menu-item index="2" v-popover:popover-lang>
          <li style="color: #fff;" class="fa fa-language fa-lg"></li>
          <el-popover ref="popover-lang" placement="bottom-start" trigger="click" v-model="langVisible">
            <div class="lang-item" @click="changeLanguage('zh_cn')">简体中文</div>
            <div class="lang-item" @click="changeLanguage('en_us')">English</div>
          </el-popover>
        </el-menu-item>
        <el-menu-item index="5">
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
    },
    // 打开新的url
    openWindow (url) {
      window.open(url)
    },
    // 语言切换
    changeLanguage (lang) {
      lang = lang === '' ? 'zh_cn' : lang // 为空就默认是中文
      this.$i18n.locale = lang
      this.langVisible = false
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

  .lang-item {
    font-size: 16px;
    padding-left: 8px;
    padding-top: 8px;
    padding-bottom: 8px;
    cursor: pointer;
  }

  .lang-item:hover {
    font-size: 18px;
    background: #b0d6ce4d;
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
