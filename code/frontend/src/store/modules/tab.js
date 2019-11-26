/***********************************************************
 * @Description : 标签页管理功能
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/26 23:59
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
export default {
  state: {
    // 主入口标签
    mainTabs: [],
    // 当前页标签
    mainTabsActiveName: ''
  },
  mutations: {
    updateMainTabs (state, tabs) {
      state.mainTabs = tabs
    },
    updateMainTabsActiveName (state, name) {
      state.mainTabsActiveName = name
    }
  }
}
