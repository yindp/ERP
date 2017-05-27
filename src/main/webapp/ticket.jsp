<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
%>
<%--
  Created by IntelliJ IDEA.
  User: yindp
  Date: 5/5/2017
  Time: 13:25
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

<s:form action="#" style="width:100%" theme="simple">
    <hr>
    <table cellspacing="5px">

        <tr>
            <td><s:label>Type :</s:label></td>
            <td>
                <select class="easyui-combotree" url="<%=path%>/admin/serviceType/jsonQueryAll" style="width:156px;"/>
            </td>
            <td><s:label>Category :</s:label></td>
            <td>
                <select class="easyui-combotree" url="<%=path%>/admin/incidentCategory/query"  style="width:156px;"/>
            </td>
        </tr>
        <tr>
            <td colspan="8">
                <hr>
            </td>
        </tr>
        <tr>
            <td><s:label>Employee ID :</s:label></td>
            <td><s:property value="user.no"/> </td>
            <td><s:label>Name :</s:label></td>
   <%--         <td><s:textfield/></td>--%>
            <td><s:property value="user.name"/> </td>
            <td><s:label>Phone :</s:label></td>
            <td><s:property value="user.phone"/> </td>
            <td><s:label>Email :</s:label></td>
            <td><s:property value="user.email"/> </td>
        </tr>
        <tr>
            <td><s:label>Region :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Country :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Location :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Site :</s:label></td>
            <td><s:textfield/></td>
        </tr>
        <tr>
            <td><s:label>Company :</s:label></td>
            <td><s:property value="user.company.name"/> </td>
            <td><s:label>Department :</s:label></td>
            <td><s:property value="user.department.name"/></td>
        </tr>
        <tr>
            <td colspan="8">
                <hr>
            </td>
        </tr>
        <tr>
            <td><s:label>Depth of Support :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Impact :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Urgency :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Priority :</s:label></td>
            <td><s:textfield/></td>
        </tr>
        <tr>
            <td><s:label>Assignment group :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Assigned to :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Master Ticket :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Contact type :</s:label></td>
            <td><s:textfield/></td>
        </tr>
        <tr>
            <td colspan="2"><s:label>Customer Hardware Required:</s:label></td>
            <td colspan="2"><s:textfield/></td>
            <td><s:label>Parent Incident :</s:label></td>
            <td><s:textfield/></td>
            <td><s:label>Master Ticket :</s:label></td>
            <td><s:textfield/></td>
        </tr>
        <tr>
            <td colspan="8"><s:label>Describe :</s:label></td>
        </tr>
        <tr>
            <td colspan="8"><s:textarea rows="4" cols="150"/></td>
        </tr>
    </table>
    <hr>
    <s:submit value="Submit"/><s:submit value="Assign"/>
</s:form>
<s:debug/>
</body>
</html>
