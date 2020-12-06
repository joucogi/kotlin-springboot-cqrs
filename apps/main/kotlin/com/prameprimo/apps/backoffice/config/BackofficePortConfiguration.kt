package com.prameprimo.apps.backoffice.config

import io.github.cdimascio.dotenv.Dotenv
import org.springframework.boot.web.server.ConfigurableWebServerFactory
import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.stereotype.Component

@Component
class BackofficePortConfiguration : WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    override fun customize(factory: ConfigurableWebServerFactory?) {
        val params = Dotenv.load()
        factory!!.setPort(params["BACKOFFICE_SERVER_PORT"].toInt())
    }
}