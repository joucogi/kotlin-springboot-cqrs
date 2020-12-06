package com.prameprimo.apps.shop.config

import org.springframework.boot.web.server.ConfigurableWebServerFactory
import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.stereotype.Component

@Component
class ShopPortConfiguration : WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    override fun customize(factory: ConfigurableWebServerFactory?) {
        factory!!.setPort(8080)
    }
}