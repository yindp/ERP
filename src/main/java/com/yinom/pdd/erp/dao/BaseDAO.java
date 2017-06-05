package com.yinom.pdd.erp.dao;

import com.yinom.pdd.erp.bean.Pagination;

import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */
public interface BaseDAO<T> {
    void insert(T entity);

    void delete(T entity);

    void update(T entity);

    long count(String hql, Object... params);

    Pagination count(Class<T> entityClazz);

    T query(String hql, Object... params);

    List<T> queryList(Pagination pagination,String hql);

    List<T> queryList(String hql, Object... params);

    List<T> queryList(Pagination pagination, String hql, Object... params);
}