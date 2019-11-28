import store from '../store'

/**
 * 判断当前用户是否有操作权限。
 * 原理：根据传入的权限标识，查看总的权限列表perms中是否有指定的权限集合
 * @param perms 用户传入的权限集合
 * @returns {boolean} 用户是否有权限
 */
export function hasPermission (perms) {
  let hasPermission = false
  let permissions = store.state.user.perms
  let len = permissions.length
  for (let i = 0; i < len; i++) {
    if (permissions[i] === perms) {
      hasPermission = true
      break
    }
  }
  return hasPermission
}
