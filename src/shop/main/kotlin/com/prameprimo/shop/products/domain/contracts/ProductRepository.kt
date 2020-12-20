package com.prameprimo.shop.products.domain.contracts

import com.prameprimo.shop.products.application.ProductsResponse

interface ProductRepository {
    fun searchAll(): ProductsResponse
}