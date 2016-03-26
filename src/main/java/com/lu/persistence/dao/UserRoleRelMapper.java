package com.lu.persistence.dao;

import com.lu.model.UserRoleRelExample;
import com.lu.model.UserRoleRelKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleRelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.t_user_role_rel
     *
     * @mbggenerated Sat Mar 26 16:46:07 CST 2016
     */
    int countByExample(UserRoleRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.t_user_role_rel
     *
     * @mbggenerated Sat Mar 26 16:46:07 CST 2016
     */
    int deleteByExample(UserRoleRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.t_user_role_rel
     *
     * @mbggenerated Sat Mar 26 16:46:07 CST 2016
     */
    int deleteByPrimaryKey(UserRoleRelKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.t_user_role_rel
     *
     * @mbggenerated Sat Mar 26 16:46:07 CST 2016
     */
    int insert(UserRoleRelKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.t_user_role_rel
     *
     * @mbggenerated Sat Mar 26 16:46:07 CST 2016
     */
    int insertSelective(UserRoleRelKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.t_user_role_rel
     *
     * @mbggenerated Sat Mar 26 16:46:07 CST 2016
     */
    List<UserRoleRelKey> selectByExample(UserRoleRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.t_user_role_rel
     *
     * @mbggenerated Sat Mar 26 16:46:07 CST 2016
     */
    int updateByExampleSelective(@Param("record") UserRoleRelKey record, @Param("example") UserRoleRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.t_user_role_rel
     *
     * @mbggenerated Sat Mar 26 16:46:07 CST 2016
     */
    int updateByExample(@Param("record") UserRoleRelKey record, @Param("example") UserRoleRelExample example);
}