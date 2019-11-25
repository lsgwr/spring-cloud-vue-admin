export default {
  state: {
    navTree: [] // 导航菜单树
  },
  getters: {},
  mutations: {
    // 设置导航菜单树
    setNavTree (state, navTree) {
      state.navTree = navTree
    }
  }
}
