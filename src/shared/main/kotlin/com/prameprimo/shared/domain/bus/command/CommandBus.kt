package com.prameprimo.shared.domain.bus.command

interface CommandBus {
    fun dispatch(command: Command<Any?>)
}