package com.yuweihung.bookstore.controller

import com.yuweihung.bookstore.common.Response
import com.yuweihung.bookstore.service.TestService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 测试用控制类
 */
@RestController
@Validated
class TestController(
    val testService: TestService,
) {
    @GetMapping("/test/init")
    fun initRole(): Response {
        testService.initDB()
        return Response.success("init database")
    }

    @GetMapping("/admin/hello")
    fun helloAdmin(): Response {
        return Response.success("hello, admin")
    }

    @GetMapping("/hello")
    fun hello(): Response {
        return Response.success("hello, world")
    }

//    @GetMapping("/test")
//    fun test(): Response {
//        return Response.success()
//    }

}
