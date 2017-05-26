package com.yinom.pdd.erp.service;

import com.yinom.pdd.erp.bean.IncidentCategory;
import com.yinom.pdd.erp.bean.User;

import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */
public interface IncidentCategoryService {
    void insert(IncidentCategory incidentCategory);

    List<IncidentCategory> queryAll(IncidentCategory incidentCategory);

    List<IncidentCategory> queryAll(String hql, Object... params);

    IncidentCategory query(String hql, Object... params);
}
