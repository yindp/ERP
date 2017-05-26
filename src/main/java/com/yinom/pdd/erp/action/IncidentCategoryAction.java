package com.yinom.pdd.erp.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yinom.pdd.erp.bean.Department;
import com.yinom.pdd.erp.bean.IncidentCategory;
import com.yinom.pdd.erp.bean.TreeNode;
import com.yinom.pdd.erp.service.IDepartmentService;
import com.yinom.pdd.erp.service.IncidentCategoryService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yindp on 5/26/17.
 */
@Namespace(value = "/admin/incidentCategory")
@Scope(value = "prototype")
@Controller(value = "incidentCategoryAction")
@ParentPackage(value = "json-default")
public class IncidentCategoryAction extends ActionSupport {
    private List<IncidentCategory> incidentCategoryList = new ArrayList<IncidentCategory>();
    private List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
    private List<Department> departmentList = new ArrayList<Department>();
    private TreeNode treeNode = new TreeNode();
    private String id=null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Autowired
    private IncidentCategoryService incidentCategoryService;
    @Autowired
    private IDepartmentService departmentService;

    @Test
    @Action(value = "query", results = {@Result(type = "json", params = {"root", "treeNodeList"}), @Result(name = "error", location = "/error.jsp")})
    public String query() {
        String hql2;
        String[] params;
        if (id == null) {
            hql2 = "from Department where parent is null";
            departmentList = departmentService.queryAll(hql2);
        } else {
            hql2="from Department where parent.id =?";
            params = new String[]{id};
            departmentList = departmentService.queryAll(hql2,params);
        }
/*        String hql = "from IncidentCategory where parentCategory is null";*/

        /*incidentCategoryList = incidentCategoryService.queryAll(hql);*/


        /*for (IncidentCategory incidentCategory : incidentCategoryList) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(incidentCategory.getId());
            treeNode.setText(incidentCategory.getName());
            treeNode.setChecked(false);
            treeNodeList.add(treeNode);
        }*/
        for (Department department : departmentList) {
            treeNode = new TreeNode();
            treeNode.setId(department.getId());
            treeNode.setText(department.getName());
            if (hasChildrenNode(department.getId())) {
                treeNode.setState("closed");
            } else {
                treeNode.setState("open");
            }
            treeNodeList.add(treeNode);
        }
        return SUCCESS;
    }
    public boolean hasChildrenNode(String pa) {
        String hql= "from Department where parent.id =?";
        System.out.println(hql);
        String[] params = new String[]{pa};
        List<Department> departmentList1=departmentService.queryAll(hql,params);
        if (departmentList1.size() > 0) {
            return true;
        }else {
            return false;
        }
    }

    public List<IncidentCategory> getIncidentCategoryList() {
        return incidentCategoryList;
    }

    public void setIncidentCategoryList(List<IncidentCategory> incidentCategoryList) {
        this.incidentCategoryList = incidentCategoryList;
    }

    public List<TreeNode> getTreeNodeList() {
        return treeNodeList;
    }

    public void setTreeNodeList(List<TreeNode> treeNodeList) {
        this.treeNodeList = treeNodeList;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public TreeNode getTreeNode() {
        return treeNode;
    }

    public void setTreeNode(TreeNode treeNode) {
        this.treeNode = treeNode;
    }
}
