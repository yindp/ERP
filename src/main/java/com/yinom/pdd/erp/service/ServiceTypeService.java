package com.yinom.pdd.erp.service;

import com.yinom.pdd.erp.bean.Category;
import com.yinom.pdd.erp.bean.ServiceType;

import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */
public interface ServiceTypeService {
    void insert(ServiceType serviceType);

    List<ServiceType> queryAll(ServiceType serviceType);

    List<ServiceType> queryAll(String hql, Object... params);

    ServiceType query(String hql, Object... params);
}
