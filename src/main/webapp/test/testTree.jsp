<%--
  Created by IntelliJ IDEA.
  User: yindp
  Date: 5/25/17
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
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
<script type="text/javascript">
    $(document).ready(function(){
        $('#myTree').tree({
            url: "<%=path%>/admin/treeLoad",
            checkbox:true,
            loadFilter: function(data){
                if (data.treeNodes){
                    return data.treeNodes;
                } else {
                    return data;
                }
            }
        });
    });
</script>
<div>
    <ul id="myTree" class="easyui-tree"></ul>
</div>
</body>
</html>
