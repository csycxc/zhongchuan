package com.csicerc.dss.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ArticleExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table article
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table article
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table article
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public ArticleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table article
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table article
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(Integer value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(Integer value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(Integer value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(Integer value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(Integer value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<Integer> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<Integer> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(Integer value1, Integer value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleSourceIsNull() {
            addCriterion("article_source is null");
            return (Criteria) this;
        }

        public Criteria andArticleSourceIsNotNull() {
            addCriterion("article_source is not null");
            return (Criteria) this;
        }

        public Criteria andArticleSourceEqualTo(String value) {
            addCriterion("article_source =", value, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceNotEqualTo(String value) {
            addCriterion("article_source <>", value, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceGreaterThan(String value) {
            addCriterion("article_source >", value, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceGreaterThanOrEqualTo(String value) {
            addCriterion("article_source >=", value, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceLessThan(String value) {
            addCriterion("article_source <", value, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceLessThanOrEqualTo(String value) {
            addCriterion("article_source <=", value, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceLike(String value) {
            addCriterion("article_source like", value, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceNotLike(String value) {
            addCriterion("article_source not like", value, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceIn(List<String> values) {
            addCriterion("article_source in", values, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceNotIn(List<String> values) {
            addCriterion("article_source not in", values, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceBetween(String value1, String value2) {
            addCriterion("article_source between", value1, value2, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleSourceNotBetween(String value1, String value2) {
            addCriterion("article_source not between", value1, value2, "articleSource");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorIsNull() {
            addCriterion("article_author is null");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorIsNotNull() {
            addCriterion("article_author is not null");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorEqualTo(String value) {
            addCriterion("article_author =", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorNotEqualTo(String value) {
            addCriterion("article_author <>", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorGreaterThan(String value) {
            addCriterion("article_author >", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("article_author >=", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorLessThan(String value) {
            addCriterion("article_author <", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorLessThanOrEqualTo(String value) {
            addCriterion("article_author <=", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorLike(String value) {
            addCriterion("article_author like", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorNotLike(String value) {
            addCriterion("article_author not like", value, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorIn(List<String> values) {
            addCriterion("article_author in", values, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorNotIn(List<String> values) {
            addCriterion("article_author not in", values, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorBetween(String value1, String value2) {
            addCriterion("article_author between", value1, value2, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleAuthorNotBetween(String value1, String value2) {
            addCriterion("article_author not between", value1, value2, "articleAuthor");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNull() {
            addCriterion("article_title is null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNotNull() {
            addCriterion("article_title is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleEqualTo(String value) {
            addCriterion("article_title =", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotEqualTo(String value) {
            addCriterion("article_title <>", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThan(String value) {
            addCriterion("article_title >", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThanOrEqualTo(String value) {
            addCriterion("article_title >=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThan(String value) {
            addCriterion("article_title <", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThanOrEqualTo(String value) {
            addCriterion("article_title <=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLike(String value) {
            addCriterion("article_title like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotLike(String value) {
            addCriterion("article_title not like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIn(List<String> values) {
            addCriterion("article_title in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotIn(List<String> values) {
            addCriterion("article_title not in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleBetween(String value1, String value2) {
            addCriterion("article_title between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotBetween(String value1, String value2) {
            addCriterion("article_title not between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleDateIsNull() {
            addCriterion("article_date is null");
            return (Criteria) this;
        }

        public Criteria andArticleDateIsNotNull() {
            addCriterion("article_date is not null");
            return (Criteria) this;
        }

        public Criteria andArticleDateEqualTo(Date value) {
            addCriterionForJDBCDate("article_date =", value, "articleDate");
            return (Criteria) this;
        }

        public Criteria andArticleDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("article_date <>", value, "articleDate");
            return (Criteria) this;
        }

        public Criteria andArticleDateGreaterThan(Date value) {
            addCriterionForJDBCDate("article_date >", value, "articleDate");
            return (Criteria) this;
        }

        public Criteria andArticleDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("article_date >=", value, "articleDate");
            return (Criteria) this;
        }

        public Criteria andArticleDateLessThan(Date value) {
            addCriterionForJDBCDate("article_date <", value, "articleDate");
            return (Criteria) this;
        }

        public Criteria andArticleDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("article_date <=", value, "articleDate");
            return (Criteria) this;
        }

        public Criteria andArticleDateIn(List<Date> values) {
            addCriterionForJDBCDate("article_date in", values, "articleDate");
            return (Criteria) this;
        }

        public Criteria andArticleDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("article_date not in", values, "articleDate");
            return (Criteria) this;
        }

        public Criteria andArticleDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("article_date between", value1, value2, "articleDate");
            return (Criteria) this;
        }

        public Criteria andArticleDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("article_date not between", value1, value2, "articleDate");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIsNull() {
            addCriterion("article_status is null");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIsNotNull() {
            addCriterion("article_status is not null");
            return (Criteria) this;
        }

        public Criteria andArticleStatusEqualTo(String value) {
            addCriterion("article_status =", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotEqualTo(String value) {
            addCriterion("article_status <>", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusGreaterThan(String value) {
            addCriterion("article_status >", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusGreaterThanOrEqualTo(String value) {
            addCriterion("article_status >=", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusLessThan(String value) {
            addCriterion("article_status <", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusLessThanOrEqualTo(String value) {
            addCriterion("article_status <=", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusLike(String value) {
            addCriterion("article_status like", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotLike(String value) {
            addCriterion("article_status not like", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIn(List<String> values) {
            addCriterion("article_status in", values, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotIn(List<String> values) {
            addCriterion("article_status not in", values, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusBetween(String value1, String value2) {
            addCriterion("article_status between", value1, value2, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotBetween(String value1, String value2) {
            addCriterion("article_status not between", value1, value2, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andWebIdIsNull() {
            addCriterion("web_id is null");
            return (Criteria) this;
        }

        public Criteria andWebIdIsNotNull() {
            addCriterion("web_id is not null");
            return (Criteria) this;
        }

        public Criteria andWebIdEqualTo(Integer value) {
            addCriterion("web_id =", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdNotEqualTo(Integer value) {
            addCriterion("web_id <>", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdGreaterThan(Integer value) {
            addCriterion("web_id >", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("web_id >=", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdLessThan(Integer value) {
            addCriterion("web_id <", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdLessThanOrEqualTo(Integer value) {
            addCriterion("web_id <=", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdIn(List<Integer> values) {
            addCriterion("web_id in", values, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdNotIn(List<Integer> values) {
            addCriterion("web_id not in", values, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdBetween(Integer value1, Integer value2) {
            addCriterion("web_id between", value1, value2, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdNotBetween(Integer value1, Integer value2) {
            addCriterion("web_id not between", value1, value2, "webId");
            return (Criteria) this;
        }

        public Criteria andArticleFindByKeywordIsNull() {
            addCriterion("article_find_by_keyword is null");
            return (Criteria) this;
        }

        public Criteria andArticleFindByKeywordIsNotNull() {
            addCriterion("article_find_by_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andArticleFindByKeywordEqualTo(String value) {
            addCriterion("article_find_by_keyword =", value, "articleFindByKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleFindByKeywordNotEqualTo(String value) {
            addCriterion("article_find_by_keyword <>", value, "articleFindByKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleFindByKeywordGreaterThan(String value) {
            addCriterion("article_find_by_keyword >", value, "articleFindByKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleFindByKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("article_find_by_keyword >=", value, "articleFindByKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleFindByKeywordLessThan(String value) {
            addCriterion("article_find_by_keyword <", value, "articleFindByKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleFindByKeywordLessThanOrEqualTo(String value) {
            addCriterion("article_find_by_keyword <=", value, "articleFindByKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleFindByKeywordLike(String value) {
            addCriterion("article_find_by_keyword like", value, "articleFindByKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleFindByKeywordNotLike(String value) {
            addCriterion("article_find_by_keyword not like", value, "articleFindByKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleFindByKeywordIn(List<String> values) {
            addCriterion("article_find_by_keyword in", values, "articleFindByKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleFindByKeywordNotIn(List<String> values) {
            addCriterion("article_find_by_keyword not in", values, "articleFindByKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleFindByKeywordBetween(String value1, String value2) {
            addCriterion("article_find_by_keyword between", value1, value2, "articleFindByKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleFindByKeywordNotBetween(String value1, String value2) {
            addCriterion("article_find_by_keyword not between", value1, value2, "articleFindByKeyword");
            return (Criteria) this;
        }

        public Criteria andArticleDownloadDateIsNull() {
            addCriterion("article_download_date is null");
            return (Criteria) this;
        }

        public Criteria andArticleDownloadDateIsNotNull() {
            addCriterion("article_download_date is not null");
            return (Criteria) this;
        }

        public Criteria andArticleDownloadDateEqualTo(Date value) {
            addCriterionForJDBCDate("article_download_date =", value, "articleDownloadDate");
            return (Criteria) this;
        }

        public Criteria andArticleDownloadDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("article_download_date <>", value, "articleDownloadDate");
            return (Criteria) this;
        }

        public Criteria andArticleDownloadDateGreaterThan(Date value) {
            addCriterionForJDBCDate("article_download_date >", value, "articleDownloadDate");
            return (Criteria) this;
        }

        public Criteria andArticleDownloadDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("article_download_date >=", value, "articleDownloadDate");
            return (Criteria) this;
        }

        public Criteria andArticleDownloadDateLessThan(Date value) {
            addCriterionForJDBCDate("article_download_date <", value, "articleDownloadDate");
            return (Criteria) this;
        }

        public Criteria andArticleDownloadDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("article_download_date <=", value, "articleDownloadDate");
            return (Criteria) this;
        }

        public Criteria andArticleDownloadDateIn(List<Date> values) {
            addCriterionForJDBCDate("article_download_date in", values, "articleDownloadDate");
            return (Criteria) this;
        }

        public Criteria andArticleDownloadDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("article_download_date not in", values, "articleDownloadDate");
            return (Criteria) this;
        }

        public Criteria andArticleDownloadDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("article_download_date between", value1, value2, "articleDownloadDate");
            return (Criteria) this;
        }

        public Criteria andArticleDownloadDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("article_download_date not between", value1, value2, "articleDownloadDate");
            return (Criteria) this;
        }

        public Criteria andArticleReferenceUrlIsNull() {
            addCriterion("article_reference_url is null");
            return (Criteria) this;
        }

        public Criteria andArticleReferenceUrlIsNotNull() {
            addCriterion("article_reference_url is not null");
            return (Criteria) this;
        }

        public Criteria andArticleReferenceUrlEqualTo(String value) {
            addCriterion("article_reference_url =", value, "articleReferenceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleReferenceUrlNotEqualTo(String value) {
            addCriterion("article_reference_url <>", value, "articleReferenceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleReferenceUrlGreaterThan(String value) {
            addCriterion("article_reference_url >", value, "articleReferenceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleReferenceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("article_reference_url >=", value, "articleReferenceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleReferenceUrlLessThan(String value) {
            addCriterion("article_reference_url <", value, "articleReferenceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleReferenceUrlLessThanOrEqualTo(String value) {
            addCriterion("article_reference_url <=", value, "articleReferenceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleReferenceUrlLike(String value) {
            addCriterion("article_reference_url like", value, "articleReferenceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleReferenceUrlNotLike(String value) {
            addCriterion("article_reference_url not like", value, "articleReferenceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleReferenceUrlIn(List<String> values) {
            addCriterion("article_reference_url in", values, "articleReferenceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleReferenceUrlNotIn(List<String> values) {
            addCriterion("article_reference_url not in", values, "articleReferenceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleReferenceUrlBetween(String value1, String value2) {
            addCriterion("article_reference_url between", value1, value2, "articleReferenceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleReferenceUrlNotBetween(String value1, String value2) {
            addCriterion("article_reference_url not between", value1, value2, "articleReferenceUrl");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table article
     *
     * @mbg.generated do_not_delete_during_merge Thu Jul 19 10:33:09 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table article
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}