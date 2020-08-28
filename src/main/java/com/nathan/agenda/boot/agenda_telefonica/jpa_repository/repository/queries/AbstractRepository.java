package com.nathan.agenda.boot.agenda_telefonica.jpa_repository.repository.queries;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AbstractRepository<T, PK extends Serializable> {

    private final Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public T findById(PK id) {
        return entityManager.find(entityClass, id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("FROM" + entityClass.getSimpleName(), entityClass).getResultList();
    }

    protected List<T> createQuery(String jpql, Object... params) {
        TypedQuery<T> query = entityManager.createQuery(jpql, entityClass);
        for(int i = 0; i < params.length; i++) {
            query.setParameter(i+1, params[i]);
        }
        return query.getResultList();
    }
}
