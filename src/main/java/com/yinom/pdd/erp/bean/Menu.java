package com.yinom.pdd.erp.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by yindp on 5/4/2017.
 */
@Entity
@Table(name = "tb_menu")
public class Menu {
    private String id;
    private String name;
    private String comment;
    private Set<Menu> children;
    private Menu parent;

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

    @OneToMany(mappedBy = "parent")
    public Set<Menu> getChildren() {
        return children;
    }

    public void setChildren(Set<Menu> children) {
        this.children = children;
    }


    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }
}
