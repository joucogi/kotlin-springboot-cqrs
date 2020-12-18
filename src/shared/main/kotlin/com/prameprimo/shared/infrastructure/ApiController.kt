package com.prameprimo.shared.infrastructure

import com.prameprimo.shared.domain.bus.query.Query
import com.prameprimo.shared.domain.bus.query.QueryBus
import org.springframework.beans.factory.annotation.Autowired

abstract class ApiController {
    @Autowired
    val queryBus: QueryBus? = null

    protected fun ask(query: Query<Any?>): HashMap<String, String> = queryBus!!.ask(query)
}