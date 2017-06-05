/*
package com.yinom.pdd.erp.action;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;
import com.yinom.pdd.erp.bean.Company;
import com.yinom.pdd.erp.bean.Page;
import com.yinom.pdd.erp.service.CompanyService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * Created by yindp on 5/4/2017.
 *//*

@Namespace(value = "/admin/company")
@Scope(value = "prototype")
@Controller(value = "companyAction")
@ParentPackage(value = "json-default")
public class CompanyAction extends ActionSupport {
    private String resultObj;
    private Page page;
    private Company company;
    private List<Company> companyList = new ArrayList<Company>();
    @Autowired
    private CompanyService companyService;

    @Action(value = "list", results = {@Result(type = "json",params = {"root","resultObj"}), @Result(name = "error", location = "/error.jsp")})
    public String list() {
        page = companyService.count();
        companyList = companyService.queryList(page);
        ArrayList<Map<String, Object>> all = new ArrayList<Map<String, Object>>();
        for (Company company : companyList) {
            Map<String, Object> m = new HashMap<String, Object>();
            m.put("id", company.getId());
            m.put("name", company.getName());
            m.put("esc", company.getEsc());
            m.put("address", company.getAddress());
            m.put("pinyin", company.getPinyin());
            m.put("comment", company.getComment());

            all.add(m);
        }
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("total", page.getTotalRows());
        json.put("page", page.getCurrentPage());
        json.put("rows", all);
        Gson gson=new Gson();
        resultObj = gson.toJson(json);
        System.out.println(resultObj);
        return SUCCESS;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getResultObj() {
        return resultObj;
    }

    public void setResultObj(String resultObj) {
        this.resultObj = resultObj;
    }
}
*/
