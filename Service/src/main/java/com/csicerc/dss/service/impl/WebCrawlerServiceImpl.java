package com.csicerc.dss.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csicerc.dss.domain.Article;
import com.csicerc.dss.domain.ArticleCategory;
import com.csicerc.dss.domain.ArticleCategoryKeyword;
import com.csicerc.dss.domain.ArticleKeyword;
import com.csicerc.dss.domain.Web;
import com.csicerc.dss.domain.WebCrawlerSchedule;
import com.csicerc.dss.persist.dao.ArticleCategoryKeywordMapper;
import com.csicerc.dss.persist.dao.ArticleCategoryMapper;
import com.csicerc.dss.persist.dao.ArticleKeywordMapper;
import com.csicerc.dss.persist.dao.ArticleMapper;
import com.csicerc.dss.persist.dao.ExtendMapper;
import com.csicerc.dss.persist.dao.WebCrawlerScheduleMapper;
import com.csicerc.dss.persist.dao.WebMapper;
import com.csicerc.dss.persist.dao.WebUrlMapper;
import com.csicerc.dss.service.WebCrawlerService;
import com.csicerc.dss.domain.WebUrl;

@Service
public class WebCrawlerServiceImpl implements WebCrawlerService {

	@Autowired
	private WebMapper webMapper;

	@Autowired
	private WebUrlMapper webUrlMapper;

	@Autowired
	private WebCrawlerScheduleMapper webCrawlerScheduleMapper;

	@Autowired
	private ArticleMapper articleMapper;

	@Autowired
	private ArticleKeywordMapper articleKeywordMapper;

	@Autowired
	private ArticleCategoryMapper articleCategoryMapper;

	@Autowired
	private ArticleCategoryKeywordMapper articleCategoryKeywordMapper;

	@Autowired
	private ExtendMapper extendMapper;

	// ===================webMapper===================================
	@Override
	public Web selectWebByPrimaryKey(int i) {
		return webMapper.selectByPrimaryKey(i);
	}

	@Override
	public List<Web> selectAllWeb() {
		List<Web> list = webMapper.selectAll();
		return list;
	}

	@Override
	public int insertWeb(Web web) {
		return webMapper.insert(web);
	}

	// ==================webCrawlerScheduleMapper====================
	@Override
	public WebCrawlerSchedule selectWebCrawlerScheduleByPrimaryKey(int webCrawlerScheduleId) {
		// TODO Auto-generated method stub
		return webCrawlerScheduleMapper.selectByPrimaryKey(webCrawlerScheduleId);
	}

	@Override
	public int insertWebCrawlerSchedule(WebCrawlerSchedule webCrawlerSchedule) {
		// TODO Auto-generated method stub
		return webCrawlerScheduleMapper.insert(webCrawlerSchedule);
	}

	@Override
	public int deleteWebCrawlerSchedule(int webCrawlerScheduleId) {
		// TODO Auto-generated method stub
		return webCrawlerScheduleMapper.deleteByPrimaryKey(webCrawlerScheduleId);
	}

	@Override
	public int updateWebCrawlerSchedule(WebCrawlerSchedule webCrawlerSchedule) {
		// TODO Auto-generated method stub
		return webCrawlerScheduleMapper.updateByPrimaryKey(webCrawlerSchedule);
	}

	// ==================articleMapper===============================
	@Override
	public Article selectArticleByPrimaryKey(int articleId) {
		// TODO Auto-generated method stub
		return articleMapper.selectByPrimaryKey(articleId);
	}

	@Override
	public int insertArticle(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.insert(article);
	}

	@Override
	public int deleteArticle(int articleId) {
		// TODO Auto-generated method stub
		return articleMapper.deleteByPrimaryKey(articleId);
	}

	@Override
	public int updateArticle(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.updateByPrimaryKey(article);
	}

	// ==================articleKeywordMapper========================
	@Override
	public ArticleKeyword selectArticleKeywordByPrimaryKey(int articleKeywordId) {
		// TODO Auto-generated method stub
		return articleKeywordMapper.selectByPrimaryKey(articleKeywordId);
	}

	@Override
	public int insertArticleKeyword(ArticleKeyword articleKeyword) {
		// TODO Auto-generated method stub
		return articleKeywordMapper.insert(articleKeyword);
	}

	@Override
	public int deleteArticleKeyword(int articleKeywordId) {
		// TODO Auto-generated method stub
		return articleKeywordMapper.deleteByPrimaryKey(articleKeywordId);
	}

	@Override
	public int updateArticleKeyword(ArticleKeyword articleKeyword) {
		// TODO Auto-generated method stub
		return articleKeywordMapper.updateByPrimaryKey(articleKeyword);
	}

	// ==================articleCategoryMapper=======================
	@Override
	public ArticleCategory selectArticleCategoryByPrimaryKey(int articleCategoryId) {
		// TODO Auto-generated method stub
		return articleCategoryMapper.selectByPrimaryKey(articleCategoryId);
	}

	@Override
	public int insertArticleCategory(ArticleCategory articleCategory) {
		// TODO Auto-generated method stub
		return articleCategoryMapper.insert(articleCategory);
	}

	@Override
	public int deleteArticleCategory(int articleCategoryId) {
		// TODO Auto-generated method stub
		return articleCategoryMapper.deleteByPrimaryKey(articleCategoryId);
	}

	@Override
	public int updateArticleCategory(ArticleCategory articleCategory) {
		// TODO Auto-generated method stub
		return articleCategoryMapper.updateByPrimaryKey(articleCategory);
	}

	// ==================articleCategoryKeywordMapper================
	@Override
	public ArticleCategoryKeyword selectArticleCategoryKeywordByPrimaryKey(int articleCategoryKeywordId) {
		// TODO Auto-generated method stub
		return articleCategoryKeywordMapper.selectByPrimaryKey(articleCategoryKeywordId);
	}

	@Override
	public int insertArticleCategoryKeyword(ArticleCategoryKeyword articleCategoryKeyword) {
		// TODO Auto-generated method stub
		return articleCategoryKeywordMapper.insert(articleCategoryKeyword);
	}

	@Override
	public int deleteArticleCategoryKeyword(int articleCategoryKeywordId) {
		// TODO Auto-generated method stub
		return articleCategoryKeywordMapper.deleteByPrimaryKey(articleCategoryKeywordId);
	}

	@Override
	public int updateArticleCategoryKeyword(ArticleCategoryKeyword articleCategoryKeyword) {
		// TODO Auto-generated method stub
		return articleCategoryKeywordMapper.updateByPrimaryKey(articleCategoryKeyword);
	}

	@Override
	public List<WebUrl> selectAllWebUrl() {
		return webUrlMapper.selectAll();
	}
	


	@Override
	public int updateWebByPrimaryKey(Web web) {
		webMapper.updateByPrimaryKey(web);
		return 0;
	}

	@Override
	public WebUrl selectWebUrlByPrimaryKey(int key) {
		return webUrlMapper.selectByPrimaryKey(key);
	}

	public List<HashMap> selectArticles() {
		return extendMapper.selectArticles();
	}

	public List<HashMap> selectArticlesByWebID(int web_id) {
		return extendMapper.selectArticlesByWebID(web_id);
	}

	public List<HashMap> selectArticlesByWebIDRange(int min_web_id, int max_web_id) {
		return extendMapper.selectArticlesByWebIDRange(min_web_id, max_web_id);
	}

	@Override
	public List<HashMap> selectArticlesByWebIDandDate(int web_id, Date publish_date) {
		return extendMapper.selectArticlesByWebIDandDate(web_id, publish_date);
	}

	@Override
	public List<HashMap> selectArticlesByWebIDRangeAndDate(int min_web_id, int max_web_id, Date publish_date) {
		return extendMapper.selectArticlesByWebIDRangeAndDate(min_web_id, max_web_id, publish_date);
	}

}
