$(function() {
	$('#dg').datagrid({
		url : '',
		iconCls : 'icon-save',
		width : $(document).width()-25,
		height : $(document).height()-50,
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
			field : 'uuid',
			title : 'UUID',
			width : 100
		}, {
			field : 'msgSeq',
			title : '顺序号',
			width : 80
		}, {
			field : 'tranCode',
			title : '交易码',
			width : 100,
			align : 'right'
		}, {
			field : 'requestTime',
			title : '请求时间',
			width : 150,
			align : 'right'
		}, {
			field : 'responseTime',
			title : '响应时间',
			width : 150
		}, {
			field : 'status',
			title : '状态',
			width : 60,
			align : 'center'
		}, {
			field : 'diffCode',
			title : '对比结果',
			width : 60,
			align : 'center'
		} ] ],
		onDblClickRow : function(rowIndex, rowData) {
			showDetail(rowData.uuid);
		}
	});
});

function doFind() {
	var o = serializeObject("#conds");
	$("#dg").datagrid({
		queryParams : o,
		url : "/replay/list.json"
	});
}

// 详细信息展示
function showDetail(uuid) {
	window.parent.$("#childUse").window({
		title : "比对结果详细",
		width : 1100,
		height : 500,
		collapsible : false,
		modal : true,
		inline : false,
		href : "/replay/detail/" + uuid
	});
}

function help() {
	$.messager.alert('提示', 'Just do it！', 'info');
}
