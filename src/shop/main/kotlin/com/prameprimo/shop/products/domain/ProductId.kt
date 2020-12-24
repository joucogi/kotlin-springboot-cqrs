package com.prameprimo.shop.products.domain

import com.prameprimo.shared.domain.Identifier

data class ProductId(override val value: String) : Identifier()