package com.prameprimo.shared.domain.bus.query

interface QueryHandler<in T>{
    fun handle(query: T): HashMap<String, String>
}