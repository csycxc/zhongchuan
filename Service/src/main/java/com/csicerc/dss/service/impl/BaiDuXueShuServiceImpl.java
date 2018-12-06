package com.csicerc.dss.service.impl;

import java.util.List;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.csicerc.dss.domain.BaiDuArticle;
import com.csicerc.dss.service.BaiDuXueShuService;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.UpdateOptions;

@Service
public class BaiDuXueShuServiceImpl implements BaiDuXueShuService {

	private static Logger log = LoggerFactory.getLogger(BaiDuXueShuServiceImpl.class);
	
	private MongoCollection collection;
	@Autowired
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		collection = mongoTemplate.getCollection("baidu_paper");//百度学术
	}
	
	@Override
	public void saveArticle(List<BaiDuArticle> list) {
		// TODO Auto-generated method stub
		
		for (BaiDuArticle article : list) {
			Document doc = new Document();
			
			//log.info("article ====="+article.toString());
			
			String searchWord = article.getSearchWord();//获取搜索的关键字
			String title = article.getTitle();//获取文章名字
			
			if(searchWord !=null && !"".equals(searchWord)) {
				doc.append("searchWord", searchWord);
			}
			if(title !=null && !"".equals(title)) {
				doc.append("title", title);
			}
			if(article.getAuthor()!=null && !"".equals(article.getAuthor())) {
				doc.append("author", article.getAuthor());
			}
			if(article.getDigest() != null && !"".equals(article.getDigest())) {
				doc.append("digest", article.getDigest());
			}
			if(article.getPeriodical()!=null && !"".equals(article.getPeriodical())) {
				doc.append("periodical", article.getPeriodical());
			}
			if(article.getYears()!=null && !"".equals(article.getYears())) {
				doc.append("years", article.getYears());
			}
			if(article.getCitations()!=null && !"".equals(article.getCitations())) {
				doc.append("citations", article.getCitations());
			}
			if(article.getType()!=null && !"".equals(article.getType())) {
				doc.append("type", article.getType());
			}
			if(article.getTypeNum()!=null && !"".equals(article.getTypeNum())) {
				doc.append("typeNum", article.getTypeNum());
			}
			if(article.getKeyWord()!=null && !"".equals(article.getKeyWord())) {
				doc.append("keyWord", article.getKeyWord());
			}
			if(article.getOrganization()!=null && !"".equals(article.getOrganization())) {
				doc.append("organization", article.getOrganization());
			}
			if(article.getArticleUrl() != null && !"".equals(article.getArticleUrl())) {
				doc.append("articleUrl", article.getArticleUrl());
			}
			
			//判断名字在数据库中是否存在，如果存在，则更新  如果不存在，则插入
			BasicDBObject searchQuery = new BasicDBObject().append("title",title);
			Document existingDoc = (Document) collection.find(searchQuery).first();
			
			if (existingDoc != null) {//存在，即更新
				//log.info("existingDoc======"+existingDoc.toString());
				//“搜索关键字”如果不为空，查看是否包含，包含则用原来的，不包含则在后面添加“，新搜索关键字”
				if(existingDoc.getString("searchWord") != null && !"".equals(existingDoc.getString("searchWord"))) {
					if(searchWord != null && !"".equals(searchWord)) {
						if(existingDoc.getString("searchWord").contains(searchWord)) {//contains(null)报错空指针。
							//如果搜索的关键字里面包含此搜索关键字，不添加，关键字还用原来的。
							doc.append("searchWord", existingDoc.getString("searchWord"));
						}else {//不包含，则在后面添加
							doc.append("searchWord", existingDoc.getString("searchWord")+";"+searchWord);
						}
					}else {
						doc.append("searchWord", existingDoc.getString("searchWord"));
					}
				}
				if(existingDoc.getString("articleUrl") != null && !"".equals(existingDoc.getString("articleUrl"))) {
					/*if(article.getArticleUrl()!= null && !"".equals(article.getArticleUrl())) {
						if(existingDoc.getString("articleUrl").equals(article.getArticleUrl())) {
							doc.append("articleUrl", article.getArticleUrl());
						}else {
							doc.append("articleUrl", existingDoc.getString("articleUrl"));
						}
					}else {
						doc.append("articleUrl", existingDoc.getString("articleUrl"));
					}*/
					doc.append("articleUrl", existingDoc.getString("articleUrl"));
				}
				//title属性不为空时，两个title一样，所以直接将该title赋值。              title为空时，基本 不存在。
				if(existingDoc.getString("title") != null && !"".equals(existingDoc.getString("title"))) {
					if(title != null && !"".equals(title)) {
						if(existingDoc.getString("title").contains(title)) {
							doc.append("title", existingDoc.getString("title"));
						}else {
							doc.append("title", existingDoc.getString("title")+";"+title);
						}						
					}else {
						doc.append("title", existingDoc.getString("title"));
					}
				}
				if(existingDoc.getString("author") != null && !"".equals(existingDoc.getString("author"))) {
					if(article.getAuthor() != null && !"".equals(article.getAuthor())) {
						if(existingDoc.getString("author").contains(article.getAuthor())) {
							doc.append("author", existingDoc.getString("author"));						
						}else {
							doc.append("author", existingDoc.getString("author")+";"+article.getAuthor());
						}
					}else {
						doc.append("author", existingDoc.getString("author"));
					}
				}
				if(existingDoc.getString("digest") != null && !"".equals(existingDoc.getString("digest"))) {
					/*if(article.getDigest() != null && !"".equals(article.getDigest())) {
						if(existingDoc.getString("digest").contains(article.getDigest())) {
							doc.append("digest", existingDoc.getString("digest"));						
						}else {
							doc.append("digest", existingDoc.getString("digest")+";"+article.getDigest());
						}
					}else {
						doc.append("digest", existingDoc.getString("digest"));
					}*/
					if(article.getDigest() == null || "".equals(article.getDigest())) {
						doc.append("digest", existingDoc.getString("digest"));
					}
				}
				
				if(existingDoc.getString("periodical") !=null && !"".equals(existingDoc.getString("periodical"))) {
					if(article.getPeriodical() != null && !"".equals(article.getPeriodical())) {
						if(existingDoc.getString("periodical").contains(article.getPeriodical())) {
							doc.append("periodical", existingDoc.getString("periodical"));
						}else {
							doc.append("periodical", existingDoc.getString("periodical")+";"+article.getPeriodical());
						}						
					}else {
						doc.append("periodical", existingDoc.getString("periodical"));
					}
				}
				if(existingDoc.getString("years") !=null && !"".equals(existingDoc.getString("years"))) {
					if(article.getYears() != null && !"".equals(article.getYears())) {
						if(existingDoc.getString("years").contains(article.getYears())) {
							doc.append("years", existingDoc.getString("years"));						
						}else {
							doc.append("years", existingDoc.getString("years")+";"+article.getYears());
						}						
					}else {
						doc.append("years", existingDoc.getString("years"));
					}
					
				}
				if(existingDoc.getString("citations") !=null && !"".equals(existingDoc.getString("citations"))) {
					if(article.getCitations() != null && !"".equals(article.getCitations())) {
						if(existingDoc.getString("citations").contains(article.getCitations())) {
							doc.append("citations", existingDoc.getString("citations"));						
						}else {
							doc.append("citations", existingDoc.getString("citations")+";"+article.getCitations());
						}						
					}else {
						doc.append("citations", existingDoc.getString("citations"));
					}
				}
				if(existingDoc.getString("type") !=null && !"".equals(existingDoc.getString("type"))) {
					if(article.getType() != null && !"".equals(article.getType())) {
						if(existingDoc.getString("type").contains(article.getType())) {
							doc.append("type", existingDoc.getString("type"));						
						}else {
							doc.append("type", existingDoc.getString("type")+";"+article.getType());
						}						
					}else {
						doc.append("type", existingDoc.getString("type"));
					}
				}
				if(existingDoc.getString("typeNum") !=null && !"".equals(existingDoc.getString("typeNum"))) {
					if(article.getTypeNum() != null && !"".equals(article.getTypeNum())) {
						if(existingDoc.getString("typeNum").contains(article.getTypeNum())) {
							doc.append("typeNum", existingDoc.getString("typeNum"));						
						}else {
							doc.append("typeNum", existingDoc.getString("typeNum")+";"+article.getTypeNum());
						}						
					}else {
						doc.append("typeNum", existingDoc.getString("typeNum"));
					}
				}
				if(existingDoc.getString("keyWord") !=null && !"".equals(existingDoc.getString("keyWord"))) {
					if(article.getKeyWord() != null && !"".equals(article.getKeyWord())) {
						if(existingDoc.getString("keyWord").contains(article.getKeyWord())) {
							doc.append("keyWord", existingDoc.getString("keyWord"));						
						}else {
							doc.append("keyWord", existingDoc.getString("keyWord")+";"+article.getKeyWord());
						}
					}else {
						doc.append("keyWord", existingDoc.getString("keyWord"));
					}
				}
				if(existingDoc.getString("organization") !=null && !"".equals(existingDoc.getString("organization"))) {
					if(article.getOrganization() != null && !"".equals(article.getOrganization())) {
						if(existingDoc.getString("organization").contains(article.getOrganization())) {
							doc.append("organization", existingDoc.getString("organization"));						
						}else {
							doc.append("organization", existingDoc.getString("organization")+";"+article.getOrganization());
						}						
					}else {
						doc.append("organization", existingDoc.getString("organization"));
					}
				}
				UpdateOptions options = new UpdateOptions().upsert(true); // insert if not existing
				collection.replaceOne(searchQuery, doc, options);
			} else {//不存在，插入
				collection.insertOne(doc);
			}
		}
	}

	

	
	
	
}
