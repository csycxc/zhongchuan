package com.csicerc.dss.webcrawler;

import java.io.InputStream;
import java.net.URL;

import org.xml.sax.InputSource;

import de.l3s.boilerpipe.document.TextDocument;
import de.l3s.boilerpipe.sax.BoilerpipeSAXInput;


/***
 * 
 * @author Haomeng, Wang
 *
 *  Boilerpipe Article Extractor 算法封装(对于复杂中文网站，抓取的很不准确，暂时没有使用）
 *  
 */


public class Boilerpipe {
	
	/***
	 * 
	 * @param articleURL 文章URL
	 * @return 文章正文
	 * @throws Exception
	 */
	public static String getArticleContent(String articleURL) throws Exception
	{
		URL url;
        url = new URL(articleURL);
               
        final InputStream urlStream = url.openStream();
        final InputSource is = new InputSource(urlStream);

        final BoilerpipeSAXInput in = new BoilerpipeSAXInput(is);
        final TextDocument doc = in.getTextDocument();
        urlStream.close();        
        return doc.getTitle();        
	}

}
