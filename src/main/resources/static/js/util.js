function serializeObject(formId) {
	var o = {};
	$.each($(formId).serializeArray(), function(index) {
		if (o[this['name']]) {
			o[this['name']] = o[this['name']] + ","
					+ (this['value'] == '' ? ' ' : this['value']);
		} else {
			o[this['name']] = this['value'] == '' ? ' ' : this['value'];
		}
	});
	return o;
}