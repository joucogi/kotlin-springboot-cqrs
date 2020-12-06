package com.prameprimo.apps.shop.config

import io.github.cdimascio.dotenv.Dotenv
import org.springframework.boot.web.server.ConfigurableWebServerFactory
import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.stereotype.Component

@Component
class ShopPortConfiguration : WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    override fun customize(factory: ConfigurableWebServerFactory?) {
        val params = Dotenv.load()
        factory!!.setPort(params["SHOP_SERVER_PORT"].toInt())
    }
}