package com.csicerc.dss.webcrawler;

import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.CellStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csicerc.dss.service.WebCrawlerService;

/***
 * 
 * @author Haomeng, Wang Excel 工具类
 *
 */

@Component
public class ExcelExport {

	@Autowired
	private WebCrawlerService webCrawlerService;

	private static Logger log = LoggerFactory.getLogger(ExcelExport.class);

	public static boolean isExcel2003(String filePath) {
		return filePath.matches("^.+\\.(?i)(xls)$");
	}

	public static boolean isExcel2007(String filePath) {
		return filePath.matches("^.+\\.(?i)(xlsx)$");
	}

	
	/**
	 * 
	 * @param path       导出excel目录和文件有
	 * @param recentDays 导出最近几天内的记录
	 */
	public void exportBaiduArticlesToExcelByArticleIDRange(String path, int articleIDFrom, int articleIDTo) {

		FileOutputStream out;

		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet1 = workbook.createSheet("baidu");

		sheet1.setColumnWidth(0, 10 * 256); // 来源 网站
		sheet1.setColumnWidth(1, 10 * 256); // 关键字
		sheet1.setColumnWidth(2, 20 * 256); // 发布时间
		sheet1.setColumnWidth(3, 60 * 256); // 标题
		sheet1.setColumnWidth(4, 30 * 256); // 链接
		sheet1.setColumnWidth(5, 100 * 256); // 摘要
		

		List<HashMap> articleList = webCrawlerService.selectArticlesByArticleIdRange(articleIDFrom,  articleIDTo);

		log.info("articlelist.size:" + articleList.size());
		//System.exit(0);

		for (int i = 0; i < articleList.size(); i++) {

			log.info("writing rows: " + i);
			HSSFRow row = sheet1.createRow(i);
			baiduArticlesCellPopulate(row, (HashMap) articleList.get(i));

		}

		try {
			out = new FileOutputStream(path);
			workbook.write(out);
			out.close();
		} catch (Exception e) {
			log.error("Write file error:" + e.getMessage());
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * @param path       导出excel目录和文件有
	 * @param recentDays 导出最近几天内的记录
	 */
	public void exportBaiduArticlesToExcel(String path, int recentDays) {

		FileOutputStream out;

		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet1 = workbook.createSheet("baidu");

		sheet1.setColumnWidth(0, 10 * 256); // 来源 网站
		sheet1.setColumnWidth(1, 10 * 256); // 关键字
		sheet1.setColumnWidth(2, 20 * 256); // 发布时间
		sheet1.setColumnWidth(3, 60 * 256); // 标题
		sheet1.setColumnWidth(4, 30 * 256); // 链接
		sheet1.setColumnWidth(5, 100 * 256); // 摘要

		Calendar recentDay = Calendar.getInstance();
		recentDay.add(Calendar.DATE, -1 * recentDays);

		List<HashMap> articleList = webCrawlerService.selectArticlesByWebIDandDate(-1, recentDay.getTime());

		log.info("articlelist.size:" + articleList.size());
		//System.exit(0);

		for (int i = 0; i < articleList.size(); i++) {

			log.info("writing rows: " + i);
			HSSFRow row = sheet1.createRow(i);
			baiduArticlesCellPopulate(row, (HashMap) articleList.get(i));

		}

		try {
			out = new FileOutputStream(path);
			workbook.write(out);
			out.close();
		} catch (Exception e) {
			log.error("Write file error:" + e.getMessage());
			e.printStackTrace();
		}

	}

	public void exportOtherArticlesToExcel(String path, int recentDays) {

		FileOutputStream out;

		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet1 = workbook.createSheet("other");

		sheet1.setColumnWidth(0, 10 * 256); // 来源 网站
		sheet1.setColumnWidth(1, 10 * 256); // 栏目
		sheet1.setColumnWidth(2, 20 * 256); // 发布时间
		sheet1.setColumnWidth(3, 50 * 256); // 标题
		sheet1.setColumnWidth(4, 30 * 256); // 链接
		sheet1.setColumnWidth(5, 130 * 256); // 正文

		Calendar recentDay = Calendar.getInstance();
		recentDay.add(Calendar.DATE, -1 * recentDays);

		List<HashMap> articleList = webCrawlerService.selectArticlesByWebIDRangeAndDate(0, 1000, recentDay.getTime()); // excluding
																														// baidu

		log.info("articlelist.size:" + articleList.size());

		for (int i = 0; i < articleList.size(); i++) {

			log.info("writing rows: " + i);
			HSSFRow row = sheet1.createRow(i);
			otherArticlesCellPopulate(row, (HashMap) articleList.get(i));

		}

		try {
			out = new FileOutputStream(path);
			workbook.write(out);
			out.close();
		} catch (Exception e) {
			log.error("Write file error:" + e.getMessage());
			e.printStackTrace();
		}

	}

	public void baiduArticlesCellPopulate(HSSFRow row, HashMap article) {
		HSSFCell cell0 = row.createCell(0);
		cell0.setCellValue(article.get("web_name").toString());
		CellStyle cellStyle = cell0.getCellStyle();
		cellStyle.setWrapText(true);
		// cellStyle.setVerticalAlignment(VerticalAlignment.TOP);

		HSSFCell cell1 = row.createCell(1);
		cell1.setCellValue(article.get("article_search_by_keyword").toString());
		cellStyle = cell1.getCellStyle();
		cellStyle.setWrapText(true);

		HSSFCell cell2 = row.createCell(2);
		cell2.setCellValue(article.get("article_date").toString());
		cellStyle = cell2.getCellStyle();
		cellStyle.setWrapText(true);

		HSSFCell cell3 = row.createCell(3);
		cell3.setCellValue(article.get("article_title").toString());
		cellStyle = cell3.getCellStyle();
		cellStyle.setWrapText(true);

		HSSFCell cell4 = row.createCell(4);
		cell4.setCellValue(article.get("article_link").toString());
		cellStyle = cell4.getCellStyle();
		cellStyle.setWrapText(true);

		HSSFCell cell5 = row.createCell(5);
		cell5.setCellValue(article.get("article_abstract").toString());
		cellStyle = cell5.getCellStyle();
		cellStyle.setWrapText(true);

	}

	public void otherArticlesCellPopulate(HSSFRow row, HashMap article) {
		HSSFCell cell0 = row.createCell(0);
		cell0.setCellValue(article.get("web_name").toString());
		CellStyle cellStyle = cell0.getCellStyle();
		cellStyle.setWrapText(true);
		// cellStyle.setVerticalAlignment(HSSFCellStyle);

		HSSFCell cell1 = row.createCell(1);
		cell1.setCellValue(article.get("web_url_name").toString());
		cellStyle = cell1.getCellStyle();
		cellStyle.setWrapText(true);

		HSSFCell cell2 = row.createCell(2);
		cell2.setCellValue(article.get("article_date").toString());
		cellStyle = cell2.getCellStyle();
		cellStyle.setWrapText(true);

		HSSFCell cell3 = row.createCell(3);
		cell3.setCellValue(article.get("article_title").toString());
		cellStyle = cell3.getCellStyle();
		cellStyle.setWrapText(true);

		HSSFCell cell4 = row.createCell(4);
		cell4.setCellValue(article.get("article_link").toString());
		cellStyle = cell4.getCellStyle();
		cellStyle.setWrapText(true);

		HSSFCell cell5 = row.createCell(5);
		cell5.setCellValue(article.get("article_content").toString());
		cellStyle = cell5.getCellStyle();
		cellStyle.setWrapText(true);
	}

	public static void main(String[] args) {
		// exportArticlesToExcel("");
	}
}
