package com.prameprimo.shared.domain

import java.io.Serializable

abstract class Identifier(val value: String) : Serializable {
    init {
        if (value == "") {
            throw IllegalArgumentException()
        }
    }
}