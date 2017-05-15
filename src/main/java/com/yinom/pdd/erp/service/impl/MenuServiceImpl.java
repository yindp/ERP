package com.yinom.pdd.erp.service.impl;

import com.yinom.pdd.erp.bean.Menu;
import com.yinom.pdd.erp.dao.IMenuDAO;
import com.yinom.pdd.erp.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */

@Service(value = "iMenuService")
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private IMenuDAO iMenuDAO;

    public void insert(Menu menu) {
        iMenuDAO.insert(menu);
    }

    public List<Menu> queryAll(Menu menu) {
        return iMenuDAO.queryAll(Menu.class);
    }
}
