package com.prameprimo.shared.infrastructure.bus.query

import com.prameprimo.shared.domain.Service
import com.prameprimo.shared.domain.bus.query.Query
import com.prameprimo.shared.domain.bus.query.QueryHandler
import com.prameprimo.shared.domain.bus.query.Response
import org.reflections.Reflections
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

@Service
class QueryHandlersInformation {

    private val indexedQueryHandlers = hashMapOf<Type, Class<out QueryHandler<Query<*>, Response>>>()

    fun search(query: Query<Any?>): Class<out QueryHandler<Query<*>, Response>>? {
        if (indexedQueryHandlers.isEmpty()) {
            println("Search query handlers")
            indexingQueryHandlers()
        }

        return indexedQueryHandlers[query.javaClass]
    }

    private fun indexingQueryHandlers() {
        val reflections = Reflections("com.prameprimo")
        val queryHandlers = reflections.getSubTypesOf(QueryHandler::class.java)
        formatHandlers(queryHandlers as MutableSet<Class<out QueryHandler<Query<*>, Response>>>)
    }

    private fun formatHandlers(queryHandlers: MutableSet<Class<out QueryHandler<Query<*>, Response>>>) {
        queryHandlers.forEach {
            handler ->
                val paramType = handler.genericInterfaces[0] as ParameterizedType
                val queryName = paramType.actualTypeArguments[0]
                indexedQueryHandlers[queryName] = handler
        }
    }
}