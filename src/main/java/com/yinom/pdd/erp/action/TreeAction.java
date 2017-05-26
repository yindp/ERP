package com.yinom.pdd.erp.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yinom.pdd.erp.bean.TreeNode;
import com.yinom.pdd.erp.util.ConnectionManager;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yindp on 5/26/17.
 */
@Namespace(value = "/test")
@Scope(value = "prototype")
@Controller(value = "treeAction")
@ParentPackage(value = "json-default")
public class TreeAction extends ActionSupport {
    private List<TreeNode> treeNodes = new ArrayList<TreeNode>(); //返回的JSON数据
    private String id; // 树组件使用的ID

    @Action(value = "treeLoad", results = {@Result(type = "json", params = {"root", "treeNodes"}), @Result(name = "error", location = "/error.jsp")})
    public String treeLoad() {

        Statement sta = null;
        ResultSet rs = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            sta = conn.createStatement();
            String sql = "";
            if (id == null) {  //如果id为null则是根节点
                sql = "select * from tree where parentid is null";
            } else {           //查询下面的子节点
                sql = "select * from tree where parentid = " + id;
            }
            rs = sta.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                TreeNode node = new TreeNode();
                node.setId(id);
                node.setText(name);
                node.setChecked(false);
                //判断是否有子节点，如果有则closed否则open
                if (isChildrenNode(id)) {
                    node.setState("closed");
                } else {
                    node.setState("open");
                }

                treeNodes.add(node);
            }
            // 关闭所有资源
            ConnectionManager.closeAll(rs, sta, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(treeNodes.toString());
        return SUCCESS;
    }

    /**
     * 判断是否有子节点
     *
     * @return
     */
    public boolean isChildrenNode(String id) {
        Boolean flag = false;
        Statement sta = null;
        ResultSet rs = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            sta = conn.createStatement();
            String sql = "select * from tree where parentid = " + id;
            rs = sta.executeQuery(sql);
            while (rs.next()) {
                flag = true;
            }
            // 关闭所有资源
            ConnectionManager.closeAll(rs, sta, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }


    public List<TreeNode> getTreeNodes() {
        return treeNodes;
    }

    public void setTreeNodes(List<TreeNode> treeNodes) {
        this.treeNodes = treeNodes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
