package com.prameprimo.shared.infrastructure.config

import com.prameprimo.shared.domain.Service
import io.github.cdimascio.dotenv.Dotenv

@Service
class Parameter(private val dotenv: Dotenv) {

    fun get(key: String): String {
        return dotenv.get(key) ?: throw ParameterNotExist(key)
    }

    fun getInt(key: String): Int {
        return get(key).toInt()
    }
}