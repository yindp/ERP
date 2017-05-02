package com.yinom.pdd.erp.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yindp on 4/25/17.
 */
@Entity
@Table(name = "tb_department")
public class Department {
    private String id;
    private String name;
    private String describe;
    private Company company;
    private Set<Department> superiorDepartment;
    private Set<Department> subDepartments = new HashSet<Department>();
    private Set<Post> posts = new HashSet<Post>();
    private Set<User> users = new HashSet<User>();


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "superiorDepartment_id")
    public Set<Department> getSuperiorDepartment() {
        return superiorDepartment;
    }

    public void setSuperiorDepartment(Set<Department> superiorDepartment) {
        this.superiorDepartment = superiorDepartment;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "superiorDepartment", fetch = FetchType.EAGER)
    public Set<Department> getSubDepartments() {
        return subDepartments;
    }

    public void setSubDepartments(Set<Department> subDepartments) {
        this.subDepartments = subDepartments;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.EAGER)
    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.EAGER)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Department() {

    }

    public Department(String id, String name, String describe, Company company, Set<Department> superiorDepartment, Set<Department> subDepartments, Set<Post> posts, Set<User> users) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.company = company;
        this.superiorDepartment = superiorDepartment;
        this.subDepartments = subDepartments;
        this.posts = posts;
        this.users = users;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                ", company=" + company +
                ", superiorDepartment=" + superiorDepartment +
                ", subDepartments=" + subDepartments +
                ", posts=" + posts +
                ", users=" + users +
                '}';
    }
}
