package com.csicerc.dss.domain;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table article_keyword
 *
 * @mbg.generated do_not_delete_during_merge Thu Jul 12 17:09:12 CST 2018
 */
public class ArticleKeyword {

	/**
	 * Database Column Remarks: �ؼ���ID This field was generated by MyBatis Generator. This field corresponds to the database column article_keyword.article_keyword_id
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private Integer articleKeywordId;
	/**
	 * Database Column Remarks: �ؼ��� This field was generated by MyBatis Generator. This field corresponds to the database column article_keyword.article_keyword_name
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String articleKeywordName;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column article_keyword.article_keyword_id
	 * @return  the value of article_keyword.article_keyword_id
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public Integer getArticleKeywordId() {
		return articleKeywordId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column article_keyword.article_keyword_id
	 * @param articleKeywordId  the value for article_keyword.article_keyword_id
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setArticleKeywordId(Integer articleKeywordId) {
		this.articleKeywordId = articleKeywordId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column article_keyword.article_keyword_name
	 * @return  the value of article_keyword.article_keyword_name
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getArticleKeywordName() {
		return articleKeywordName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column article_keyword.article_keyword_name
	 * @param articleKeywordName  the value for article_keyword.article_keyword_name
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setArticleKeywordName(String articleKeywordName) {
		this.articleKeywordName = articleKeywordName;
	}
}