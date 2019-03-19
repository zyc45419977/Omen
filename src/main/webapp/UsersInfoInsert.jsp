<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form >
<div align="center">
<table>
	<tr> 
		<td>员工编号</td> 
		<td><input type="text" name="userId" id="userId" readonly="readonly"/></td> 
	</tr> 
	<tr> 
		<td>角色编号</td> 
		<td>
					<input type="text" name="roleId" id="roleId" />				
		</td> 
	</tr> 
	<tr> 
		<td>职位编号</td> 
		<td>		
			<input type="text" name="positionId" id="positionId" />
		</td> 
	</tr> 
	<tr> 
		<td>帐号编号</td> 
		<td><input type="text" name="useraccount" id="useraccount"  /></td> 
	</tr> 
	<tr> 
		<td>用户密码</td> 
		<td><input type="text" name="userpwd" id="userpwd"/></td> 
	</tr>
	<tr> 
		<td>用户名</td> 
		<td><input type="text" name="username" id="username"  /></td> 
	</tr> 
	<tr> 
		<td>性别</td> 
		<td>
				<input type="radio" name="usersex" id="usersex" checked="checked" value="男"/>男
		    	<input type="radio" name="usersex" value="女"/>女
		</td> 
	</tr> 
	<tr> 
		<td>上级领导编号</td> 
		<td><input type="text" name="superior" id="superior"  /></td> 
	</tr> 
	
	<tr> 
		<td>员工工资</td> 
		<td><input type="text" name="usersal" id="usersal"  /></td> 
	</tr>

	<tr> 
		<td>身份证</td> 
		<td><input type="text" name="usercard" id="usercard"  /></td> 
	</tr> 
	<tr> 
		<td>电话号码</td> 
		<td><input type="text" name="usertel" id="usertel"  /></td> 
	</tr> 
	<tr> 
		<td>电子邮件</td> 
		<td><input type="text" name="useremail" id="useremail"  /></td> 
	</tr> 
	<tr> 
		<td>地址</td> 
		<td><input type="text" name="useraddress"  id="useraddress"  /></td> 
	</tr> 
</table>
<input type="button"  value="添加"  onclick="usersadd()" />
</div>
</form>

<script type="text/javascript">
function usersadd(){
	$('form').form('submit', {    
	    url:'addUser.action',    
	    success:function(data){    
	        alert(data);
	    }    
	});  
   	setTimeout(function(){
   		$("#mywindowusers").window('close');
   		//重新刷新datagrid的数据
   		$("#users").datagrid('load'); 
		},500)
}
</script>

</body>
</html>