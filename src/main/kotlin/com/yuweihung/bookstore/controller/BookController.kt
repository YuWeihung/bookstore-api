package com.yuweihung.bookstore.controller

import com.yuweihung.bookstore.bean.vo.BookVo
import com.yuweihung.bookstore.response.Response
import com.yuweihung.bookstore.service.BookService
import org.springframework.cache.annotation.Cacheable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 首页和搜索相关控制类
 */
@RestController
class BookController(
    val bookService: BookService,
) {
    /**
     * 分页获取书籍
     */
    @Cacheable("books")
    @GetMapping("/index")
    fun index(page: Int): Response {
        val books = bookService.getBooks(page)
        val result = books.map { BookVo(it) }
        return Response.success(result)
    }

    /**
     * 根据书名搜索书籍
     */
    @Cacheable("books")
    @GetMapping("/search/name")
    fun searchByName(name: String, page: Int): Response {
        val books = bookService.searchByName(name, page)
        val result = books.map { BookVo(it) }
        return Response.success(result)
    }

    /**
     * 根据出版社搜索书籍
     */
    @Cacheable("books")
    @GetMapping("/search/press")
    fun searchByPress(pressId: Long, page: Int): Response {
        val books = bookService.searchByPress(pressId, page)
        val result = books.map { BookVo(it) }
        return Response.success(result)
    }

    /**
     * 根据作者搜索书籍
     */
    @Cacheable("books")
    @GetMapping("/search/author")
    fun searchByAuthor(authorId: Long, page: Int): Response {
        val books = bookService.searchByAuthor(authorId, page)
        val result = books.map { BookVo(it) }
        return Response.success(result)
    }
}