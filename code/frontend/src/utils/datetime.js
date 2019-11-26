/**
 * 时间日期相关操作
 */

/**
 * 时间格式化
 * 将 2018-09-23T11:54:16.000+0000 格式化成 2018-09-23 11:54:16
 * @param datetime 国际化日期格式
 */
export function format (datetime) {
  return formatWithSeparator(datetime, '-', ':')
}

/**
 * 时间格式化
 * 将 2018-09-23T11:54:16.000+0000 格式化成类似 2018/09/23 11:54:16
 * 可以指定日期和时间分隔符
 * @param datetime 国际化日期格式
 * @param dateSeparator 日期分隔符(年月日的分隔符)
 * @param timeSeparator 时间分隔符(时分秒的分隔符)
 */
export function formatWithSeparator (datetime, dateSeparator, timeSeparator) {
  if (datetime != null) {
    const dateMat = new Date(datetime)
    const year = dateMat.getFullYear()
    const month = dateMat.getMonth() + 1
    const day = dateMat.getDate()
    const hh = dateMat.getHours()
    const mm = dateMat.getMinutes()
    const ss = dateMat.getSeconds()
    return year + dateSeparator + month + dateSeparator + day + ' ' + hh + timeSeparator + mm + timeSeparator + ss
  }
}
