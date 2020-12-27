package com.prameprimo.shop.products

import com.prameprimo.shop.ShopInfrastructureTestCase
import com.prameprimo.shop.products.domain.contracts.ProductRepository
import com.prameprimo.shop.products.infrastructure.persistence.InMemoryProductRepository
import org.springframework.beans.factory.annotation.Autowired

abstract class ProductsShopInfrastructureTestCase : ShopInfrastructureTestCase() {
    protected val inMemoryProductRespository = InMemoryProductRepository()

    @Autowired
    protected lateinit var mysqlProductRespository: ProductRepository
}