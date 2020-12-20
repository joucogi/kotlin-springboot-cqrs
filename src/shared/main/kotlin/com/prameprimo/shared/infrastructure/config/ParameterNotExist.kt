package com.prameprimo.shared.infrastructure.config

class ParameterNotExist(key: String): Throwable("Parameter $key does not exist")