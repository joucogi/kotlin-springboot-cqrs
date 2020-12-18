package com.prameprimo.apps.shop

import com.prameprimo.shared.domain.Service
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType

@SpringBootApplication
@ComponentScan(
        basePackages = ["com.prameprimo.shop", "com.prameprimo.shared", "com.prameprimo.apps.shop"],
        includeFilters = [ComponentScan.Filter(Service::class)]
)
class ShopApplication
