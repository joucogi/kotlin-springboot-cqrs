package com.prameprimo.shop.products.application.search_all

import com.prameprimo.shared.domain.Service
import com.prameprimo.shop.products.application.ProductsResponse
import com.prameprimo.shop.products.domain.Product
import com.prameprimo.shop.products.domain.contracts.ProductRepository

@Service
class AllProductsSearcher(private val repository: ProductRepository) {
    fun search(): ProductsResponse = repository.searchAll()
}