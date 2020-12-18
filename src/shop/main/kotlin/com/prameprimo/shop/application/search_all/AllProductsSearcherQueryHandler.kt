package com.prameprimo.shop.application.search_all

import com.prameprimo.shared.domain.bus.query.QueryHandler
import org.springframework.stereotype.Service

@Service
class AllProductsSearcherQueryHandler(
        private val searcher: AllProductsSearcher
) : QueryHandler<AllProductsSearcherQuery> {

    override fun handle(query: AllProductsSearcherQuery): HashMap<String, String> {
        return searcher.search()
    }
}