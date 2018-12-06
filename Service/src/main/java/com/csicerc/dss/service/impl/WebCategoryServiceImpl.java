package com.csicerc.dss.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csicerc.dss.domain.WebCategory;
import com.csicerc.dss.persist.dao.ExtendMapper;
import com.csicerc.dss.persist.dao.WebCategoryMapper;
import com.csicerc.dss.service.WebCategoryService;

@Service
public class WebCategoryServiceImpl implements WebCategoryService {

	@Autowired
	private WebCategoryMapper webCategoryMapper;
	@Autowired
	private ExtendMapper WebCategoryDao;
	
	private static Logger log = LoggerFactory.getLogger(WebCategoryServiceImpl.class);
	
	@Override
	public int insertWebCategory(String webCategoryName) {
		// TODO Auto-generated method stub
		List<WebCategory> list = webCategoryMapper.selectAll();
		if(list.size()>0) {//数据库中有分类
			for (WebCategory wc : list) {
				if(wc.getWebCategoryName().equals(webCategoryName)) {
					return 0;//已有该分类，不做处理
				}
			}
		}
		//没有该分类，添加。
		WebCategory webCategory = new WebCategory();
		webCategory.setWebCategoryName(webCategoryName);
		int i = webCategoryMapper.insert(webCategory);
		return i;
	}

	@Override
	public int deleteWebCategory(String webCategoryName) {
		// TODO Auto-generated method stub
		int j = WebCategoryDao.deleteWebCategoryWebByWebCategoryName(webCategoryName);
		log.info("删除webCategoryName为"+webCategoryName+"的时候，同时删除了"+j+"条web_category_web表中的记录。");
		int i = WebCategoryDao.deleteByWebCategoryName(webCategoryName);
		return i;
	}

	@Override
	public List<HashMap> findAllWebCategory() {
		// TODO Auto-generated method stub
		List<HashMap> list = WebCategoryDao.selectAllWebCategory();
		return list;
	}

	@Override
	public List<HashMap> findWebCategoryAndWebByKeyWord(String word, int start, int length) {
		// TODO Auto-generated method stub
		List<HashMap> list = WebCategoryDao.findWebCategoryAndWebByKeyWord(word,start,length);
		return list;
	}
	@Override
	public long selectCount(String string) {
		// TODO Auto-generated method stub
		long number = 0;
		if(string != null && !"".equals(string)) {
			number = WebCategoryDao.selectWordWebCategoryCount(string);
		}else {
			number = WebCategoryDao.selectAllWebCategoryCount();
		}
		return number;
	}

	@Override
	public List<HashMap> findAllWebCategoryAndWebWithPage(int start, int length) {
		// TODO Auto-generated method stub
		List<HashMap> list = WebCategoryDao.findAllWebCategoryAndWebWithPage(start,length);
		return list;
	}
	@Override
	public long selectCountByWeb(String string) {
		// TODO Auto-generated method stub
		long number = 0;
		if(string != null && !"".equals(string)) {
			number = WebCategoryDao.selectWordWebCategoryCountByWeb(string);
		}else {
			number = WebCategoryDao.selectAllWebCategoryCountByWeb();
		}
		return number;
	}

	@Override
	public List<HashMap> findWebCategoryByKeyWord(String word, int start, int length) {
		// TODO Auto-generated method stub
		List<HashMap> list = WebCategoryDao.findWebCategoryByKeyWord(word,start,length);
		return list;
	}
	
	
	@Override
	public List<HashMap> findAllWebCategoryWithPage(int start, int length) {
		// TODO Auto-generated method stub
		List<HashMap> list = WebCategoryDao.findAllWebCategoryWithPage(start,length);
		return list;
	}

	@Override
	public List<HashMap> findAllWebCategoryByKeyWord(String word) {
		// TODO Auto-generated method stub
		List<HashMap> list = WebCategoryDao.findAllWebCategoryByKeyWord(word); 
		return list;
	}

}
