package com.yinom.pdd.erp.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yinom.pdd.erp.bean.Company;
import com.yinom.pdd.erp.service.ICompanyService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * Created by yindp on 5/4/2017.
 */
@Namespace(value = "/company")
@Scope(value = "prototype")
@Controller(value = "companyAction")
@ParentPackage(value = "struts-default")
/*@ParentPackage(value = "need-login")*/
//@InterceptorRef(value = "myDefaultStack")
public class CompanyAction extends ActionSupport implements ModelDriven {

    private Company company;
    private List<Company> companies = new ArrayList<Company>();
    private List<Company> headquarters = new ArrayList<Company>();
    private List<Company> affiliates = new ArrayList<Company>();

    @Autowired
    private ICompanyService iCompanyService;

    public Object getModel() {
        if (company == null) {
            company = new Company();
        }
        return company;
    }

    @Action(value = "list", results = {@Result(name = "success", location = "/user/company.jsp"), @Result(name = "error", location = "/error.jsp")})
    public String company() {
        companies = iCompanyService.queryAll(company);
        ActionContext.getContext().put("companies", companies);
        return SUCCESS;
    }

    @Action(value = "add", results = {@Result(name = "success", location = "/company/list",type = "redirect"), @Result(name = "error", location = "/error.jsp")})
    public String add() {
        if (company.getParent().getId().equals("-1")) {
            company.setParent(null);
        }
        Calendar c=Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String no = sdf.format(c.getTime());
        company.setNo(no);
        iCompanyService.insert(company);
        return SUCCESS;
    }
    public String insert() {
        iCompanyService.insert(company);
        return SUCCESS;
    }
    public String delete() {
        return SUCCESS;
    }
    public String update() {
        return SUCCESS;
    }
    public String query() {
        return SUCCESS;
    }
    public String queryByPage() {
        return SUCCESS;
    }
    public String queryAll() {
        return SUCCESS;
    }



    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Company> getHeadQuarters() {
        return headquarters;
    }

    public void setHeadQuarters(List<Company> headquarters) {
        this.headquarters = headquarters;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<Company> getAffiliates() {
        return affiliates;
    }

    public void setAffiliates(List<Company> affiliates) {
        this.affiliates = affiliates;
    }
}
