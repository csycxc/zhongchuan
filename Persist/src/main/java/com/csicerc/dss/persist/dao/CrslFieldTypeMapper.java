package com.csicerc.dss.persist.dao;

import com.csicerc.dss.domain.CrslFieldType;
import java.util.List;

public interface CrslFieldTypeMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CRSL_FIELD_TYPE
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int insert(CrslFieldType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table CRSL_FIELD_TYPE
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	List<CrslFieldType> selectAll();
}