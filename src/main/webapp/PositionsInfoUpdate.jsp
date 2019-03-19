<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>职位修改</title>
</head>
<body>
<form id="editzhiwei">
	<div align="center">
		<table>
			<tr>
				<td>职位编号</td>
				<td><input type="text" name="positionId" id="positionId" value="${param.positionId }" disabled="disabled" /></td>
			</tr>
			<tr>
				<td>职位名称</td>
				<td><input type="text" name="positionName" id="positionName" value="${param.positionName }" /></td>
			</tr>
			<tr>
				<td>职位负责人</td>
				<td><input type="text" name="positionPrincipal" id="positionPrincipal" value="${param.positionPrincipal}" /></td>
			</tr>
		</table>
		<input type="button" value="修改" onclick="editroles()">
	</div>
</form>
<script type="text/javascript">
	function editroles(){
		var values = {
				"positionId":$("#positionId").val(),
				"positionName":$("#positionName").val(),
				"positionPrincipal":$("#positionPrincipal").val()
		};
		$.post('updatezhiwei.action',values,function(data1){
			alert(data1); 
		},"text"); 
		setTimeout(function(){
			$("#mywindow1").window('close');
			$("#positions").datagrid('reload'); 
			},500)
	}


</script>
</body>
</html>