package com.prameprimo.shared.infrastructure.hibernate

import org.hibernate.SessionFactory
import javax.persistence.criteria.CriteriaQuery

abstract class HibernateRepository<T>(
        protected val sessionFactory: SessionFactory,
        protected val aggregateClass: Class<T>
) {
        protected fun all(): List<T> {
                val criteria: CriteriaQuery<T> = sessionFactory.criteriaBuilder.createQuery(aggregateClass)
                criteria.from(aggregateClass)
                return sessionFactory.currentSession.createQuery(criteria).resultList
        }
}