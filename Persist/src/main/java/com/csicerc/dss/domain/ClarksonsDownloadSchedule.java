package com.csicerc.dss.domain;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table clarksons_download_schedule
 */
public class ClarksonsDownloadSchedule {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column clarksons_download_schedule.clarksons_download_schedule_id
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private Integer clarksonsDownloadScheduleId;
	/**
	 * Database Column Remarks: 下载的数据库名称 This field was generated by MyBatis Generator. This field corresponds to the database column clarksons_download_schedule.clarksons_download_database
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String clarksonsDownloadDatabase;
	/**
	 * Database Column Remarks: 下载的表名 This field was generated by MyBatis Generator. This field corresponds to the database column clarksons_download_schedule.clarksons_download_table
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String clarksonsDownloadTable;
	/**
	 * Database Column Remarks: 要下载的字段ID，逗号分隔 This field was generated by MyBatis Generator. This field corresponds to the database column clarksons_download_schedule.clarksons_download_fields
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String clarksonsDownloadFields;
	/**
	 * Database Column Remarks: 下载开始时间 This field was generated by MyBatis Generator. This field corresponds to the database column clarksons_download_schedule.clarksons_download_start_time
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private Date clarksonsDownloadStartTime;
	/**
	 * Database Column Remarks: 下载结束时间 This field was generated by MyBatis Generator. This field corresponds to the database column clarksons_download_schedule.clarksons_download_end_time
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private Date clarksonsDownloadEndTime;
	/**
	 * Database Column Remarks: 成功保存记录页数 This field was generated by MyBatis Generator. This field corresponds to the database column clarksons_download_schedule.clarksons_download_saved_page_count
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private Integer clarksonsDownloadSavedPageCount;
	/**
	 * Database Column Remarks: 失败页数 This field was generated by MyBatis Generator. This field corresponds to the database column clarksons_download_schedule.clarksons_download_error_page_count
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private Integer clarksonsDownloadErrorPageCount;
	/**
	 * Database Column Remarks: 下载每页大小，默认每页25个记录 This field was generated by MyBatis Generator. This field corresponds to the database column clarksons_download_schedule.clarksons_download_error_page_size
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private Integer clarksonsDownloadErrorPageSize;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column clarksons_download_schedule.clarksons_download_schedule_id
	 * @return  the value of clarksons_download_schedule.clarksons_download_schedule_id
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public Integer getClarksonsDownloadScheduleId() {
		return clarksonsDownloadScheduleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column clarksons_download_schedule.clarksons_download_schedule_id
	 * @param clarksonsDownloadScheduleId  the value for clarksons_download_schedule.clarksons_download_schedule_id
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setClarksonsDownloadScheduleId(Integer clarksonsDownloadScheduleId) {
		this.clarksonsDownloadScheduleId = clarksonsDownloadScheduleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column clarksons_download_schedule.clarksons_download_database
	 * @return  the value of clarksons_download_schedule.clarksons_download_database
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getClarksonsDownloadDatabase() {
		return clarksonsDownloadDatabase;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column clarksons_download_schedule.clarksons_download_database
	 * @param clarksonsDownloadDatabase  the value for clarksons_download_schedule.clarksons_download_database
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setClarksonsDownloadDatabase(String clarksonsDownloadDatabase) {
		this.clarksonsDownloadDatabase = clarksonsDownloadDatabase;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column clarksons_download_schedule.clarksons_download_table
	 * @return  the value of clarksons_download_schedule.clarksons_download_table
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getClarksonsDownloadTable() {
		return clarksonsDownloadTable;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column clarksons_download_schedule.clarksons_download_table
	 * @param clarksonsDownloadTable  the value for clarksons_download_schedule.clarksons_download_table
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setClarksonsDownloadTable(String clarksonsDownloadTable) {
		this.clarksonsDownloadTable = clarksonsDownloadTable;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column clarksons_download_schedule.clarksons_download_fields
	 * @return  the value of clarksons_download_schedule.clarksons_download_fields
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getClarksonsDownloadFields() {
		return clarksonsDownloadFields;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column clarksons_download_schedule.clarksons_download_fields
	 * @param clarksonsDownloadFields  the value for clarksons_download_schedule.clarksons_download_fields
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setClarksonsDownloadFields(String clarksonsDownloadFields) {
		this.clarksonsDownloadFields = clarksonsDownloadFields;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column clarksons_download_schedule.clarksons_download_start_time
	 * @return  the value of clarksons_download_schedule.clarksons_download_start_time
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public Date getClarksonsDownloadStartTime() {
		return clarksonsDownloadStartTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column clarksons_download_schedule.clarksons_download_start_time
	 * @param clarksonsDownloadStartTime  the value for clarksons_download_schedule.clarksons_download_start_time
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setClarksonsDownloadStartTime(Date clarksonsDownloadStartTime) {
		this.clarksonsDownloadStartTime = clarksonsDownloadStartTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column clarksons_download_schedule.clarksons_download_end_time
	 * @return  the value of clarksons_download_schedule.clarksons_download_end_time
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public Date getClarksonsDownloadEndTime() {
		return clarksonsDownloadEndTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column clarksons_download_schedule.clarksons_download_end_time
	 * @param clarksonsDownloadEndTime  the value for clarksons_download_schedule.clarksons_download_end_time
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setClarksonsDownloadEndTime(Date clarksonsDownloadEndTime) {
		this.clarksonsDownloadEndTime = clarksonsDownloadEndTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column clarksons_download_schedule.clarksons_download_saved_page_count
	 * @return  the value of clarksons_download_schedule.clarksons_download_saved_page_count
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public Integer getClarksonsDownloadSavedPageCount() {
		return clarksonsDownloadSavedPageCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column clarksons_download_schedule.clarksons_download_saved_page_count
	 * @param clarksonsDownloadSavedPageCount  the value for clarksons_download_schedule.clarksons_download_saved_page_count
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setClarksonsDownloadSavedPageCount(Integer clarksonsDownloadSavedPageCount) {
		this.clarksonsDownloadSavedPageCount = clarksonsDownloadSavedPageCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column clarksons_download_schedule.clarksons_download_error_page_count
	 * @return  the value of clarksons_download_schedule.clarksons_download_error_page_count
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public Integer getClarksonsDownloadErrorPageCount() {
		return clarksonsDownloadErrorPageCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column clarksons_download_schedule.clarksons_download_error_page_count
	 * @param clarksonsDownloadErrorPageCount  the value for clarksons_download_schedule.clarksons_download_error_page_count
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setClarksonsDownloadErrorPageCount(Integer clarksonsDownloadErrorPageCount) {
		this.clarksonsDownloadErrorPageCount = clarksonsDownloadErrorPageCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column clarksons_download_schedule.clarksons_download_error_page_size
	 * @return  the value of clarksons_download_schedule.clarksons_download_error_page_size
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public Integer getClarksonsDownloadErrorPageSize() {
		return clarksonsDownloadErrorPageSize;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column clarksons_download_schedule.clarksons_download_error_page_size
	 * @param clarksonsDownloadErrorPageSize  the value for clarksons_download_schedule.clarksons_download_error_page_size
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setClarksonsDownloadErrorPageSize(Integer clarksonsDownloadErrorPageSize) {
		this.clarksonsDownloadErrorPageSize = clarksonsDownloadErrorPageSize;
	}
}