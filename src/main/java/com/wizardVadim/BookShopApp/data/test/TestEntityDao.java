package com.wizardVadim.BookShopApp.data.test;

import com.wizardVadim.BookShopApp.data.AbstractHibernateDao;
import com.wizardVadim.BookShopApp.data.test.TestEntity;
import org.springframework.stereotype.Repository;

@Repository
public class TestEntityDao extends AbstractHibernateDao<TestEntity> {
    public TestEntityDao() {
        super();
        setClazz(TestEntity.class);
    }
}
