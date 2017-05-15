package com.yinom.pdd.erp.service;

import com.yinom.pdd.erp.bean.Company;

import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */
public interface ICompanyService {
    void insert(Company company);
    List<Company> queryAll(Company company);
}
