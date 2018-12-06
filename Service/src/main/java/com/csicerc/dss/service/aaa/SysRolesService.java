package com.csicerc.dss.service.aaa;

import java.util.List;

/**
 * 
 * @author Xudk
 */
public interface SysRolesService {

	/**
	 * 根据id查询角色
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Role getById(String id) throws AccountException;
	/**
	 * 新增角色
	 * @param role
	 * @return 返回用户id
	 */
	public void saveRole(Role role) throws AccountException;
	
	/**
	 * 删除角色
	 * @param roleId
	 */
	public void deleteRole(String roleId) throws AccountException;
	;
	
	/**
	 * 根据条件查询角色
	 * @param sqlWhere
	 * @return
	 */
	public List<Role> findAllRole(String sqlWhere)throws AccountException;
	
	/**
	 * 新增角色对应资源
	 * @param roleRes
	 * @return
	 */
	public void saveRoleResources(SysRolesResources roleRes) throws AccountException;
	
	/**
	 * 查询角色已选的资源
	 * @param roleCode
	 * @return
	 */
	public List<SysResource> findRoleRes(String roleCode) throws AccountException;
	
	
	/**
	 * 保存角色对应资源
	 * @param roleCode
	 * @param ids
	 */
	public void saveRoleRes(String roleCode, String ids, String createUser) throws AccountException;
	
	/**
	 * 保存用户角色对应关系
	 * @param roleCode
	 * @param ids
	 * @param createUser
	 * @throws Exception
	 */
	public void saveUsersRoles(String roleCode, String ids, String createUser) throws AccountException;
	
	/**
	 * 删除用户角色对应关系
	 * @param roleId
	 * @param ids
	 */
	public void delUserInRolesList(String roleId, String ids) throws AccountException;
	
	/**
	 * 通过角色寻找拥有该角色的用户
	 * @param roleCode
	 * @return
	 */
	public List<SysUsers> findUsersByRole(String roleCode) throws AccountException;
	
	/**
	 * 通过角色寻找没有该角色的用户
	 * @param roleCode
	 * @return
	 */
	public List<SysUsers> findWaitUsersByRole(String roleCode) throws AccountException;
	
	/**
	 * 通过用户编号寻找用户拥有的角色列表
	 * @param userCode
	 * @return
	 */
	public List<Role> findRoleByUser(String userCode) throws AccountException;
	
	/**
	 * 根据角色删除其拥有的资源模块
	 * @author chenshiyu
	 * @param roleCode
	 */
	public int deleteRoleRes(String roleCode);
}
