package com.yinom.pdd.erp.service;

import com.yinom.pdd.erp.bean.Department;

import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */
public interface IDepartmentService {
    void insert(Department department);
    List<Department> queryAll(Department department);
}
