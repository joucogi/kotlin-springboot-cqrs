package com.prameprimo.shop.products

import com.prameprimo.shop.ShopInfrastructureTestCase
import com.prameprimo.shop.products.infrastructure.persistence.InMemoryProductRepository
import org.springframework.beans.factory.annotation.Autowired

open class ProductsShopInfrastructureTestCase : ShopInfrastructureTestCase() {
    protected val inMemoryProductRespository = InMemoryProductRepository()

    //@Autowired
    //val mysqlProductRespository: MySqlProductRepository? = null
}