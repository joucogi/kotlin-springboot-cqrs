package com.prameprimo.shared.domain.bus.query

interface QueryHandler<T> {
    fun handle(command: T): HashMap<String, String>
}