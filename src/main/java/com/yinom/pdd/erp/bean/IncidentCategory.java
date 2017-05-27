package com.yinom.pdd.erp.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by yindp on 5/26/17.
 */
@Entity
@Table(name = "tb_incidentCategory")
public class IncidentCategory {
    private String id;
    private String name;
    private String comment;
    private IncidentCategory parentCategory;
    private List<IncidentCategory> childrenCategoryList;

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
    @JoinColumn(name = "parentCategory_id", referencedColumnName = "id")
    public IncidentCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(IncidentCategory parentCategory) {
        this.parentCategory = parentCategory;
    }

    @OneToMany(mappedBy = "parentCategory")
    public List<IncidentCategory> getChildrenCategoryList() {
        return childrenCategoryList;
    }

    public void setChildrenCategoryList(List<IncidentCategory> childrenCategoryList) {
        this.childrenCategoryList = childrenCategoryList;
    }

    public IncidentCategory() {

    }

    public IncidentCategory(String id, String name, String comment, IncidentCategory parentCategory, List<IncidentCategory> childrenCategoryList) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.parentCategory = parentCategory;
        this.childrenCategoryList = childrenCategoryList;
    }

    @Override
    public String toString() {
        return "IncidentCategory{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", parentCategory=" + parentCategory +
                ", childrenCategoryList=" + childrenCategoryList +
                '}';
    }
}
