package com.prameprimo.shop.products.infrastructure.adapters

import com.prameprimo.shared.domain.Service
import com.prameprimo.shop.products.application.ProductsResponse
import com.prameprimo.shop.products.domain.Product
import com.prameprimo.shop.products.domain.contracts.ProductRepository

@Service
class InMemoryProductRepository : ProductRepository {

    private val products = listOf(
            Product("Product 1"),
            Product("Product 2"),
            Product("Product 3"),
            Product("Product 4"),
            Product("Product 5"),
            Product("Product 6"),
            Product("Product 7"),
    )

    override fun searchAll(): ProductsResponse {
        return ProductsResponse(products)
    }
}