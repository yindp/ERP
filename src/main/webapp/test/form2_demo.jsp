
<!DOCTYPE html>
<%
String path = request.getContextPath();
%>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="keywords" content="jquery,ui,easy,easyui,web">
	<meta name="description" content="easyui help you build your web page easily!">
	<title>jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="<%=path%>/jquery-easyui-1.5.2/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/jquery-easyui-1.5.2/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/jquery-easyui-1.5.2/themes/color.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/jquery-easyui-1.5.2/demo/demo.css">
	<script type="text/javascript" src="<%=path%>/jquery-easyui-1.5.2/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path%>/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		function savereg(){
			$('#ff').form('submit',{
				url:'form2_proc.php',
				success:function(data){
					$.messager.alert('Info', data, 'info');
				}
			});
		}
	</script>
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
					<td><select class="easyui-combotree" url="<%=path%>/admin/incidentCategory/query" name="city" style="width:156px;"/></td>
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