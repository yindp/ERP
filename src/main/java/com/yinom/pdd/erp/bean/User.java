package com.yinom.pdd.erp.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by yindp on 4/25/17.
 */
public class User {
    private String id;
    private String userName;
    private String password;
    private Company company;
    private Department department;
    private Post post;
    private String email;
    private String phone;

    public User() {

    }

    public User(String id, String userName, String password, Company company, Department department, Post post, String email, String phone) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.company = company;
        this.department = department;
        this.post = post;
        this.email = email;
        this.phone = phone;
    }

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
