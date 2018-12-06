package com.csicerc.dss.domain;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table article
 *
 * @mbg.generated do_not_delete_during_merge Thu Jul 12 17:09:12 CST 2018
 */
public class Article {

	/**
	 * Database Column Remarks: ������������ID This field was generated by MyBatis Generator. This field corresponds to the database column article.article_id
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private Integer articleId;
	/**
	 * Database Column Remarks: ������Դ This field was generated by MyBatis Generator. This field corresponds to the database column article.article_source
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String articleSource;
	/**
	 * Database Column Remarks: ����ԭʼ���� This field was generated by MyBatis Generator. This field corresponds to the database column article.article_link
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String articleLink;
	/**
	 * Database Column Remarks: �������� This field was generated by MyBatis Generator. This field corresponds to the database column article.article_author
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String articleAuthor;
	/**
	 * Database Column Remarks: ���±��� This field was generated by MyBatis Generator. This field corresponds to the database column article.article_title
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String articleTitle;
	/**
	 * Database Column Remarks: ����ժҪ This field was generated by MyBatis Generator. This field corresponds to the database column article.article_abstract
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String articleAbstract;
	/**
	 * Database Column Remarks: ���·������� This field was generated by MyBatis Generator. This field corresponds to the database column article.article_date
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private Date articleDate;
	/**
	 * Database Column Remarks: ����״̬ This field was generated by MyBatis Generator. This field corresponds to the database column article.article_status
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String articleStatus;
	/**
	 * Database Column Remarks: web��վID This field was generated by MyBatis Generator. This field corresponds to the database column article.web_url_id
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private Integer webUrlId;
	/**
	 * Database Column Remarks: ��ʲô�ؼ��ֲ鵽�ĸ����� This field was generated by MyBatis Generator. This field corresponds to the database column article.article_search_by_keyword
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String articleSearchByKeyword;
	/**
	 * Database Column Remarks: �������� This field was generated by MyBatis Generator. This field corresponds to the database column article.article_reference_url
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String articleReferenceUrl;
	/**
	 * Database Column Remarks: �������� This field was generated by MyBatis Generator. This field corresponds to the database column article.article_size
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private Integer articleSize;
	/**
	 * Database Column Remarks: ����ץȡʱ�� This field was generated by MyBatis Generator. This field corresponds to the database column article.article_crawled_date
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private Date articleCrawledDate;
	/**
	 * Database Column Remarks: �������� This field was generated by MyBatis Generator. This field corresponds to the database column article.article_content
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	private String articleContent;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column article.article_id
	 * @return  the value of article.article_id
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public Integer getArticleId() {
		return articleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column article.article_id
	 * @param articleId  the value for article.article_id
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column article.article_source
	 * @return  the value of article.article_source
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getArticleSource() {
		return articleSource;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column article.article_source
	 * @param articleSource  the value for article.article_source
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setArticleSource(String articleSource) {
		this.articleSource = articleSource;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column article.article_link
	 * @return  the value of article.article_link
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getArticleLink() {
		return articleLink;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column article.article_link
	 * @param articleLink  the value for article.article_link
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setArticleLink(String articleLink) {
		this.articleLink = articleLink;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column article.article_author
	 * @return  the value of article.article_author
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getArticleAuthor() {
		return articleAuthor;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column article.article_author
	 * @param articleAuthor  the value for article.article_author
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setArticleAuthor(String articleAuthor) {
		this.articleAuthor = articleAuthor;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column article.article_title
	 * @return  the value of article.article_title
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getArticleTitle() {
		return articleTitle;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column article.article_title
	 * @param articleTitle  the value for article.article_title
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column article.article_abstract
	 * @return  the value of article.article_abstract
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getArticleAbstract() {
		return articleAbstract;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column article.article_abstract
	 * @param articleAbstract  the value for article.article_abstract
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setArticleAbstract(String articleAbstract) {
		this.articleAbstract = articleAbstract;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column article.article_date
	 * @return  the value of article.article_date
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public Date getArticleDate() {
		return articleDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column article.article_date
	 * @param articleDate  the value for article.article_date
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setArticleDate(Date articleDate) {
		this.articleDate = articleDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column article.article_status
	 * @return  the value of article.article_status
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getArticleStatus() {
		return articleStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column article.article_status
	 * @param articleStatus  the value for article.article_status
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setArticleStatus(String articleStatus) {
		this.articleStatus = articleStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column article.web_url_id
	 * @return  the value of article.web_url_id
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public Integer getWebUrlId() {
		return webUrlId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column article.web_url_id
	 * @param webUrlId  the value for article.web_url_id
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setWebUrlId(Integer webUrlId) {
		this.webUrlId = webUrlId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column article.article_search_by_keyword
	 * @return  the value of article.article_search_by_keyword
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getArticleSearchByKeyword() {
		return articleSearchByKeyword;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column article.article_search_by_keyword
	 * @param articleSearchByKeyword  the value for article.article_search_by_keyword
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setArticleSearchByKeyword(String articleSearchByKeyword) {
		this.articleSearchByKeyword = articleSearchByKeyword;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column article.article_reference_url
	 * @return  the value of article.article_reference_url
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getArticleReferenceUrl() {
		return articleReferenceUrl;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column article.article_reference_url
	 * @param articleReferenceUrl  the value for article.article_reference_url
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setArticleReferenceUrl(String articleReferenceUrl) {
		this.articleReferenceUrl = articleReferenceUrl;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column article.article_size
	 * @return  the value of article.article_size
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public Integer getArticleSize() {
		return articleSize;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column article.article_size
	 * @param articleSize  the value for article.article_size
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setArticleSize(Integer articleSize) {
		this.articleSize = articleSize;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column article.article_crawled_date
	 * @return  the value of article.article_crawled_date
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public Date getArticleCrawledDate() {
		return articleCrawledDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column article.article_crawled_date
	 * @param articleCrawledDate  the value for article.article_crawled_date
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setArticleCrawledDate(Date articleCrawledDate) {
		this.articleCrawledDate = articleCrawledDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column article.article_content
	 * @return  the value of article.article_content
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public String getArticleContent() {
		return articleContent;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column article.article_content
	 * @param articleContent  the value for article.article_content
	 * @mbg.generated  Tue Jul 31 17:28:09 CST 2018
	 */
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	
	
	
}