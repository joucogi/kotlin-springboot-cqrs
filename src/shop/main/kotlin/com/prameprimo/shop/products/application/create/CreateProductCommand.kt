package com.prameprimo.shop.products.application.create

import com.prameprimo.shared.domain.bus.command.Command

class CreateProductCommand(val productId: String, val productName: String): Command<Any?>