package com.prameprimo.shop.products.infrastructure.persistence

import com.prameprimo.shop.products.ProductsShopInfrastructureTestCase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.transaction.Transactional

@Transactional
internal open class MySqlProductRepositoryTest : ProductsShopInfrastructureTestCase() {

   /* @Test
    fun `Should return empty list when there are not products`() {
        val products = mysqlProductRespository!!.searchAll()

        assertEquals(0, products.size)
    } */
}