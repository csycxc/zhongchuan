package com.csicerc.dss.webcrawler;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/***
 * 
 * @author Haomeng,Wang
 * 
 *         联合早报网站文章抓取类（测试Jsoup类，最终不会被调用）
 * 
 *         该网站支持关键字搜索， 搜索后会返回多个分页页面，每个页面中有10个文章
 *         "http://www.zaobao.com/search/site/智能"
 * 
 *         每个文章页面中有如下细节信息： 发布/2018年6月8日 3:30 AM 文/杨全龙 来自/联合早报
 * 
 */
//@Component

public class WC_Zaobao implements CommandLineRunner {

	@Override
	public void run(String... args) {

		// 1 加载关键字搜索页面，获取总页数
		//  接口 getPageSize
		//
		String key = "智能";
		String url = "http://www.zaobao.com/search/site/" + key;
		Document doc = null;
		int pageSize = 0; // 默认分页为零页，就是没有文章
		List<String> allArticleLinks = new ArrayList<String>(); // 保存一个关键字查询查出来的所有的文章的URL

		try {
			doc = Jsoup.connect(url).get();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 * 获取尾页信息，得到总页码
		 * <li class="pager-last last">
		 * <a href="/search/site/%E6%99%BA%E8%83%BD?page=7" target="_blank">尾页 »</a>
		 * </li>
		 * 
		 */
		Elements pagerLast = doc.select("li.last.pager-last");
		//print("\nli.last.pager-last elements size: (%d)", pagerLast.size());
		if (pagerLast.size() == 1) {
			String lastPageLink = pagerLast.get(0).children().get(0).attr("abs:href");
			String[] pageNums = lastPageLink.split("page=");
			if (pageNums != null && pageNums.length > 0) {
				pageSize = Integer.parseInt(pageNums[1]) + 1;
				print("\npage size: (%d)", pageSize);
			}
		}

		// 2 逐页抓取业内文章链接
		for (int i = 0; i < pageSize; i++) {
			try {
				doc = Jsoup.connect(url + "?page=" + (i)).get();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Elements articleLinks = doc.select("a[href].headline");
			for (Element link : articleLinks)
				allArticleLinks.add(link.attr("abs:href"));
		}

		// 3 主页面抓取文章标题内容等
		print("\n all links size: %d", allArticleLinks.size());
		for(int i=0;i<allArticleLinks.size();i++)
		{
			String link = allArticleLinks.get(i);
			print("%d %s", i, link);
			try {
				doc = Jsoup.connect(link).get();

				// 解析发布日期
				Elements articlePublishDateTag = doc.select("span.meta-date-published");
				if(articlePublishDateTag.size()>0)
					print("\n articlePublishDate: %s", articlePublishDateTag.get(0).html());

				// 解析标题
				Elements articleTitle = doc.select("h1");				
				print("\n articleTitle : %s", articleTitle.get(0).html());

				// 解析内容区域
				Elements articleContent = doc.select("div.article-content-container p");
				print("\n articleContent:");

				for (Element p : articleContent)
					print("\n%s", p.ownText());

				print("\n ========================================================== \n");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	private static void print(String msg, Object... args) {
		System.out.println(String.format(msg, args));
	}

	private static String trim(String s, int width) {
		if (s.length() > width)
			return s.substring(0, width - 1) + ".";
		else
			return s;
	}
}