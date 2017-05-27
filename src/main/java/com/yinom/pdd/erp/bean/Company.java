package com.yinom.pdd.erp.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by yindp on 5/3/2017.
 */
@Entity
@Table(name = "tb_company")
public class Company {
    private String id;
    private String no;
    private String shortName;
    private String fullName;
    private Location location;
    private String address;
    private String comment;
    private Company parent;
    private Set<Company> children;
    private Set<Department> departments;
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

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    public Company getParent() {
        return parent;
    }

    public void setParent(Company parent) {
        this.parent = parent;
    }


    @OneToMany(mappedBy = "parent")
    public Set<Company> getChildren() {
        return children;
    }

    public void setChildren(Set<Company> children) {
        this.children = children;
    }

    @OneToMany(mappedBy = "company")
    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    @OneToMany(mappedBy = "company")
    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @OneToMany(mappedBy = "company")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Company() {

    }

    public Company(String id, String no, String shortName, String fullName, String address, String comment, Company parent, Set<Company> children, Set<Department> departments, Set<Post> posts, Set<User> users) {
        this.id = id;
        this.no = no;
        this.shortName = shortName;
        this.fullName = fullName;
        this.address = address;
        this.comment = comment;
        this.parent = parent;
        this.children = children;
        this.departments = departments;
        this.posts = posts;
        this.users = users;
    }
}
