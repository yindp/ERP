package com.yinom.pdd.erp.service;

import com.yinom.pdd.erp.bean.User;

import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */
public interface IUserService {
    void insert(User user);

    List<User> queryAll(User user);

    List<User> queryAll(String hql, Object... params);

    User query(String hql, Object... params);
}
