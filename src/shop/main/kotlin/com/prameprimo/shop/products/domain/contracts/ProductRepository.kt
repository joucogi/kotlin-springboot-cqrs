package com.prameprimo.shop.products.domain.contracts

import com.prameprimo.shop.products.domain.Product
import com.prameprimo.shop.products.domain.ProductId

interface ProductRepository {
    fun searchAll(): List<Product>
    fun findById(id: ProductId): Product
    fun save(product: Product)
}