package com.csicerc.dss.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csicerc.dss.domain.Article;
import com.csicerc.dss.persist.dao.ArticleMapper;
import com.csicerc.dss.persist.dao.ExtendMapper;
import com.csicerc.dss.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private ExtendMapper articleDao;
	
	private static Logger log = LoggerFactory.getLogger(ArticleServiceImpl.class);
	
	@Override
	public Article findArticleById(int articleId) {
		log.info("findArticleById call with articleId="+articleId);
		Article article = articleMapper.selectByPrimaryKey(articleId);
		return article;
	}

	@Override
	public List<HashMap> findAllArticleWithPage(int start, int length) {
		// TODO Auto-generated method stub
		log.info("findAllArticleWithPage call with start=" + start +" and length=" + length);
		List<HashMap> list = articleDao.findAllArticleWithPage(start,length);
		return list;
	}

	@Override
	public List<Article> findAllArticle() {
		// TODO Auto-generated method stub
		log.info("findAllArticle start...");
		List<Article> list = articleMapper.selectAll();
		return list;
	}

	@Override
	public List<HashMap> findArticleByKeyWord(String word,int start, int length) {
		// TODO Auto-generated method stub
		log.info("findArticleByKeyWord call with word = "+word);
		List<HashMap> list = articleDao.findArticleByKeyWord(word,start,length);
		return list;
	}

	@Override
	public int deleteArticleById(int id) {
		// TODO Auto-generated method stub
		log.info("deleteArticleById call with articleId = "+id);
		int i = articleMapper.deleteByPrimaryKey(id);
		return i;
	}

	@Override
	public int deleteArticleByIds(String ids) {
		String[] split = ids.split(",");
		int i = 0;
		for (String string : split) {
			int id = Integer.parseInt(string);
			articleMapper.deleteByPrimaryKey(id);
			i++;
		}
		return i;
	}

	@Override
	public long selectCount(String string) {
		// TODO Auto-generated method stub
		long number = 0;
		if(string != null && !"".equals(string)) {
			number = articleDao.selectWordArticleCount(string);
		}else {
			number = articleDao.selectAllArticleCount();
		}
		return number;
	}


	
	
}
