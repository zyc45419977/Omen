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
					<td>员工编号</td>
					<td><input type="text" name="user_id" id="user_id"
						value="${param.user_id}" disabled="disabled" /></td>
				</tr>
				<tr>
					<td>角色编号</td>
					<td>
					<select name="role_id" id="role_id">
							<option value="2">管理员</option>
							<option value="1">超级管理员</option>
							<option value="3" selected="selected">员工</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>职位编号</td>
					<td><select name="position_id" id="position_id">
							<option value="1">经理</option>
							<option value="2">主管</option>
							<option value="3">组长</option>
							<option value="4" selected="selected">员工</option>
					</select></td>
				</tr>
				<tr>
					<td>帐号编号</td>
					<td><input type="text" name="user_account" id="user_account" value="${param.user_account }" /></td>
				</tr>
				<tr>
					<td>用户密码</td>
					<td><input type="text" name="user_pwd" id="user_pwd" value="${param.user_pwd }" /></td>
				</tr>
				<tr>
					<td>用户名</td>
					<td><input type="text" name="user_name" id="user_name"  value="${param.user_name }" /></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><select name="user_sex" id="user_sex">
							<option selected="selected" value="1">男</option>
							<option value="0">女</option>
					</select></td>
				</tr>
				<tr>
					<td>上级领导编号</td>
					<td><input type="text" name="superior" id="superior"  value="${param.superior }" /></td>
				</tr>
				<tr>
					<td>入职时间</td>
					<td><input type="date" name="user_date" class="easyui-datebox" 
					required="required" id="user_date"  value="${param.user_date }" ></td>
				</tr>
				<tr>
					<td>员工工资</td>
					<td><input type="text" name="user_sal" id="user_sal"  value="${param.user_sal }" /></td>
				</tr>
				<tr>
					<td>身份证</td>
					<td><input type="text" name="user_card" id="user_card"  value="${param.user_card }" /></td>
				</tr>
				<tr>
					<td>电话号码</td>
					<td><input type="text" name="user_tel" id="user_tel"  value="${param.user_tel }" /></td>
				</tr>
				<tr>
					<td>电子邮件</td>
					<td><input type="text" name="user_email" id="user_email"  value="${param.user_email }"  /></td>
				</tr>
				<tr>
					<td>地址</td>
					<td><input type="text" name="user_address" id="user_address"  value="${param.user_address }" /></td>
				</tr>
			</table>
			<input type="button" value="修改" onclick="editroles()">
		</div>
	</form>
	<script type="text/javascript">
		function editroles() {
			alert("修改成功！")
			var values = {
					"user_id":$("#user_id").val(),
					"role_id":$("#role_id").val(),
					"position_id":$("#position_id").val(),
					"user_account":$("#user_account").val(),
					"user_pwd":$("#user_pwd").val(),
					"user_name":$("#user_name").val(),
					"user_sex":$("#user_sex").val(),
					"superior":$("#superior").val(),
					"user_date":$("#user_date").val(),
					"user_sal":$("#user_sal").val(),
					"user_card":$("#user_card").val(),
					"user_tel":$("#user_tel").val(),
					"user_email":$("#user_email").val(),
					"user_address":$("#user_address").val()
				};
			$.post('users/usersupdate', values, function(data1) {
				alert(data1);
			}, "text");
			$("#mywindowusers").window('close');
			//重新刷新datagrid的数据
			$("#users").datagrid('load'); 
		}
	</script>
</body>
</html>