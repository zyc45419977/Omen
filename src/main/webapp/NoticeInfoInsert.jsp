<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<% String admin =  (String)request.getSession().getAttribute("admin"); %>

<form action="addnotice">
<div align="center">
<table>
	<tr>
		<td>公告编号</td>
		<td><input type="text" name="noticeId" id="noticeId"  readonly="readonly"/></td> 
	</tr> 
	<tr> 
		<td>公告标题</td> 
		<td><input type="text" name="noticename" id="noticename"/></td> 
	</tr>
	<tr> 
		<td>公告内容</td> 
		<td><input type="text" name="noticematter" id="noticematter"/></td> 
	</tr>
	<tr> 
		<td>发表人</td> 
		<td><input type="text" name="noticeissuer" id="noticeissuer" value="${user1.useraccount }" disabled="disabled"/></td> 
	</tr>
</table>
<input type="button" value="提交" onclick="noticeadd()" />
</div>
</form>

<script type="text/javascript">
	function noticeadd(){
		var values = {
			"noticeId":$("#noticeId").val(),
			"noticename":$("#noticename").val(),
			"noticematter":$("#noticematter").val(),
			"noticeissuer":$("#noticeissuer").val()
		};
		$.post('addNotice.action',values,function(data){
			alert(data); 
		},'text');
	
	   	setTimeout(function(){
	   		$("#mywindownotice").window('close');
			$("#notice").datagrid('load'); 
			},500)
	}


</script>
</body>
</html>
