/**
 * 扩展了EasyUI DateGrid
 * 
 * @param option
 *            是datagrid 的选项：其中要传入id 为构建datagrid的dom的id
 */
var DataGrid = function(option) {
	var self = this;
	var defaultOption = {
		pagination : true,
		rownumbers : true,
		singleSelect : true,
		fitColumns : true,
		fit : true

	};

	var newOption = $.extend({}, defaultOption, option);
	self.reload = function() {
		$(option.id).datagrid("reload");
	};
	$(option.id).datagrid(newOption);
};