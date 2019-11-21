import Vue from 'vue'
import App from './App.vue'
import router from './router'
import api from './http'
import global from './utils/global'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

import Router from 'vue-router'

const originalPush = Router.prototype.push
Router.prototype.push = function push (location) {
  return originalPush.call(this, location).catch(err => err)
}

Vue.config.productionTip = false

Vue.use(api) // 注册使用API模块

Vue.use(ElementUI) // 注册使用ElementUI模块

Vue.prototype.global = global // 挂载全局配置模块

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
