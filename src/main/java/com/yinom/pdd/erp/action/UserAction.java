/*
package com.yinom.pdd.erp.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yinom.pdd.erp.bean.Company;
import com.yinom.pdd.erp.bean.Department;
import com.yinom.pdd.erp.bean.Post;
import com.yinom.pdd.erp.bean.User;
import com.yinom.pdd.erp.service.CompanyService;
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

*
 * Created by yindp on 5/4/2017.


@Namespace(value = "/user")
@Scope(value = "prototype")
@Controller(value = "userAction")
@ParentPackage(value = "struts-default")
@ParentPackage(value = "need-login")

//@InterceptorRef(value = "myDefaultStack")
public class UserAction extends ActionSupport implements ModelDriven {

    private User user;
    private List<Company> companies = new ArrayList<Company>();
    private List<Department> departments = new ArrayList<Department>();
    private List<Post> posts = new ArrayList<Post>();
    private List<User> users = new ArrayList<User>();

    @Autowired
    private IUserService iUserService;
    @Autowired
    private CompanyService companyService;
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

    @Action(value = "list", results = {@Result(name = "success", location = "/user/user.jsp"), @Result(name = "error", location = "/error.jsp")})
    public String User() {
        companies = companyService.queryAll(user.getCompany());
        departments = iDepartmentService.queryAll(user.getDepartment());
        posts = iPostService.queryAll(user.getPost());
        users = iUserService.queryAll(user);
        ActionContext.getContext().put("companies", companies);
        ActionContext.getContext().put("departments", departments);
        ActionContext.getContext().put("posts", posts);
        return SUCCESS;
    }

    @Action(value = "add", results = {@Result(name = "success", location = "/user/list",type = "redirect"), @Result(name = "error", location = "/error.jsp")})
    public String add() {
        if (user.getCompany().getId().equals("-1")) {
            user.setCompany(null);
        }
        if (user.getDepartment().getId().equals("-1")) {
            user.setDepartment(null);
        }
        if (user.getPost().getId().equals("-1")) {
            user.setPost(null);
        }
        Calendar c=Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String no = sdf.format(c.getTime());
        user.setNo(no);
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
*/
