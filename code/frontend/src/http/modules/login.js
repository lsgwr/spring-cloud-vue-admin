import axios from '../axios'
import REST_URLS from './index'

export const login = (data) => {
  return axios({
    url: REST_URLS.Login,
    method: 'post',
    data
  })
}

export const logout = () => {
  return axios({
    url: REST_URLS.Logout,
    method: 'get'
  })
}
