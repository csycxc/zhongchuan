package com.csicerc.dss.job;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.csicerc.dss.webcrawler.BaiDuSearch;
import com.csicerc.dss.webcrawler.ExcelExport;

public class ExportExcelJob implements BaseJob {  
	
	@Autowired
	ExcelExport excelExport;
	
    private static Logger _log = LoggerFactory.getLogger(BaiduSearchJob.class);  
     
    public ExportExcelJob() {  
          
    }  
     
    public void execute(JobExecutionContext context)  
        throws JobExecutionException {  
        _log.info("BaiduSearchJob start at : " + new Date());  
        DateFormat format2 = new SimpleDateFormat("yyyyMMddhhmmss");
        String s = format2.format(new Date());
        excelExport.exportBaiduArticlesToExcel("c:/baidu_" + s + ".xls", 1);
        excelExport.exportOtherArticlesToExcel("c:/other_" + s + ".xls", 1);
        _log.info("BaiduSearchJob end at : " + new Date());  
    }  

}
