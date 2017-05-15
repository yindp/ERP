<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: yindp
  Date: 5/4/2017
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="/company/add" method="POST">
   <%-- <s:select list="headquarters" listValue="" listKey="" name="" id="" headerKey="" headerValue=""/>--%>
    <s:select label="Company" list="#companies" listKey="id" listValue="name" headerKey="-1" headerValue="Null"  name="parent.id"/>
    <s:textfield label="Name" name="name"/>
    <s:textarea label="Address" name="address"/>
    <s:textarea label="Comment" name="comment"/>
    <s:submit value="Submit"/>
    <s:debug/>
</s:form>
</body>
</html>
