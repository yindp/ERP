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
    String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="$('#w').window('open')">New</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
       onclick="javascript:$('#dg').edatagrid('destroyRow')">Destroy</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"
       onclick="javascript:$('#dg').edatagrid('saveRow')">Save</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-undo" plain="true"
       onclick="javascript:$('#dg').edatagrid('cancelRow')">Cancel</a>
</div>
<div>
    <table class="easyui-datagrid" title="Department" style="height:250px"
           data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'">
        <thead>
        <tr>
            <th data-options="field:'itemits',align:'center'">Company</th>
            <th data-options="field:'itemid',align:'center'">Name</th>
            <th data-options="field:'unitcost',align:'center'">Comment</th>
        </tr>
        </thead>
        <s:iterator value="departments">
            <tr>
                <td><s:property value="company.name"/> </td>
                <td><s:property value="name"/> </td>
                <td><s:property value="coment"/> </td>
            </tr>
        </s:iterator>

    </table>
    <div class="easyui-panel">
        <div class="easyui-pagination" data-options="total:114"></div>
    </div>
</div>
<div>
    <div id="w" class="easyui-window" title="Add a department" data-options="modal:true,closed:true"
         style="width:auto;height:auto;padding:10px;">
        <s:form action="/department/add" method="POST">
            <%-- <s:select list="headquarters" listValue="" listKey="" name="" id="" headerKey="" headerValue=""/>--%>
            <s:select label="Company" list="#companies" listKey="id" listValue="name" headerKey="-1" headerValue="Null"
                      name="company.id"/>
            <s:select label="Department" list="#departments" listKey="id" listValue="name" headerKey="-1" headerValue="Null"
                      name="parent.id"/>
            <s:textfield label="Name" name="name"/>
            <s:textarea label="Comment" name="comment"/>
            <s:submit value="Submit" id="formSubmit" cssStyle="display: none"/>
        </s:form>
        <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="javascript:$('#formSubmit').click()" style="width:80px">Ok</a>
            <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="javascript:$('#w').window('close')" style="width:80px">Cancel</a>
        </div>
    </div>

</div>
</body>
</html>
