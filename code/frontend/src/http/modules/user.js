import axios from '../axios'
import REST_URLS from './index'

export const save = (data) => {
  return axios({
    url: REST_URLS.UserSave,
    method: 'post',
    data
  })
}

export const batchDelete = (data) => {
  return axios({
    url: REST_URLS.UserDelete,
    method: 'post',
    data
  })
}

export const findPage = (data) => {
  return axios({
    url: REST_URLS.UserPage,
    method: 'post',
    data
  })
}

export const findPermissions = (params) => {
  return axios({
    url: REST_URLS.UserPermissions,
    method: 'get',
    params
  })
}
