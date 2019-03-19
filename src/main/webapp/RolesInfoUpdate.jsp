<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="editroles">
	<div align="center">
		<table>
			<tr>
				<td>角色编号</td>
				<td><input type="text" name="roleid" id="roleid"  value="${param.roleid } " /></td>
			</tr>
			<tr>
				<td>角色名</td>
				<td><input type="text" name="rolename" id="rolename" value="${param.rolename }" /></td>
			</tr>
		</table>
		<input type="button" value="修改" onclick="editroles()">
	</div>
</form>
<script type="text/javascript">
	function editroles(){
		alert("修改成功！")
		var values = {
				"roleid":$("#roleid").val(),
				"rolename":$("#rolename").val()
		};
		$.post('updateRole.action',values,function(data1){
			alert(data1); 
		},"text"); 
		setTimeout(function(){
			$("#mywindow2").window('close');
			$("#roles").datagrid('load'); 
		},500)
	}


</script>


</body>
</html>