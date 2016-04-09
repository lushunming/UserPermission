/**
 * 工具类
 */

var Util = {
	gotoPage : function(url, width, height) {
		var _width = '700px';
		var _height = '400px';
		if (width != undefined && width != "" && width != null) {
			_width = width;
		}
		if (height != undefined && height != "" && height != null) {
			_height = height;
		}
		layer.open({
			type : 2,
			area : [ _width, _height ],
			fix : false, // 不固定
			maxmin : true,
			content : url
		});
	},
	/**
	 * 打开弹窗
	 * 
	 * @param title
	 *            弹窗题目
	 * @param href
	 *            url
	 * @param width
	 *            弹窗的宽度
	 * @param height
	 *            弹窗的高度
	 * @param modal
	 *            是不是modal框
	 * @param minimizable
	 *            最小化
	 * @param maximizable
	 *            最大化
	 */
	openWin : function(title, href, width, height, modal, minimizable, maximizable) {
		$('#myWindow').window({
			title : title,
			width : width === undefined ? 600 : width,
			height : height === undefined ? 400 : height,
			content : '<iframe scrolling="auto" frameborder="0" src="' + href + '" style="width:100%;height:98%;"></iframe>',
			// href : href,
			modal : modal === undefined ? true : modal,
			minimizable : minimizable === undefined ? false : minimizable,
			maximizable : maximizable === undefined ? false : maximizable,
			shadow : false,
			cache : false,
			closed : false,
			collapsible : false,
			resizable : false,
			loadingMessage : '正在加载数据，请稍等片刻......'
		});
	},
	/**
	 * 
	 * @param msg
	 */
	showMessage : function(msg) {
		(msg == undefined) ? message = "" : message = msg;
		var config = {
			msg : message,
			timeout : 5000,
			showType : 'slide'
		};
		$.messager.show(config);

	},
	/**
	 * 
	 * @param url
	 *            ur l
	 * @param param
	 *            请求参数
	 * 
	 * @param callback
	 *            请求成功的回调
	 */
	callAjax : function(url, param, callback) {
		var success;
		if (typeof callback == 'function') {
			success = callback;
		}
		$.ajax({
			type : "POST",
			url : url,
			data : param,
			success : success,
			dataType : "json"
		});
	}

}