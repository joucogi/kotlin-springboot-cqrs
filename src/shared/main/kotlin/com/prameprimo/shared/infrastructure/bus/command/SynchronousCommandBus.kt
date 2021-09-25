package com.prameprimo.shared.infrastructure.bus.command

import com.prameprimo.shared.domain.Service
import com.prameprimo.shared.domain.bus.command.Command
import com.prameprimo.shared.domain.bus.command.CommandBus
import com.prameprimo.shared.domain.bus.command.CommandHandler
import org.springframework.context.ApplicationContext

@Service
class SynchronousCommandBus(
    private val information: CommandHandlersInformation,
    private val context: ApplicationContext
) : CommandBus {

    override fun dispatch(command: Command<Any?>) {
        val commandHandlerClass = information.search(command)

        if (null === commandHandlerClass) {
            throw RuntimeException("Command Handler is not finded")
        }

        @Suppress("UNCHECKED_CAST")
        val handler: CommandHandler<Command<*>> = context.getBean(commandHandlerClass) as CommandHandler<Command<*>>

        handler.handle(command)
    }
}