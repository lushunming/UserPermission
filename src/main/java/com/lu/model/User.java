package com.lu.model;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.t_user.id
     *
     * @mbggenerated Sat Mar 26 16:46:06 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.t_user.loginname
     *
     * @mbggenerated Sat Mar 26 16:46:06 CST 2016
     */
    private String loginname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.t_user.password
     *
     * @mbggenerated Sat Mar 26 16:46:06 CST 2016
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.t_user.status
     *
     * @mbggenerated Sat Mar 26 16:46:06 CST 2016
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.t_user.id
     *
     * @return the value of public.t_user.id
     *
     * @mbggenerated Sat Mar 26 16:46:06 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.t_user.id
     *
     * @param id the value for public.t_user.id
     *
     * @mbggenerated Sat Mar 26 16:46:06 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.t_user.loginname
     *
     * @return the value of public.t_user.loginname
     *
     * @mbggenerated Sat Mar 26 16:46:06 CST 2016
     */
    public String getLoginname() {
        return loginname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.t_user.loginname
     *
     * @param loginname the value for public.t_user.loginname
     *
     * @mbggenerated Sat Mar 26 16:46:06 CST 2016
     */
    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.t_user.password
     *
     * @return the value of public.t_user.password
     *
     * @mbggenerated Sat Mar 26 16:46:06 CST 2016
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.t_user.password
     *
     * @param password the value for public.t_user.password
     *
     * @mbggenerated Sat Mar 26 16:46:06 CST 2016
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.t_user.status
     *
     * @return the value of public.t_user.status
     *
     * @mbggenerated Sat Mar 26 16:46:06 CST 2016
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.t_user.status
     *
     * @param status the value for public.t_user.status
     *
     * @mbggenerated Sat Mar 26 16:46:06 CST 2016
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}