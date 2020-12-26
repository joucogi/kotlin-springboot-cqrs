package com.prameprimo.shop

import com.prameprimo.apps.shop.ShopApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(classes = [ShopApplication::class])
open class ShopInfrastructureTestCase