package com.prameprimo.apps

import com.prameprimo.apps.shop.ShopApplication
import org.springframework.boot.runApplication

fun main(args: Array<String>) {
    val starter = Starter()
    starter.run(args)
}

class Starter {
    fun run(args: Array<String>) {
        runApplication<ShopApplication>(*args)
    }
}