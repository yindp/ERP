/*
package com.yinom.pdd.erp.service.impl;

import com.yinom.pdd.erp.bean.Category;
import com.yinom.pdd.erp.dao.CategoryDAO;
import com.yinom.pdd.erp.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

*/
/**
 * Created by yindp on 5/4/2017.
 *//*


@Service(value = "iCategoryService")
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryDAO iCategoryDAO;

    public void insert(Category category) {
        iCategoryDAO.insert(category);
    }

    public List<Category> queryAll(Category category) {
        return iCategoryDAO.queryAll(Category.class);
    }

    public List<Category> queryAll(String hql, Object... params) {
        return iCategoryDAO.queryAll(hql, params);
    }

    public Category query(String hql, Object... params) {
        return iCategoryDAO.query(hql, params);
    }
}
*/
