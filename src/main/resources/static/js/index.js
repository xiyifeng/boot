$(function(){
	initMenu();
	var tabsMenu;
	var tabs =$("#main_tabs"); 
	tabs.tabs({  
		tools:[{
			iconCls:'icon-reload',
			handler:function(){
				var href = $('#main_tabs').tabs('getSelected').panel('options').href;
				if (href) {
					
					/*说明tab是以href方式引入的目标页面*/
					var index = $('#main_tabs').tabs('getTabIndex', $('#main_tabs').tabs('getSelected'));
					$('#main_tabs').tabs('getTab', index).panel('refresh');
				} else {
					
					/*说明tab是以content方式引入的目标页面*/
					var panel = $('#main_tabs').tabs('getSelected').panel('panel');
					var frame = panel.find('iframe');
					try {
						if (frame.length > 0) {
							for ( var i = 0; i < frame.length; i++) {
								frame[i].contentWindow.document.write('');
								frame[i].contentWindow.close();
								frame[i].src = frame[i].src;
							}
							if ($.browser.msie) {
								CollectGarbage();
							}
						}
					} catch (e) {
					}
				}
			}
		},{
			iconCls:'icon-cancel',
			handler:function(){
				var index = $('#main_tabs').tabs('getTabIndex', $('#main_tabs').tabs('getSelected'));
				var tab = $('#main_tabs').tabs('getTab', index);
				if (tab.panel('options').closable) {
					$('#main_tabs').tabs('close', index);
				} else {
					$.messager.alert('提示', '[' + tab.panel('options').title + ']不可以被关闭', 'error');
				}
			}
		},{
			iconCls:'icon-lock',
			handler:function(){
				$('#theme').menu({   
					onClick:function(item){   
						var cookiesColor1=jqueryUtil.cookies.get("cookiesColor");
                    	if(cookiesColor1!=item.id){
							jqueryUtil.cookies.set("cookiesColor",item.id,30);
							jqueryUtil.chgSkin(item.id,cookiesColor1);
                        }
					}   
				});
                $('#theme').menu('show', {
						 left: '91%',   
						 top: 97
				});
			}
		}],
		toolPosition:'right',
		onContextMenu : function(e, title) {
			e.preventDefault();
			tabsMenu.menu('show', {
				left : e.pageX,
				top : e.pageY
			}).data('tabTitle', title);
		}
	});
	
	tabsMenu = $('#tabsMenu').menu({
		onClick : function(item) {
			var curTabTitle = $(this).data('tabTitle');
			var type = $(item.target).attr('type');

			if (type === 'refresh') {
				refreshTab(curTabTitle);
				return;
			}

			if (type === 'close') {
				var t = tabs.tabs('getTab', curTabTitle);
				if (t.panel('options').closable) {
					tabs.tabs('close', curTabTitle);
				}
				return;
			}

			var allTabs = tabs.tabs('tabs');
			var closeTabsTitle = [];

			$.each(allTabs, function() {
				var opt = $(this).panel('options');
				if (opt.closable && opt.title != curTabTitle && type === 'closeOther') {
					closeTabsTitle.push(opt.title);
				} else if (opt.closable && type === 'closeAll') {
					closeTabsTitle.push(opt.title);
				}
			});

			for ( var i = 0; i < closeTabsTitle.length; i++) {
				tabs.tabs('close', closeTabsTitle[i]);
			}
		}
	});
	
});
function initMenu(){
	var $ma=$("#menuAccordion");
	$ma.accordion({animate:true,
		fit:true,
		border:true,
		selected:'0'});
	$.post("loadMenu", {userName:""}, function(rsp) {
		$.each(rsp,function(i,e){
			var menulist = "";
			if(e.child && e.child.length>0){
				$.each(e.child,function(ci,ce){
					menulist += "<a href=\"javascript:void(0);\" style=\"width:100px;margin:6px 6px 6px 6px;\" class=\"easyui-linkbutton\" data-options=\"size:'large',iconAlign:'top',plain:true,iconCls:'"+ce.iconCls+"'\" onclick=\"addItem('"+ce.name+"','" + ce.url +"','" + ce.iconCls + "');\">"+ce.name+"</a><br/>";
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
 * 点击菜单触发
 * 
 * @param title
 * @param url
 * @param clsClass
 */
function addItem(title, url, clsClass) {
	if ($('#main_tabs').tabs('exists', title)) {
		$('#main_tabs').tabs('select', title);
	} else {
		var content = '<iframe frameborder="0"  src="'
				+ url + '" style="width:100%;height:600px;"></iframe>';
		$('#main_tabs').tabs('add', {
			title : title,
			content : content,
			closable : true,
			iconCls : clsClass,
			tools : [ {
				iconCls : 'icon-mini-refresh',
				handler : function() {
					refreshTab(title);
				}
			} ]
		});
	}
}

/**
 * 页面刷新
 * 
 * @param title
 */
function refreshTab(title) {
	var mainTab = $('#main_tabs');
	var tab = mainTab.tabs('getTab', title);
	mainTab.tabs('update', {
		tab : tab,
		options : tab.panel('options')
	});
}

/**
 * 退出系统
 */
function logout( type ) {
	var msg;
	if( type )
	{
		msg = "确认退出系统吗?";
	}
	else
	{
		msg = "确认重新登陆吗?";
	}
	$.messager.confirm("提示", msg, function(r) {
		if (r) {
			$.ajax({
				async : false,
				cache : false,
				type : "POST",
				dataType : "json",
				url : "logout",
				error : function() {
				},
				success : function(json) {
					if( json && json.code && json.code == '0000' )
					{
						location.replace("/");
					}
					else
					{
						$.messager.alert("提示", "系统退出失败!");
					}
				}
			});
		}
	});
}

/**
 * 密码修改
 */
function passwordModify()
{
	$.messager.alert("提示", "密码修改暂未开通!");
}

/**
 * 说明
 */
function help()
{
	$.messager.alert("说明", "Copyright @ xiyifeng 2016 - 2020 All rights reserved");
}