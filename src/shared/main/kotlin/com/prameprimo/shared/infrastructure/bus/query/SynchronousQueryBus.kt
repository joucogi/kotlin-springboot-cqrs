package com.prameprimo.shared.infrastructure.bus.query

import com.prameprimo.shared.domain.Service
import com.prameprimo.shared.domain.bus.query.Query
import com.prameprimo.shared.domain.bus.query.QueryBus
import com.prameprimo.shared.domain.bus.query.QueryHandler
import com.prameprimo.shared.domain.bus.query.Response
import org.springframework.context.ApplicationContext

@Service
class SynchronousQueryBus(
        private val information: QueryHandlersInformation,
        private val context: ApplicationContext
) : QueryBus {

    override fun ask(query: Query<Any?>): Response {
        val queryHandlerClass = information.search(query)

        if (null === queryHandlerClass) {
            throw RuntimeException("Handler is not finded")
        }

        @Suppress("UNCHECKED_CAST")
        val handler: QueryHandler<Query<*>, Response> = context.getBean(queryHandlerClass) as QueryHandler<Query<*>, Response>

        return handler.handle(query)
    }
}