package com.yuweihung.bookstore.repository;

import com.yuweihung.bookstore.bean.entity.Order
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

/**
 * 订单的数据库访问接口
 */
interface OrderRepository : JpaRepository<Order, Long> {
    fun findByUser_Username(username: String, pageable: Pageable): Page<Order>

}
