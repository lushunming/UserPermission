/**
 * 扩展了EasyUI DateGrid
 * 
 * @param option
 *            是datagrid 的选项：其中要传入id 为构建datagrid的dom的id
 */
var DataGrid = function(option) {
	option = option || {};
	var self = this;
	var defaultOption = {
		pagination : true,
		rownumbers : true,
		singleSelect : true,
		fitColumns : true,
		fit : true,
		autoRowHeight : true,
		fitColumns : true
	};

	var newOption = $.extend({}, defaultOption, option);
	self.reload = function() {
		$(option.id).datagrid("reload");
	};
	self.selectRow = function(index) {
		$(option.id).datagrid("selectRow", index);
	}
	self.getChecked = function() {
		return $(option.id).datagrid("getChecked");
	}
	$(option.id).datagrid(newOption);
};