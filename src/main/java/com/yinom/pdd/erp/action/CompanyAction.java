package com.yinom.pdd.erp.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.yinom.pdd.erp.bean.Company;
import com.yinom.pdd.erp.service.inte.CompanyServiceInte;

/**
 * Created by yindp on 5/2/17.
 */
public class CompanyAction extends ActionSupport implements ModelDriven {
    private Company company;
    private CompanyServiceInte companyServiceInte;


    public String addCompany() {
        try {
            companyServiceInte.insert(company);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }


    public CompanyServiceInte getCompanyServiceInte() {
        return companyServiceInte;
    }

    public void setCompanyServiceInte(CompanyServiceInte companyServiceInte) {
        this.companyServiceInte = companyServiceInte;
    }

    public Company getCompany() {
        return company;
    }


    public void setCompany(Company company) {
        this.company = company;
    }


    public Object getModel() {
        if (company == null) {
            company = new Company();
        }
        return company;
    }
}
