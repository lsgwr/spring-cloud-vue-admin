<template>
  <!-- 解决栈溢出的问题,element ui的官方bug,https://github.com/ElemeFE/element/issues/17391  -->
  <!-- 和 https://github.com/ElemeFE/element/pull/17133 等新版本发布去掉popper-append-to-body即可 -->
  <el-submenu v-if="menu.children && menu.children.length >= 1" :index="'' + menu.id" :popper-append-to-body="false">
    <template slot="title">
      <i :class="menu.icon"></i>
      <span slot="title">{{menu.name}}</span>
    </template>
    <MenuTree v-for="item in menu.children" :key="item.id" :menu="item"></MenuTree>
  </el-submenu>
  <el-menu-item v-else :index="'' + menu.id" @click="handleRoute(menu)">
    <i :class="menu.icon"></i>
    <span slot="title">{{menu.name}}</span>
  </el-menu-item>
</template>

<script>
import { getIFramePath } from '../../utils/iframe'

export default {
  name: 'MenuTree',
  props: {
    menu: {
      type: Object,
      required: true
    }
  },
  methods: {
    handleRoute (menu) {
      // 如果是嵌套页面。转换为iframe的path
      let path = getIFramePath(menu.url)
      if (!path) { // iframe的路由没有，说明是普通路由
        path = menu.url
      }
      // 通过菜单URL跳转至指定路由
      this.$router.push('/' + path)
    }
  }
}
</script>

<style scoped lang="scss">

</style>
