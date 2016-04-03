package com.lu.common;

/**
 * 常量类，用来存放用到的常量
 * 
 * @author lusm
 * @date 2016年3月26日
 *
 */
public class CommonConstant {
	// ---------------------------操作结果码start-----------------------------------------
	/** 保存成功 */
	public static final Integer SAVE_SUCCESS = 0;
	/** 保存出错 */
	public static final Integer SAVE_ERROR = 1;
	/** 更新成功 */
	public static final Integer UPDATE_SUCCESS = 2;
	/** 更新失败 */
	public static final Integer UPDATE_ERROR = 3;
	/** 查询成功 */
	public static final Integer SELECT_SUCCESS = 4;
	/** 查询失败 */
	public static final Integer SELECT_ERROR = 5;
	/** 删除成功 */
	public static final Integer DELETE_SUCCESS = 6;
	/** 删除失败 */
	public static final Integer DELETE_ERROR = 7;
	/** 登录失败 */
	public static final Integer LOGIN_FAILED = 8;
	/** 登录成功 */
	public static final Integer LOGIN_SUCCESS = 9;

	// ---------------------------操作结果码end-----------------------------------------
	// ---------------------------用户状态start-----------------------------------------
	/** 0 未审核 */
	public static final Integer STATUS_UNCHECK = 0;
	/** 1审核通过 */
	public static final Integer STATUS_CHECKED = 1;
	/** 2审核未通过 */
	public static final Integer STATUS_CHECK_NOPASS = 2;
	// ---------------------------用户状态end-----------------------------------------

}
