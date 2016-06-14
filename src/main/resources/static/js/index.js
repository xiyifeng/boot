$(function(){
	initMenu();
});
function initMenu(){
	var $ma=$("#menuAccordion");
	$ma.accordion({animate:true,fit:true,border:true,selected:'0'});
	$.post("loadMenu", {userName:""}, function(rsp) {
		$.each(rsp,function(i,e){
			var menulist;
			if(e.child && e.child.length>0){
				$.each(e.child,function(ci,ce){
					menulist ="<a href=\"javascript:void(0);\" style=\"width:100px;margin:6px 6px 6px 6px;\" class=\"easyui-linkbutton\" data-options=\"size:'large',iconAlign:'top',plain:true,iconCls:'"+ce.iconCls+"'\" onclick=\"addItem('"+ce.name+"','" + ce.url +"','" + ce.iconCls + "');\">"+ce.name+"</a><br/>";
				});
			}
			$ma.accordion('add', {
	            title: e.name,
	            content: menulist,
				style : "padding-left:20px;",
	            iconCls: e.iconCls,
	            selected: false
	        });
		});
	}, "JSON").error(function() {
		$.messager.alert("提示", "获取菜单出错,请重新登陆!");
	});
}

/**
 * 退出系统
 */
function logout() {
	$.messager.confirm("提示", "确认退出系统吗?", function(r) {
		if (r) {
			$.ajax({
				async : false,
				cache : false,
				type : "POST",
				url : "logout",
				error : function() {
				},
				success : function(json) {
					location.replace("/");
				}
			});
		}
	});
}
