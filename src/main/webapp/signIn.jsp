<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: yindp
  Date: 5/4/2017
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
<s:form action="/user/signIn" method="POST">
    <s:textfield label="Email" name="email"/>
    <s:textfield label="Password" name="password"/>
    <s:submit value="Sign In"/>
</s:form>
</body>
</html>
