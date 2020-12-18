package com.prameprimo.shared.infrastructure.bus.query

import com.prameprimo.shared.domain.bus.query.Query
import com.prameprimo.shared.domain.bus.query.QueryHandler
import org.reflections.Reflections
import org.springframework.stereotype.Service
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

@Service
class QueryHandlersInformation {

    private val indexedQueryHandlers: HashMap<Type, Class<out QueryHandler<*>>> = hashMapOf()

    fun search(query: Query): Class<out QueryHandler<*>>? {
        if (indexedQueryHandlers.isEmpty()) {
            println("Search query handlers")
            indexingQueryHandlers()
        }

        return indexedQueryHandlers[query.javaClass]
    }

    private fun indexingQueryHandlers() {
        val reflections = Reflections("com.prameprimo.marketplace")
        val queryHandlers = reflections.getSubTypesOf(QueryHandler::class.java)
        formatHandlers(queryHandlers)
    }

    private fun formatHandlers(queryHandlers: MutableSet<Class<out QueryHandler<*>>>) {
        queryHandlers.forEach {
            handler ->
                val paramType = handler.genericInterfaces[0] as ParameterizedType
                val queryName = paramType.actualTypeArguments[0]
                indexedQueryHandlers[queryName] = handler
        }
    }
}