package com.prameprimo.apps.shop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(
        basePackages = ["com.prameprimo.shop", "com.prameprimo.shared", "com.prameprimo.apps.shop"]
)
class ShopApplication
