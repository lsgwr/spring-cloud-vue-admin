/***********************************************************
 * @Description : HTTP状态
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 13:07
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.core.http;

public interface HttpStatus {

    // --- 1xx Informational --- 信息

    /**
     * {@code 100 Continue} (HTTP/1.1 - RFC 2616) 继续
     */
    int SC_CONTINUE = 100;
    /**
     * {@code 101 Switching Protocols} (HTTP/1.1 - RFC 2616) 交换协议
     */
    int SC_SWITCHING_PROTOCOLS = 101;
    /**
     * {@code 102 Processing} (WebDAV - RFC 2518) 处理中
     */
    int SC_PROCESSING = 102;

    // --- 2xx Success ---

    /**
     * {@code 200 OK} (HTTP/1.0 - RFC 1945) 成功
     */
    int SC_OK = 200;
    /**
     * {@code 201 Created} (HTTP/1.0 - RFC 1945) 创建
     */
    int SC_CREATED = 201;
    /**
     * {@code 202 Accepted} (HTTP/1.0 - RFC 1945) 已接受
     */
    int SC_ACCEPTED = 202;
    /**
     * {@code 203 Non Authoritative Information} (HTTP/1.1 - RFC 2616) 非权威信息
     */
    int SC_NON_AUTHORITATIVE_INFORMATION = 203;
    /**
     * {@code 204 No Content} (HTTP/1.0 - RFC 1945) 没有内容
     */
    int SC_NO_CONTENT = 204;
    /**
     * {@code 205 Reset Content} (HTTP/1.1 - RFC 2616) 重置内容
     */
    int SC_RESET_CONTENT = 205;
    /**
     * {@code 206 Partial Content} (HTTP/1.1 - RFC 2616) 部分内容
     */
    int SC_PARTIAL_CONTENT = 206;
    /**
     * {@code 207 Multi-Status} (WebDAV - RFC 2518)
     * or
     * {@code 207 Partial Update OK} (HTTP/1.1 - draft-ietf-http-v11-spec-rev-01?)
     */
    int SC_MULTI_STATUS = 207;

    // --- 3xx Redirection ---

    /**
     * {@code 300 Multiple Choices} (HTTP/1.1 - RFC 2616) 多种选择
     */
    int SC_MULTIPLE_CHOICES = 300;
    /**
     * {@code 301 Moved Permanently} (HTTP/1.0 - RFC 1945) 永久移动
     */
    int SC_MOVED_PERMANENTLY = 301;
    /**
     * {@code 302 Moved Temporarily} (Sometimes {@code Found}) (HTTP/1.0 - RFC 1945) 暂时移动
     */
    int SC_MOVED_TEMPORARILY = 302;
    /**
     * {@code 303 See Other} (HTTP/1.1 - RFC 2616) 参见其他
     */
    int SC_SEE_OTHER = 303;
    /**
     * {@code 304 Not Modified} (HTTP/1.0 - RFC 1945) 未修改
     */
    int SC_NOT_MODIFIED = 304;
    /**
     * {@code 305 Use Proxy} (HTTP/1.1 - RFC 2616) 使用代理
     */
    int SC_USE_PROXY = 305;
    /**
     * {@code 307 Temporary Redirect} (HTTP/1.1 - RFC 2616) 临时重定向
     */
    int SC_TEMPORARY_REDIRECT = 307;

    // --- 4xx Client Error --- 客户端错误

    /**
     * {@code 400 Bad Request} (HTTP/1.1 - RFC 2616) 错误的请求
     */
    int SC_BAD_REQUEST = 400;
    /**
     * {@code 401 Unauthorized} (HTTP/1.0 - RFC 1945) 未经授权
     */
    int SC_UNAUTHORIZED = 401;
    /**
     * {@code 402 Payment Required} (HTTP/1.1 - RFC 2616) 付费请求
     */
    int SC_PAYMENT_REQUIRED = 402;
    /**
     * {@code 403 Forbidden} (HTTP/1.0 - RFC 1945) 禁止
     */
    int SC_FORBIDDEN = 403;
    /**
     * {@code 404 Not Found} (HTTP/1.0 - RFC 1945) 没有找到
     */
    int SC_NOT_FOUND = 404;
    /**
     * {@code 405 Method Not Allowed} (HTTP/1.1 - RFC 2616) 方法不允许
     */
    int SC_METHOD_NOT_ALLOWED = 405;
    /**
     * {@code 406 Not Acceptable} (HTTP/1.1 - RFC 2616) 不可接受
     */
    int SC_NOT_ACCEPTABLE = 406;
    /**
     * {@code 407 Proxy Authentication Required} (HTTP/1.1 - RFC 2616) 需要代理身份认证
     */
    int SC_PROXY_AUTHENTICATION_REQUIRED = 407;
    /**
     * {@code 408 Request Timeout} (HTTP/1.1 - RFC 2616) 请求超时
     */
    int SC_REQUEST_TIMEOUT = 408;
    /**
     * {@code 409 Conflict} (HTTP/1.1 - RFC 2616) 指令冲突
     */
    int SC_CONFLICT = 409;
    /**
     * {@code 410 Gone} (HTTP/1.1 - RFC 2616) 文档永久地离开了指定的位置
     */
    int SC_GONE = 410;
    /**
     * {@code 411 Length Required} (HTTP/1.1 - RFC 2616) 需要Content-Length请求头
     */
    int SC_LENGTH_REQUIRED = 411;
    /**
     * {@code 412 Precondition Failed} (HTTP/1.1 - RFC 2616) 前提条件失败
     */
    int SC_PRECONDITION_FAILED = 412;
    /**
     * {@code 413 Request Entity Too Large} (HTTP/1.1 - RFC 2616) 请求体太大
     */
    int SC_REQUEST_TOO_LONG = 413;
    /**
     * {@code 414 Request-URI Too Long} (HTTP/1.1 - RFC 2616) 请求URI太长
     */
    int SC_REQUEST_URI_TOO_LONG = 414;
    /**
     * {@code 415 Unsupported Media Type} (HTTP/1.1 - RFC 2616) 不支持的媒体类型
     */
    int SC_UNSUPPORTED_MEDIA_TYPE = 415;
    /**
     * {@code 416 Requested Range Not Satisfiable} (HTTP/1.1 - RFC 2616) 请求的范围不满足
     */
    int SC_REQUESTED_RANGE_NOT_SATISFIABLE = 416;
    /**
     * {@code 417 Expectation Failed} (HTTP/1.1 - RFC 2616) 期望失败
     */
    int SC_EXPECTATION_FAILED = 417;

    /**
     * Static constant for a 418 error.
     * {@code 418 Unprocessable Entity} (WebDAV drafts?)
     * or {@code 418 Reauthentication Required} (HTTP/1.1 drafts?)
     */
    // not used
    //  int SC_UNPROCESSABLE_ENTITY = 418;

    /**
     * Static constant for a 419 error.
     * {@code 419 Insufficient Space on Resource}
     * (WebDAV - draft-ietf-webdav-protocol-05?)
     * or {@code 419 Proxy Reauthentication Required}
     * (HTTP/1.1 drafts?)
     */
    int SC_INSUFFICIENT_SPACE_ON_RESOURCE = 419;
    /**
     * Static constant for a 420 error.
     * {@code 420 Method Failure}
     * (WebDAV - draft-ietf-webdav-protocol-05?)
     */
    int SC_METHOD_FAILURE = 420;
    /**
     * {@code 422 Unprocessable Entity} (WebDAV - RFC 2518)
     */
    int SC_UNPROCESSABLE_ENTITY = 422;
    /**
     * {@code 423 Locked} (WebDAV - RFC 2518)
     */
    int SC_LOCKED = 423;
    /**
     * {@code 424 Failed Dependency} (WebDAV - RFC 2518)
     */
    int SC_FAILED_DEPENDENCY = 424;

    // --- 5xx Server Error ---

    /**
     * {@code 500 Server Error} (HTTP/1.0 - RFC 1945) 服务器内部错误
     */
    int SC_INTERNAL_SERVER_ERROR = 500;
    /**
     * {@code 501 Not Implemented} (HTTP/1.0 - RFC 1945) 未实现
     */
    int SC_NOT_IMPLEMENTED = 501;
    /**
     * {@code 502 Bad Gateway} (HTTP/1.0 - RFC 1945) 错误的网关
     */
    int SC_BAD_GATEWAY = 502;
    /**
     * {@code 503 Service Unavailable} (HTTP/1.0 - RFC 1945) 服务不可用
     */
    int SC_SERVICE_UNAVAILABLE = 503;
    /**
     * {@code 504 Gateway Timeout} (HTTP/1.1 - RFC 2616) 网关超时
     */
    int SC_GATEWAY_TIMEOUT = 504;
    /**
     * {@code 505 HTTP Version Not Supported} (HTTP/1.1 - RFC 2616) HTTP版本不支持
     */
    int SC_HTTP_VERSION_NOT_SUPPORTED = 505;

    /**
     * {@code 507 Insufficient Storage} (WebDAV - RFC 2518) 存储不足
     */
    int SC_INSUFFICIENT_STORAGE = 507;

}
