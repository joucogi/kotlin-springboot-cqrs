package com.prameprimo.shop.products.application.search_all

import com.prameprimo.apps.shop.ShopApplication
import com.prameprimo.shop.products.application.ProductsResponse
import com.prameprimo.shop.products.domain.Product
import com.prameprimo.shop.products.domain.ProductId
import com.prameprimo.shop.products.domain.ProductName
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
        val products = ProductsResponse(
                listOf(
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
        )

        every { repository!!.searchAll() } returns products

        assertEquals(products, handlerSearch!!.handle(query))
    }
}

