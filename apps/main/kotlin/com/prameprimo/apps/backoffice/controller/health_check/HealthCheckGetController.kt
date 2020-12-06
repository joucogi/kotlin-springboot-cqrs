package com.prameprimo.apps.backoffice.controller.health_check

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckGetController {

    @GetMapping("/health-check")
    fun index(): ResponseEntity<HashMap<String, String>> =
            ResponseEntity.ok().body(
                    hashMapOf(
                            "status" to "ok",
                            "application" to "backoffice"
                    )
            )
}