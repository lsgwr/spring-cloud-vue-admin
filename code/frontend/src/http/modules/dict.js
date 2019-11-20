import axios from '../axios'
import REST_URLS from './index'

export const save = (data) => {
  return axios({
    url: REST_URLS.DictSave,
    method: 'post',
    data
  })
}

export const batchDelete = (data) => {
  return axios({
    url: REST_URLS.DictDelete,
    method: 'post',
    data
  })
}

export const findPage = (data) => {
  return axios({
    url: REST_URLS.DictPage,
    method: 'post',
    data
  })
}
