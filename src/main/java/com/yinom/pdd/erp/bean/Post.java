package com.yinom.pdd.erp.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yindp on 4/25/17.
 */
@Entity
@Table(name = "tb_post")
public class Post {
    private String id;
    private String name;
    private String describe;
    private Company company;
    private Department department;
    private Post superiorPost;
    private Set<Post> subPosts;
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
    @JoinColumn(name = "department_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;

    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "superiorPost_id")
    public Post getSuperiorPost() {
        return superiorPost;
    }

    public void setSuperiorPost(Post superiorPost) {
        this.superiorPost = superiorPost;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "superiorPost", fetch = FetchType.EAGER)
    public Set<Post> getSubPosts() {
        return subPosts;
    }

    public void setSubPosts(Set<Post> subPosts) {
        this.subPosts = subPosts;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post", fetch = FetchType.EAGER)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Post() {

    }

    public Post(String id, String name, String describe, Company company, Department department, Post superiorPost, Set<Post> subPosts, Set<User> users) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.company = company;
        this.department = department;
        this.superiorPost = superiorPost;
        this.subPosts = subPosts;
        this.users = users;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                ", company=" + company +
                ", department=" + department +
                ", superiorPost=" + superiorPost +
                ", subPosts=" + subPosts +
                ", users=" + users +
                '}';
    }
}
