<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人员资料修改</title>
</head>
<body>

<form id="editroles">
	<div align="center">
		<table>
			<tr>	
				<td>公告编号</td>
				<td><input type="text" name="notice_id" id="notice_id" value="${param.notice_id }" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>公告标题</td>
				<td><input type="text" name="notice_title" id="notice_title" value="${param.notice_title }" /></td>
			</tr>
			<tr>
				<td>公告内容</td>
				<td><input type="text" name="notice_content" id="notice_content" value="${param.notice_content }" /></td>
			</tr>
			<tr>
				<td>发表人</td>
				<td><input type="text" name="notice_name" id="notice_name" value="${param.notice_name}" /></td>
			</tr>
		</table>
		<input type="button" value="修改" onclick="editnotice()">
	</div>
</form>
<script type="text/javascript">
	function editnotice(){
		alert("修改成功！")
		var values = {
				"notice_id":$("#notice_id").val(),
				"notice_title":$("#notice_title").val(),
				"notice_content":$("#notice_content").val(),
				"notice_name":$("#notice_name").val()
		};
		$.post('notice/notcieupdate',values,function(data1){
			alert(data1); 
		},"text"); 
		$("#mywindownotice").window('close');
		$("#notice").datagrid('load'); 
	}


</script>
</body>
</html>