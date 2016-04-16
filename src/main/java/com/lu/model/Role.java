package com.lu.model;

import java.io.Serializable;

public class Role implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7571765076534318704L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.t_role.id
     *
     * @mbggenerated Sun Apr 10 11:22:04 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.t_role.name
     *
     * @mbggenerated Sun Apr 10 11:22:04 CST 2016
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.t_role.description
     *
     * @mbggenerated Sun Apr 10 11:22:04 CST 2016
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.t_role.level
     *
     * @mbggenerated Sun Apr 10 11:22:04 CST 2016
     */
    private Integer level;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.t_role.id
     *
     * @return the value of public.t_role.id
     *
     * @mbggenerated Sun Apr 10 11:22:04 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.t_role.id
     *
     * @param id the value for public.t_role.id
     *
     * @mbggenerated Sun Apr 10 11:22:04 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.t_role.name
     *
     * @return the value of public.t_role.name
     *
     * @mbggenerated Sun Apr 10 11:22:04 CST 2016
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.t_role.name
     *
     * @param name the value for public.t_role.name
     *
     * @mbggenerated Sun Apr 10 11:22:04 CST 2016
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.t_role.description
     *
     * @return the value of public.t_role.description
     *
     * @mbggenerated Sun Apr 10 11:22:04 CST 2016
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.t_role.description
     *
     * @param description the value for public.t_role.description
     *
     * @mbggenerated Sun Apr 10 11:22:04 CST 2016
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.t_role.level
     *
     * @return the value of public.t_role.level
     *
     * @mbggenerated Sun Apr 10 11:22:04 CST 2016
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.t_role.level
     *
     * @param level the value for public.t_role.level
     *
     * @mbggenerated Sun Apr 10 11:22:04 CST 2016
     */
    public void setLevel(Integer level) {
        this.level = level;
    }
}