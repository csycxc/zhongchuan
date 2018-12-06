package com.csicerc.dss.persist.dao;

import com.csicerc.dss.domain.QrtzJobDetails;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QrtzJobDetailsMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_JOB_DETAILS
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int deleteByPrimaryKey(@Param("schedName") String schedName, @Param("jobName") String jobName,
			@Param("jobGroup") String jobGroup);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_JOB_DETAILS
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int insert(QrtzJobDetails record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_JOB_DETAILS
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	QrtzJobDetails selectByPrimaryKey(@Param("schedName") String schedName, @Param("jobName") String jobName,
			@Param("jobGroup") String jobGroup);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_JOB_DETAILS
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	List<QrtzJobDetails> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_JOB_DETAILS
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int updateByPrimaryKey(QrtzJobDetails record);
}