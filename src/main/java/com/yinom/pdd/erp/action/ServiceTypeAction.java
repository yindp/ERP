/*
package com.yinom.pdd.erp.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yinom.pdd.erp.bean.Category;
import com.yinom.pdd.erp.bean.Department;
import com.yinom.pdd.erp.bean.ServiceType;
import com.yinom.pdd.erp.bean.TreeNode;
import com.yinom.pdd.erp.service.ICategoryService;
import com.yinom.pdd.erp.service.ServiceTypeService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by yindp on 5/4/2017.
 *//*

@Namespace(value = "/admin/serviceType")
@Scope(value = "prototype")
@Controller(value = "serviceTypeAction")
@ParentPackage(value = "json-default")
public class ServiceTypeAction extends ActionSupport implements ModelDriven {
    private ServiceType serviceType;
    private List<ServiceType> serviceTypeList = new ArrayList<ServiceType>();
    private List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
    @Autowired
    private ServiceTypeService serviceTypeService;

    public Object getModel() {
        if (serviceType == null) {
            serviceType = new ServiceType();
        }
        return serviceType;
    }
    @Action(value = "queryAll", results = {@Result(name = "success", location = "/user/serviceType.jsp"), @Result(name = "error", location = "/error.jsp")})
    public String queryAll() {
        serviceTypeList = serviceTypeService.queryAll(serviceType);
        return SUCCESS;
    }
    @Action(value = "jsonQueryAll", results = {@Result(type = "json",params = {"root","treeNodeList"}), @Result(name = "error", location = "/error.jsp")})
    public String jsonQueryAll() {
        serviceTypeList = serviceTypeService.queryAll(serviceType);
        for (ServiceType serviceType : serviceTypeList) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(serviceType.getId());
            treeNode.setText(serviceType.getName());
            treeNodeList.add(treeNode);
        }
        return SUCCESS;
    }
    @Action(value = "add", results = {@Result(name = "success", location = "/admin/serviceType/queryAll",type = "redirect"), @Result(name = "error", location = "/error.jsp")})
    public String add() {
        serviceTypeService.insert(serviceType);
        return SUCCESS;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public List<ServiceType> getServiceTypeList() {
        return serviceTypeList;
    }

    public void setServiceTypeList(List<ServiceType> serviceTypeList) {
        this.serviceTypeList = serviceTypeList;
    }

    public List<TreeNode> getTreeNodeList() {
        return treeNodeList;
    }

    public void setTreeNodeList(List<TreeNode> treeNodeList) {
        this.treeNodeList = treeNodeList;
    }
}
*/
