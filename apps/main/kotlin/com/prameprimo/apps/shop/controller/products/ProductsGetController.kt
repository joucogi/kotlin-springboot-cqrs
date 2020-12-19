package com.prameprimo.apps.shop.controller.products

import com.prameprimo.shared.infrastructure.ApiController
import com.prameprimo.shop.application.products.search_all.AllProductsSearcherQuery
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductsGetController : ApiController() {

    @GetMapping("/products")
    fun index(): ResponseEntity<HashMap<String, String>> {
        val query = AllProductsSearcherQuery()

        val response = ask(query)

        return ResponseEntity.ok().body(response)
    }
}