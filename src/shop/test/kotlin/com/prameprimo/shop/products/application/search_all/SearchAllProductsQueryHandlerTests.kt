package com.prameprimo.shop.products.application.search_all

import com.prameprimo.apps.shop.ShopApplication
import com.prameprimo.shop.products.application.ProductsResponse
import com.prameprimo.shop.products.domain.ProductMother
import com.prameprimo.shop.products.domain.contracts.ProductRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(classes = [ShopApplication::class])
internal class SearchAllProductsQueryHandlerTests {

    private var handlerSearch: SearchAllProductsQueryHandler? = null
    private var repository: ProductRepository? = null

    @BeforeEach
    fun setUp() {
        repository = mockk()

        handlerSearch = SearchAllProductsQueryHandler(
                AllProductsSearcher(repository!!)
        )
    }

    @Test
    fun `should return all products`() {
        val query = SearchAllProductsQuery()
        val products = listOf(
                ProductMother.random(),
                ProductMother.random(),
                ProductMother.random(),
                ProductMother.random()
        )
        val expected = ProductsResponse(products)

        every { repository!!.searchAll() } returns products

        assertEquals(expected, handlerSearch!!.handle(query))
    }
}

