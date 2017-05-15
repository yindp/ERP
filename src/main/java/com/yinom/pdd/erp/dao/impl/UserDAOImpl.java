package com.yinom.pdd.erp.dao.impl;

import com.yinom.pdd.erp.bean.User;
import com.yinom.pdd.erp.dao.IUserDAO;
import org.springframework.stereotype.Repository;

/**
 * Created by yindp on 5/4/2017.
 */
@Repository(value = "iUserDAO")
public class UserDAOImpl extends BaseDAOImpl<User> implements IUserDAO {
/*
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void insert(Company company) {
        System.out.println("Start Insert");
        try {
            getSession().saveOrUpdate(company);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Company> queryAll() {
        List<Company> companies = null;
        String hql = "from Company";
        Query query = getSession().createQuery(hql);
        companies = query.getResultList();
        return companies;
    }

    public List<Company> queryHeadQuarters(Company company) {
        List<Company> companies = null;
        String hql = "from Company where id=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, company.getHeadquarter());
        companies = query.getResultList();
        return companies;
    }

    public List<Company> queryAffiliates(Company company) {
        List<Company> companies = null;
        String hql = "from Company where headquarter=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, company.getId());
        companies = query.getResultList();
        return companies;
    }
*/


}
