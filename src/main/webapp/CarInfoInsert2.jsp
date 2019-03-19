ki<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>车辆登记</title>
</head>
<body>
	<form action="addfiles">
		<div align="center">
			<table>
				<tr>
					<td>车辆编号</td>
					<td><input type="text" name="carId" id="carId" disabled="disabled" /></td>
				</tr>
				<tr>
					<td>车辆名称</td>
					<td><input  type="text"   name="carName"   id="carName" >  </td>
				</tr>
				<tr>
					<td>车辆号</td>
					<td><input type="text" name="carPlatenumer" id="carPlatenumer"  /></td>
				</tr>
				<tr>
					<td>车辆状态</td>
					<td><input type="text" name="carState" id="carState" value="未使用" disabled="disabled"/></td>
				</tr>
				<tr>
					<td>使用者</td>
					<td><input type="text" name="carUser" id="carUser"value="${user1.useraccount } " disabled="disabled"/></td>
				</tr>
				<tr>
					<td>车辆价格</td>
					<td><input type="text" name="carPrice" id="carPrice" /></td>
				</tr>
			</table>
			<input type="button" value="提交" onclick="filesadd()" />
		</div>
	</form>
	<script type="text/javascript">
		function filesadd() {
			var values = {
				"carId" : $("#carId").val(),
				"carName" : $("#carName").val(),
				"carPlatenumer" : $("#carPlatenumer").val(),
				"carState" : $("#carState").val(),
				"carUser" : $("#carUser").val(),
				"carPrice" : $("#carPrice").val()
			};
			$.post('addcar.action', values, function(data) {
				alert(data);
		}, 'text');
			setTimeout(function(){
				$("#mywindowcar").window('close');
				$("#car").datagrid('load');
			},500)
		}
	</script>
</body>
</html>
