package com.csicerc.dss.service;

import java.util.HashMap;
import java.util.List;

import com.csicerc.dss.domain.WebCategory;

/**
 * 关于网站分类的接口
 * @author chenshiyu
 * @date 20180821
 *
 */
public interface WebCategoryService {

	/**
	 * 保存（包括插入和修改两种操作）
	 * @param webCategoryName
	 */
	int insertWebCategory(String webCategoryName);

	/**
	 * 删除网站分类，返回删除个数。
	 * @param id
	 * @return
	 */
	int deleteWebCategory(String webCategoryName);

	/**
	 * 查询所有网站分类
	 * @return
	 */
	List<HashMap> findAllWebCategory();

	/**
	 * 根据关键字查询   分类和web 分页
	 * @param word
	 * @param start
	 * @param length
	 * @return
	 */
	List<HashMap> findWebCategoryAndWebByKeyWord(String word, int start, int length);
	/**
	 * 根据关键字查询数量。
	 * @param word
	 * @return
	 */
	long selectCount(String word);

	/**
	 * 分页查询    所有分类和web
	 * @param start
	 * @param length
	 * @return
	 */
	List<HashMap> findAllWebCategoryAndWebWithPage(int start, int length);
	/**
	 * 根据web查询数量
	 * @param word
	 * @return
	 */
	long selectCountByWeb(String word);
	
	/**
	 * 根据关键字查询所有分类 分页
	 * @param word
	 * @param start
	 * @param length
	 * @return
	 */
	List<HashMap> findWebCategoryByKeyWord(String word, int start, int length);
	/**
	 * 查询所有分类 分页
	 * @param start
	 * @param length
	 * @return
	 */
	List<HashMap> findAllWebCategoryWithPage(int start, int length);

	/**
	 * 根据关键字查询所有分类 （不分页）
	 * @param word
	 * @return
	 */
	List<HashMap> findAllWebCategoryByKeyWord(String word);
	
	
	
	
	
	
}
