package com.prameprimo.shared.infrastructure.hibernate

import com.prameprimo.shared.domain.Identifier
import org.hibernate.SessionFactory
import javax.persistence.criteria.CriteriaQuery

abstract class HibernateRepository<T>(
        private val sessionFactory: SessionFactory,
        private val aggregateClass: Class<T>
) {
        protected fun all(): List<T> {
                val criteria: CriteriaQuery<T> = sessionFactory.criteriaBuilder.createQuery(aggregateClass)
                criteria.from(aggregateClass)
                return sessionFactory.currentSession.createQuery(criteria).resultList
        }

        protected fun byId(id: Identifier): T? {
                return sessionFactory.currentSession.byId(aggregateClass).load(id)
        }

        protected fun persist(entity: T) {
                sessionFactory.currentSession.saveOrUpdate(entity)
                sessionFactory.currentSession.flush()
                sessionFactory.currentSession.clear()
        }
}