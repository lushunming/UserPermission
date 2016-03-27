/**
 * 
 */

var PageUtil = {
	gotoPage : function(url, width, height) {
		var _width = '700px';
		var _height = '530px';
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
	}

}