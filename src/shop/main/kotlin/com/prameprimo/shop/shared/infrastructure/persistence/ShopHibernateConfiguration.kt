package com.prameprimo.shop.shared.infrastructure.persistence

import com.prameprimo.shared.infrastructure.config.Parameter
import com.prameprimo.shared.infrastructure.config.ParameterNotExist
import com.prameprimo.shared.infrastructure.hibernate.HibernateConfigurationFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.orm.hibernate5.LocalSessionFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.io.IOException
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
open class ShopHibernateConfiguration(
        private val factory: HibernateConfigurationFactory,
        private val config: Parameter
) {
    private val CONTEXT_NAME = "shop"

    @Throws(IOException::class, ParameterNotExist::class)
    @Bean("shop-transaction_manager")
    open fun hibernateTransactionManager(): PlatformTransactionManager {
        return factory.hibernateTransactionManager(sessionFactory())
    }

    @Bean("shop-session_factory")
    @Throws(IOException::class, ParameterNotExist::class)
    open fun sessionFactory(): LocalSessionFactoryBean {
        return factory.sessionFactory(CONTEXT_NAME, dataSource())
    }

    @Bean("shop-data_source")
    @Throws(IOException::class, ParameterNotExist::class)
    open fun dataSource(): DataSource {
        return factory.dataSource(
                config.get("SHOP_DATABASE_HOST"),
                config.getInt("SHOP_DATABASE_PORT"),
                config.get("SHOP_DATABASE_NAME"),
                config.get("SHOP_DATABASE_USER"),
                config.get("SHOP_DATABASE_PASSWORD")
        )
    }
}