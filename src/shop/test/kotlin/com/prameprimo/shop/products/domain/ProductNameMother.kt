package com.prameprimo.shop.products.domain

import io.github.serpro69.kfaker.Faker

class ProductNameMother {
    companion  object {
        fun random() : ProductName {
            val faker = Faker()
            return ProductName(faker.book.title())
        }
    }
}