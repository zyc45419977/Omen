<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>发送邮件</title>
</head>
<body>
	<form action="addemail">
		<div align="center">
			<table>
				<tr>
					<td>邮件编号</td>
					<td><input type="text" name="emailId" id="emailId" disabled="disabled" /></td>
				</tr>
				<tr>
					<td>发件人</td>
					<td>
					 <input name="emailName" id="emailName"  value="${user1.useraccount } " disabled="disabled"/></td>
				</tr>
				<tr>
					<td>邮件标题</td>
					<td><input type="text" name="emailHeadline" id="emailHeadline" /></td>
				</tr>
	
				<tr>
					<td>邮件内容</td>
					<td><input  type="text" name="emailContent"  id="emailContent" />  </td>
				</tr>
				
				<tr>
					<td>接收人</td>
					<td>  <select name="emailRecipients" id="emailRecipients">
					 	 <option  value="admin">admin</option>
						 <option  value="zyc">zyc</option>
						 <option  value="clearlove" >clearlove</option>
					</select>
					</td>
				</tr>
			</table>
			<input type="button" value="提交" onclick="emailadd()" />
		</div>
	</form>
	<script type="text/javascript">
		function emailadd() {
			var values = {
				"emailId" : $("#emailId").val(),
				"emailName" : $("#emailName").val(),
				"emailHeadline" : $("#emailHeadline").val(),
				"emailContent" : $("#emailContent").val(),
				"emailRecipients" : $("#emailRecipients").val()
			};
			$.post('addemail.action', values, function(data) {
				alert(data);
		}, 'text');
			setTimeout(function(){
				$("#mywindowemail").window('close');
				$("#email").datagrid('load');
				},500)
		}
	</script>
</body>
</html>
