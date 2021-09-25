package com.prameprimo.shop.products.application.create

import com.prameprimo.shared.domain.Service
import com.prameprimo.shared.domain.bus.command.CommandHandler

@Service
class CreateProductCommandHandler(
    private val creator: ProductCreator
) : CommandHandler<CreateProductCommand> {
    override fun handle(command: CreateProductCommand) {
        creator.create(
            command.productId,
            command.productName
        )
    }
}