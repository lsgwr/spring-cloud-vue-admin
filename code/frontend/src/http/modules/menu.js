import axios from '../axios'
import REST_URLS from './index'

export const save = (data) => {
  return axios({
    url: REST_URLS.MenuSave,
    method: 'post',
    data
  })
}

export const batchDelete = (data) => {
  return axios({
    url: REST_URLS.MenuDelete,
    method: 'post',
    data
  })
}

export const findNavTree = (params) => {
  return axios({
    url: REST_URLS.MenuNavTree,
    method: 'get',
    params
  })
}

export const findMenuTree = () => {
  return axios({
    url: REST_URLS.MenuTree,
    method: 'get'
  })
}
