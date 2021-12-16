import service from '../utils/request.js'
 
/**
 * POST 请求封装
*/
export function apiPost(url, data) {
  return service.request({
    url: url,
    method: 'post',
    data
  })
}
 
/**
 * GET 请求封装
*/
export function apiGet(url, data) {
  return service.request({
    url: url,
    method: 'get',
    data
  })
}
 
/**
 * PUT 请求封装
*/
export function apiPut(url, data) {
  return service.request({
    url: url,
    method: 'put',
    data
  })
}

