package com.yinom.pdd.erp.action;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.opensymphony.xwork2.ActionSupport;
import com.yinom.pdd.erp.bean.Company;
import com.yinom.pdd.erp.bean.Pagination;
import com.yinom.pdd.erp.service.CompanyService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yindp on 6/1/17.
 */
@Namespace(value = "/test/company")
@Scope(value = "prototype")
@Controller(value = "testCompanyAction")
@ParentPackage(value = "json-default")
public class TestCompanyAction extends ActionSupport {
    private String page;
    private String rows;
    private JSONObject result;
    private JsonObject jsonObject;
    private Pagination pagination = new Pagination();
    private Company company;
    private String res;

    @Autowired
    private CompanyService companyService;

    @Action(value = "list", results = {@Result(name = "success", location = "/user/company.jsp")})
    public String list() {
        return SUCCESS;
    }

    @Action(value = "queryJson", results = {@Result(name = "success", type = "json", params = {"root", "result"})})
    public String queryJson() {
        pagination.setCurrentPage(Integer.parseInt(page));
        pagination.setRowsPerPage(Integer.parseInt(rows));
        List<Company> companyList = companyService.queryList(pagination);
        pagination.setTotalRows(companyService.count().getTotalRows());
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total", pagination.getTotalRows());
        jsonMap.put("rows", companyList);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"parent", "children", "departments", "posts", "users"});
        result = JSONObject.fromObject(jsonMap, jsonConfig);
        System.out.println(result);
        return SUCCESS;
    }

    @Action(value = "queryGson", results = {@Result(name = "success", type = "json",params = {"root", "res"})})
    public String queryGson() {
        pagination.setCurrentPage(Integer.parseInt(page));
        pagination.setRowsPerPage(Integer.parseInt(rows));
        List<Company> companyList = companyService.queryList(pagination);
        pagination.setTotalRows(companyService.count().getTotalRows());
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total", pagination.getTotalRows());
        jsonMap.put("page", pagination.getCurrentPage());
        jsonMap.put("rows", companyList);
        Gson gson = new Gson();
        res = gson.toJson(jsonMap);
        JsonParser jsonParser = new JsonParser();
        jsonObject = jsonParser.parse(res).getAsJsonObject();
        result = JSONObject.fromObject(jsonMap);
        System.out.println(jsonObject);
        return SUCCESS;
    }

    @Action(value = "insert", results = {@Result(name = "success", location = "/test/company/list", type = "redirect")})
    public String insert() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String esc = sdf.format(c.getTime());
        company.setEsc(esc);
        companyService.insert(company);
        return SUCCESS;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public JSONObject getResult() {
        return result;
    }

    public void setResult(JSONObject result) {
        this.result = result;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public JsonObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
}
