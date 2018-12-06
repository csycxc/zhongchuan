package com.csicerc.dss.persist.dao;

import com.csicerc.dss.domain.Article;
import com.csicerc.dss.domain.ArticleExample;
import java.util.List;


public interface ArticleMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int deleteByPrimaryKey(Integer articleId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int insert(Article record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	Article selectByPrimaryKey(Integer articleId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	List<Article> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int updateByPrimaryKey(Article record);
}