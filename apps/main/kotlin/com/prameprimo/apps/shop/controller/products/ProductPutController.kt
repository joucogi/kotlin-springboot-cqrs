package com.prameprimo.apps.shop.controller.products

import com.prameprimo.shared.infrastructure.ApiController
import com.prameprimo.shop.products.application.create.CreateProductCommand
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class ProductPutController : ApiController() {

    @PutMapping("/products/{productId}")
    @ResponseStatus(code = HttpStatus.CREATED)
    fun index(
        @PathVariable productId: String,
        @RequestBody requestBody: RequestProductBody
    ) {
        val command = CreateProductCommand(
            productId,
            requestBody.name
        )

        dispatch(command)
    }
}

class RequestProductBody {
    var name: String = ""
}