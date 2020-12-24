package com.prameprimo.shared.domain

import java.io.Serializable

abstract class Identifier : Serializable {
    abstract val value: String

    init {
        if (value.equals("")) {
            throw IllegalArgumentException()
        }
    }
}