import Vue from 'vue'
import Vuex from 'vuex'

// 引入子模块
import app from './modules/app'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {},
  mutations: {},
  actions: {},
  modules: {
    app: app // 键值相同时应该可以缩写成单个的app,这里就不省略了
  }
})
export default store
