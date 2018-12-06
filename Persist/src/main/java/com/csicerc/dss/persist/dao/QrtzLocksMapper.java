package com.csicerc.dss.persist.dao;

import com.csicerc.dss.domain.QrtzLocks;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QrtzLocksMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_LOCKS
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int deleteByPrimaryKey(@Param("schedName") String schedName, @Param("lockName") String lockName);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_LOCKS
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int insert(QrtzLocks record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table QRTZ_LOCKS
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	List<QrtzLocks> selectAll();
}