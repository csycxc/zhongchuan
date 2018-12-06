package com.csicerc.dss.persist.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.csicerc.dss.domain.Web;

public interface ExtendMapper {

	@Select("SELECT w.web_name,wu.web_url_name,a.article_date,a.article_title, a.article_abstract, a.article_content, a.article_link "
			+ "FROM article a, web_url wu, web w " + "WHERE a.web_url_id=wu.web_url_id AND wu.web_id=w.web_id")
	public List<HashMap> selectArticles();

	@Select("SELECT w.web_name,wu.web_url_name,a.article_date,a.article_title, a.article_abstract, a.article_content, a.article_link "
			+ "FROM article a, web_url wu, web w "
			+ "WHERE a.web_url_id=wu.web_url_id AND wu.web_id=w.web_id and wu.web_id= #{web_id}")
	public List<HashMap> selectArticlesByWebID(int web_id);

	@Select("SELECT w.web_name,wu.web_url_name,a.article_date,a.article_title, a.article_search_by_keyword, a.article_abstract, a.article_content, a.article_link "
			+ "FROM article a, web_url wu, web w "
			+ "WHERE a.web_url_id=wu.web_url_id AND wu.web_id=w.web_id and wu.web_id= #{web_id} and a.article_date> #{publish_date}")
	public List<HashMap> selectArticlesByWebIDandDate(int web_id, Date publish_date);

	@Select("SELECT w.web_name,wu.web_url_name,a.article_date,a.article_title, a.article_abstract, a.article_content, a.article_link "
			+ "FROM article a, web_url wu, web w "
			+ "WHERE a.web_url_id=wu.web_url_id AND wu.web_id=w.web_id and wu.web_id>=#{min_web_id} and wu.web_id<=#{max_web_id} ")
	public List<HashMap> selectArticlesByWebIDRange(int min_web_id, int max_web_id);

	@Select("SELECT w.web_name,wu.web_url_name,a.article_date,a.article_title, a.article_abstract, a.article_content, a.article_link "
			+ "FROM article a, web_url wu, web w "
			+ "WHERE a.web_url_id=wu.web_url_id AND wu.web_id=w.web_id and wu.web_id>=#{min_web_id} "
			+ "and wu.web_id<=#{max_web_id} and a.article_date> #{publish_date} ")
	public List<HashMap> selectArticlesByWebIDRangeAndDate(int min_web_id, int max_web_id, Date publish_date);

	@Select("SELECT ctf.`CRSL_TABLE_ID`, cf.`CRSL_FIELD_ID`,cf.`CRSL_FIELD_NAME`,cf.`CRSL_FIELD_DATAFIELDTYPE` "
			+ "FROM CRSL_FIELD cf, CRSL_TABLE_FIELD ctf "
			+ "WHERE cf.`CRSL_FIELD_ID`=ctf.`CRSL_FIELD_ID` and ctf.CRSL_TABLE_ID=#{tableID} "
			+ "and cf.CRSL_FIELD_DISABLED=0")
	public List<HashMap> selectCRSLTableFields(int tableID);
	
	
	
/*
select a.*,w.web_name,wc.web_category_name 
from article a 
left join web_url wu on a.web_url_id = wu.web_url_id 
left join web w on wu.web_id = w.web_id 
left join web_category_web wcw on w.web_id = wcw.web_id
left join web_category wc on wcw.web_category_id = wc.web_category_id
order by a.article_id
*/
	@Select({"select ","a.*,w.web_name,wc.web_category_name ",
    	"from article a left join web_url wu on a.web_url_id = wu.web_url_id ", 
    	"left join web w on wu.web_id = w.web_id ", 
    	"left join web_category_web wcw on w.web_id = wcw.web_id ",
    	"left join web_category wc on wcw.web_category_id = wc.web_category_id",
		"order by a.article_id limit #{startNum},#{pageSize} "})
	List<HashMap> findAllArticleWithPage(int startNum, int pageSize);
	
	
	@Select({"select ","a.*,w.web_name,wc.web_category_name ",
    	"from article a left join web_url wu on a.web_url_id = wu.web_url_id ", 
    	"left join web w on wu.web_id = w.web_id ", 
    	"left join web_category_web wcw on w.web_id = wcw.web_id ",
    	"left join web_category wc on wcw.web_category_id = wc.web_category_id",
		"where a.article_title like concat('%',#{word},'%') or a.article_content like concat('%',#{word},'%') ",
		"or w.web_name like concat('%',#{word},'%') or wc.web_category_name like concat('%',#{word},'%') ",
		"order by a.article_id",
		"limit #{startNum},#{pageSize} "
	})
	List<HashMap> findArticleByKeyWord(String word, int startNum, int pageSize);

	@Select({
		"select ","web_id, web_name, web_home_url, web_status, web_enabled, web_is_SE, web_recently_errors ",
		"from web ","limit #{start},#{pageSize} "
	})
	public List<HashMap> findAllWebWithPage(int start, int pageSize);

	@Select({
		"select ","web_id, web_name, web_home_url, web_status, web_enabled, web_is_SE, web_recently_errors ",
		"from web ","where web_name like concat('%',#{word},'%') ","limit #{startNum},#{pageSize} "
	})
	public List<HashMap> findWebByKeyWord(String word,int startNum,int pageSize);

	@Select({"select count(1) ",
		"from article a left join web_url wu on a.web_url_id = wu.web_url_id ", 
    	"left join web w on wu.web_id = w.web_id ", 
    	"left join web_category_web wcw on w.web_id = wcw.web_id ",
    	"left join web_category wc on wcw.web_category_id = wc.web_category_id",
		"where a.article_title like concat('%',#{word},'%') or a.article_content like concat('%',#{word},'%') ",
		"or w.web_name like concat('%',#{word},'%') or wc.web_category_name like concat('%',#{word},'%') "
		})
	public long selectWordArticleCount(String word);
	@Select("select count(1) from article ")
	public long selectAllArticleCount();
	@Select("select count(1) from web where web_name like concat('%',#{word},'%') or web_home_url like concat('%',#{word},'%') ")
	public long selectWordWebCount(String word);
	@Select("select count(1) from web ")
	public long selectAllWebCount();
	
	@Select({
		"select wc.*, w.* ",
		"from web_category wc ",
		"left join web_category_web wcw on wc.web_category_id = wcw.web_category_id ",
		"left join web w on w.web_id = wcw.web_id ",
		"where wc.web_category_name like concat('%',#{word},'%') or w.web_name like concat('%',#{word},'%') ",
		"limit #{startNum},#{pageSize} "
	})
	public List<HashMap> findWebCategoryAndWebByKeyWord(String word, int startNum, int pageSize);
	@Select({
		"select wc.*, w.* ",
		"from web_category wc ",
		"left join web_category_web wcw on wc.web_category_id = wcw.web_category_id ",
		"left join web w on w.web_id = wcw.web_id ",
		"limit #{start},#{pageSize} "
	})
	public List<HashMap> findAllWebCategoryAndWebWithPage(int start, int pageSize);

	@Select({
		"select count(*) from (",
		"select wc.*, w.* ",
		"from web_category wc ",
		"left join web_category_web wcw on wc.web_category_id = wcw.web_category_id ",
		"left join web w on w.web_id = wcw.web_id ",
		"where wc.web_category_name like concat('%',#{word},'%') or w.web_name like concat('%',#{word},'%') ",
		") hh"
	})
	public long selectWordWebCategoryCountByWeb(String word);
	@Select({
		"select count(*) from (",
		"select wc.*, w.* ",
		"from web_category wc ",
		"left join web_category_web wcw on wc.web_category_id = wcw.web_category_id ",
		"left join web w on w.web_id = wcw.web_id ",
		") hh"
	})
	public long selectAllWebCategoryCountByWeb();
	
	@Select({
		"select * ",
		"from web_category ",
		"where web_category_name like concat('%',#{word},'%') ",
		"limit #{start},#{length} "
	})
	public List<HashMap> findWebCategoryByKeyWord(String word, int start, int length);
	@Select({
		"select * ",
		"from web_category ",
		"limit #{start},#{length} "
	})
	public List<HashMap> findAllWebCategoryWithPage(int start, int length);
	
	@Select("select count(1) from web_category where web_category_name like concat('%',#{word},'%') ")
	public long selectWordWebCategoryCount(String word);
	@Select("select count(1) from web_category ")
	public long selectAllWebCategoryCount();
	
	@Delete({
		"delete from web_category where web_category_name = #{webCategoryName}"
	})
	public int deleteByWebCategoryName(String webCategoryName);
	
	@Delete({
		"delete from web_category_web where web_category_id in (",
		"select web_category_id from web_category where web_category_name = #{webCategoryName}) "
	})
	public int deleteWebCategoryWebByWebCategoryName(String webCategoryName);
	
	@Select({
		"select web_id from web_category_web where web_category_id = #{webCategoryId} "
	})
	public List<Integer> findWebByWebCategory(int webCategoryId);

	@Delete({
		"delete from web_category_web where web_category_id = #{webCategoryId}"
	})
	public int deleteWebCategoryWebByWebCategoryId(int webCategoryId);
	
	@Insert({
		"insert into web_category_web(web_category_id,web_id) values(#{webCategoryId},#{webId})"
	})
	public int saveWebCategoryWeb(int webCategoryId, int webId);
	
	@Select({
		"select * from web_category "
	})
	public List<HashMap> selectAllWebCategory();
	@Select({
		"select * from web_category where web_category_name like concat('%',#{word},'%') "
	})
	public List<HashMap> findAllWebCategoryByKeyWord(String word);
	@Select({
		"select * from web "
	})
	public List<HashMap> selectAllWeb();
	@Select({
		"select * from web where web_name like concat('%',#{word},'%') "
	})
	public List<HashMap> selectWebByKeyWord(String word);

	@Select("select count(1) from web ")
	public long selectCount();
	@Select("select count(1) from web where web_name like concat('%',#{word},'%') ")
	public long selectCountByKeyWord(String word);
	

	
	
}
