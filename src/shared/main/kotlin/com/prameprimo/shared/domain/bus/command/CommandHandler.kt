package com.prameprimo.shared.domain.bus.command

interface CommandHandler<in T>{
    fun handle(command: T)
}