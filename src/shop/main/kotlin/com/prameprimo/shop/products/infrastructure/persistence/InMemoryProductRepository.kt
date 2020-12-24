package com.prameprimo.shop.products.infrastructure.persistence

import com.prameprimo.shared.domain.Service
import com.prameprimo.shop.products.domain.Product
import com.prameprimo.shop.products.domain.ProductId
import com.prameprimo.shop.products.domain.ProductName
import com.prameprimo.shop.products.domain.contracts.ProductRepository
import com.prameprimo.shop.products.domain.exceptions.ProductNotExist

@Service
class InMemoryProductRepository : ProductRepository {

    private val products = mutableListOf(
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

    override fun searchAll(): List<Product> {
        return products
    }

    override fun findById(id: ProductId): Product {
        val product = products.find { it.id === id }

        return product ?: throw ProductNotExist(id)
    }

    override fun save(product: Product) {
        products.add(product)
    }
}