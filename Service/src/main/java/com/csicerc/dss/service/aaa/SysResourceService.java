package com.csicerc.dss.service.aaa;


import java.util.List;

/**
 * 
 * @author Xudk
 */
public interface SysResourceService {

	/**
	 * 根据resourceCode获取资源
	 * @param resourceCode
	 * @return
	 */
	public SysResource getBySysResourceCode(String resourceCode)  throws AccountException;

	/**
	 * 新增资源
	 * @param resource
	 */
	public void saveSysResource(SysResource resource)  throws AccountException;
	
	/**
	 * 删除资源
	 * @param resourceId
	 */
	public void deleteSysResource(String resourceCode) throws AccountException;
	
	/**
	 * 查询资源菜单
	 * @param userCode
	 * @return
	 * @throws AccountException
	 */
	public List<SysResource> findSysResourceByUserCode(String userCode, String prCode, String menu) throws AccountException;
	
	/**
	 * 查询所有资源菜单
	 * @return
	 * @throws AccountException
	 */
	public List<SysResource> findAll() throws AccountException;
	
	/**
	 * 查询资源菜单
	 * @param roleCode
	 * @return
	 * @throws AccountException
	 */
	public List<SysResource> findSysResourceByRoleCode(String roleCode) throws AccountException;
}
