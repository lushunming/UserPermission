package com.lu.model;

import java.io.Serializable;

public class UserRoleRelKey  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7045006196791114433L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.t_user_role_rel.user_id
     *
     * @mbggenerated Sun Mar 27 14:15:44 CST 2016
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.t_user_role_rel.role_id
     *
     * @mbggenerated Sun Mar 27 14:15:44 CST 2016
     */
    private Integer roleId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.t_user_role_rel.user_id
     *
     * @return the value of public.t_user_role_rel.user_id
     *
     * @mbggenerated Sun Mar 27 14:15:44 CST 2016
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.t_user_role_rel.user_id
     *
     * @param userId the value for public.t_user_role_rel.user_id
     *
     * @mbggenerated Sun Mar 27 14:15:44 CST 2016
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.t_user_role_rel.role_id
     *
     * @return the value of public.t_user_role_rel.role_id
     *
     * @mbggenerated Sun Mar 27 14:15:44 CST 2016
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.t_user_role_rel.role_id
     *
     * @param roleId the value for public.t_user_role_rel.role_id
     *
     * @mbggenerated Sun Mar 27 14:15:44 CST 2016
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}