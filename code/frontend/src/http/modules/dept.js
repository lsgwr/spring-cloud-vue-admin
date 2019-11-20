import axios from '../axios'
import REST_URLS from './index'

export const save = (data) => {
  return axios({
    url: REST_URLS.DeptSave,
    method: 'post',
    data
  })
}

export const batchDelete = (data) => {
  return axios({
    url: REST_URLS.DeptDelete,
    method: 'post',
    data
  })
}

export const findDeptTree = () => {
  return axios({
    url: REST_URLS.DeptTree,
    method: 'get'
  })
}
