import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home'
import NotFound from '../views/404'
import Login from '../views/Login'
import store from '../store'
import api from '../http/api'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home,
    children: []
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/404',
    name: '404',
    component: NotFound
  }
]

let router = new VueRouter({
  routes
})

// 导航守卫:
// 1.判断用户是否过期
//   1.1 如果登录有效而且当前是登录页面，就直接跳转到首页
//   1.2 如果是非登录页而且页面会话过期，则跳到登录页
// 2.动态加载路由和菜单并跳转到目标页面
router.beforeEach((to, from, next) => {
  // 登录页面登录成功后，会把会话信息保存在会话，存在时间为会话声明周期，页面关闭即失效
  let userName = sessionStorage.getItem('user')
  if (to.path === '/login') {
    if (userName) {
      // 1.1 如果登录有效而且当前是登录页面，就直接跳转到首页
      next({ path: '/' })
    } else {
      // 正常登录即可
      next()
    }
  } else {
    if (!userName) {
      // 1.2 如果是非登录页而且页面会话过期，则跳到登录页
      next({ path: '/login' })
    } else {
      // 2.动态加载路由和菜单并跳转到目标页面
      addDynamicMenuAndRoutes(userName, to, from)
      next()
    }
  }
})

/**
 * 动态加载路由和菜单
 */
function addDynamicMenuAndRoutes (userName, to, from) {
  if (store.state.app.menuRouteLoaded) {
    // 如果路由已经存在就不重复加载了
    console.log('动态路由和菜单已经存在！')
    return
  }
  api.menu.findNavTree({ 'userName': userName })
    .then(res => {
      // 添加动态路由
      let dynamicRoutes = addDynamicRoutes(res.data)
      // Todo:下面这两行很精巧，重点理解下
      router.options.routes[0].children = router.options.routes[0].children.concat(dynamicRoutes)
      // 重新设置router，要不每次都addRoutes会导致路由重复添加
      router = new VueRouter({
        routes
      })
      store.commit('menuRouteLoaded', true)
      store.commit('setNavTree', res.data)
    })
    .then(res => {
      api.user.findPermissions({ 'name': userName })
        .then(res => {
          // 保存用户权限标识集合
          store.commit('setPerms', res.data)
        })
    })
    .catch(function (err) {
      console.log(err)
    })
}

/**
 * 添加动态(菜单)路由
 * @param {*} menuList 菜单列表
 * @param {*} routes 递归创建的动态(菜单)路由
 */
function addDynamicRoutes (menuList = [], routes = []) {
  let temp = []
  for (let i = 0; i < menuList.length; i++) {
    if (menuList[i].children && menuList[i].children.length >= 1) {
      temp = temp.concat(menuList[i].children)
    } else if (menuList[i].url && /\S/.test(menuList[i].url)) {
      menuList[i].url = menuList[i].url.replace(/^\//, '')
      // 创建路由配置
      const route = {
        path: menuList[i].url,
        component: null,
        name: menuList[i].name,
        meta: {
          icon: menuList[i].icon,
          index: menuList[i].id
        }
      }
      try {
        // 根据菜单URL动态加载vue组件，这里要求vue组件须按照url路径存储
        // 如url="sys/user"，则组件路径应是"@/components/sys/user.vue",否则组件加载不到,@标识src所在的路径
        let array = menuList[i].url.split('/')
        let url = ''
        for (let i = 0; i < array.length; i++) {
          url += array[i].substring(0, 1).toUpperCase() + array[i].substring(1) + '/'
        }
        url = url.substring(0, url.length - 1)
        route['component'] = resolve => require([`../components/${url}`], resolve)
      } catch (e) {
      }
      routes.push(route)
    }
  }
  if (temp.length >= 1) {
    addDynamicRoutes(temp, routes)
  } else {
    console.log('动态路由加载...')
    console.log(routes)
    console.log('动态路由加载完成.')
  }
  return routes
}

export default router
