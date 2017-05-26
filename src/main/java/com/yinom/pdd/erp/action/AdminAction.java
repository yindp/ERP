package com.yinom.pdd.erp.action;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yinom.pdd.erp.bean.Company;
import com.yinom.pdd.erp.bean.User;
import com.yinom.pdd.erp.service.ICompanyService;
import com.yinom.pdd.erp.service.IUserService;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yindp on 5/4/2017.
 */
@Namespace(value = "/admin")
@Scope(value = "prototype")
@Controller(value = "adminAction")
@ParentPackage(value = "json-default")
/*@ParentPackage(value = "need-login")*/
//@InterceptorRef(value = "myDefaultStack")
public class AdminAction extends ActionSupport implements ModelDriven, ServletRequestAware {

    private User user;
    private Company company;
    private List<Company> companies = new ArrayList<Company>();
    private List<User> users = new ArrayList<User>();
    private String result;
    private HttpServletRequest request;

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

    @Action(value = "query", results = {@Result(type = "json", params = {"root", "result"}), @Result(name = "error", location = "/error.jsp")})
    public String queryUser() {
       /* companies = iCompanyService.queryAll(company);
        users = iUserService.queryAll(user);*/
        String hql = "from User user where user.email = ?";
        Object[] objects = new Object[]{user.getEmail()};
        user = iUserService.query(hql, objects);
        //This is json demo
        /*JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setIgnoreDefaultExcludes(false);
        jsonConfig.setExcludes(new String[]{"company","department","post","parent","children"});
        JSONObject json = JSONObject.fromObject(user,jsonConfig);
          result = json.toString();*/

        //this is gson demo
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("no", user.getNo());
        map.put("name", user.getName());
        map.put("company", user.getCompany().getName());
        map.put("department", user.getDepartment().getName());
        map.put("phone", user.getPhone());
        map.put("email", user.getEmail());

        Gson gson=new Gson();
        result = gson.toJson(map);
        System.out.println(result);
        return SUCCESS;
    }
    @Action(value = "newTicket", results = {@Result(name = "success", location = "/ticket.jsp"), @Result(name = "error", location = "/error.jsp")})
    public String newTicket() {
        String hql = "from User user where user.no = ?";
        Object[] objects = new Object[]{user.getNo()};
        user = iUserService.query(hql, objects);
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }
}
