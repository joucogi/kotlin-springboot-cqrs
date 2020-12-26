package com.prameprimo.shop.products.domain

class ProductMother {
    companion object {
        fun random() : Product = Product(
                ProductIdMother.random(),
                ProductNameMother.random()
        )

        fun create(
                id: ProductId,
                name: ProductName
        ) : Product = Product(id, name)
    }
}