package com.prameprimo.shop.products.application

import com.prameprimo.shared.domain.bus.query.Response
import com.prameprimo.shop.products.domain.Product

data class ProductsResponse(val products: List<Product>): Response