/**
 * 所有接口的url
 */
const modules = ['config', 'dept', 'dict', 'log', 'login', 'loginlog', 'menu', 'role', 'user']
const REST_URLS = {
  // 1.系统配置接口
  ConfigSave: `/${modules[0]}/save`, // 保存
  ConfigDelete: `/${modules[0]}/delete`, // 删除
  ConfigPage: `/${modules[0]}/findPage`, // 分页查询

  // 2.机构管理模块
  DeptSave: `/${modules[1]}/save`, // 保存
  DeptDelete: `/${modules[1]}/delete`, // 删除
  DeptTree: `/${modules[1]}/findTree`, // 查询机构树

  // 3.字典管理模块
  DictSave: `/${modules[2]}/save`, // 保存
  DictDelete: `/${modules[2]}/delete`, // 删除
  DictPage: `/${modules[2]}/findPage`, // 分页查询

  // 4.操作日志模块
  LogDelete: `/${modules[3]}/delete`, // 删除
  LogPage: `/${modules[3]}/findPage`, // 分页查询

  // 5.系统登录模块
  Login: `login`, // 登录
  Logout: `logout`, // 登出

  // 6.登录日志模块
  LoginlogDelete: `/${modules[5]}/delete`,
  LoginlogPage: `/${modules[5]}/findPage`, // 分页查询

  // 7.菜单管理模块
  MenuSave: `/${modules[6]}/save`, // 保存
  MenuDelete: `/${modules[6]}/delete`, // 删除
  MenuNavTree: `/${modules[6]}/findNavTree`, // 获取导航树
  MenuTree: `/${modules[6]}/findMenuTree`, // 获取菜单树

  // 8.角色管理模块
  RoleSave: `/${modules[7]}/save`, // 保存
  RoleDelete: `/${modules[7]}/delete`, // 删除
  RolePage: `/${modules[7]}/findPage`, // 分页查询
  RoleAll: `/${modules[7]}/findAll`, // 获取所有角色
  RoleMenusGet: `/${modules[7]}/findRoleMenus`, // 获取指定角色可以访问的菜单集合
  RoleMenusSave: `/${modules[7]}/saveRoleMenus`, // 保存指定角色可以访问的菜单集合

  // 9.用户管理模块
  UserSave: `/${modules[8]}/save`, // 保存
  UserDelete: `/${modules[8]}/delete`, // 删除
  UserPage: `/${modules[8]}/findPage`, // 分页查询
  UserPermissions: `/${modules[8]}/findPermissions` // 获取指定用户的菜单权限集合
}
export default REST_URLS
