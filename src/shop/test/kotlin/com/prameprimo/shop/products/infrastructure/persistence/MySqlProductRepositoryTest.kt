package com.prameprimo.shop.products.infrastructure.persistence

import com.prameprimo.shop.products.ProductsShopInfrastructureTestCase
import com.prameprimo.shop.products.domain.ProductMother
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.transaction.Transactional

@Transactional
open class MySqlProductRepositoryTest : ProductsShopInfrastructureTestCase() {

    @Test
    fun `Should save product correctly`() {
        val product = ProductMother.random()

        mysqlProductRespository.save(product)
    }

    @Test
    fun `Should return empty list when there are not products`() {
        val products = mysqlProductRespository.searchAll()

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

        val sortedProducts = products.sortedBy { it.id }

        sortedProducts.forEach {
            mysqlProductRespository.save(it)
        }

        assertEquals(sortedProducts, mysqlProductRespository.searchAll())
    }

    @Test
    fun `Should return the product when exists`() {
        val product = ProductMother.random()

        mysqlProductRespository.save(product)

        assertEquals(product, mysqlProductRespository.findById(product.id))
    }
}