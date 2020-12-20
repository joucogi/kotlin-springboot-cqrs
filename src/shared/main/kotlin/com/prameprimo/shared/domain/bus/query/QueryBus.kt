package com.prameprimo.shared.domain.bus.query

interface QueryBus {
    fun ask(query: Query<Any?>) : Response
}