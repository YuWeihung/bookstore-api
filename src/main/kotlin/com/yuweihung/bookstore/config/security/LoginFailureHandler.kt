package com.yuweihung.bookstore.config.security

import com.yuweihung.bookstore.common.ErrorCode
import com.yuweihung.bookstore.common.Response
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import mu.KotlinLogging
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.InternalAuthenticationServiceException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger { }

/**
 * 登录失败根据情况返回相应信息
 */
@Component
class LoginFailureHandler : AuthenticationFailureHandler {
    override fun onAuthenticationFailure(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        exception: AuthenticationException?,
    ) {
        val result = when (exception) {
            is BadCredentialsException -> {
                Response.failure(ErrorCode.PASSWORD_WRONG)
            }

            is InternalAuthenticationServiceException -> {
                Response.failure(ErrorCode.USER_NOT_EXIST)
            }

            else -> {
                Response.failure(ErrorCode.UNKNOWN_ERROR)
            }
        }
        logger.info { exception?.message }
        response?.let { Response.render(it, result) }
    }
}
