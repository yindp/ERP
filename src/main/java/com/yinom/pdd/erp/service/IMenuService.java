package com.yinom.pdd.erp.service;

import com.yinom.pdd.erp.bean.Menu;

import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */
public interface IMenuService {
    void insert(Menu menu);
    List<Menu> queryAll(Menu menu);
}
