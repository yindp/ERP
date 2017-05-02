package com.yinom.pdd.erp.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yindp on 4/25/17.
 */
@Entity
@Table(name = "tb_company")
public class Company {
    private String id;
    private String name;
    private String address;
    private String phone;
    private String describe;
    private Company headquarter;
    private Set<Company> affiliates = new HashSet<Company>();
    private Set<Department> departments = new HashSet<Department>();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "headquarter_id")
    public Company getHeadquarter() {
        return headquarter;
    }

    public void setHeadquarter(Company headquarter) {
        this.headquarter = headquarter;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "headquarter", fetch = FetchType.EAGER)
    public Set<Company> getAffiliates() {
        return affiliates;
    }

    public void setAffiliates(Set<Company> affiliates) {
        this.affiliates = affiliates;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.EAGER)
    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.EAGER)
    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.EAGER)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Company() {

    }

    public Company(String id, String name, String address, String phone, String describe, Company headquarter, Set<Company> affiliates, Set<Department> departments, Set<Post> posts, Set<User> users) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.describe = describe;
        this.headquarter = headquarter;
        this.affiliates = affiliates;
        this.departments = departments;
        this.posts = posts;
        this.users = users;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", describe='" + describe + '\'' +
                ", headquarter=" + headquarter +
                ", affiliates=" + affiliates +
                ", departments=" + departments +
                ", posts=" + posts +
                ", users=" + users +
                '}';
    }
}
