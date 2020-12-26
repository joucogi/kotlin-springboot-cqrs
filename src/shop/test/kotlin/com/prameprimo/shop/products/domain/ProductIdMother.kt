package com.prameprimo.shop.products.domain

import java.util.UUID

class ProductIdMother {
    companion object {
        fun random() : ProductId {
            return ProductId(UUID.randomUUID().toString())
        }
    }
}