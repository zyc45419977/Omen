<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请假审批</title>
</head>
<body>
<form action="updateemail">
		<div align="center">
		审批人:${user1.useraccount}
			<table>	
				<tr>
					<td>请假编号</td>
					<td><input type="text" name="leaveId" id="leaveId" disabled="disabled" value="${param.leaveId }"/></td>
				</tr>
				<tr>
					<td>请假结果</td>
					<td>
					<select  name="leavereSults" id="leavereSults" >
							<option value="已通过" value="${param.leavereSults }">通过</option>
							<option value="不通过" value="${param.leavereSults }">不通过</option>
					</select>
					</td>
				</tr>
			</table>
			<input type="button" value="审批" onclick="editleave()" />
		</div>
	</form>
<script type="text/javascript">
	function editleave(){
		

		var values = {
				"leaveId":$("#leaveId").val(),
				"leavereSults":$("#leavereSults").val(), 
		};
		$.post('updateleave.action',values,function(data){
			alert(data); 
		},"text"); 
		setTimeout(function(){
			$("#mywindowleave2").window('close');
			$("#leave2").datagrid('load');
		},500)
	}
</script>
</body>
</html>