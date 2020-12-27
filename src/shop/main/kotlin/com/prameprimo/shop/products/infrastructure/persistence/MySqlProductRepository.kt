package com.prameprimo.shop.products.infrastructure.persistence

import com.prameprimo.shared.domain.Service
import com.prameprimo.shared.infrastructure.hibernate.HibernateRepository
import com.prameprimo.shop.products.domain.Product
import com.prameprimo.shop.products.domain.ProductId
import com.prameprimo.shop.products.domain.contracts.ProductRepository
import com.prameprimo.shop.products.domain.exceptions.ProductNotExist
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Primary
import org.springframework.transaction.annotation.Transactional

@Service
@Primary
@Transactional("shop-transaction_manager")
open class MySqlProductRepository(
        @Qualifier("shop-session_factory") sessionFactory: SessionFactory
) : HibernateRepository<Product>(
        sessionFactory,
        Product::class.java
), ProductRepository {
    override fun searchAll(): List<Product> = all()

    override fun findById(id: ProductId): Product = byId(id) ?: throw ProductNotExist(id)

    override fun save(product: Product) = persist(product)
}
