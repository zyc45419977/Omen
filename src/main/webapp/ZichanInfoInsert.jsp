<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>资产申请</title>
</head>
<body>

<form action="addzichan">
<div align="center">
<table>
<!-- 	<tr>
		<td>资产编号</td>
		<td><input type="text" name="prid" id="prid"  readonly="readonly"/></td> 
	</tr>  -->
	<tr> 
		<td>资产名称</td> 
		<td><input type="text" name="prname" id="prname"/></td> 
	</tr>
	<tr> 
		<td>资产价格</td> 
		<td><input type="text" name="price" id="price"/></td> 
	</tr>
	<tr>
		<td>申请时间</td>
		<td><input  type="date"   name="prdate"  class="easyui-datebox" required="required"  id="prdate" ></td> 
	</tr>
	<tr> 
		<td>资产状态</td> 
		<td><input type="text" name="propertySults" id="propertySults" disabled="disabled" value="未使用" /></td> 
	</tr> 
		<tr> 
		<td>资产拥有人ID</td> 
		<td>
			<select  name="userid" id="userid" >
				<option value="1" >1</option>
				<option value="2" >2</option>
				<option value="3" >3</option>
				<option value="4" >4</option>
			</select>
		</td>
	</tr>
	
</table>
<input type="button" value="提交" onclick="noticeadd()" />
</div>
</form>

<script type="text/javascript">
	function noticeadd(){
		var values = {	
		/* 	"prid":$("#prid").val(), */
			"prname":$("#prname").val(),
			"price":$("#price").val(),
			"prdate":$("#prdate").val(),
		 	"propertySults":$("#propertySults").val(), 
			"userid":$("#userid").val()
		};
		$.post('propertyadd.action',values,function(data){
			alert(data); 
		},'text');
		$("#mywindowzichan").window('close');
		$("#zichan").datagrid('load'); 
	}


</script>
</body>
</html>
