package com.csicerc.dss.persist.dao;

import com.csicerc.dss.domain.QrtzBlobTriggers;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QrtzBlobTriggersMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_BLOB_TRIGGERS
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int deleteByPrimaryKey(@Param("schedName") String schedName, @Param("triggerName") String triggerName,
			@Param("triggerGroup") String triggerGroup);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_BLOB_TRIGGERS
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int insert(QrtzBlobTriggers record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_BLOB_TRIGGERS
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	QrtzBlobTriggers selectByPrimaryKey(@Param("schedName") String schedName, @Param("triggerName") String triggerName,
			@Param("triggerGroup") String triggerGroup);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_BLOB_TRIGGERS
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	List<QrtzBlobTriggers> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_BLOB_TRIGGERS
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int updateByPrimaryKey(QrtzBlobTriggers record);
}