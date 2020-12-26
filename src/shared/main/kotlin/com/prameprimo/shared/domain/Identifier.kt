package com.prameprimo.shared.domain

import java.io.Serializable
import java.util.*

abstract class Identifier : Serializable {
    val value: String

    constructor(value: String) {
        ensureValidUuid(value)
        this.value = value
    }

    constructor() {
        this.value = ""
    }

    private fun ensureValidUuid(value: String) {
        UUID.fromString(value)
    }
}