package com.csicerc.dss.service;

import java.util.HashMap;
import java.util.List;

import com.csicerc.dss.domain.BaiDuArticle;

/**
 * 百度学术下载文章service。
 * @author Administrator
 *
 */
public interface BaiDuXueShuService {

	/**
	 * 保存百度学术下载的文章信息（包括更新和插入两种操作）
	 * @param map1
	 */
	void saveArticle(List<BaiDuArticle> list);
	

}
