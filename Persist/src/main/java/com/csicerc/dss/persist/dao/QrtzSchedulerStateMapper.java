package com.csicerc.dss.persist.dao;

import com.csicerc.dss.domain.QrtzSchedulerState;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QrtzSchedulerStateMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_SCHEDULER_STATE
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int deleteByPrimaryKey(@Param("schedName") String schedName, @Param("instanceName") String instanceName);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_SCHEDULER_STATE
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int insert(QrtzSchedulerState record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_SCHEDULER_STATE
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	QrtzSchedulerState selectByPrimaryKey(@Param("schedName") String schedName,
			@Param("instanceName") String instanceName);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_SCHEDULER_STATE
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	List<QrtzSchedulerState> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_SCHEDULER_STATE
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int updateByPrimaryKey(QrtzSchedulerState record);
}