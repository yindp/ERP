package com.yinom.pdd.erp.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yinom.pdd.erp.bean.Company;
import com.yinom.pdd.erp.bean.Department;
import com.yinom.pdd.erp.service.ICompanyService;
import com.yinom.pdd.erp.service.IDepartmentService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */
@Namespace(value = "/department")
@Scope(value = "prototype")
@Controller(value = "departmentAction")
@ParentPackage(value = "struts-default")
/*@ParentPackage(value = "need-login")*/
//@InterceptorRef(value = "myDefaultStack")
public class DepartmentAction extends ActionSupport implements ModelDriven {

    private Department department;
    private List<Department> departments = new ArrayList<Department>();
    private List<Company> companies = new ArrayList<Company>();

    @Autowired
    private IDepartmentService iDepartmentService;
    @Autowired
    private ICompanyService iCompanyService;

    public Object getModel() {
        if (department == null) {
            department = new Department();
        }
        return department;
    }

    @Action(value = "list", results = {@Result(name = "success", location = "/user/department.jsp"), @Result(name = "error", location = "/error.jsp")})
    public String Department() {
        companies = iCompanyService.queryAll(department.getCompany());
        departments = iDepartmentService.queryAll(department);
        ActionContext.getContext().put("departments", departments);
        ActionContext.getContext().put("companies", companies);
        return SUCCESS;
    }

    @Action(value = "add", results = {@Result(name = "success", location = "/department/list",type = "redirect"), @Result(name = "error", location = "/error.jsp")})
    public String add() {
        if (department.getParent().getId().equals("-1")) {
            department.setParent(null);
        }
        if (department.getCompany().getId().equals("-1")) {
            department.setCompany(null);
        }
        iDepartmentService.insert(department);
        return SUCCESS;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
