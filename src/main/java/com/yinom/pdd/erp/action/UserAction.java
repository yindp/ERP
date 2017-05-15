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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yindp on 5/4/2017.
 */
@Namespace(value = "/user")
@Scope(value = "prototype")
@Controller(value = "userAction")
@ParentPackage(value = "struts-default")
/*@ParentPackage(value = "need-login")*/
//@InterceptorRef(value = "myDefaultStack")
public class UserAction extends ActionSupport implements ModelDriven {

    private User user;
    private List<Company> companies = new ArrayList<Company>();
    private List<Department> departments = new ArrayList<Department>();
    private List<Post> posts = new ArrayList<Post>();

    @Autowired
    private IUserService iUserService;
    @Autowired
    private ICompanyService iCompanyService;
    @Autowired
    private IDepartmentService iDepartmentService;
    @Autowired
    private IPostService iPostService;

    public Object getModel() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    @Action(value = "list", results = {@Result(name = "success", location = "/user.jsp"), @Result(name = "error", location = "/error.jsp")})
    public String User() {
        companies = iCompanyService.queryAll(user.getCompany());
        departments = iDepartmentService.queryAll(user.getDepartment());
        posts = iPostService.queryAll(user.getPost());
        ActionContext.getContext().put("companies", companies);
        ActionContext.getContext().put("departments", departments);
        ActionContext.getContext().put("posts", posts);
        return SUCCESS;
    }

    @Action(value = "add", results = {@Result(name = "success", location = "/success.jsp"), @Result(name = "error", location = "/error.jsp")})
    public String add() {
        iUserService.insert(user);
        return SUCCESS;
    }

    @Action(value = "signIn", results = {@Result(name = "success", location = "/index.jsp"), @Result(name = "error", location = "/error.jsp")})
    public String signIn() {
        String hql = "from User where email=? and password=?";
        user = iUserService.query(hql, user.getEmail(), user.getPassword());
        if (user != null) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

}
