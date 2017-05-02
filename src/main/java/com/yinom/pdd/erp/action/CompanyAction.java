package com.yinom.pdd.erp.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yinom.pdd.erp.bean.Company;
import com.yinom.pdd.erp.service.inte.CompanyService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by yindp on 5/2/17.
 */
@Namespace(value = "/")
@Scope(value = "prototype")
@Controller(value = "companyAction")
/*@ParentPackage(value = "struts-default")*/
/*@ParentPackage(value = "need-login")*/
//@InterceptorRef(value = "myDefaultStack")
public class CompanyAction extends ActionSupport implements ModelDriven {
    private Company company = new Company();
    @Autowired
    private CompanyService companyService;

    @Action(value = "addCompany", results = {@Result(name = "success", location = "/success.jsp"), @Result(name = "error", location = "/error.jsp")})
    public String addCompany() {
        try {
            companyService.insert(company);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }


    public Company getCompany() {
        return company;
    }


    public void setCompany(Company company) {
        this.company = company;
    }


    public Object getModel() {
        if (company == null) {
            company = new Company();
        }
        return company;
    }
}
