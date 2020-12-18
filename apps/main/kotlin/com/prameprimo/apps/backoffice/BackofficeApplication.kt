package com.prameprimo.apps.backoffice

import com.prameprimo.shared.domain.Service
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(
        basePackages = ["com.prameprimo.backoffice", "com.prameprimo.shared", "com.prameprimo.apps.backoffice"],
        includeFilters = [ComponentScan.Filter(Service::class)]
)
class BackofficeApplication
