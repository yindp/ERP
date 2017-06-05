<%--
  Created by IntelliJ IDEA.
  User: yindp
  Date: 6/1/17
  Time: 12:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>Test EasyUI Datagrid-----Company</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/jquery-easyui-1.5.2/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/jquery-easyui-1.5.2/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/jquery-easyui-1.5.2/themes/color.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/jquery-easyui-1.5.2/demo/demo.css">
    <script type="text/javascript" src="<%=path%>/jquery-easyui-1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
</head>
<body>
<table id="list_data" cellspacing="0" cellpadding="0">
    <thead>
    <tr>
        <th field="id" align="center">ID</th>
        <th field="esc" align="center">ESC</th>
        <th field="name" align="center">Name</th>
        <th field="pinyin" align="center">PinYin</th>
        <th field="address" align="center">Address</th>
        <th field="comment" align="center">Comment</th>
    </tr>
    </thead>
</table>
<script type="text/javascript">
    //datagrid初始化
    $('#list_data').datagrid({
        title:'应用系统列表',
        iconCls:'icon-edit',//图标
        width: 700,
        height: 'auto',
        nowrap: false,
        striped: true,
        border: true,
        collapsible:false,//是否可折叠的
        fit: true,//自动大小
        url:'/test/company/query',
        //sortName: 'code',
        //sortOrder: 'desc',
        remoteSort:false,
        idField:'fldId',
        singleSelect:false,//是否单选
        pagination:true,//分页控件
        rownumbers:true,//行号
        frozenColumns:[[
            {field:'ck',checkbox:true}
        ]],
        toolbar: [{
            text: '添加',
            iconCls: 'icon-add',
            handler: function() {
                openDialog("add_dialog","add");
            }
        }, '-', {
            text: '修改',
            iconCls: 'icon-edit',
            handler: function() {
                openDialog("add_dialog","edit");
            }
        }, '-',{
            text: '删除',
            iconCls: 'icon-remove',
            handler: function(){
                delAppInfo();
            }
        }],
    });
    //设置分页控件
    var p = $('#list_data').datagrid('getPager');
    $(p).pagination({
        pageSize: 10,//每页显示的记录条数，默认为10
        pageList: [5,10,15],//可以设置每页记录条数的列表
        beforePageText: '第',//页数文本框前显示的汉字
        afterPageText: '页    共 {pages} 页',
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
        /*onBeforeRefresh:function(){
         $(this).pagination('loading');
         alert('before refresh');
         $(this).pagination('loaded');
         }*/
    });
</script>
</body>
</html>
