package com.csicerc.dss.persist.dao;

import com.csicerc.dss.domain.ArticleKeyword;
import com.csicerc.dss.domain.ArticleKeywordExample;
import java.util.List;

public interface ArticleKeywordMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_keyword
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int deleteByPrimaryKey(Integer articleKeywordId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_keyword
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int insert(ArticleKeyword record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_keyword
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	ArticleKeyword selectByPrimaryKey(Integer articleKeywordId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_keyword
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	List<ArticleKeyword> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table article_keyword
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	int updateByPrimaryKey(ArticleKeyword record);
}