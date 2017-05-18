<%--
  Created by IntelliJ IDEA.
  User: yindp
  Date: 5/16/17
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.2/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.2/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.2/themes/color.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.2/demo/demo.css">
    <script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
</head>
<body>
<div>
    <table id="dg" title="My Users" style="width:550px;height:250px"
           toolbar="#toolbar" idField="id"
           rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
        <tr>
            <th field="firstname" width="50" editor="{type:'validatebox',options:{required:true}}">First Name</th>
            <th field="lastname" width="50" editor="{type:'validatebox',options:{required:true}}">Last Name</th>
            <th field="phone" width="50" editor="text">Phone</th>
            <th field="email" width="50" editor="{type:'validatebox',options:{validType:'email'}}">Email</th>
        </tr>
        </thead>
    </table>
    <div id="toolbar">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#dg').edatagrid('addRow')">New</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$('#dg').edatagrid('destroyRow')">Destroy</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:$('#dg').edatagrid('saveRow')">Save</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#dg').edatagrid('cancelRow')">Cancel</a>
    </div>
</div>
</body>
</html>
