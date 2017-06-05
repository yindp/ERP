/*
package com.yinom.pdd.erp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

*/
/**
 * Created by yindp on 5/4/2017.
 *//*

@Namespace(value = "/test")
@Scope(value = "prototype")
@Controller(value = "testAction")
@ParentPackage(value = "json-default")
public class TestAction extends ActionSupport implements ServletRequestAware {
    private static final long serialVersionUID = 1L;
    private HttpServletRequest request;
    private String result;

    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    @Action(value = "jsonAjax", results = {@Result(name = "success",type = "json",params = {"root","result"}), @Result(name = "error", location = "/error.jsp")})
    public String executeAjax() {
        try {
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String position = request.getParameter("position");

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", name);
            map.put("age", age);
            map.put("position", position);

            net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(map);

            result = json.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }
}
*/
