package com.yinom.pdd.erp.service.impl;

import com.yinom.pdd.erp.bean.Company;
import com.yinom.pdd.erp.dao.impl.CompanyDAOImpl;
import com.yinom.pdd.erp.dao.inte.CompanyDAOInte;
import com.yinom.pdd.erp.service.inte.CompanyServiceInte;

import java.util.List;

/**
 * Created by yindp on 5/2/17.
 */
public class CompanyServiceImpl implements CompanyServiceInte {
    private CompanyDAOInte companyDAOInte = new CompanyDAOImpl();

    public CompanyDAOInte getCompanyDAOInte() {
        return companyDAOInte;
    }

    public void setCompanyDAOInte(CompanyDAOInte companyDAOInte) {
        this.companyDAOInte = companyDAOInte;
    }

    public void insert(Company company) {
        companyDAOInte.insert(company);
    }

    public void delete(Company company) {
        companyDAOInte.delete(company);
    }

    public void update(Company company) {
        companyDAOInte.update(company);
    }

    public Company query(Company company) {
        return companyDAOInte.query(company);
    }

    public List<Company> queryAll() {
        return getCompanyDAOInte().queryAll();
    }
}
