package com.csicerc.dss.persist.dao;

import com.csicerc.dss.domain.Web;
import com.csicerc.dss.domain.WebExample;
import java.util.List;

public interface WebMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table web
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int deleteByPrimaryKey(Integer webId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table web
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int insert(Web record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table web
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	Web selectByPrimaryKey(Integer webId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table web
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	List<Web> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table web
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int updateByPrimaryKey(Web record);
}