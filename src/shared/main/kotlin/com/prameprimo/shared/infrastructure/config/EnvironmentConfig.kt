package com.prameprimo.shared.infrastructure.config

import io.github.cdimascio.dotenv.Dotenv
import io.github.cdimascio.dotenv.dotenv
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ResourceLoader

@Configuration
open class EnvironmentConfig(private val resourceLoader: ResourceLoader ) {

   @Bean
    open fun dotenv(): Dotenv {
       val resource = resourceLoader.getResource("classpath:/.env.local")

        return dotenv {
            directory = "/"
            filename = if (resource.exists()) ".env.local" else ".env"
        }
    }
}