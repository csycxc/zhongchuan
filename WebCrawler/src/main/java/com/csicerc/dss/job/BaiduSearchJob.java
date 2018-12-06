package com.csicerc.dss.job;

import java.util.Date;  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.csicerc.dss.webcrawler.BaiDuSearch;

import org.quartz.JobExecutionContext;  
import org.quartz.JobExecutionException;  
  


/***
 * 
 * @author Haomeng, Wang
 *
 *  定义定时器任务BaiduSearchJob 
 *  该Job会被持久化并被Quarzt定时调用 
 */

public class BaiduSearchJob implements BaseJob {  
  
	@Autowired
	BaiDuSearch baiduSearch;
	
    private static Logger _log = LoggerFactory.getLogger(BaiduSearchJob.class);  
     
    public BaiduSearchJob() {  
          
    }  
     
    public void execute(JobExecutionContext context)  
        throws JobExecutionException {  
        _log.info("BaiduSearchJob start at : " + new Date());  
        baiduSearch.search();    
        _log.info("BaiduSearchJob end at : " + new Date());  
    }  
}  
