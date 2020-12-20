package com.prameprimo.shared.domain.bus.query

interface QueryHandler<in T, out K>{
    fun handle(query: T): K
}