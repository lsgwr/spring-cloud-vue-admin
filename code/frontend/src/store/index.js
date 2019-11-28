import Vue from 'vue'
import Vuex from 'vuex'

// 引入子模块
import app from './modules/app'
import user from './modules/user'
import menu from './modules/menu'
import tab from './modules/tab'
import iframe from './modules/iframe'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {},
  mutations: {},
  actions: {},
  modules: {
    app: app, // 键值相同时应该可以缩写成单个的app,这里就不省略了
    iframe: iframe,
    user: user,
    tab: tab,
    menu: menu
  }
})
export default store
