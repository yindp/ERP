package com.yinom.pdd.erp.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */
public interface IBaseDAO<T> {
/*
    void insert(T entity);

    List<T> queryAll(Class<T> entityClazz);

    List query(String hql,Object... params);*/

    // 根据ID加载实体
    T query(Class<T> entityClazz, Serializable id);

    List<T> queryAll(String hql, Object... params);
    T query(String hql, Object... params);

    // 保存实体
    Serializable insert(T entity);
    // 更新实体
    void update(T entity);
    // 删除实体
    void delete(T entity);
    // 根据ID删除实体
    void delete(Class<T> entityClazz, Serializable id);
    // 获取所有实体
    List<T> queryAll(Class<T> entityClazz);
    // 获取实体总数
    long queryCount(Class<T> entityClazz);


}