import api from './api' // 导入所有接口

const install = Vue => {
  if (install.installed) {
    return
  }
  install.installed = true
  Object.defineProperties(Vue.prototype, {
    // 注意，此处挂载在Vue原型的$api对象上
    $api: {
      get () {
        return api
      }
    }
  })
}
export default install
