package com.csicerc.dss.service.aaa;


import java.util.List;

/**
 * 
 * @author Xudk
 */
public interface SysDeptsService {

	/**
	 * 根据id获取部门
	 * @param deptCode
	 * @return
	 */
	public SysDepts getByDeptCode(String deptCode)  throws AccountException;
	
	/**
	 * 新增部门
	 * @param dept
	 */
	public void saveDept(SysDepts dept)  throws AccountException;
	
	/**
	 * 删除部门
	 * @param deptCode
	 */
	public void deleteDept(String deptCode) throws AccountException;
	
	/**
	 * 根据条件查询部门
	 * @return
	 */
	public List findAllDept() throws AccountException;
	
}
