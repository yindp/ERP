package com.yinom.pdd.erp.service;

import com.yinom.pdd.erp.bean.Company;
import com.yinom.pdd.erp.bean.Pagination;

import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */
public interface CompanyService {
    void insert(Company company);

    void delete(Company company);

    void update(Company company);

    Pagination count();

    Company query(String hql, Object... params);

    List<Company> queryList(Pagination pagination);
}
