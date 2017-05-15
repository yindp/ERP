package com.yinom.pdd.erp.dao.impl;

import com.yinom.pdd.erp.dao.IBaseDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */
public class BaseDAOImpl<T> implements IBaseDAO<T> {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public T query(Class entityClazz, Serializable id) {
        return (T) getSession().get(entityClazz, id);
    }

    public Serializable insert(Object entity) {
        return getSession().save(entity);
    }

    public void update(Object entity) {
        getSession().saveOrUpdate(entity);
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }

    public void delete(Class<T> entityClazz, Serializable id) {
        String hql = "delete from " + entityClazz.getSimpleName() + "where id=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        query.executeUpdate();
        getSession().beginTransaction().commit();
    }

    public List queryAll(Class entityClazz) {
        return query("select en from " + entityClazz.getSimpleName() + " en");
    }

    public long queryCount(Class entityClazz) {
        List list = query("select count(*) from" + entityClazz.getSimpleName());
        if (list != null && list.size() == 1) {
            return (Long) list.get(0);
        }
        return 0;
    }

    public List query(String hql) {
        return (List) getSession().createQuery(hql).list();
    }


    public List<T> queryAll(String hql, Object... params) {
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
        return (List) query.list();
    }

    public T query(String hql, Object... params) {
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i, params[i]);
        }
        return (T) query.uniqueResult();
    }

    protected List queryByPage(String hql, int pageNo, int pageSize) {
        return getSession().createQuery(hql).setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
    }

    protected List queryByPage(String hql, int pageNo, int pageSize, Object... params) {
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + "", params[i]);
        }
        return query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
    }
}
