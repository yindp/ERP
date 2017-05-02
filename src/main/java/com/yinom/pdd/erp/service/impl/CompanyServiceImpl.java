package com.yinom.pdd.erp.service.impl;

import com.yinom.pdd.erp.bean.Company;
import com.yinom.pdd.erp.dao.inte.CompanyDAO;
import com.yinom.pdd.erp.service.inte.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yindp on 5/2/17.
 */
@Service(value = "companyService")
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDAO companyDAO;

    public void insert(Company company) {
        companyDAO.insert(company);
    }

    public void delete(Company company) {
        companyDAO.delete(company);
    }

    public void update(Company company) {
        companyDAO.update(company);
    }

    public Company query(Company company) {
        return companyDAO.query(company);
    }

    public List<Company> queryAll() {
        return companyDAO.queryAll();
    }
}
