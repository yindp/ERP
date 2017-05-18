<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Full Layout - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.2/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.2/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.2/themes/color.css">
    <link rel="stylesheet" type="text/css" href="/jquery-easyui-1.5.2/demo/demo.css">
    <script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.min.js"></script>
    <script type="text/javascript" src="/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',border:false" style="height:150px;background:#B3DFDA;padding:10px;">
    <%--    <div class="easyui-panel">
            <a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g1'">Button 1</a>
            <a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g1',selected:true">Button 2</a>
            <a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g1'">Button 3</a>
            <a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g1'">Button 4</a>
            <a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g1'">Button 5</a>
            <a href="#" class="easyui-linkbutton c1" style="width:120px">Button1</a>
            <a href="#" class="easyui-linkbutton c2" style="width:120px">Button2</a>
            <a href="#" class="easyui-linkbutton c3" style="width:120px">Button3</a>
            <a href="#" class="easyui-linkbutton c4" style="width:120px">Button4</a>
        </div>
        <div class="easyui-panel">
            <a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true">Button 1</a>
            <a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true,selected:true">Button
                2</a>
            <a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true">Button 3</a>
            <a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true">Button 4</a>
            <a href="#" class="easyui-linkbutton" data-options="toggle:true,group:'g2',plain:true">Button 5</a>
            <a href="#" class="easyui-linkbutton c5" style="width:120px">Button5</a>
            <a href="#" class="easyui-linkbutton c6" style="width:120px">Button6</a>
            <a href="#" class="easyui-linkbutton c7" style="width:120px">Button7</a>
            <a href="#" class="easyui-linkbutton c8" style="width:120px">Button8</a>
        </div>--%>
    <div style="margin-top: 30px">
        <label>Company ID :</label><input class="easyui-textbox" type="text">
        <label>Employee ID :</label><input class="easyui-textbox" type="text">
        <label>User Name :</label><input class="easyui-textbox" type="text">
        <label>Phone :</label><input class="easyui-textbox" type="text">
        <label>Email :</label><input class="easyui-textbox" type="text">
        <input class="easyui-linkbutton" type="button" value="Search">
    </div>
    <div style="background: white;height: 50px;margin-top: 10px">
        <h1 style="text-align: center">Search result box</h1>
    </div>
</div>
<div data-options="region:'west',split:true,title:'Menu'" style="width:15%;">
    <div class="easyui-accordion" data-options="multiple:true,selected:false" style="width: 100%;">
        <div title="Setting">
            <div class="easyui-panel" style="padding:5px">
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true" onclick="addCompany()" style="width: 100%">
                    Company
                </a>
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true" onclick="addCompany()" style="width: 100%">
                    Company
                </a>
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true" onclick="addCompany()" style="width: 100%">
                    Company
                </a>
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true" onclick="addCompany()" style="width: 100%">
                    Company
                </a>
            </div>
            <script type="text/javascript">
                var index = 0;
                function addCompany() {
                    index++;
                    $('#tt').tabs('add', {
                        title: 'Company' + index,
                        /* content: '<div style="padding:10px">Content'+index+'</div>',*/
                        content: '<iframe name="test" src="/company/list" frameborder="0" style="height:100%;width:100%;" "></iframe>',
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
        function addPanel() {
            index++;
            $('#tt').tabs('add', {
                title: 'Ticket' + index,
                /* content: '<div style="padding:10px">Content'+index+'</div>',*/
                content: '<iframe name="test" src="ticket.jsp" frameborder="0" style="height:100%;width:100%;" "></iframe>',
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