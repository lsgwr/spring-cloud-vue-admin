import axios from '../axios'
import REST_URLS from './index'

export const batchDelete = (data) => {
  return axios({
    url: REST_URLS.LogDelete,
    method: 'post',
    data
  })
}

export const findPage = (data) => {
  return axios({
    url: REST_URLS.LogPage,
    method: 'post',
    data
  })
}
