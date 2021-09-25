package com.prameprimo.shop.products.application.create

import com.prameprimo.shared.domain.Service
import com.prameprimo.shop.products.domain.Product
import com.prameprimo.shop.products.domain.ProductId
import com.prameprimo.shop.products.domain.ProductName
import com.prameprimo.shop.products.domain.contracts.ProductRepository

@Service
class ProductCreator(private val repository: ProductRepository) {
    fun create(productId: String, productName: String) {
        val product = Product(
            ProductId(productId),
            ProductName(productName)
        )

        repository.save(product)
    }
}