package com.csicerc.dss.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import com.csicerc.dss.domain.Article;
import com.csicerc.dss.domain.ArticleCategory;
import com.csicerc.dss.domain.ArticleCategoryKeyword;
import com.csicerc.dss.domain.ArticleKeyword;
import com.csicerc.dss.domain.Web;
import com.csicerc.dss.domain.WebCrawlerSchedule;
import com.csicerc.dss.domain.WebUrl;

public interface WebCrawlerService {

	/**
	 * 根据主键查询Web网页实体类
	 * 
	 * @param i
	 * @return
	 */
	Web selectWebByPrimaryKey(int i);

	List<Web> selectAllWeb();

	List<WebUrl> selectAllWebUrl();
	
	
	WebUrl selectWebUrlByPrimaryKey(int key);
	
	WebCrawlerSchedule selectWebCrawlerScheduleByPrimaryKey(int i);

	/**
	 * 根据主键插入WebCrawlerSchedule实体类
	 */
	int insertWebCrawlerSchedule(WebCrawlerSchedule webCrawlerSchedule);


	/**
	 * 删除WebCrawlerSchedule
	 */
	int deleteWebCrawlerSchedule(int webCrawlerScheduleId);

	/**
	 * 更新WebCrawlerSchedule
	 */
	int updateWebCrawlerSchedule(WebCrawlerSchedule webCrawlerSchedule);



//	private ArticleMapper articleMapper;
	/**
	 * 根据主键查询Article文章
	 */
	Article selectArticleByPrimaryKey(int articleId);

	/**
	 * 插入Article
	 */
	int insertArticle(Article article);

	
	/**
	 * 删除Article
	 */
	int deleteArticle(int articleId);

	/**
	 * 更新Article
	 */
	int updateArticle(Article article);


//	private ArticleKeywordMapper articleKeywordMapper;
	/**
	 * 根据主键查询ArticleKeyword
	 */
	ArticleKeyword selectArticleKeywordByPrimaryKey(int articleKeywordId);

	/**
	 * 插入ArticleKeyword
	 */
	int insertArticleKeyword(ArticleKeyword articleKeyword);


	/**
	 * 删除ArticleKeyword
	 */
	int deleteArticleKeyword(int articleKeywordId);

	/**
	 * 更新ArticleKeyword
	 */
	int updateArticleKeyword(ArticleKeyword articleKeyword);

	

//	private ArticleCategoryMapper articleCategoryMapper;
	/**
	 * 根据主键查询ArticleCategory
	 * 
	 * @param articleCategoryId
	 * @return
	 */
	ArticleCategory selectArticleCategoryByPrimaryKey(int articleCategoryId);

	/**
	 * 插入ArticleCategory
	 */
	int insertArticleCategory(ArticleCategory articleCategory);


	/**
	 * 删除ArticleCategory
	 */
	int deleteArticleCategory(int articleCategoryId);

	/**
	 * 更新ArticleCategory
	 */
	int updateArticleCategory(ArticleCategory articleCategory);


//	private ArticleCategoryKeywordMapper articleCategoryKeywordMapper;	
	/**
	 * 根据主键查询ArticleCategoryKeyword
	 */
	ArticleCategoryKeyword selectArticleCategoryKeywordByPrimaryKey(int articleCategoryKeywordId);

	/**
	 * 插入ArticleCategoryKeyword
	 */
	int insertArticleCategoryKeyword(ArticleCategoryKeyword articleCategoryKeyword);


	/**
	 * 删除ArticleCategoryKeyword
	 */
	int deleteArticleCategoryKeyword(int articleCategoryKeywordId);

	/**
	 * 更新ArticleCategoryKeyword
	 */
	int updateArticleCategoryKeyword(ArticleCategoryKeyword articleCategoryKeyword);


	int insertWeb(Web web);

	int updateWebByPrimaryKey(Web web);
	
	
	
	List<HashMap> selectArticles();
	
	List<HashMap> selectArticlesByWebID(int web_id);
	
	List<HashMap> selectArticlesByWebIDandDate(int web_id, Date publish_date);
	
	List<HashMap> selectArticlesByWebIDRange(int min_web_id, int max_web_id);
	
	List<HashMap> selectArticlesByWebIDRangeAndDate(int min_web_id, int max_web_id, Date publish_date);
	
	

}
