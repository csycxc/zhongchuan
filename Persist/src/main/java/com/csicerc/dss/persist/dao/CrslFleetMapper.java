package com.csicerc.dss.persist.dao;

import com.csicerc.dss.domain.CrslFleet;
import java.util.List;

public interface CrslFleetMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CRSL_FLEET
     *
     * @mbg.generated Tue Jul 31 17:28:09 CST 2018
     */
    int deleteByPrimaryKey(Long sourceitemid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CRSL_FLEET
     *
     * @mbg.generated Tue Jul 31 17:28:09 CST 2018
     */
    int insert(CrslFleet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CRSL_FLEET
     *
     * @mbg.generated Tue Jul 31 17:28:09 CST 2018
     */
    CrslFleet selectByPrimaryKey(Long sourceitemid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CRSL_FLEET
     *
     * @mbg.generated Tue Jul 31 17:28:09 CST 2018
     */
    List<CrslFleet> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CRSL_FLEET
     *
     * @mbg.generated Tue Jul 31 17:28:09 CST 2018
     */
    int updateByPrimaryKey(CrslFleet record);
}