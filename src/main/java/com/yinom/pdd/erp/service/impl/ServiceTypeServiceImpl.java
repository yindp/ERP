/*
package com.yinom.pdd.erp.service.impl;

import com.yinom.pdd.erp.bean.ServiceType;
import com.yinom.pdd.erp.dao.ServiceTypeDAO;
import com.yinom.pdd.erp.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

*/
/**
 * Created by yindp on 5/4/2017.
 *//*


@Service(value = "serviceTypeServiceImpl")
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeDAO serviceTypeDAO;

    public void insert(ServiceType serviceType) {
        serviceTypeDAO.insert(serviceType);
    }

    public List<ServiceType> queryAll(ServiceType serviceType) {
        return serviceTypeDAO.queryAll(ServiceType.class);
    }

    public List<ServiceType> queryAll(String hql, Object... params) {
        return serviceTypeDAO.queryAll(hql, params);
    }

    public ServiceType query(String hql, Object... params) {
        return serviceTypeDAO.query(hql, params);
    }
}
*/
