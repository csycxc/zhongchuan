package com.csicerc.dss.persist.dao;

import com.csicerc.dss.domain.CrslTableField;
import java.util.List;

public interface CrslTableFieldMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CRSL_TABLE_FIELD
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int deleteByPrimaryKey(Integer crslTableFieldId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CRSL_TABLE_FIELD
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int insert(CrslTableField record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CRSL_TABLE_FIELD
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	CrslTableField selectByPrimaryKey(Integer crslTableFieldId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CRSL_TABLE_FIELD
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	List<CrslTableField> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CRSL_TABLE_FIELD
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int updateByPrimaryKey(CrslTableField record);
}