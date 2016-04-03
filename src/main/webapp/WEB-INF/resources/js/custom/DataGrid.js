/**
 * 扩展了EasyUI DateGrid
 * 
 * @param option
 *            是datagrid 的选项：其中要传入id 为构建datagrid的dom的id
 */
var DataGrid = function(option) {
	var defaultOption = {
		pagination : true,
		rownumbers : true,
		fit:true
	};

	var newOption = $.extend({}, defaultOption, option)
	$(option.id).datagrid(newOption);
};