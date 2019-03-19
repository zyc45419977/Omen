<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>人员添加</title>
</head>
<body>
	<form action="addrenyuan">
		<div align="center">
			<table>
				<tr>
					<td>人员编号:</td>
					<td><input type="text" name="file_id" id="file_id" disabled="disabled" /></td>
				</tr>
				<tr>
					<td>人员姓名:</td>
					<td><input  type="text"   name="file_date"  id="file_date" >  </td>
				</tr>
				<tr>
					<td>人员性别:</td>
					<td><select name="user_sex" id="user_sex"  >
						<option selected="selected"  value="1">男</option>
						<option  value="0">女</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>人员年龄:</td>
					<td><input type="text" name="file_url" id="file_url" /></td>
				</tr>
				<tr>
					<td>人员上级:</td>
					<td><select name="user_sex" id="user_sex"  >
						<option selected="selected"  value="1">管理员</option>
						<option  value="0">超级管理员</option>
						</select>
					</td>
				</tr>
			</table>
			<input type="button" value="提交" onclick="filesadd()" />
		</div>
	</form>
	<script type="text/javascript">
		function filesadd() {
			alert("添加成功！")
			var values = {
				"files_id" : $("#files_id").val(),
				"file_date" : $("#file_date").val(),
				"fine_name" : $("#fine_name").val(),
				"file_url" : $("#file_url").val()
			};
			$.post('files/filesinsert', values, function(data) {
			
				alert(data);
		}, 'text');
			$("#mywindowFiles").window('close');
			$("#files").datagrid('load');
		}
	</script>
</body>
</html>
