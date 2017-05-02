package com.yinom.pdd.erp.dao.impl;

import com.yinom.pdd.erp.bean.Company;
import com.yinom.pdd.erp.dao.inte.CompanyDAOInte;
import com.yinom.pdd.erp.util.OurSessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yindp on 5/2/17.
 */
public class CompanyDAOImpl implements CompanyDAOInte {
    private Session session = OurSessionFactory.openSession();

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void insert(Company company) {
        session.saveOrUpdate(company);
    }

    public void delete(Company company) {
        session.delete(company);
    }

    public void update(Company company) {
        session.update(company);
    }

    public Company query(Company company) {
        Company company1 = session.load(Company.class, company.getId());
        return company1;
    }

    public List<Company> queryAll() {
        String hql = "from Company";
        List<Company> companies = null;
        Query query = session.createQuery(hql);
        companies = query.getResultList();
        return companies;
    }
}
