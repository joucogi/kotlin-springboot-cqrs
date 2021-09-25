package com.prameprimo.shared.infrastructure

import com.prameprimo.shared.domain.bus.command.Command
import com.prameprimo.shared.domain.bus.command.CommandBus
import com.prameprimo.shared.domain.bus.query.Query
import com.prameprimo.shared.domain.bus.query.QueryBus
import com.prameprimo.shared.domain.bus.query.Response
import org.springframework.beans.factory.annotation.Autowired

abstract class ApiController {
    @Autowired
    private val queryBus: QueryBus? = null

    @Autowired
    private val commandBus: CommandBus? = null

    protected fun ask(query: Query<Any?>): Response = queryBus!!.ask(query)
    protected fun dispatch(command: Command<Any?>) = commandBus!!.dispatch(command)
}