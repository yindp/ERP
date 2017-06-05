package com.yinom.pdd.erp.service.impl;

import com.yinom.pdd.erp.bean.Company;
import com.yinom.pdd.erp.bean.Pagination;
import com.yinom.pdd.erp.dao.CompanyDAO;
import com.yinom.pdd.erp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */

@Service(value = "companyService")
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDAO iCompanyDAO;

    public void insert(Company company) {
        iCompanyDAO.insert(company);
    }

    public void delete(Company company) {
        iCompanyDAO.delete(company);
    }

    public void update(Company company) {
        iCompanyDAO.update(company);
    }

    public Pagination count() {
        return iCompanyDAO.count(Company.class);
    }

    public Company query(String hql, Object... params) {
        return null;
    }

    public List<Company> queryList(Pagination pagination) {
        String hql = "from Company order by esc desc";
        return iCompanyDAO.queryList(pagination, hql);
    }
}
