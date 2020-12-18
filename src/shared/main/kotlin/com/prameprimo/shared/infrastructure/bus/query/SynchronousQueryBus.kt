package com.prameprimo.shared.infrastructure.bus.query

import com.prameprimo.shared.domain.Service
import com.prameprimo.shared.domain.bus.query.Query
import com.prameprimo.shared.domain.bus.query.QueryBus
import org.springframework.context.ApplicationContext

@Service
class SynchronousQueryBus(
    private val information: QueryHandlersInformation,
    private val context: ApplicationContext
) : QueryBus {

    override fun ask(query: Query) : HashMap<String, String> {
        val queryHandlerClass = information.search(query)

        if (null === queryHandlerClass) {
            throw RuntimeException("Handler is not finded")
        }

        val handler = context.getBean(queryHandlerClass)

        return handler.handle(query)
    }
}