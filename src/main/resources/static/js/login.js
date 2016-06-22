$(document).ready(function() {

	// 点击登录
	$('#loginButton').click(function(e) {
		alert('dod');
		submit();
	});

	// 回车登录
	$(document).keydown(function(e) {
		if (e.keyCode == 13) {
			submit();
		}
	});

});

function submit() {
	var submit = true;
	// 判断表单数据是否为空
	$("input[nullmsg]").each(function() {
		if ($("#" + this.name).val() == "") {
			showError($("#" + this.name).attr("nullmsg"), 500);
			submit = false;
			return false;
		}
	});
	if (submit) {
		login();
	}
}

// 显示错误提示
function showError(str) {
	$('#alertMessage').html(str).stop(true, true).show().animate({
		opacity : 1,
		right : '0'
	}, 500);
}

// 登录处理函数
function login() {
	var actionurl = $('form').attr('action');
	var formData = new Object();
	var data = $(":input").each(function() {
		formData[this.name] = $("#" + this.name).val();
	});
	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		url : actionurl,// 请求的action路径
		data : formData,
		error : function() {// 请求失败处理函数
		},
		success : function(data) {
			if (data.code == '0000') {
				setTimeout("window.location.href='index'", 1000);
			} else {
				showError(data.code + "-" + data.message);
			}
		}
	});
}
