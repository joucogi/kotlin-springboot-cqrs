package com.prameprimo.apps.shop.config

import com.prameprimo.shared.infrastructure.config.Parameter
import org.springframework.boot.web.server.ConfigurableWebServerFactory
import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.stereotype.Component

@Component
class ShopPortConfiguration(private val parameter: Parameter) : WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    override fun customize(factory: ConfigurableWebServerFactory) {
        factory.setPort(parameter.getInt("SHOP_SERVER_PORT"))
    }
}