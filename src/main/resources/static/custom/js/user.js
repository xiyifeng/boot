$(function() {
	$('#dg').datagrid({
		url : '',
		iconCls : 'icon-save',
		width : 1200,
		height : 450,
		fitColumns : true,
		singleSelect : true,
		striped : false,
		method : "post",
		loadMsg : "数据加载中",
		pagination : true,
		rownumbers : true,
		singleSelect : true,
		pagePosition : "bottom",
		toolbar : "#conds",
		columns : [ [ {
			field : 'usercode',
			title : '用户号',
			width : 80
		}, {
			field : 'username',
			title : '用户名称',
			width : 120
		}, {
			field : 'position',
			title : '职位',
			width : 100,
			align : 'right'
		}, {
			field : 'email',
			title : 'EMAIL',
			width : 150,
			align : 'right'
		}, {
			field : 'mobilPhone',
			title : '移动号码',
			width : 150
		}, {
			field : 'status',
			title : '状态',
			width : 60,
			align : 'center'
		}, {
			field : 'lang',
			title : '语言',
			width : 60,
			align : 'center'
		}, {
			field : 'theme',
			title : '主题',
			width : 60,
			align : 'center'
		}, {
			field : 'errorLoginTimes',
			title : '错误登陆次数',
			width : 60,
			align : 'center'
		}, {
			field : 'remark',
			title : '备注',
			width : 60,
			align : 'center'
		} ] ],
		onDblClickRow : function(rowIndex, rowData) {
			showDetail(rowData.usercode);
		}
	});
});

/**
 * 查询
 */
function doFind() {
	var o = serializeObject("#conds");
	$("#dg").datagrid({
		queryParams : o,
		url : "/user/list"
	});
}

// 详细信息展示
function showDetail(usercode) {
	window.parent.$("#childUse").dialog({
		title : "用户信息",
		width : 600,
		height : 400,
		collapsible : false,
		modal : true,
		inline : false,
		href : "/user/detail?usercode=" + usercode,
		buttons : [ {
			text : '&nbsp;取&nbsp;消&nbsp;',
			iconCls : 'icon-cancel',
			handler : function() {
				window.parent.$("#childUse").dialog('close');
			}
		} ]
	});
}

// 新增
function doAdd() {
	window.parent.$("#childUse").dialog(
	{
		title : "用户添加",
		width : 600,
		height : 400,
		collapsible : false,
		modal : true,
		inline : false,
		href : "/user/add",
		buttons : [
				{
					text : '&nbsp;保&nbsp;存&nbsp;',
					iconCls : 'icon-ok',
					handler : function() {
						var sn = window.parent.$("#childUse").find("#userForm");
						bootAjax(sn.serialize(),"user/add");
					}
				},
				{
					text : '&nbsp;取&nbsp;消&nbsp;',
					iconCls : 'icon-cancel',
					handler : function() {
						window.parent.$("#childUse").dialog(
								'close');
					}
				} ]
	});
}

// 修改
function doModify() {
	var row = $('#dg').datagrid('getSelected');
	if (!row) {
		$.messager.alert('提示', '请选择一条记录！');
		return;
	}
	window.parent.$("#childUse").dialog({
		title : "用户变更",
		width : 600,
		height : 400,
		collapsible : false,
		modal : true,
		inline : false,
		href : "/user/detail?usercode=" + row.usercode,
		buttons : [ {
			text : '&nbsp;修&nbsp;改&nbsp;',
			iconCls : 'icon-ok',
			handler : function() {
				var sn = window.parent.$("#childUse").find("#userForm");
				bootAjax(sn.serialize(),"user/modify");
			}
		}, {
			text : '&nbsp;取&nbsp;消&nbsp;',
			iconCls : 'icon-cancel',
			handler : function() {
				window.parent.$("#childUse").dialog('close');
			}
		} ]
	});
}

/**
 * ajax提交
 * 
 * @param data
 *            DATA
 * @param url
 *            URL
 */
function bootAjax(data, url) {
	if( data instanceof Object )
	{
		data.ptStyle = "json";
	}
	else
	{
		if( data.length > 0 )
		{
			data += "&ptStyle=json";
		}
		else
		{
			data = "ptStyle=json";
		}	
	}
	$.ajax({
		type : "POST",
		url : url,
		async : true,
		dataType : "json",
		data : data,
		cache : false,
		complete : function(xmlHttpRequest, textStatus)
		{
		},
		success : function(msg, textStatus) {
			window.parent.$.messager.alert('提示', msg.code + "-" + msg.message);
			if( msg.code == '0000' )
			{
				window.parent.$("#childUse").dialog('close');
				doFind();
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown)
		{
			alert(XMLHttpRequest.responseText);
		}
	});
}