<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
<body class="easyui-layout">
<div data-options="region:'north',border:false" style="height:150px;background:#B3DFDA;padding:10px;">
    <div style="margin-top: 30px">
        <form action="#" method="post">
            <label>Company NO :</label><input id="companyNO" class="easyui-textbox" type="text" name="company.no">
            <label>Employee NO :</label><input id="userNo" class="easyui-textbox" type="text" name="user.no">
            <label>User Name :</label><input id="userName" class="easyui-textbox" type="text" name="user.name">
            <label>Phone :</label><input id="userPhone" class="easyui-textbox" type="text" name="user.phone">
            <label>Email :</label><input id="userEmail" class="easyui-textbox" type="text" name="user.email">
            <input class="easyui-linkbutton" type="button" value="Search" id="query">
        </form>
    </div>
    <script type="text/javascript">

        /* 提交结果，执行ajax */

        function btn() {

            var $btn = $("#query");//获取按钮元素

            //给按钮绑定点击事件

            $btn.bind("click", function () {

                $.ajax({

                    type: "post",

                    url: "admin/query",//需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名

                    data: {//设置数据源

                        companyNO: $("#companyNO").val(),
                        userNO: $("#userNo").val(),
                        name: $("#userName").val(),
                        phone: $("#userPhone").val(),
                        email: $("#userEmail").val()
                        //这里不要加","  不然会报错，而且根本不会提示错误地方
                    },

                    dataType: "json",//设置需要返回的数据类型

                    success: function (data) {

                        var d = eval("(" + data + ")");//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
      /*                  alert(data);*/
                        //得到的d是一个形如{"key":"value","key1":"value1"}的数据类型，然后取值出来
                        $("#resultNo").text("" + d.no + "");
                        $("#resultName").text("" + d.name + "");
                        $("#resultCompany").text("" + d.company+ "");
                        $("#resultDepartment").text("" + d.department+ "");
                        $("#resultPhone").text("" + d.phone + "");
                        $("#resultEmail").text("" + d.email + "");
                    },

                    error: function () {

                        alert("系统异常，请稍后重试！");

                    }//这里不要加","

                });

            });

        }


        /* 页面加载完成，绑定事件 */

        $(document).ready(function () {

            btn();//点击提交，执行ajax

        });

    </script>

    <div id="queryResult" style="background: white;margin-top: 5px">
        <table border="1" cellspacing="2" id="queryUser">
            <thead>
            <tr>
                <th>Service NO</th>
                <th>Name</th>
                <th>Company</th>
                <th>Department</th>
                <th>Phone</th>
                <th>Email</th>
            </tr>
            </thead>
            <tr>
                <td id="resultNo"></td>
                <td id="resultName"></td>
                <td id="resultCompany"></td>
                <td id="resultDepartment"></td>
                <td id="resultPhone"></td>
                <td id="resultEmail"></td>
            </tr>
        </table>
    </div>
</div>
<div data-options="region:'west',split:true,title:'Menu'" style="width:10%;">
    <div class="easyui-accordion" data-options="multiple:true,selected:false" style="width: 100%;">
        <div title="Setting">
            <div class="easyui-panel" style="padding:5px">
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true" onclick="addCompany()"
                   style="width: 100%">
                    Company
                </a>
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true"
                   onclick="addDepartment()" style="width: 100%">
                    Department
                </a>
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true" onclick="addPost()"
                   style="width: 100%">
                    Post
                </a>
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true" onclick="addUser()"
                   style="width: 100%">
                    User
                </a>
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true" onclick="Category()"
                   style="width: 100%">
                    Category
                </a>
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true" onclick="incidentCategory()"
                   style="width: 100%">
                    Incident Category
                </a>
            </div>
            <script type="text/javascript">
                var index = 0;
                function addCompany() {
                    index++;
                    $('#tt').tabs('add', {
                        title: 'Company' + index,
                        /* content: '<div style="padding:10px">Content'+index+'</div>',*/
                        content: '<iframe name="test" src="<%=path%>/test/company/list" frameborder="0" style="height:100%;width:100%;" "></iframe>',
                        closable: true,//tab显示关闭键
                        cache: true
                    });
                }
                function addDepartment() {
                    index++;
                    $('#tt').tabs('add', {
                        title: 'Department' + index,
                        /* content: '<div style="padding:10px">Content'+index+'</div>',*/
                        content: '<iframe name="test" src="<%=path%>/department/list" frameborder="0" style="height:100%;width:100%;" "></iframe>',
                        closable: true,//tab显示关闭键
                        cache: true
                    });
                }
                function addPost() {
                    index++;
                    $('#tt').tabs('add', {
                        title: 'Post' + index,
                        /* content: '<div style="padding:10px">Content'+index+'</div>',*/
                        content: '<iframe name="test" src="<%=path%>/post/list" frameborder="0" style="height:100%;width:100%;" "></iframe>',
                        closable: true,//tab显示关闭键
                        cache: true
                    });
                }
                function addUser() {
                    index++;
                    $('#tt').tabs('add', {
                        title: 'User' + index,
                        /* content: '<div style="padding:10px">Content'+index+'</div>',*/
                        content: '<iframe name="test" src="<%=path%>/user/list" frameborder="0" style="height:100%;width:100%;" "></iframe>',
                        closable: true,//tab显示关闭键
                        cache: true
                    });
                }
                function Category() {
                    index++;
                    $('#tt').tabs('add', {
                        title: 'Category' + index,
                        /* content: '<div style="padding:10px">Content'+index+'</div>',*/
                        content: '<iframe name="test" src="<%=path%>/admin/queryCategoryALL" frameborder="0" style="height:100%;width:100%;" "></iframe>',
                        closable: true,//tab显示关闭键
                        cache: true
                    });
                }
                function incidentCategory() {
                    index++;
                    $('#tt').tabs('add', {
                        title: 'Incident Category' + index,
                        /* content: '<div style="padding:10px">Content'+index+'</div>',*/
                        content: '<iframe name="test" src="<%=path%>/admin/incidentCategory/queryAll" frameborder="0" style="height:100%;width:100%;" "></iframe>',
                        closable: true,//tab显示关闭键
                        cache: true
                    });
                }
                function removePanel() {
                    var tab = $('#tt').tabs('getSelected');
                    if (tab) {
                        var index = $('#tt').tabs('getTabIndex', tab);
                        $('#tt').tabs('close', index);
                    }
                }
                $("table tr").bind("click", function () {
                    var b=document.getElementById("resultNo").innerHTML;
                    addPanel(b);
                })
            </script>
        </div>

        <div title="asdfasdf">
            <div class="easyui-panel" style="padding:5px">
                <ul class="easyui-tree">
                    <li><a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true"
                           onclick="f()">New Ticket</a></li>
                    <li>
                        <span>My Documents</span>
                        <ul>
                            <li data-options="state:'closed'">
                                <span>Photos</span>
                                <ul>
                                    <li>
                                        <span>Friend</span>
                                    </li>
                                    <li>
                                        <span>Wife</span>
                                    </li>
                                    <li>
                                        <span>Company</span>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <span>Program Files</span>
                                <ul>
                                    <li>Intel</li>
                                    <li>Java</li>
                                    <li>Microsoft Office</li>
                                    <li>Games</li>
                                </ul>
                            </li>
                            <li>index.html</li>
                            <li>about.html</li>
                            <li>welcome.html</li>
                        </ul>
                    </li>
                    <li>
                        <span>My Documents</span>
                        <ul>
                            <li data-options="state:'closed'">
                                <span>Photos</span>
                                <ul>
                                    <li>
                                        <span>Friend</span>
                                    </li>
                                    <li>
                                        <span>Wife</span>
                                    </li>
                                    <li>
                                        <span>Company</span>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <span>Program Files</span>
                                <ul>
                                    <li>Intel</li>
                                    <li>Java</li>
                                    <li>Microsoft Office</li>
                                    <li>Games</li>
                                </ul>
                            </li>
                            <li>index.html</li>
                            <li>about.html</li>
                            <li>welcome.html</li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <div title="asdfasdf">
            <div class="easyui-panel" style="padding:5px">
                <ul class="easyui-tree">
                    <li><a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true"
                           onclick="addPanel()">New Ticket</a></li>
                    <li>
                        <span>My Documents</span>
                        <ul>
                            <li data-options="state:'closed'">
                                <span>Photos</span>
                                <ul>
                                    <li>
                                        <span>Friend</span>
                                    </li>
                                    <li>
                                        <span>Wife</span>
                                    </li>
                                    <li>
                                        <span>Company</span>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <span>Program Files</span>
                                <ul>
                                    <li>Intel</li>
                                    <li>Java</li>
                                    <li>Microsoft Office</li>
                                    <li>Games</li>
                                </ul>
                            </li>
                            <li>index.html</li>
                            <li>about.html</li>
                            <li>welcome.html</li>
                        </ul>
                    </li>
                    <li>
                        <span>My Documents</span>
                        <ul>
                            <li data-options="state:'closed'">
                                <span>Photos</span>
                                <ul>
                                    <li>
                                        <span>Friend</span>
                                    </li>
                                    <li>
                                        <span>Wife</span>
                                    </li>
                                    <li>
                                        <span>Company</span>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <span>Program Files</span>
                                <ul>
                                    <li>Intel</li>
                                    <li>Java</li>
                                    <li>Microsoft Office</li>
                                    <li>Games</li>
                                </ul>
                            </li>
                            <li>index.html</li>
                            <li>about.html</li>
                            <li>welcome.html</li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <div title="Ruby">
            <div class="easyui-panel" style="padding:5px">
                <ul class="easyui-tree">
                    <li><a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true"
                           onclick="addPanel()">New Ticket</a></li>
                    <li>
                        <span>My Documents</span>
                        <ul>
                            <li data-options="state:'closed'">
                                <span>Photos</span>
                                <ul>
                                    <li>
                                        <span>Friend</span>
                                    </li>
                                    <li>
                                        <span>Wife</span>
                                    </li>
                                    <li>
                                        <span>Company</span>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <span>Program Files</span>
                                <ul>
                                    <li>Intel</li>
                                    <li>Java</li>
                                    <li>Microsoft Office</li>
                                    <li>Games</li>
                                </ul>
                            </li>
                            <li>index.html</li>
                            <li>about.html</li>
                            <li>welcome.html</li>
                        </ul>
                    </li>
                    <li>
                        <span>My Documents</span>
                        <ul>
                            <li data-options="state:'closed'">
                                <span>Photos</span>
                                <ul>
                                    <li>
                                        <span>Friend</span>
                                    </li>
                                    <li>
                                        <span>Wife</span>
                                    </li>
                                    <li>
                                        <span>Company</span>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <span>Program Files</span>
                                <ul>
                                    <li>Intel</li>
                                    <li>Java</li>
                                    <li>Microsoft Office</li>
                                    <li>Games</li>
                                </ul>
                            </li>
                            <li>index.html</li>
                            <li>about.html</li>
                            <li>welcome.html</li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <div title="Fortran">
            <div class="easyui-panel" style="padding:5px">
                <ul class="easyui-tree">
                    <li><a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true"
                           onclick="addPanel()">New Ticket</a></li>
                    <li>
                        <span>My Documents</span>
                        <ul>
                            <li data-options="state:'closed'">
                                <span>Photos</span>
                                <ul>
                                    <li>
                                        <span>Friend</span>
                                    </li>
                                    <li>
                                        <span>Wife</span>
                                    </li>
                                    <li>
                                        <span>Company</span>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <span>Program Files</span>
                                <ul>
                                    <li>Intel</li>
                                    <li>Java</li>
                                    <li>Microsoft Office</li>
                                    <li>Games</li>
                                </ul>
                            </li>
                            <li>index.html</li>
                            <li>about.html</li>
                            <li>welcome.html</li>
                        </ul>
                    </li>
                    <li>
                        <span>My Documents</span>
                        <ul>
                            <li data-options="state:'closed'">
                                <span>Photos</span>
                                <ul>
                                    <li>
                                        <span>Friend</span>
                                    </li>
                                    <li>
                                        <span>Wife</span>
                                    </li>
                                    <li>
                                        <span>Company</span>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <span>Program Files</span>
                                <ul>
                                    <li>Intel</li>
                                    <li>Java</li>
                                    <li>Microsoft Office</li>
                                    <li>Games</li>
                                </ul>
                            </li>
                            <li>index.html</li>
                            <li>about.html</li>
                            <li>welcome.html</li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>

</div>
<div data-options="region:'east',split:true,title:'East'" style="width:15%;padding:10px;">
    <div class="easyui-calendar" showWeek="true" weekNumberHeader="Wk" style="width:100%;"></div>
</div>
<div data-options="region:'south',border:false" style="height:70px;background:#A9FACD;padding:10px;">south region</div>
<div data-options="region:'center',title:'Center'">

    <div id="tt" class="easyui-tabs" data-options="tools:'#tab-tools'" style="width: 100%;height: 100%">
    </div>
    <div id="tab-tools">
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'"
           onclick="addPanel()">New Ticket</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-remove'"
           onclick="removePanel()"></a>
    </div>
    <script type="text/javascript">
        var index = 0;
        function addPanel(a) {
            index++;
            $('#tt').tabs('add', {
                title: 'Ticket' + index,
                /* content: '<div style="padding:10px">Content'+index+'</div>',*/
                /*content: '<iframe name="test" src="ticket.jsp" frameborder="0" style="height:100%;width:100%;" "></iframe>', */
                content: '<iframe name="test" src="<%=path%>/admin/newTicket?user.no='+a+'" frameborder="0" style="height:100%;width:100%;" "></iframe>',
                closable: true,//tab显示关闭键
                cache: true
            });
        }
        function removePanel() {
            var tab = $('#tt').tabs('getSelected');
            if (tab) {
                var index = $('#tt').tabs('getTabIndex', tab);
                $('#tt').tabs('close', index);
            }
        }
    </script>
</div>
</body>
</html>