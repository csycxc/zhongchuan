package com.csicerc.dss.domain;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table QRTZ_CRON_TRIGGERS
 */
public class QrtzCronTriggers {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_CRON_TRIGGERS.SCHED_NAME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String schedName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_CRON_TRIGGERS.TRIGGER_NAME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String triggerName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_CRON_TRIGGERS.TRIGGER_GROUP
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String triggerGroup;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_CRON_TRIGGERS.CRON_EXPRESSION
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String cronExpression;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_CRON_TRIGGERS.TIME_ZONE_ID
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String timeZoneId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_CRON_TRIGGERS.SCHED_NAME
	 * @return  the value of QRTZ_CRON_TRIGGERS.SCHED_NAME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getSchedName() {
		return schedName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_CRON_TRIGGERS.SCHED_NAME
	 * @param schedName  the value for QRTZ_CRON_TRIGGERS.SCHED_NAME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setSchedName(String schedName) {
		this.schedName = schedName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_CRON_TRIGGERS.TRIGGER_NAME
	 * @return  the value of QRTZ_CRON_TRIGGERS.TRIGGER_NAME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getTriggerName() {
		return triggerName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_CRON_TRIGGERS.TRIGGER_NAME
	 * @param triggerName  the value for QRTZ_CRON_TRIGGERS.TRIGGER_NAME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_CRON_TRIGGERS.TRIGGER_GROUP
	 * @return  the value of QRTZ_CRON_TRIGGERS.TRIGGER_GROUP
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getTriggerGroup() {
		return triggerGroup;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_CRON_TRIGGERS.TRIGGER_GROUP
	 * @param triggerGroup  the value for QRTZ_CRON_TRIGGERS.TRIGGER_GROUP
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_CRON_TRIGGERS.CRON_EXPRESSION
	 * @return  the value of QRTZ_CRON_TRIGGERS.CRON_EXPRESSION
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getCronExpression() {
		return cronExpression;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_CRON_TRIGGERS.CRON_EXPRESSION
	 * @param cronExpression  the value for QRTZ_CRON_TRIGGERS.CRON_EXPRESSION
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_CRON_TRIGGERS.TIME_ZONE_ID
	 * @return  the value of QRTZ_CRON_TRIGGERS.TIME_ZONE_ID
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getTimeZoneId() {
		return timeZoneId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_CRON_TRIGGERS.TIME_ZONE_ID
	 * @param timeZoneId  the value for QRTZ_CRON_TRIGGERS.TIME_ZONE_ID
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId;
	}
}