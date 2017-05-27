package com.yinom.pdd.erp.service;

import com.yinom.pdd.erp.bean.Company;

import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */
public interface ICompanyService {
    void insert(Company company);

    void delete(Company company);

    void update(Company company);

    Company query(String hql, Object... params);

    List<Company> queryByPage(String hql, Object... params);

    List<Company> queryAll(Company company);
}
