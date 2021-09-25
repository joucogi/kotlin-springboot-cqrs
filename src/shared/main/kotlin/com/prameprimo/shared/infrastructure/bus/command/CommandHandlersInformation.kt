package com.prameprimo.shared.infrastructure.bus.command

import com.prameprimo.shared.domain.Service
import com.prameprimo.shared.domain.bus.command.Command
import com.prameprimo.shared.domain.bus.command.CommandHandler
import org.reflections.Reflections
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

@Service
class CommandHandlersInformation {

    private val indexedCommandHandlers = hashMapOf<Type, Class<out CommandHandler<Command<*>>>>()

    fun search(command: Command<Any?>): Class<out CommandHandler<Command<*>>>? {
        if (indexedCommandHandlers.isEmpty()) {
            println("Search command handlers")
            indexingCommandHandlers()
        }

        return indexedCommandHandlers[command.javaClass]
    }

    private fun indexingCommandHandlers() {
        val reflections = Reflections("com.prameprimo")
        val commandHandlers = reflections.getSubTypesOf(CommandHandler::class.java)
        formatHandlers(commandHandlers as MutableSet<Class<out CommandHandler<Command<*>>>>)
    }

    private fun formatHandlers(queryHandlers: MutableSet<Class<out CommandHandler<Command<*>>>>) {
        queryHandlers.forEach {
            handler ->
                val paramType = handler.genericInterfaces[0] as ParameterizedType
                val commandName = paramType.actualTypeArguments[0]
                indexedCommandHandlers[commandName] = handler
        }
    }
}