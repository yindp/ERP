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
<s:form action="/user/add" method="POST">
    <%-- <s:select list="headquarters" listValue="" listKey="" name="" id="" headerKey="" headerValue=""/>--%>
    <s:select label="Company" list="#companies" listKey="id" listValue="name" headerKey="-1" headerValue="Null"
              name="company.id"/>
    <s:select label="Department" list="#departments" listKey="id" listValue="name" headerKey="-1" headerValue="Null"
              name="department.id"/>
    <s:select label="Post" list="#posts" listKey="id" listValue="name" headerKey="-1" headerValue="Null"
              name="post.id"/>
    <s:textfield label="Name" name="name"/>
    <s:textfield label="Password" name="password"/>
    <s:textfield label="Phone" name="phone"/>
    <s:textfield label="Email" name="email"/>
    <s:textarea label="Comment" name="comment"/>
    <s:submit value="Submit"/>
    <s:debug/>
</s:form>
</body>
</html>
