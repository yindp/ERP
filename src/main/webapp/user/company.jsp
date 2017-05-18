<%--
  Created by IntelliJ IDEA.
  User: yindp
  Date: 5/16/17
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
<div id="toolbar">
    <%-- <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
        onclick="javascript:$('#dg').edatagrid('addRow')">New</a>--%>
<%--    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true"
       onclick="$('#dlg').dialog('open')">New</a>--%>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="$('#w').window('open')">New</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
       onclick="javascript:$('#dg').edatagrid('destroyRow')">Destroy</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"
       onclick="javascript:$('#dg').edatagrid('saveRow')">Save</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-undo" plain="true"
       onclick="javascript:$('#dg').edatagrid('cancelRow')">Cancel</a>
</div>
<div>
    <table class="easyui-datagrid" title="Company" style="height:250px"
           data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'">
        <thead>
        <tr>
            <th data-options="field:'itemits',width:80">Service ID</th>
            <th data-options="field:'itemid',width:80">Name</th>
            <th data-options="field:'productid',width:100">Address</th>
            <th data-options="field:'listprice',width:80,align:'right'">Contact</th>
            <th data-options="field:'unitcost',width:80,align:'right'">Phone</th>
            <th data-options="field:'attr1',width:250">Start Time</th>
            <th data-options="field:'status',width:60,align:'center'">End Time</th>
        </tr>
        </thead>
        <tr>
            <td>1asdfas</td>
            <td>Test</td>
            <td>Test</td>
            <td>Test</td>
            <td>Test</td>
            <td>Test</td>
            <td>Test</td>
        </tr>
        <tr>
            <td>2asdfasdf</td>
            <td>Test</td>
            <td>Test</td>
            <td>Test</td>
            <td>Test</td>
            <td>Test</td>
            <td>Test</td>
        </tr>
        <tr>
            <td>2asdfasdf</td>
            <td>Test</td>
            <td>Test</td>
            <td>Test</td>
            <td>Test</td>
            <td>Test</td>
            <td>Test</td>
        </tr>
    </table>
    <%--<div class="easyui-panel">
        <div class="easyui-pagination"
             data-options=" total:114,layout:['list','sep','first','prev','links','next','last','sep','refresh']">

        </div>
    </div>--%>
    <div class="easyui-panel">
        <div class="easyui-pagination" data-options="total:114"></div>
    </div>
</div>
<div>
    <div id="w" class="easyui-window" title="Add a company" data-options="modal:true,closed:true"
         style="width:auto;height:auto;padding:10px;">
        <s:form action="/company/add" method="POST" id="addCompany">
            <%-- <s:select list="headquarters" listValue="" listKey="" name="" id="" headerKey="" headerValue=""/>--%>
            <s:select label="Company" list="#companies" listKey="id" listValue="name" headerKey="-1" headerValue="Null"  name="parent.id"/>
            <s:textfield label="Name" name="name"/>
            <s:textarea label="Address" name="address"/>
            <s:textarea label="Comment" name="comment"/>
            <s:submit value="Submit" id="formSubmit" cssStyle="display: none"/>
        </s:form>
        <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="javascript:$('#formSubmit').click()" style="width:80px">Ok</a>
            <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="javascript:$('#w').window('close')" style="width:80px">Cancel</a>
        </div>
    </div>
   <%-- <div id="w" class="easyui-window" title="Window Layout" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:200px;padding:5px;">
        <div class="easyui-layout" data-options="fit:true">
            &lt;%&ndash;<div data-options="region:'east',split:true" style="width:100px"></div>&ndash;%&gt;
            <div data-options="region:'center'" style="padding:10px;">
                jQuery EasyUI framework help you build your web page easily.
            </div>
            <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
                <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="javascript:alert('ok')" style="width:80px">Ok</a>
                <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="javascript:$('#w').window('close')" style="width:80px">Cancel</a>
               &lt;%&ndash; <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:alert('save')">Save</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#dlg').dialog('close')">Close</a>&ndash;%&gt;
            </div>
        </div>
    </div>--%>
</div>
</body>
</html>
