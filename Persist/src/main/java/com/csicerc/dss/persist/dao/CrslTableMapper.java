package com.csicerc.dss.persist.dao;

import com.csicerc.dss.domain.CrslTable;
import com.csicerc.dss.domain.CrslTableExample;
import java.util.List;

public interface CrslTableMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CRSL_TABLE
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int deleteByPrimaryKey(Integer crslTableId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CRSL_TABLE
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int insert(CrslTable record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CRSL_TABLE
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	CrslTable selectByPrimaryKey(Integer crslTableId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CRSL_TABLE
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	List<CrslTable> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CRSL_TABLE
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int updateByPrimaryKey(CrslTable record);
}