package com.yinom.pdd.erp.service.impl;

import com.yinom.pdd.erp.bean.Department;
import com.yinom.pdd.erp.dao.IDepartmentDAO;
import com.yinom.pdd.erp.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */

@Service(value = "iDepartmentService")
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    private IDepartmentDAO iDepartmentDAO;

    public void insert(Department department) {
        iDepartmentDAO.insert(department);
    }

    public List<Department> queryAll(Department department) {
        return iDepartmentDAO.queryAll(Department.class);
    }
}
