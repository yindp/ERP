package com.yinom.pdd.erp.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yinom.pdd.erp.bean.Company;
import com.yinom.pdd.erp.bean.Department;
import com.yinom.pdd.erp.bean.Post;
import com.yinom.pdd.erp.service.ICompanyService;
import com.yinom.pdd.erp.service.IDepartmentService;
import com.yinom.pdd.erp.service.IPostService;
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
@Namespace(value = "/post")
@Scope(value = "prototype")
@Controller(value = "postAction")
@ParentPackage(value = "struts-default")
/*@ParentPackage(value = "need-login")*/
//@InterceptorRef(value = "myDefaultStack")
public class PostAction extends ActionSupport implements ModelDriven {

    private Post post;
    private List<Post> posts = new ArrayList<Post>();
    private List<Company> companies = new ArrayList<Company>();
    private List<Department> departments = new ArrayList<Department>();

    @Autowired
    private IPostService iPostService;
    @Autowired
    private ICompanyService iCompanyService;
    @Autowired
    private IDepartmentService iDepartmentService;

    public Object getModel() {
        if (post == null) {
            post = new Post();
        }
        return post;
    }

    @Action(value = "list", results = {@Result(name = "success", location = "/user/post.jsp"), @Result(name = "error", location = "/error.jsp")})
    public String Post() {
        companies = iCompanyService.queryAll(post.getCompany());
        departments = iDepartmentService.queryAll(post.getDepartment());
        posts = iPostService.queryAll(post);
        ActionContext.getContext().put("posts", posts);
        ActionContext.getContext().put("companies", companies);
        ActionContext.getContext().put("departments", departments);
        return SUCCESS;
    }

    @Action(value = "add", results = {@Result(name = "success", location = "/post/list",type = "redirect"), @Result(name = "error", location = "/error.jsp")})
    public String add() {
        if (post.getParent().getId().equals("-1")) {
            post.setParent(null);
        }
        if (post.getCompany().getId().equals("-1")) {
            post.setCompany(null);
        }
        if (post.getDepartment().getId().equals("-1")) {
            post.setDepartment(null);
        }
        iPostService.insert(post);
        return SUCCESS;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
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
