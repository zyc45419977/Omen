<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>请假申请</title>
</head>
<body>
	<form action="addleave">
		<div align="center">
			<table>
				<tr>
					<td>请假编号</td>
					<td><input type="text" name="leaveId" id="leaveId" disabled="disabled"/></td>
				</tr>
				<tr>
					<td>请假人编号</td>
					<td><input type="text" name="leavemanId" id="leavemanId" value="${user1.useraccount } " disabled="disabled" /></td>
				</tr>
				<tr>
					<td>请假原因</td>
					<td><input  type="text"   name="leaveContent"  id="leaveContent" >  </td>
				</tr>
				<tr>
					<td>请假开始时间</td>
					<td><input  type="date"   name="startTime"  class="easyui-datebox" required="required"  id="startTime" ></td> 
				</tr>
				<tr>
					<td>请假结束时间</td>
					<td><input type="date" name="endTime" id="endTime" class="easyui-datebox" required="required"   /></td>
				</tr>
				<tr>
					<td>请假结果</td>	
					<td>
					<input name="leavereSults" id="leavereSults" value="待审核" disabled="disabled" >
					</td>
				</tr>
				<tr>
					<td>上级ID</td>
					<td>
					<select name="leadId" id="leadId" >
						<option  value="admin">admin</option>
						<option  value="zyc">zyc</option>
						<option  value="clearlove7">clearlove7</option>
					</select>
					</td>
				</tr>
			</table>
			<input type="button" value="提交" onclick="leaveadd()" />
		</div>
	</form>
	<script type="text/javascript">
		function leaveadd() {	
			var values = {
				"leaveId":$("#leaveId").val(),
				"leavemanId":$("#leavemanId").val(),
				"leaveContent":$("#leaveContent").val(),
				"startTime":$("#startTime").val(),
				"endTime":$("#endTime").val(),
				"leavereSults":$("#leavereSults").val(),
				"leadId":$("#leadId").val()
			};
			$.post('addleave.action',values,function(data){
				alert(data); 
			
			},'text');
		
			setTimeout(function(){
				 $("#mywindowleave").window('close');
					$("#leave").datagrid('load'); 
				},500)
		}
	</script>
</body>
</html>
