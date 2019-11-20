import axios from '../axios'
import REST_URLS from './index'

export const save = (data) => {
  return axios({
    url: REST_URLS.RoleSave,
    method: 'post',
    data
  })
}

export const batchDelete = (data) => {
  return axios({
    url: REST_URLS.RoleDelete,
    method: 'post',
    data
  })
}

export const findPage = (data) => {
  return axios({
    url: REST_URLS.RolePage,
    method: 'post',
    data
  })
}

export const findAll = () => {
  return axios({
    url: REST_URLS.RoleAll,
    method: 'get'
  })
}

export const findRoleMenus = (params) => {
  return axios({
    url: REST_URLS.RoleMenusGet,
    method: 'get',
    params
  })
}

export const saveRoleMenus = (data) => {
  return axios({
    url: REST_URLS.RoleMenusSave,
    method: 'post',
    data
  })
}
