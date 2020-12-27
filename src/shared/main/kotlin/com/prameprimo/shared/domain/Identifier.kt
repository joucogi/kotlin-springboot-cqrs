package com.prameprimo.shared.domain

import java.io.Serializable
import java.util.*

abstract class Identifier : Comparable<Identifier>, Serializable {
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

    override operator fun compareTo(other: Identifier): Int = when {
        value > other.value -> 1
        value < other.value -> -1
        else -> 0
    }

    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other == null -> false
        this::class !== other::class -> false
        other is Identifier -> value == other.value
        else -> true
    }
}