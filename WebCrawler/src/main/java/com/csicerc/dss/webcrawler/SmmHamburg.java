package com.csicerc.dss.webcrawler;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/***
 * 
 * @author Haomeng,Wang
 * 
 * Download all company info from https://www.smm-hamburg.com/en/the-fair/exhibitors-products/exhibitor-news
 * 
 */

//@Component
public class SmmHamburg {

	static List allArticleList = new ArrayList();

	static HSSFWorkbook workbook = new HSSFWorkbook();

	static HSSFSheet sheet1 = workbook.createSheet("SMM-Hamburg");

	static int i = 0;

	// @Override
	public static void run(String... args) {

		sheet1.setColumnWidth(0, 10 * 256); // 来源 网站
		sheet1.setColumnWidth(1, 10 * 256); // 关键字
		sheet1.setColumnWidth(2, 20 * 256); // 发布时间
		sheet1.setColumnWidth(3, 60 * 256); // 标题

		String url = "https://www.smm-hamburg.com/en/the-fair/exhibitors-products/exhibitor-news/";
		Document doc = null;

		List categoryList = new ArrayList();

		try {

			Connection conn = Jsoup.connect(url).timeout(20000);
			setHeader(conn);
			doc = conn.get();

		} catch (Exception e) {
			e.printStackTrace();
		}

		Elements eles = doc.select("a.hmc-btn-primary");

		if (eles.size() >= 1) {
			for (int i = 0; i < eles.size(); i++) {

				HashMap hashmap = new HashMap();
				hashmap.put("link", eles.get(i).attr("abs:href").toString());
				hashmap.put("title", eles.get(i).ownText());
				categoryList.add(hashmap);

				checkOneCagetoryOut(hashmap);

			}
		}

		System.out.println("allArticleList.size" + allArticleList.size());

//	
	}

	public static void checkOneCagetoryOut(HashMap hashmap) {

		System.out.println("Checking " + (hashmap));

		String page2Link = checkOneCagetoryFirstPageArticlesOut(hashmap);

		String pageUrl = calcPage2UrlPattern(page2Link);

		System.out.println("pageUrl:" + pageUrl);

		// loop pages
		for (int i = 2; i < 30; i++) {
			String pageLink = pageUrl + i;
			boolean ret = checkOnePageLinks(pageLink, hashmap.get("title").toString());
			if (!ret)
				break;
		}

	}

	// input:
	// https://www.smm-hamburg.com/en/the-fair/exhibitors-products/exhibitor-news/ships-including-repairs-and-refits/?tx_hmcexhibitornews_news%5B%40widget_0%5D%5BcurrentPage%5D=2&cHash=05504a468e0ae26c69c88264ab5e1991
	// output
	// https://www.smm-hamburg.com/en/the-fair/exhibitors-products/exhibitor-news/ships-including-repairs-and-refits/?tx_hmcexhibitornews_news%5B%40widget_0%5D%5BcurrentPage%5D=
	public static String calcPage2UrlPattern(String page2Url) {
		int tmp = page2Url.indexOf("currentPage%5D=");
		return page2Url.substring(0, tmp + 15);
	}

	// return page2 link
	public static String checkOneCagetoryFirstPageArticlesOut(HashMap category) {
		System.out.println("checkOneCagetoryFirstPageArticlesOut " + (category));
		String page2Link = "";

		checkOnePageLinks(category.get("link").toString(), category.get("title").toString());

		return getPage2Link(category.get("link").toString());

	}

	public static String getPage2Link(String baselink) {
		System.out.println("getPage2Link " + (baselink));
		String page2Link = "";

		Document doc = null;

		try {

			Connection conn = Jsoup.connect(baselink).timeout(20000);
			setHeader(conn);
			doc = conn.get();

		} catch (Exception e) {
			e.printStackTrace();
		}

		Elements eles = doc.select("ul.pagination li a");
		System.out.println(eles);

		if (eles.size() > 2) {

			System.out.println("getPage2Link is:" + eles.get(2).attr("abs:href"));

			page2Link = eles.get(2).attr("abs:href").toString();
		}

		return page2Link;
	}

	public static boolean checkOnePageLinks(String link, String catetory) {
		System.out.println(" checkOnePageLinks " + link);
		Document doc = null;

		List list = new ArrayList();

		try {

			Connection conn = Jsoup.connect(link).timeout(20000);
			setHeader(conn);
			doc = conn.get();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		Elements eles = doc.select("a.hmc-btn.hmc-btn-primary");

		if (eles.size() >= 1) {
			System.out.println(" eles.size()" + eles.size());
			for (int i = 0; i < eles.size(); i++) {

				checkOneArticleOut(eles.get(i).attr("abs:href"), catetory);
			}
			return true;
		} else
			return false;
	}

	public static HashMap checkOneArticleOut(String link, String category) {
		HashMap hashmap = new HashMap();
		System.out.println("checkOneArticleOut Checking article " + link + ", category=" + category);
		Document doc = null;
		try {

			Connection conn = Jsoup.connect(link).timeout(20000);
			setHeader(conn);
			doc = conn.get();

		} catch (Exception e) {
			e.printStackTrace();
		}

		Elements eles = doc.select("h2 a");

		if (eles.size() >= 1) {

			hashmap.put("company_name", eles.get(0).text());

		}

		eles = doc.select("h3");

		if (eles.size() >= 1) {

			hashmap.put("company_spec", eles.get(0).text());

		}

		eles = doc.select("div.col-md-8.col-xs-12");

		if (eles.size() >= 1) {

			// checkOneArticleOut(eles.get(i).attr("abs:href"), catetory);

			hashmap.put("company_desc", eles.get(0).text());

		}

		hashmap.put("company_category", category);

		exportToExcel(hashmap);

		i++;

		System.out.println("compnany :" + hashmap);
		return hashmap;
	}

	public static void exportToExcel(HashMap map) {
		FileOutputStream out;

		HSSFRow row = sheet1.createRow(i);

		HSSFCell cell0 = row.createCell(0);
		cell0.setCellValue(map.get("company_name").toString());
		CellStyle cellStyle = cell0.getCellStyle();
		cellStyle.setWrapText(true);
		// cellStyle.setVerticalAlignment(VerticalAlignment.TOP);

		HSSFCell cell1 = row.createCell(1);
		cell1.setCellValue(map.get("company_spec").toString());
		cellStyle = cell1.getCellStyle();
		cellStyle.setWrapText(true);

		HSSFCell cell2 = row.createCell(2);
		cell2.setCellValue(map.get("company_desc").toString());
		cellStyle = cell2.getCellStyle();
		cellStyle.setWrapText(true);

		HSSFCell cell3 = row.createCell(3);
		cell3.setCellValue(map.get("company_category").toString());
		cellStyle = cell3.getCellStyle();
		cellStyle.setWrapText(true);

		try {
			out = new FileOutputStream("c:/smm-hamburg.xls");
			workbook.write(out);
			out.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// set common headers
	public static void setHeader(Connection conn) {
		conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		conn.header("Accept-Encoding", "gzip, deflate, sdch");
		conn.header("Accept-Language", "zh-CN,zh;q=0.8");
		conn.header("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36");
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

	public static void main(String[] arg) {
		run(arg);
	}
}