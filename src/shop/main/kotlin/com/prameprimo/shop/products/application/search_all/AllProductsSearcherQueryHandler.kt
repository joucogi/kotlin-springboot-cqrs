package com.prameprimo.shop.products.application.search_all

import com.prameprimo.shared.domain.Service
import com.prameprimo.shared.domain.bus.query.QueryHandler

@Service
class AllProductsSearcherQueryHandler(
        private val searcher: AllProductsSearcher
) : QueryHandler<AllProductsSearcherQuery> {

    override fun handle(query: AllProductsSearcherQuery): HashMap<String, String> {
        return searcher.search()
    }
}