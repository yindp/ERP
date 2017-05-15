package com.yinom.pdd.erp.service.impl;

import com.yinom.pdd.erp.bean.Company;
import com.yinom.pdd.erp.dao.ICompanyDAO;
import com.yinom.pdd.erp.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */

@Service(value = "iCompanyService")
public class CompanyServiceImpl implements ICompanyService {
    @Autowired
    private ICompanyDAO iCompanyDAO;

    public void insert(Company company) {
        iCompanyDAO.insert(company);
    }

    public List<Company> queryAll(Company company) {
        return iCompanyDAO.queryAll(Company.class);
    }
}
