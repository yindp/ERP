package com.yinom.pdd.erp.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by yindp on 5/3/2017.
 */
@Entity
@Table(name = "tb_department")
public class Department {
    private String id;
    private String name;
    private String comment;
    private Company company;
    private Set<Department> childreen;
    private Department parent;
    private Set<Post> posts;
    private Set<User> users;

    @GenericGenerator(name = "g", strategy = "uuid")
    @GeneratedValue(generator = "g")
    @Id
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @OneToMany(mappedBy = "parent")
    public Set<Department> getChildreen() {
        return childreen;
    }

    public void setChildreen(Set<Department> childreen) {
        this.childreen = childreen;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "department")
    public Set<Post> getPosts() {
        return posts;
    }

    @OneToMany(mappedBy = "department")
    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @OneToMany(mappedBy = "department")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
