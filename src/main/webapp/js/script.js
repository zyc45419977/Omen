$(function(){
	//初始化树控件
	$("#mytree").tree({url:'menu.action',
		onClick:function(node){
			if(node.attributes.url==undefined){
				return;
			}
			var name=node.text;
			var url =node.attributes.url;
			createtab(name,url);
			
			
	}});
	//初始化tab控件
	$("#mytab").tabs({fit:true});
	//添加一个默认的欢迎tab
	$("#mytab").tabs('add',{title:'首页',content:'欢迎使用本系统'});
	//初始化菜单按钮
	$("#qxgl").menubutton({iconCls:'icon-vcard_key',menu:'#mqxgl'});
	$("#hygl").menubutton({iconCls:'icon-user_red'});
	//初始化菜单
	var param1={
			text:'查看权限',
			iconCls:'icon-wrench',
			id:'privileges.html'	
			
	};
	$("#mqxgl").menu('appendItem',param1);
	$("#mqxgl").menu({onClick:function(item){
		var name =item.text;
		var url=item.id;
		createtab(name,url);
	}});
	$("#mhygl").menu();
});
function createtab(name,url){
	//是否已打开
	var isopen=$("#mytab").tabs('exists',name);
	//是  select
	if(isopen){
		$("#mytab").tabs('select',name);
		return;
	}
	//否  create
	var addparam={
			title:name,
			closable:true,
			href:url	
	};
	$("#mytab").tabs('add',addparam);
}