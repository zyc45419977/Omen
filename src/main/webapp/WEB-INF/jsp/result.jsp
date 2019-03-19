<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
<!--主题css-->
<link rel="stylesheet" href="js/easyui/themes/default/easyui.css" />
<!--图标css -->
<link rel="stylesheet" href="js/easyui/themes/icon.css" />
<link rel="stylesheet" href="js/easyui/themes/IconExtension.css" />
<!-- 导入jquery的库文件-->
<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
<!--导入easyui的js库 -->
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<!--本地语言库 -->
<script type="text/javascript"
	src="js/easyui/locale/easyui-lang-zh_CN.js"></script>
	
	<script type="text/javascript"
	src="js/script.js"></script>
</head>
<body class="easyui-layout">
<div id="top" data-options="region:'north'" style="height:120px"><h2>办公管理系统</h2>
</div>

<div id="left" data-options="region:'west',title:'功能菜单'" style="width:180px">

<!-- 树功能菜单 -->
<ul id="mytree"></ul>

</div>

<div id="center" data-options="region:'center'">

<a href="javascript:void(0)" id="qxgl" >权限管理</a>   
<a href="javascript:void(0)" id="hygl" >会员管理</a>  
<div id="mqxgl"  style="width:120px;">   </div>
<div id="mhygl"  style="width:120px;">   </div>


<!-- tab选项卡 展示页面 -->
<div id="mytab">

</div>

</div>


</body>
</html>