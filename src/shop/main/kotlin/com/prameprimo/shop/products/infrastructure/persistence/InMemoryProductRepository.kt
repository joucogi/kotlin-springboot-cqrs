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
                    ProductId("77c01680-f64f-4f0c-a879-81c9a52a1100"),
                    ProductName("Product 1")
            ),
            Product(
                    ProductId("d6fc4e5a-c134-460d-a40e-39bd70188df0"),
                    ProductName("Product 2")
            ),
            Product(
                    ProductId("69d39353-486e-44e8-8b22-f338eef50bcb"),
                    ProductName("Product 3")
            ),
            Product(
                    ProductId("0ad0c821-76c0-4683-a216-060ce9bb55c1"),
                    ProductName("Product 4")
            )
    )

    override fun searchAll(): List<Product> = products

    override fun findById(id: ProductId): Product {
        val product = products.find { it.id === id }

        return product ?: throw ProductNotExist(id)
    }

    override fun save(product: Product) {
        products.add(product)
    }

    fun truncate() = products.clear()
}