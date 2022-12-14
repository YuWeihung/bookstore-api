package com.yuweihung.bookstore.common

/**
 * 自定义异常的实现
 */
class ErrorException(errorCode: BaseErrorInterface) : RuntimeException(), BaseErrorInterface {
    override val code = errorCode.code
    override val message = errorCode.message
}
