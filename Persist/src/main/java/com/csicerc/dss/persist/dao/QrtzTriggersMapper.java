package com.csicerc.dss.persist.dao;

import com.csicerc.dss.domain.QrtzTriggers;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QrtzTriggersMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_TRIGGERS
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int deleteByPrimaryKey(@Param("schedName") String schedName, @Param("triggerName") String triggerName,
			@Param("triggerGroup") String triggerGroup);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_TRIGGERS
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int insert(QrtzTriggers record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_TRIGGERS
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	QrtzTriggers selectByPrimaryKey(@Param("schedName") String schedName, @Param("triggerName") String triggerName,
			@Param("triggerGroup") String triggerGroup);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_TRIGGERS
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	List<QrtzTriggers> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_TRIGGERS
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int updateByPrimaryKey(QrtzTriggers record);
}