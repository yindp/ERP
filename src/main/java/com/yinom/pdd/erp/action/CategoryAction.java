package com.yinom.pdd.erp.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yinom.pdd.erp.bean.Category;
import com.yinom.pdd.erp.bean.Company;
import com.yinom.pdd.erp.service.ICategoryService;
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
@Namespace(value = "/admin")
@Scope(value = "prototype")
@Controller(value = "categoryAction")
@ParentPackage(value = "struts-default")
/*@ParentPackage(value = "need-login")*/
//@InterceptorRef(value = "myDefaultStack")
public class CategoryAction extends ActionSupport implements ModelDriven {
    private Category category;
    private List<Category> categories = new ArrayList<Category>();
    @Autowired
    private ICategoryService categoryService;



    public Object getModel() {
        if (category == null) {
            category = new Category();
        }
        return category;
    }
    @Action(value = "queryCategoryALL", results = {@Result(name = "success", location = "/user/category.jsp"), @Result(name = "error", location = "/error.jsp")})
    public String queryCategoryALL() {
        categories = categoryService.queryAll(category);
        ActionContext.getContext().put("categories", categories);
        return SUCCESS;
    }
    @Action(value = "addCategory", results = {@Result(name = "success", location = "/admin/queryCategoryALL",type = "redirect"), @Result(name = "error", location = "/error.jsp")})
    public String addCategory() {
        if (category.getParent().getId().equals("-1")) {
            category.setParent(null);
        }
        categoryService.insert(category);
        return SUCCESS;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
