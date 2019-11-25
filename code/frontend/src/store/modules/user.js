export default {
  state: {
    perms: [] // 用户权限标识集合，记录可以访问哪些路由
  },
  getters: {},
  mutations: {
    setPerms (state, perms) {
      // 设置用户权限标识集合
      state.perms = perms
    }
  }
}
