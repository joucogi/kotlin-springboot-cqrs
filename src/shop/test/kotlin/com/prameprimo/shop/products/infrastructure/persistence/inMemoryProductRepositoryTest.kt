package com.prameprimo.shop.products.infrastructure.persistence

import com.prameprimo.shop.products.ProductsShopInfrastructureTestCase
import com.prameprimo.shop.products.domain.ProductMother
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal open class inMemoryProductRepositoryTest : ProductsShopInfrastructureTestCase() {

    @BeforeEach
    fun SetUp() {
        inMemoryProductRespository.truncate()
    }

    @Test
    fun `Should save product correctly`() {
        val product = ProductMother.random()

        inMemoryProductRespository.save(product)
    }

    @Test
    fun `Should return empty list when there are not products`() {
        val products = inMemoryProductRespository.searchAll()

        assertEquals(0, products.size)
    }

    @Test
    fun `Should return all products when there are products`() {
        val products = listOf(
                ProductMother.random(),
                ProductMother.random(),
                ProductMother.random(),
                ProductMother.random()
        )

        products.forEach {
            inMemoryProductRespository.save(it)
        }

        assertEquals(products, inMemoryProductRespository.searchAll())
    }

    @Test
    fun `Should return the product when exists`() {
        val product = ProductMother.random()

        inMemoryProductRespository.save(product)

        assertEquals(product, inMemoryProductRespository.findById(product.id))
    }
}