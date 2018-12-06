package com.csicerc.dss.service.aaa;

import java.util.List;

/**
 * 
 * @author Xudk
 */
public interface SysUsersService {

	/**
	 * 
	 * @param code
	 * @return
	 * @throws AccountException
	 */
	public SysUsers getByCode(String code) throws AccountException;

	/**
	 * 新增用户
	 * @param user
	 * @return 返回用户id
	 */
	public void saveUser(SysUsers user) throws AccountException ;
	
	/**
	 * 删除用户
	 * @param code
	 */
	public void deleteUser(String code) throws AccountException;
	
	/**
	 * 根据条件查询用户
	 * @return
	 */
	public List<SysUsers> findAllUser() throws AccountException;
	
	/**
	 * 依据划分查询有此划分权限的人
	 * @author Xu Dingkui
	 * @date 2017年12月21日
	 * @param divSnCode
	 * @return
	 */
	public List<SysUsers> selectByDivSnCode(String divSnCode) throws AccountException;
	
	/**
	 * 判断用户是否有此叶子节点划分权限
	 * @author Xu Dingkui
	 * @date 2017年12月21日
	 * @param userCode
	 * @param divSnCode
	 * @return
	 */
	public String checkEngDivAuthority(String userCode, String divSnCode);
}
