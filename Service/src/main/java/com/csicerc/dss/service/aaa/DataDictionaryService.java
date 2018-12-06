package com.csicerc.dss.service.aaa;

import java.util.List;

/**
 * 数据字典Service
 * @author Xu Dingkui
 * @date 2017年8月13日
 */
public interface DataDictionaryService {

	/**
	 * 根据Key查找数据字典
	 * 
	 * @param dict
	 * @return
	 * @throws Exception
	 */
	public DataDictionary findDataDictionaryByPrimaryKey(DataDictionary dict) throws AccountException;
	
	/**
	 * 根据Key查找数据字典
	 * 
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public List<DataDictionary> findDataDictionaryByType(String type) throws AccountException;
	
	/**
	 * 查找数据字典
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<DataDictionary> findAllDataDictionary() throws AccountException;

	/**
	 * 保存数据字典
	 * 
	 * @param dict
	 * @return
	 * @throws AccountException
	 */
	public void saveDataDictionary(DataDictionary dict) throws AccountException;

	/**
	 * 根据指定key删除数据字典
	 * 
	 * @param key
	 * @return
	 * @throws AccountException
	 */
	public int deleteDataDictionary(DataDictionary key) throws AccountException;

}
