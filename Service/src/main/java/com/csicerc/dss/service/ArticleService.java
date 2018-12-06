package com.csicerc.dss.service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.csicerc.dss.domain.Article;
/**
 * 关于文章实体类article的接口
 * @author chenshiyu
 * @date 2018年08月10日
 */
public interface ArticleService {
	
	/**
	 * 根据id查询文章实体类article
	 * @param id
	 * @return
	 */
	Article findArticleById(int id);
	/**
	 * 分页查询所有article
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	List<HashMap> findAllArticleWithPage(int pageNum, int pageSize);
	/**
	 * 不分页 查询所有article
	 * @return
	 */
	List<Article> findAllArticle();
	/**
	 * 根据关键字 分页查询 所有article
	 * @param word
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	List<HashMap> findArticleByKeyWord(String word,int pageNum,int pageSize);
	/**
	 * 根据id删除article
	 * @param id
	 * @return
	 */
	int deleteArticleById(int id);
	/**
	 * 根据多个id 删除多个article
	 * @param ids
	 * @return
	 */
	int deleteArticleByIds(String ids);
	/**
	 * 查询数量
	 * @return
	 */
	long selectCount(String string);
	
}
