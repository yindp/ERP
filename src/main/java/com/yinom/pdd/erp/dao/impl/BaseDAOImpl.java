package com.yinom.pdd.erp.dao.impl;

import com.yinom.pdd.erp.bean.Pagination;
import com.yinom.pdd.erp.dao.BaseDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */
public class BaseDAOImpl<T> implements BaseDAO<T> {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void insert(T entity) {
        getSession().save(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public void update(T entity) {
        getSession().update(entity);
    }

    public Query queryExe(String hql, Object... params) {
        Query query = getSession().createQuery(hql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        return query;
    }

    public Pagination count(Class<T> entityClazz) {
        Pagination pagination = new Pagination();
        String hql = "select count(*) from " + entityClazz.getSimpleName();
        Query query = getSession().createQuery(hql);
        int totalRows = ((Number) query.uniqueResult()).intValue();
        pagination.setTotalRows(totalRows);
       /* int totalPages = totalRows / pagination.getRowsPerPage() + 1;
        pagination.setTotalPages(totalPages);*/
        return pagination;
    }

    public long count(String hql, Object... params) {
        return 0;
    }

    public T query(String hql, Object... params) {
        return null;
    }

    public List<T> queryList(String hql, Object... params) {
        return null;
    }

    public List<T> queryList(Pagination pagination, String hql, Object... params) {
        Query query = getSession().createQuery(hql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i + "", params[i]);
            }
        }
        int first = (pagination.getCurrentPage() - 1) * pagination.getRowsPerPage() + 1;
        int max;
        if (pagination.getCurrentPage() != pagination.getTotalPages()) {
            max = (pagination.getCurrentPage()) * pagination.getRowsPerPage();
        } else {
            max = pagination.getTotalRows();
        }
        List<T> resultList = query.setFirstResult(first).setMaxResults(pagination.getRowsPerPage()).list();
        return resultList;
    }

    public List<T> queryList(Pagination pagination,String hql) {
        Query query = getSession().createQuery(hql);
        int first = (pagination.getCurrentPage() - 1) * pagination.getRowsPerPage() + 1;
        List<T> resultList = query.setFirstResult(first).setMaxResults(pagination.getRowsPerPage()).list();
        return resultList;
    }
}
