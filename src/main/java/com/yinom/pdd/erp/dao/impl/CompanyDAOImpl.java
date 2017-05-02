package com.yinom.pdd.erp.dao.impl;

import com.yinom.pdd.erp.bean.Company;
import com.yinom.pdd.erp.dao.inte.CompanyDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yindp on 5/2/17.
 */
@Repository(value = "companyDAO")
public class CompanyDAOImpl implements CompanyDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void insert(Company company) {
        getSession().save(company);
    }

    public void delete(Company company) {
        getSession().delete(company);
    }

    public void update(Company company) {
        getSession().update(company);
    }

    public Company query(Company company) {
        Company company1 = getSession().load(Company.class, company.getId());
        return company1;
    }

    public List<Company> queryAll() {
        String hql = "from Company";
        List<Company> companies = null;
        Query query = getSession().createQuery(hql);
        companies = query.getResultList();
        return companies;
    }
}
