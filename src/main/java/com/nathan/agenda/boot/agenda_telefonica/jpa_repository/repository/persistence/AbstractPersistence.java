package com.nathan.agenda.boot.agenda_telefonica.jpa_repository.repository.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public class AbstractPersistence<T, PK extends Serializable> {

    private final Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public void save(T entity) { entityManager.persist(entity); }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void delete(PK id) {
        entityManager.remove(entityManager.getReference(entityClass, id));
    }

}
