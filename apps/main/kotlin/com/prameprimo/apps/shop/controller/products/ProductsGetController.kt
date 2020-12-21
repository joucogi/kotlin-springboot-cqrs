package com.prameprimo.apps.shop.controller.products

import com.prameprimo.shared.infrastructure.ApiController
import com.prameprimo.shop.products.application.ProductsResponse
import com.prameprimo.shop.products.application.search_all.SearchAllProductsQuery
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductsGetController : ApiController() {

    @GetMapping("/products")
    fun index(): ResponseEntity<List<String>> {
        val query = SearchAllProductsQuery()

        val response: ProductsResponse = ask(query) as ProductsResponse

        return ResponseEntity.ok().body(response.products.map { it.name.value })
    }
}