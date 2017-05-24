<%--
  Created by IntelliJ IDEA.
  User: yindp
  Date: 5/16/17
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/jquery-easyui-1.5.2/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/jquery-easyui-1.5.2/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/jquery-easyui-1.5.2/themes/color.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/jquery-easyui-1.5.2/demo/demo.css">
    <script type="text/javascript" src="<%=path%>/jquery-easyui-1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
</head>
<body>
<div id="toolbar">
    <%-- <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
        onclick="javascript:$('#dg').edatagrid('addRow')">New</a>--%>
    <%--    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true"
           onclick="$('#dlg').dialog('open')">New</a>--%>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true"
       onclick="$('#w').window('open')">New</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
       onclick="javascript:$('#dg').edatagrid('destroyRow')">Destroy</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"
       onclick="javascript:$('#dg').edatagrid('saveRow')">Save</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-undo" plain="true"
       onclick="javascript:$('#dg').edatagrid('cancelRow')">Cancel</a>
</div>
<div>
    <table class="easyui-datagrid" title="Result" style="height:250px"
           data-options="singleSelect:true,collapsible:true,method:'get'">
        <thead>
        <tr>
            <th data-options="field:'itemits',align:'center'">Service ID</th>
            <th data-options="field:'itemid',align:'center'">Name</th>
            <th data-options="field:'productid',align:'center'">Address</th>
            <th data-options="field:'listprice',align:'center'">Contact</th>
            <th data-options="field:'unitcost',align:'center'">Phone</th>
            <th data-options="field:'attr1',align:'center'">Start Time</th>
            <th data-options="field:'status',align:'center'">End Time</th>
        </tr>
        </thead>
        <%-- <s:iterator value="companies">
             <tr>
                 <td><s:property value="no"/> </td>
                 <td><s:property value="name"/> </td>
                 <td><s:property value="address"/> </td>
                 <td></td>
                 <td></td>
                 <td></td>
                 <td></td>
             </tr>
         </s:iterator>
 --%>
        <tr>
            <td><s:property value="user.no"/></td>
            <td><s:property value="user.name"/></td>
            <td><s:property value="user.company.name"/></td>
            <td><s:property value="user.department.name"/></td>
            <td><s:property value="user.phone"/></td>
            <td><s:property value="email"/></td>
            <td></td>
        </tr>
    </table>
    <div class="easyui-panel">
        <div class="easyui-pagination" data-options="total:114"></div>
    </div>
</div>
</body>
</html>
