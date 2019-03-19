<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>文件添加</title>
</head>
<body>
	<form >
		<div align="center">
			<table>
				<tr>
					<td>文件编号</td>
					<td><input type="text" name="fileId" id="fileId" /></td>
				</tr>
				<tr>
					<td>文件目录</td>
					
					 <td> 
					 
					  <select name="fileUrl" id="fileUrl">
					 	 <option  value="1">C:/</option>
						 <option  value="2">D:/</option>
						 <option  value="3" >E:/</option>
						 <option  value="4" selected="selected" >F:/</option>
						</select> 
					</td>  
				</tr>
				<tr>
					<td>文件标题</td>
					<td><input type="text" name="fineName" id="fineName" /></td>
				</tr>
				<tr>
					<td>文件内容</td>
					<td><input type="text" name="fineContent" id="fineContent"   /></td>
				</tr>
				<tr>
					<td>文件发布时间</td>
					<td><input type="date" name="fileDate" id="fileDate"  class="easyui-datebox" required="required"/></td>
				</tr>
				<tr>
					<td>发布人</td>
					<td> <select name="userName" id="userName">
					 	 <option  value="1">经理</option>
						 <option  value="2">主管</option>
						 <option  value="3" >组长</option>
						 <option  value="4" selected="selected" >员工</option>
					</select>
					</td>
				</tr>
			</table>
				<input type="button" value="提交" onclick="filesadd()" />
		</div>
</form>
 <script type="text/javascript">
		function filesadd() {
			alert(123)
				alert($("#fileUrl").val())
			var values = {
				"fileId" : $("#fileId").val(),
				"fileUrl" : $("#fileUrl").val(),
				"fineName" : $("#fineName").val(),
				"fineContent" : $("#fineContent").val(),
				"fileDate" : $("#fileDate").val(),
				"userName" : $("#userName").val()
			};
			$.post('addwj.action', values, function(data) {
				alert(data);
		}, 'text');
			$("#mywindowFiles").window('close');
			$("#files").datagrid('load');
		}
	</script>
</body>
</html>
