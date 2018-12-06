package com.csicerc.dss.persist.dao;

import com.csicerc.dss.domain.CrslSession;
import com.csicerc.dss.domain.CrslSessionExample;
import com.csicerc.dss.domain.CrslSessionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrslSessionMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table crsl_session
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int deleteByPrimaryKey(@Param("crslSessionId") Integer crslSessionId,
			@Param("crslSessionLoginName") String crslSessionLoginName);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table crsl_session
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int insert(CrslSession record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table crsl_session
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	CrslSession selectByPrimaryKey(@Param("crslSessionId") Integer crslSessionId,
			@Param("crslSessionLoginName") String crslSessionLoginName);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table crsl_session
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	List<CrslSession> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table crsl_session
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int updateByPrimaryKey(CrslSession record);
}