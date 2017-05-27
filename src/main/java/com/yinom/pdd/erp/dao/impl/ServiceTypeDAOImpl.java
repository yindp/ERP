package com.yinom.pdd.erp.dao.impl;

import com.yinom.pdd.erp.bean.Category;
import com.yinom.pdd.erp.bean.ServiceType;
import com.yinom.pdd.erp.dao.ICategoryDAO;
import com.yinom.pdd.erp.dao.ServiceTypeDAO;
import org.springframework.stereotype.Repository;

/**
 * Created by yindp on 5/4/2017.
 */
@Repository(value = "serviceTypeDAO")
public class ServiceTypeDAOImpl extends BaseDAOImpl<ServiceType> implements ServiceTypeDAO {

}
