import Vue from 'vue'
import Vuex from 'vuex'

// 引入子模块
import app from './modules/app'
import user from './modules/user'
import menu from './modules/menu'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {},
  mutations: {},
  actions: {},
  modules: {
    app: app, // 键值相同时应该可以缩写成单个的app,这里就不省略了
    user: user,
    menu: menu
  }
})
export default store
