package com.yinom.pdd.erp.service.inte;

import com.yinom.pdd.erp.bean.Company;

import java.util.List;

/**
 * Created by yindp on 5/2/17.
 */
public interface CompanyServiceInte {
    public void insert(Company company);

    public void delete(Company company);

    public void update(Company company);

    public Company query(Company company);

    public List<Company> queryAll();
}
