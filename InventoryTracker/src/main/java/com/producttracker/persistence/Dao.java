package com.producttracker.persistence;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by amalbaugh on 4/19/17.
 */
public class Dao {

    private final Logger log = Logger.getLogger(this.getClass());

    private SessionFactory sessionFactory;

    public <T> List<T> getAll(final Class<T> type) {
        final Session session = sessionFactory.getCurrentSession();
        final Criteria crit = session.createCriteria(type);
        return crit.list();
    }

    public <T> T get(final Class<T> type, int id){
        return (T) sessionFactory.getCurrentSession().get(type, id);
    }

    public <T> T save(final T o){
        return (T) sessionFactory.getCurrentSession().save(o);
    }


    public void delete(final Object object){
        sessionFactory.getCurrentSession().delete(object);
    }

    public <T> void saveOrUpdate(final T o){
        sessionFactory.getCurrentSession().saveOrUpdate(o);
    }

}
