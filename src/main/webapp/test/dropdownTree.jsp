<%--
  Created by IntelliJ IDEA.
  User: yindp
  Date: 5/27/17
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
%>
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
<div id="dlg" class="easyui-dialog" style="width:500px;height:250px;padding:10px 30px;"
     title="Register" buttons="#dlg-buttons">
    <h2>Account Information</h2>
    <form id="ff" method="post">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" style="width:350px;"/></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address" style="width:350px;"/></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><select class="easyui-combotree" url="data/city_data.json" name="city" style="width:156px;"/></td>
            </tr>
        </table>
    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="savereg()">Submit</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
</div>
</body>
</html>
