<%--
  Created by IntelliJ IDEA.
  User: yindp
  Date: 5/2/17
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="addCompany" method="POST">
    <s:textfield label="Name" name="name"/>
    <s:textarea label="Describe" name="describe"/>
    <s:submit value="Submit"/>
</s:form>
</body>
</html>
