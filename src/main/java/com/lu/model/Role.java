package com.lu.model;

import java.io.Serializable;

public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7328318654530751502L;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column public.t_role.id
	 *
	 * @mbggenerated Sun Mar 27 14:15:44 CST 2016
	 */
	private Integer id;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column public.t_role.name
	 *
	 * @mbggenerated Sun Mar 27 14:15:44 CST 2016
	 */
	private String name;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column public.t_role.description
	 *
	 * @mbggenerated Sun Mar 27 14:15:44 CST 2016
	 */
	private String description;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column public.t_role.id
	 *
	 * @return the value of public.t_role.id
	 *
	 * @mbggenerated Sun Mar 27 14:15:44 CST 2016
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column public.t_role.id
	 *
	 * @param id the value for public.t_role.id
	 *
	 * @mbggenerated Sun Mar 27 14:15:44 CST 2016
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column public.t_role.name
	 *
	 * @return the value of public.t_role.name
	 *
	 * @mbggenerated Sun Mar 27 14:15:44 CST 2016
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column public.t_role.name
	 *
	 * @param name the value for public.t_role.name
	 *
	 * @mbggenerated Sun Mar 27 14:15:44 CST 2016
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column public.t_role.description
	 *
	 * @return the value of public.t_role.description
	 *
	 * @mbggenerated Sun Mar 27 14:15:44 CST 2016
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column public.t_role.description
	 *
	 * @param description the value for public.t_role.description
	 *
	 * @mbggenerated Sun Mar 27 14:15:44 CST 2016
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}
}