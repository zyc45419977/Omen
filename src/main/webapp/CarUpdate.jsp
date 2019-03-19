<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车辆审批</title>
</head>
<body>
<form action="updatecar">
		<div align="center">
			<table>
				<tr>
					<td>车辆编号</td>
					<td><input type="text" name="carId" id="carId" disabled="disabled" value="${param.carId }"  /></td>
				</tr>
				<tr>
					<td>车辆状态</td>
					<td >
					<select  name="carState" id="carState" >
							<option value="使用" value="${param.carState }">使用</option>
							<option value="未使用" value="${param.carState }">未使用</option>
					</select>
					</td>
				</tr>
			</table>
			<input type="button" value="审批" onclick="editcar()" />
		</div>
	</form>
<script type="text/javascript">
	function editcar(){
		var values = {
				"carId":$("#carId").val(),
				"carState":$("#carState").val()
		};
		$.post('updatecar.action',values,function(data){
			alert(data); 
		},"text"); 
		setTimeout(function(){
			$("#mywindowcar2").window('close');
			$("#car2").datagrid('reload'); 
		},500)
		
	}


</script>


</body>
</html>