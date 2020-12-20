package com.prameprimo.shop.application.products.search_all

import com.prameprimo.apps.shop.ShopApplication
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(classes = [ShopApplication::class])
internal class AllProductsSearcherQueryHandlerTests {

    private var handler: AllProductsSearcherQueryHandler? = null

    @BeforeEach
    fun setUp() {
        handler = AllProductsSearcherQueryHandler(
                AllProductsSearcher()
        )
    }

    @Test
    fun `should return all products`() {
        val query = AllProductsSearcherQuery()
        val products = hashMapOf(
                "products" to "Product 3"
        )

        assertEquals(products, handler!!.handle(query))
    }
}