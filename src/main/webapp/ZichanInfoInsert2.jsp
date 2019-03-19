<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>资产添加</title>
</head>
<body>

<form action="addzichan">
<div align="center">
<table>
	<tr>
		<td>资产编号</td>
		<td><input type="text" name="notice_id" id="notice_id"  readonly="readonly"/></td> 
	</tr> 
	<tr> 
		<td>资产名称</td> 
		<td><input type="text" name="notice_title" id="notice_title"/></td> 
	</tr>
	<tr> 
		<td>资产价格</td> 
		<td><input type="text" name="notice_content" id="notice_content"/></td> 
	</tr>
	<tr> 
		<td>资产拥有人</td> 
		<td><input type="text" name="notice_content" id="notice_content"/></td> 
	</tr>
	<tr> 
		<td>资产状态</td> 
		<td><input type="text" name="notice_content" id="notice_content"/></td> 
	</tr>
	
</table>
<input type="button" value="提交" onclick="noticeadd()" />
</div>
</form>

<script type="text/javascript">
	function noticeadd(){
		alert("添加成功！")
		var values = {
			"notice_id":$("#notice_id").val(),
			"notice_title":$("#notice_title").val(),
			"notice_content":$("#notice_content").val(),
			"notice_name":$("#notice_name").val()
		};
		$.post('notice/notcieinsert',values,function(data){
			alert(data); 
		},'text');
		$("#mywindownotice").window('close');
		$("#notice").datagrid('load'); 
	}


</script>
</body>
</html>
