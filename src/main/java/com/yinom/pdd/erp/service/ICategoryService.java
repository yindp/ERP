package com.yinom.pdd.erp.service;

import com.yinom.pdd.erp.bean.Category;
import com.yinom.pdd.erp.bean.User;

import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */
public interface ICategoryService {
    void insert(Category category);

    List<Category> queryAll(Category category);

    List<Category> queryAll(String hql, Object... params);

    Category query(String hql, Object... params);
}
