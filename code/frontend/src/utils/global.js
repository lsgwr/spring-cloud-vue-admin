/**
 * 全局常量和方法封装模块
 * 通过原型prototype挂载到Vue属性
 * 通过this.Global调用
 */

// 后台服务器的接口基地址
export const baseUrl = '/api'
// 图床的基地址
export const picBaseUrl = 'https://i.loli.net'

export default {
  baseUrl,
  picBaseUrl
}
