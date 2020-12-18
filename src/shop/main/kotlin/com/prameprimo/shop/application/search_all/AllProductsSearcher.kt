package com.prameprimo.shop.application.search_all

import com.prameprimo.shared.domain.Service

@Service
class AllProductsSearcher {
    fun search(): HashMap<String, String> {
        return hashMapOf(
                "products" to "Product 3"
        )
    }
}