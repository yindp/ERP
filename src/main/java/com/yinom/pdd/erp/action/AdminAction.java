package com.yinom.pdd.erp.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yinom.pdd.erp.bean.Company;
import com.yinom.pdd.erp.bean.Department;
import com.yinom.pdd.erp.bean.Post;
import com.yinom.pdd.erp.bean.User;
import com.yinom.pdd.erp.service.ICompanyService;
import com.yinom.pdd.erp.service.IDepartmentService;
import com.yinom.pdd.erp.service.IPostService;
import com.yinom.pdd.erp.service.IUserService;
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

/**
 * Created by yindp on 5/4/2017.
 */
@Namespace(value = "/admin")
@Scope(value = "prototype")
@Controller(value = "adminAction")
@ParentPackage(value = "json-default")
/*@ParentPackage(value = "need-login")*/
//@InterceptorRef(value = "myDefaultStack")
public class AdminAction extends ActionSupport implements ModelDriven {

    private User user;
    private Company company;
    private List<Company> companies = new ArrayList<Company>();
    private List<User> users = new ArrayList<User>();

    @Autowired
    private IUserService iUserService;
    @Autowired
    private ICompanyService iCompanyService;


    public Object getModel() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    @Action(value = "query", results = {@Result(name = "success",type = "json"), @Result(name = "error", location = "/error.jsp")})
    public String User() {
       /* companies = iCompanyService.queryAll(company);
        users = iUserService.queryAll(user);
        ActionContext.getContext().put("companies", companies);*/
       String result="Just for test";
        System.out.println("test");
        return SUCCESS;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
