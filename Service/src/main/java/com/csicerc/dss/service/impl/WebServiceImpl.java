package com.csicerc.dss.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csicerc.dss.domain.Web;
import com.csicerc.dss.persist.dao.ExtendMapper;
import com.csicerc.dss.persist.dao.WebMapper;
import com.csicerc.dss.service.WebService;

@Service
public class WebServiceImpl implements WebService {
	
	@Autowired
	private WebMapper webMapper;
	@Autowired
	private ExtendMapper webDao;
	
	@Override
	public Web findWebById(int id) {
		// TODO Auto-generated method stub
		Web web = webMapper.selectByPrimaryKey(id);
		return web;
	}

	@Override
	public List<HashMap> findAllWebWithPage(int start, int length) {
		// TODO Auto-generated method stub
		List<HashMap> list = webDao.findAllWebWithPage(start,length);
		return list;
	}

	@Override
	public List<HashMap> findAllWebByKeyWord(String word) {
		// TODO Auto-generated method stub
		List<HashMap> list;
		if(word == null || "".equals(word)) {
			list = webDao.selectAllWeb();
		}else {
			list = webDao.selectWebByKeyWord(word);
		}
		return list;			
	}

	@Override
	public List<HashMap> findWebByKeyWord(String keyWord,int start, int length) {
		// TODO Auto-generated method stub
		List<HashMap> list = webDao.findWebByKeyWord(keyWord,start,length);
		return list;
	}

	@Override
	public int deleteWebById(int webId) {
		// TODO Auto-generated method stub
		int i = webMapper.deleteByPrimaryKey(webId);
		return i;
	}

	@Override
	public int deleteWebByIds(String ids) {
		// TODO Auto-generated method stub
		String[] split = ids.split(",");
		int i = 0;
		for (String string : split) {
			int id = Integer.parseInt(string);
			webMapper.deleteByPrimaryKey(id);
			i++;
		}
		return i;
	}

	@Override
	public long selectAllWebCount(String string) {
		// TODO Auto-generated method stub
		long number = 0;
		if(string != null && !"".equals(string)) {
			number = webDao.selectWordWebCount(string);
		}else {
			number = webDao.selectAllWebCount();
		}
		return number;
	}

	@Override
	public List<Integer> findWebByWebCategory(int webCategoryId) {
		// TODO Auto-generated method stub
		List<Integer> list = webDao.findWebByWebCategory(webCategoryId);
		return list;
	}

	
	@Override
	public int saveWebCategoryWeb(int webCategoryId,ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		//先删除该分类下的所有网站，再添加
		int i = webDao.deleteWebCategoryWebByWebCategoryId(webCategoryId);
		int j=0;
		for (Integer k : list) {
			webDao.saveWebCategoryWeb(webCategoryId, k);
			j++;
		}
		return j;
	}

	@Override
	public long selectCount(String word) {
		// TODO Auto-generated method stub
		long number;
		if(word == null || "".equals(word)) {
			number = webDao.selectCount();
		}else {
			number = webDao.selectCountByKeyWord(word);
		}
		return number;
	}

	@Override
	public void deleteWebCategoryWebByWebCategoryId(int webCategoryId) {
		// TODO Auto-generated method stub
		webDao.deleteWebCategoryWebByWebCategoryId(webCategoryId);
	}

}
