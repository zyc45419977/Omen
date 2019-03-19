<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>车辆申请</title>
</head>
<body>
	<form action="addcar">
		<div align="center">
			<table>
				<tr>
					<td>车辆编号</td>
					<td><input type="text" name="file_id" id="file_id" disabled="disabled" /></td>
				</tr>
				<tr>
					<td>车辆名称</td>
					<td><input  type="date"   name="file_date"  class="easyui-datebox" required="required"  id="file_date" >  </td>
				</tr>
				<tr>
					<td>车辆型号</td>
						<td> <select name="wjpeople" id="wjpeople">
					 	 <option  value="1">小轿车</option>
						 <option  value="2">大巴</option>
						 <option  value="3" >SUV</option>
						 <option  value="4" selected="selected" >跑车</option>
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
