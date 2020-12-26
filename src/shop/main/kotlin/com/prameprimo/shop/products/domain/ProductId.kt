package com.prameprimo.shop.products.domain

import com.prameprimo.shared.domain.Identifier

class ProductId : Identifier {
    constructor(value: String): super(value)
    constructor(): super()
}

