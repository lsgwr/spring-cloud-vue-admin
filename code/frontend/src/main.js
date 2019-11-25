import Vue from 'vue'
import App from './App.vue'
import router from './router'
import api from './http'
import i18n from './i18n'
import global from './utils/global'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import 'font-awesome/css/font-awesome.min.css'

import Router from 'vue-router'

// 避免$route.push的时候没有接住Promise表达式而报错
const originalPush = Router.prototype.push
Router.prototype.push = function push (location) {
  return originalPush.call(this, location).catch(err => err)
}

Vue.config.productionTip = false

Vue.use(api) // 注册使用API模块

Vue.use(ElementUI) // 注册使用ElementUI模块

Vue.prototype.global = global // 挂载全局配置模块

new Vue({
  i18n,
  router,
  store,
  render: h => h(App)
}).$mount('#app')
