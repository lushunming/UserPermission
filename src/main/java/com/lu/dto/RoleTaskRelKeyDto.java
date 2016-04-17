package com.lu.dto;

import com.lu.model.RoleTaskRelKey;

public class RoleTaskRelKeyDto extends RoleTaskRelKey {

	/**
	 * 
	 */
	private static final long serialVersionUID = -585364867300393546L;
	/**
	 * 任务名
	 */
	private String taskName;
	/**
	 * 任务的url
	 */
	private String taskURL;
	/**
	 * 任务的描述
	 */
	private String taskDescription;

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskURL() {
		return taskURL;
	}

	public void setTaskURL(String taskURL) {
		this.taskURL = taskURL;
	}

}
