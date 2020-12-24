package com.prameprimo.shop.products.domain.exceptions

import com.prameprimo.shop.products.domain.ProductId

data class ProductNotExist(private val id: ProductId): RuntimeException("Product ${id.value} does not exist")