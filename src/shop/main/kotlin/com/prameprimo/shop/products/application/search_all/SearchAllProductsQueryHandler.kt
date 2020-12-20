package com.prameprimo.shop.products.application.search_all

import com.prameprimo.shared.domain.Service
import com.prameprimo.shared.domain.bus.query.QueryHandler
import com.prameprimo.shop.products.application.ProductsResponse

@Service
class SearchAllProductsQueryHandler(
        private val searcher: AllProductsSearcher
) : QueryHandler<SearchAllProductsQuery, ProductsResponse> {

    override fun handle(query: SearchAllProductsQuery): ProductsResponse {
        return searcher.search()
    }
}