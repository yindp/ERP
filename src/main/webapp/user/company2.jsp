<%@ taglib prefix="s" uri="/struts-tags" %>
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
<div style="height: 100%;width: 100%">
    <div style="height: 100%;width: 100%">
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
        <div id="toolbar">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New User</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove User</a>
        </div>
    </div>
    <div>
        <div id="w" class="easyui-window" title="Add a company" data-options="modal:true,closed:true"
             style="width:auto;height:auto;padding:10px;">
            <form id="ff" class="easyui-form" method="post" data-options="novalidate:true"
                  action="/test/company/insert">
                <table cellpadding="5">
                    <tr>
                        <td>Name:</td>
                        <td><input class="easyui-textbox" type="text" name="company.name"
                                   data-options="required:true"></input></td>
                    </tr>
                    <tr>
                        <td>Pin Yin:</td>
                        <td><input class="easyui-textbox" type="text" name="company.pinyin"
                                   data-options="required:true,validType:'email'"></input></td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td><input class="easyui-textbox" type="text" name="company.address"
                                   data-options="required:true,multiline:true" style="height: 60px"></input>
                        </td>
                    </tr>
                    <tr>
                        <td>Comment:</td>
                        <td><input class="easyui-textbox" name="company.comment" data-options="multiline:true"
                                   style="height:60px"></input></td>
                    </tr>
                </table>
              <%--  <s:submit value="Submit" id="formSubmit" cssStyle="display: none"/>--%>
            </form>
            <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)"
                   onclick="javascript:$('#formSubmit').click()" style="width:80px">Add</a>
                <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)"
                   onclick="javascript:$('#w').window('close')" style="width:80px">Cancel</a>
            </div>
        </div>

    </div>
    <div id="dlg" class="easyui-dialog" style="width:400px;padding:10px 20px"
         closed="true" buttons="#dlg-buttons" title="Add Company" data-options="modal:true">
        <form id="fm" method="post">
            <table cellpadding="5">
                <tr>
                    <td>Name:</td>
                    <td><input class="easyui-textbox" type="text" name="company.name"
                               data-options="required:true"></input></td>
                </tr>
                <tr>
                    <td>Pin Yin:</td>
                    <td><input class="easyui-textbox" type="text" name="company.pinyin"
                               data-options="required:true,validType:'email'"></input></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input class="easyui-textbox" type="text" name="company.address"
                               data-options="required:true,multiline:true" style="height: 60px"></input>
                    </td>
                </tr>
                <tr>
                    <td>Comment:</td>
                    <td><input class="easyui-textbox" name="company.comment" data-options="multiline:true"
                               style="height:60px"></input></td>
                </tr>
            </table>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">Save</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
    </div>
    <script type="text/javascript">
        //datagrid初始化
        $('#list_data').datagrid({
            iconCls: 'icon-edit',//图标
            width: 700,
            height: 'auto',
            nowrap: false,
            striped: true,
            border: true,
            collapsible: false,//是否可折叠的
            fit: true,//自动大小
            url: '/test/company/queryJson',
            //sortName: 'code',
            //sortOrder: 'desc',
            remoteSort: false,
            idField: 'id',
            singleSelect: false,//是否单选
            pagination: true,//分页控件
            rownumbers: true,//行号
            frozenColumns: [[
                {field: 'ck', checkbox: true}
            ]],
            toolbar: [{
                text: '添加',
                iconCls: 'icon-add',
                handler: function () {
                    /*openDialog("add_dialog", "add");*/
                    /*$('#w').window('open');*/
                    $('#dlg').dialog('open').dialog('setTitle','Add Company');
                    $('#fm').form('clear');
                    url = '/test/company/insert';
                }
            }, '-', {
                text: '修改',
                iconCls: 'icon-edit',
                handler: function () {
                    openDialog("add_dialog", "edit");
                }
            }, '-', {
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    delAppInfo();
                }
            }],
        });
        //设置分页控件
        var p = $('#list_data').datagrid('getPager');
        $(p).pagination({
            pageSize: 10,//每页显示的记录条数，默认为10
            pageList: [5, 10,20,50],//可以设置每页记录条数的列表
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
</div>
</body>
</html>
