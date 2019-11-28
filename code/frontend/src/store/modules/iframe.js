/***********************************************************
 * @Description : 嵌套页面
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/28 7:47
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
export default {
  state: {
    iframeUrl: [], // 当前嵌套页面路由路径
    iframeUrls: [] // 所有嵌套页面路由路径访问URL
  },
  getters: {},
  mutations: {
    setIFrameUrl (state, iframeUrl) { // 设置iframeUrl
      state.iframeUrl = iframeUrl
    },
    addIFrameUrl (state, iframeUrl) { // iframeUrls
      state.iframeUrls.push(iframeUrl)
    }
  },
  actions: {}
}
