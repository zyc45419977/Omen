<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.text.SimpleDateFormat"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
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
<script type="text/javascript" src="js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/script.js"></script> 
	<script>
	function shijian(){
		var d = new Date();
		var year = d.getFullYear();
		var mouth = d.getMonth();
		
		var dd = d.getDate();
		var hh = d.getHours();
		var m = d.getMinutes();
		var ss = d.getSeconds();
		var ss1 ="";
		if(ss<10){
			ss1="0"+ss;
		}else{
			ss1=ss;
		}
		var sss = d.getMilliseconds();
		var sss1 = "";
		if(sss<10){
			sss1="00"+sss;
		}else if(sss<100 && sss>=10){
			sss1="0"+sss;
		}else{
			sss1=sss;
		}
		var day = d.getDay();//获取星期几
		var d="";
		switch(day){
			case 1:
			d="一";
			break;
			case 2:
			d="二";
			break;
			case 3:
			d="三";
			break;
			case 4:
			d="四";
			break;
			case 5:
			d="五";
			break;
			case 6:
			d="六";
			break;
			case 7:
			d="日";
			break;
		}
		
		var time = year+"年"+(mouth+1)+"月"+dd+"日"+"&nbsp;&nbsp;"+hh+"时"+m+"分"+ss1+"秒"+"&nbsp;&nbsp;";
		document.getElementById("sj").innerHTML="当前时间："+time;
		
		setTimeout("shijian()",1)
		}
	</script>
	
</head>
<body class="easyui-layout" onload="shijian()">
<div id="top" data-options="region:'north'" style="height:120px"><h2 ><span style="color: pink">硅谷办公管理系统</span></h2>
		当前登陆的用户:  &nbsp;&nbsp;<span style="font-size: 20px;color: red">${user1.useraccount} </span>&nbsp;&nbsp;&nbsp;&nbsp;
		
	 <a href="javascript:location.reload();">刷新</a>
			<span id="sj">--</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <A style=" margin-left: 1290px; margin-top:-10px; background: rgb(0, 142, 173); 
				 padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); 
 				border-image: none; color: rgb(255, 255, 255); font-weight: bold;" 
 				 href="login.jsp" >注销</A> 
 			
</div>

<div id="left" data-options="region:'west',title:'功能菜单' " style="width:180px;" >

<!-- 树功能菜单 -->
<ul id="mytree"></ul>

</div>

<div id="center" data-options="region:'center'">

<a href="javascript:void(0)" id="qxgl" >权限管理</a>   

<div id="mqxgl"  style="width:120px;">  </div>



<!-- tab选项卡 展示页面 -->
<div id="mytab">

</div>

</div>

</body>
</html>