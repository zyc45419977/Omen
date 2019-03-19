<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>权限设置</title>
</head>
<body>   
   
     <div class="easyui-layout" data-options="fit:true">  
      <!-- 左边 -->
            <div data-options="region:'west'" style="width:510px">
            
	            <div id="role"></div>
	
				<div id="roletools">
				
				</div>
	            
            </div>   
            
            <!-- 右边 -->
            <div data-options="region:'center'">
            	<div id="permissions"></div>
            	<div id="permissiontools">
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="shouquan()">赋予权限</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="quxiaoshouquan()">取消权限</a>
				</div>
            </div>   
        </div>   
    
    <script type="text/javascript">
    
   function shouquan(){
    	var trobjs1 = $("#role").datagrid("getSelections");
    	if (trobjs1.length == 0 || trobjs1.length > 1) {
			$.messager.alert('警告', '请先选择角色');
			return;
		}
    	var trobjs2 = $("#permissions").datagrid("getSelections");
    	if (trobjs2.length == 0 || trobjs2.length > 1) {
			$.messager.alert('警告', '请选择需要赋予的权限');
			return;
		}
    	var rid = trobjs1[0].roleid;
    	var id = trobjs2[0].id;
    	$.messager.confirm('确认','确定授权?',function(r){
        	alert(rid)
        	alert(id)
    		if(r){
    			$.get("addrome.action",{
        			roleid:rid,
        			id:id},function(data){
    				$.messager.show({
    					title : '我的消息',
    					msg : data,
    					timeout : 5000,
    					showType : 'slide'
    				});
    	    	},"text");
    			setTimeout(function() {
    				$("#permissions").datagrid('reload');
    			}, 500)
    		}
    	})

		
    } 
    
    function quxiaoshouquan(){
    	var trobjs1 = $("#role").datagrid("getSelections");
    	if (trobjs1.length == 0 || trobjs1.length > 1) {
			$.messager.alert('警告', '请先选择角色');
			return;
		}
    	var trobjs2 = $("#permissions").datagrid("getSelections");
    	if (trobjs2.length == 0 || trobjs2.length > 1) {
			$.messager.alert('警告', '请选择要取消的权限');
			return;
		}
    	
    	var rid = trobjs1[0].roleid;
    	var id = trobjs2[0].id;
    	
    	$.messager.confirm('确认','确定取消授权?',function(r){
    		if(r){
		    	$.get("deleterome.action",{roleid:rid,id:id},function(date){
		    		$.messager.show({
						title : '我的消息',
						msg : data,
						timeout : 5000,
						showType : 'slide'
					});
		    	},"text");
		    	
		    	setTimeout(function() {

					$("#permissions").datagrid('reload');
				}, 2000)
    		}
    	})
    	
    	
    } 

    
   /* 左边 */
		 $(function(){
			var param = {
					fit:true,
					width: 650,
					fitColumns: true,
					singleSelect:true,
					 onClickRow:function(rowIndex, rowDate, value){
				
						var param211 = {
								fit:true,
								width: 650,
								fitColumns: true,
								singleSelect:true,
								columns:[[
							 { field:'ck',checkbox:true, width:50 },
							 {field:'id',title:'菜单ID',width:100},
							 {field:'text',title:'菜单名字',width:100},
							 {field:'romestate',title:'权限状态',width:100,
								styler: function(value,row,index){
									if (value == "已授权"){
										return 'color:red;';
										}else if(value == "未授权"){
											return 'color:gray;';
										}
									}

								}
								]],
								url:'queryroleid.action?id='+rowDate.roleid,
									toolbar:'#permissiontools'
						};
						$('#permissions').datagrid(param211);
					}, 
					columns:[[
					  		{field : 'ck',checkbox : true,width : 50},
							{field:'roleid',title:'角色编号',width:80},
							{field:'rolename',title:'角色名',width:80}
					]],
					url:'Role.action',
						pagination : true,
						rownumbers : true,
						pageList : [ 5, 10, 15, 20, 25 ],
						toolbar:'#roletools'
			};
			var param21 = {
					fit:true,
					width: 650,
					fitColumns: true,
					singleSelect:true,
					columns:[[
					{ field:'ck', checkbox:true, width:50 },
					{field:'menu_id',title:'菜单ID',width:100},
					{field:'menu_name',title:'菜单名字',width:100},
					{field:'romestate',title:'权限状态',width:100}
					]],
					url:'',
					toolbar:'#permissiontools'
			};
			$('#role').datagrid(param);	
			$('#permissions').datagrid(param21);
		}) 
</script>
</body>  
</html>