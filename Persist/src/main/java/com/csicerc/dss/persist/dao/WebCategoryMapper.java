package com.csicerc.dss.persist.dao;

import java.util.List;

import com.csicerc.dss.domain.WebCategory;

public interface WebCategoryMapper {


	
	public int deleteByPrimaryKey(Integer webCategoryId);

	public int insert(WebCategory webCategory);

	public WebCategory selectByPrimaryKey(Integer webCategoryId);

	public List<WebCategory> selectAll();

	public int updateByPrimaryKey(WebCategory webCategory);
}
