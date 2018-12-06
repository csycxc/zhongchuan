package com.csicerc.dss.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csicerc.dss.domain.Web;

/**
 * 关于实体类Web的接口
 * @author chenshiyu
 * @Date 2018年08月13日
 */
public interface WebService {

	/**
	 * 根据id查询web
	 * @param id
	 * @return
	 */
	Web findWebById(int id);
	/**
	 * 分页查询所有web实体。
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	List<HashMap> findAllWebWithPage(int pageNum, int pageSize);

	/**
	 * 根据关键字 分页 查询web实体。
	 * @param keyWord
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	List<HashMap> findWebByKeyWord(String keyWord,int pageNum,int pageSize);
	/**
	 * 根据id删除web实体。
	 * @param id
	 * @return
	 */
	int deleteWebById(int id);
	/**
	 * 根据多个id,删除多个web实体。
	 * @param ids
	 * @return
	 */
	int deleteWebByIds(String ids);
	/**
	 * 查询数量
	 * @param string
	 * @return
	 */
	long selectAllWebCount(String string);
	
	/**
	 * 根据分类查询该分类下的网站
	 * @param webCategoryId
	 * @return
	 */
	List<Integer> findWebByWebCategory(int webCategoryId);
	/**
	 * 保存分类对应的网站
	 * @return
	 */
	int saveWebCategoryWeb(int webCategoryId,ArrayList<Integer> list);
	/**
	 * 根据关键字查询网站 （不分页）
	 * @param word
	 * @return
	 */
	List<HashMap> findAllWebByKeyWord(String word);
	/**
	 * 根据关键字查询网站数量
	 * @param word
	 * @return
	 */
	long selectCount(String word);
	/**
	 * 根据分类id删除该分类下所有关联的网站（删除中间表信息）
	 * @param webCategoryId
	 */
	void deleteWebCategoryWebByWebCategoryId(int webCategoryId);
	

}
