/*
package com.yinom.pdd.erp.service.impl;

import com.yinom.pdd.erp.bean.User;
import com.yinom.pdd.erp.dao.UserDAO;
import com.yinom.pdd.erp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

*/
/**
 * Created by yindp on 5/4/2017.
 *//*


@Service(value = "iUserService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDAO iUserDAO;

    public void insert(User user) {
        iUserDAO.insert(user);
    }

    public List<User> queryAll(User user) {
        return iUserDAO.queryAll(User.class);
    }

    public List<User> queryAll(String hql, Object... params) {
        return iUserDAO.queryAll(hql, params);
    }

    public User query(String hql, Object... params) {
        return iUserDAO.query(hql, params);
    }
}
*/
