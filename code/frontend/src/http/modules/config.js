import axios from '../axios'
import REST_URLS from './index'

export const save = (data) => {
  return axios({
    url: REST_URLS.ConfigSave,
    method: 'post',
    data
  })
}

export const batchDelete = (data) => {
  return axios({
    url: REST_URLS.ConfigDelete,
    method: 'post',
    data
  })
}

export const findPage = (data) => {
  return axios({
    url: REST_URLS.ConfigPage,
    method: 'post',
    data
  })
}
