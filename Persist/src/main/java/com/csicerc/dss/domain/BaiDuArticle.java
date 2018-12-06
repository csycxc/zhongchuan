package com.csicerc.dss.domain;
/**
 * 百度学术下载
 * @author Administrator
 *
 */
public class BaiDuArticle {
	private String searchWord;//搜索的关键字
	private String title;//文献名（即文章标题）
	private String digest;//摘要
	private String author;//作者名
	private String periodical;//期刊
	private String years;//年代
	private String citations;//引用量
	
	private String type;//文献类型；
	private String typeNum;// 类型对应 的数字。因为url中是用的数字，所以多加一个属性；下面的关键词和机构是直接用的字符串。
	
	private String keyWord;//关键词
	
	private String organization;//机构
	
	private String ArticleUrl;
	
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPeriodical() {
		return periodical;
	}
	public void setPeriodical(String periodical) {
		this.periodical = periodical;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public String getCitations() {
		return citations;
	}
	public void setCitations(String citations) {
		this.citations = citations;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeNum() {
		return typeNum;
	}
	public void setTypeNum(String typeNum) {
		this.typeNum = typeNum;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getArticleUrl() {
		return ArticleUrl;
	}
	public void setArticleUrl(String articleUrl) {
		ArticleUrl = articleUrl;
	}
	@Override
	public String toString() {
		return "BaiDuArticle [searchWord=" + searchWord + ", title=" + title + ", digest=" + digest + ", author="
				+ author + ", periodical=" + periodical + ", years=" + years + ", citations=" + citations + ", type="
				+ type + ", typeNum=" + typeNum + ", keyWord=" + keyWord + ", organization=" + organization
				+ ", ArticleUrl=" + ArticleUrl + "]";
	}
	
	
	
	
	
}
