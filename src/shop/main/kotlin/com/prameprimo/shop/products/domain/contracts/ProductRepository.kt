package com.prameprimo.shop.products.domain.contracts

import com.prameprimo.shop.products.domain.Product

interface ProductRepository {
    fun searchAll(): List<Product>
}