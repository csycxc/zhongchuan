package com.csicerc.dss.persist.dao;

import com.csicerc.dss.domain.WebUrl;
import com.csicerc.dss.domain.WebUrlExample;
import java.util.List;

public interface WebUrlMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table web_url
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int deleteByPrimaryKey(Integer webUrlId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table web_url
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int insert(WebUrl record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table web_url
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	WebUrl selectByPrimaryKey(Integer webUrlId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table web_url
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	List<WebUrl> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table web_url
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int updateByPrimaryKey(WebUrl record);
}