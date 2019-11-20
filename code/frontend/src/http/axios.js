/**
 * axios拦截器，可以进行请求拦截和相应拦截，在发送请求和相应请求时执行一些操作
 */
import axios from 'axios'
import config from './config'
import Cookies from 'js-cookie'
import router from '../router'

export default function $axios (options) {
  // Promise是异步编程的一种解决方案, 有了Promise对象，就可以将异步操作以同步操作的流程表达出来，避免了层层嵌套的回调函数(例如ajax调用)
  return new Promise((resolve, reject) => {
    const instance = axios.create({
      baseUrl: config.baseUrl,
      headers: config.headers,
      timeout: config.timeout,
      withCredentials: config.withCredentials
    })

    // request请求拦截器
    instance.interceptors.request.use(
      config => {
        let token = Cookies.get('token')
        if (token) { // 如果Cookie里有token就在发送请求的时候带上。
          config.headers.token = token
        } else { // Cookie中没有token，说明用户还没登录，跳转到登录页
          router.push('/login') // 实际可以用this.$router.push('router中的路径')来进行跳转，因为在main.js中已经全局注册了router
        }
        return config
      },
      error => {
        return Promise.reject(error)
      }
    )

    // response响应拦截器
    instance.interceptors.response.use(
      response => {
        return response.data
      },
      error => {
        return Promise.reject(error)
      }
    )

    // 请求处理
    instance(options).then(res => {
      resolve(res)
      return false
    }).catch(error => {
      reject(error)
    })
  })
}
