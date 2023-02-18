package com.wizardVadim.BookShopApp.data;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManagerFactory;

public abstract class AbstractHibernateDao<T> {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    private Class<T> clazz;

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T findOne(Long id) {
        return getSession().find(clazz, id);
    }

    public Session getSession() {
        return entityManagerFactory.createEntityManager().unwrap(Session.class);
    }
}
