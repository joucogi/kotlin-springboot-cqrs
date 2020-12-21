package com.prameprimo.shop.products.infrastructure.persistence

import com.prameprimo.shared.domain.Service
import com.prameprimo.shop.products.application.ProductsResponse
import com.prameprimo.shop.products.domain.Product
import com.prameprimo.shop.products.domain.ProductId
import com.prameprimo.shop.products.domain.ProductName
import com.prameprimo.shop.products.domain.contracts.ProductRepository

@Service
class InMemoryProductRepository : ProductRepository {

    private val products = listOf(
            Product(
                    ProductId("1"),
                    ProductName("Product 1")
            ),
            Product(
                    ProductId("2"),
                    ProductName("Product 2")
            ),
            Product(
                    ProductId("3"),
                    ProductName("Product 3")
            ),
            Product(
                    ProductId("4"),
                    ProductName("Product 4")
            )
    )

    override fun searchAll(): ProductsResponse {
        return ProductsResponse(products)
    }
}