<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <%--
        <link rel="stylesheet" type="text/css" href="../../easyui/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="../../easyui/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="../../easyui/themes/color.css">
        <link rel="stylesheet" type="text/css" href="../../easyui/demo/demo.css">

        <script type="text/javascript" src="../../easyui/jquery.min.js"></script>
        <script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>--%>
    <link rel="stylesheet" type="text/css" href="<%=path%>/jquery-easyui-1.5.2/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/jquery-easyui-1.5.2/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/jquery-easyui-1.5.2/themes/color.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/jquery-easyui-1.5.2/demo/demo.css">
    <script type="text/javascript" src="<%=path%>/jquery-easyui-1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="userAdmin.js"></script>

    <style type="text/css">
        #fm {
            margin: 0;
            padding: 10px 30px;
        }

        .ftitle {
            font-size: 14px;
            font-weight: bold;
            padding: 5px 0;
            margin-bottom: 10px;
            border-bottom: 1px solid #ccc;
        }

        .fitem {
            margin-bottom: 5px;
        }

        .fitem label {
            display: inline-block;
            width: 80px;
        }

        .fitem input {
            width: 160px;
        }
    </style>
</head>
<body>
<table id="tt">
    <thead>
    <tr>
<%--        <th field="id" width="100" align="center">ID</th>--%>
        <th data-options="field:'id',width:100,align:'center'">ID</th>
        <th field="esc" width="100" align="center">ESC</th>
        <th field="name" width="100" align="center">Name</th>
        <th field="pinyin" width="100" align="center">Pin Yin</th>
        <th field="address" width="100" align="center">Address</th>
        <th field="comment" width="100" align="center">Comment</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New
        User</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit
        User</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove
        User</a>
</div>


<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true"
     buttons="#dlg-buttons">
    <div class="ftitle">
        User Information
    </div>
    <form id="fm" method="post" novalidate="">

        <div class="fitem">
            <label>id</label>
            <input name="userId" class="easyui-textbox" readonly="true"/>
        </div>


        <div class="fitem">
            <label>用户名</label>
            <input name="userName" class="easyui-textbox" required="true"/>
        </div>
        <div class="fitem">
            <label>密码</label>
            <input name="passWord" class="easyui-textbox" required="true"/>
        </div>

        <div class="fitem">
            <label>状态</label>
            <select name="status">
                <option value="good" selected="selected">正常</option>
                <option value="locked">冻结</option>
            </select>
        </div>

        <div class="fitem">
            <label>级别</label>
            <select name="role">
                <option value="一级管理员" selected="selected">一级管理员</option>
                <option value="二级管理员">二级管理员</option>
                <option value="三级管理员">三级管理员</option>
            </select>
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
       onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
</div>
</body>
</html>