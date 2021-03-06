package com.csicerc.dss.domain;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table QRTZ_TRIGGERS
 */
public class QrtzTriggers {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_TRIGGERS.SCHED_NAME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String schedName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_TRIGGERS.TRIGGER_NAME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String triggerName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_TRIGGERS.TRIGGER_GROUP
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String triggerGroup;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_TRIGGERS.JOB_NAME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String jobName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_TRIGGERS.JOB_GROUP
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String jobGroup;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_TRIGGERS.DESCRIPTION
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String description;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_TRIGGERS.NEXT_FIRE_TIME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private Long nextFireTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_TRIGGERS.PREV_FIRE_TIME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private Long prevFireTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_TRIGGERS.PRIORITY
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private Integer priority;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_TRIGGERS.TRIGGER_STATE
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String triggerState;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_TRIGGERS.TRIGGER_TYPE
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String triggerType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_TRIGGERS.START_TIME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private Long startTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_TRIGGERS.END_TIME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private Long endTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_TRIGGERS.CALENDAR_NAME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String calendarName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_TRIGGERS.MISFIRE_INSTR
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private Short misfireInstr;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column QRTZ_TRIGGERS.JOB_DATA
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private byte[] jobData;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_TRIGGERS.SCHED_NAME
	 * @return  the value of QRTZ_TRIGGERS.SCHED_NAME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getSchedName() {
		return schedName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_TRIGGERS.SCHED_NAME
	 * @param schedName  the value for QRTZ_TRIGGERS.SCHED_NAME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setSchedName(String schedName) {
		this.schedName = schedName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_TRIGGERS.TRIGGER_NAME
	 * @return  the value of QRTZ_TRIGGERS.TRIGGER_NAME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getTriggerName() {
		return triggerName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_TRIGGERS.TRIGGER_NAME
	 * @param triggerName  the value for QRTZ_TRIGGERS.TRIGGER_NAME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_TRIGGERS.TRIGGER_GROUP
	 * @return  the value of QRTZ_TRIGGERS.TRIGGER_GROUP
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getTriggerGroup() {
		return triggerGroup;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_TRIGGERS.TRIGGER_GROUP
	 * @param triggerGroup  the value for QRTZ_TRIGGERS.TRIGGER_GROUP
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_TRIGGERS.JOB_NAME
	 * @return  the value of QRTZ_TRIGGERS.JOB_NAME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_TRIGGERS.JOB_NAME
	 * @param jobName  the value for QRTZ_TRIGGERS.JOB_NAME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_TRIGGERS.JOB_GROUP
	 * @return  the value of QRTZ_TRIGGERS.JOB_GROUP
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getJobGroup() {
		return jobGroup;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_TRIGGERS.JOB_GROUP
	 * @param jobGroup  the value for QRTZ_TRIGGERS.JOB_GROUP
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_TRIGGERS.DESCRIPTION
	 * @return  the value of QRTZ_TRIGGERS.DESCRIPTION
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_TRIGGERS.DESCRIPTION
	 * @param description  the value for QRTZ_TRIGGERS.DESCRIPTION
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_TRIGGERS.NEXT_FIRE_TIME
	 * @return  the value of QRTZ_TRIGGERS.NEXT_FIRE_TIME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public Long getNextFireTime() {
		return nextFireTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_TRIGGERS.NEXT_FIRE_TIME
	 * @param nextFireTime  the value for QRTZ_TRIGGERS.NEXT_FIRE_TIME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setNextFireTime(Long nextFireTime) {
		this.nextFireTime = nextFireTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_TRIGGERS.PREV_FIRE_TIME
	 * @return  the value of QRTZ_TRIGGERS.PREV_FIRE_TIME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public Long getPrevFireTime() {
		return prevFireTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_TRIGGERS.PREV_FIRE_TIME
	 * @param prevFireTime  the value for QRTZ_TRIGGERS.PREV_FIRE_TIME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setPrevFireTime(Long prevFireTime) {
		this.prevFireTime = prevFireTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_TRIGGERS.PRIORITY
	 * @return  the value of QRTZ_TRIGGERS.PRIORITY
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_TRIGGERS.PRIORITY
	 * @param priority  the value for QRTZ_TRIGGERS.PRIORITY
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_TRIGGERS.TRIGGER_STATE
	 * @return  the value of QRTZ_TRIGGERS.TRIGGER_STATE
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getTriggerState() {
		return triggerState;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_TRIGGERS.TRIGGER_STATE
	 * @param triggerState  the value for QRTZ_TRIGGERS.TRIGGER_STATE
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setTriggerState(String triggerState) {
		this.triggerState = triggerState;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_TRIGGERS.TRIGGER_TYPE
	 * @return  the value of QRTZ_TRIGGERS.TRIGGER_TYPE
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getTriggerType() {
		return triggerType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_TRIGGERS.TRIGGER_TYPE
	 * @param triggerType  the value for QRTZ_TRIGGERS.TRIGGER_TYPE
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_TRIGGERS.START_TIME
	 * @return  the value of QRTZ_TRIGGERS.START_TIME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public Long getStartTime() {
		return startTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_TRIGGERS.START_TIME
	 * @param startTime  the value for QRTZ_TRIGGERS.START_TIME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_TRIGGERS.END_TIME
	 * @return  the value of QRTZ_TRIGGERS.END_TIME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public Long getEndTime() {
		return endTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_TRIGGERS.END_TIME
	 * @param endTime  the value for QRTZ_TRIGGERS.END_TIME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_TRIGGERS.CALENDAR_NAME
	 * @return  the value of QRTZ_TRIGGERS.CALENDAR_NAME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getCalendarName() {
		return calendarName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_TRIGGERS.CALENDAR_NAME
	 * @param calendarName  the value for QRTZ_TRIGGERS.CALENDAR_NAME
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_TRIGGERS.MISFIRE_INSTR
	 * @return  the value of QRTZ_TRIGGERS.MISFIRE_INSTR
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public Short getMisfireInstr() {
		return misfireInstr;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_TRIGGERS.MISFIRE_INSTR
	 * @param misfireInstr  the value for QRTZ_TRIGGERS.MISFIRE_INSTR
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setMisfireInstr(Short misfireInstr) {
		this.misfireInstr = misfireInstr;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column QRTZ_TRIGGERS.JOB_DATA
	 * @return  the value of QRTZ_TRIGGERS.JOB_DATA
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public byte[] getJobData() {
		return jobData;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column QRTZ_TRIGGERS.JOB_DATA
	 * @param jobData  the value for QRTZ_TRIGGERS.JOB_DATA
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setJobData(byte[] jobData) {
		this.jobData = jobData;
	}
}