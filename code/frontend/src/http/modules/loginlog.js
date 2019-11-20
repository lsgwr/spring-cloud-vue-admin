import axios from '../axios'
import REST_URLS from './index'

export const batchDelete = (data) => {
  return axios({
    url: REST_URLS.LoginlogDelete,
    method: 'post',
    data
  })
}

export const findPage = (data) => {
  return axios({
    url: REST_URLS.LoginlogPage,
    method: 'post',
    data
  })
}
