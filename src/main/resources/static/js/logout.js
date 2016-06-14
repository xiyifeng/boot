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
