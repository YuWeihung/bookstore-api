package com.yuweihung.bookstore.bean.entity

import jakarta.persistence.*
import java.math.BigDecimal

/**
 * 购物车实体类
 */
@Entity
@Table(name = "cart")
class Cart : BaseEntity() {
    @OneToOne(mappedBy = "cart")
    var user: User? = null

    @OneToMany
    @JoinTable(
        name = "cart_item",
        joinColumns = [JoinColumn(name = "cart_id")],
        inverseJoinColumns = [JoinColumn(name = "item_id")]
    )
    var items: MutableSet<Item> = mutableSetOf()

    @Column(name = "total_price", nullable = false)
    var totalPrice: BigDecimal = BigDecimal("0.00")

    /**
     * 计算总价
     */
    fun calculatePrice() {
        var totalPrice = BigDecimal("0.00")
        for (item in this.items) {
            val amount = BigDecimal(item.amount)
            val price = item.book.price.multiply(amount)
            totalPrice = totalPrice.plus(price)
        }
        this.totalPrice = totalPrice
    }
}
