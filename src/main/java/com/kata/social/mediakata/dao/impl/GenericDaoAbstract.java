package com.kata.social.mediakata.dao.impl;

import com.kata.social.mediakata.dao.abstracts.GenericDao;
import com.kata.social.mediakata.dao.util.SingleResultUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public abstract class GenericDaoAbstract<T, PK extends Serializable> implements GenericDao<T, PK> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> clazz;

    /*
    Ошибка при попытке наследования от этого класса(GenericDaoAbstract)
    Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [com.kata.social.mediakata.dao.impl.dto.DaoImpl]:
     Constructor threw exception; nested exception is java.lang.ClassCastException: class java.lang.Class cannot be cast to class java.lang.reflect.ParameterizedType (java.lang.Class and java.lang.reflect.ParameterizedType are in module java.base of loader 'bootstrap')
     */
    @SuppressWarnings("unchecked")
    public GenericDaoAbstract() {
        Type t = getClass().getSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        clazz = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public void create(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public Optional<T> getById(PK id) {
        TypedQuery<T> query = entityManager.createQuery(
                        "SELECT a FROM " + clazz.getSimpleName() + "as a WHERE a.id = :paramId", clazz)
                .setParameter("paramId", id);
        return SingleResultUtil.getSingleResultOrNull(query);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public void deleteById(PK id) {
        entityManager.remove(entityManager.find(clazz, id));
    }

    @Override
    public boolean existById(PK id) {
        Long count = entityManager.createQuery(
                        "SELECT count(b) " +
                                "FROM " + clazz.getSimpleName() + " b " +
                                "WHERE b.id = :paramId", Long.class)
                .setParameter("paramId", id)
                .getSingleResult();
        return (count > 0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return entityManager.createQuery("SELECT a FROM " + clazz.getSimpleName() + " AS a ORDER BY a.id").getResultList();
    }
}
