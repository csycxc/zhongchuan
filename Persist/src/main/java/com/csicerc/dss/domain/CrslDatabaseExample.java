package com.csicerc.dss.domain;

import java.util.ArrayList;
import java.util.List;

public class CrslDatabaseExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table crsl_database
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table crsl_database
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table crsl_database
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_database
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public CrslDatabaseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_database
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_database
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_database
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_database
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_database
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_database
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_database
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
     * This method corresponds to the database table crsl_database
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
     * This method corresponds to the database table crsl_database
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_database
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
     * This class corresponds to the database table crsl_database
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

        public Criteria andCrslDatabaseIdIsNull() {
            addCriterion("crsl_database_id is null");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseIdIsNotNull() {
            addCriterion("crsl_database_id is not null");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseIdEqualTo(Integer value) {
            addCriterion("crsl_database_id =", value, "crslDatabaseId");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseIdNotEqualTo(Integer value) {
            addCriterion("crsl_database_id <>", value, "crslDatabaseId");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseIdGreaterThan(Integer value) {
            addCriterion("crsl_database_id >", value, "crslDatabaseId");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("crsl_database_id >=", value, "crslDatabaseId");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseIdLessThan(Integer value) {
            addCriterion("crsl_database_id <", value, "crslDatabaseId");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseIdLessThanOrEqualTo(Integer value) {
            addCriterion("crsl_database_id <=", value, "crslDatabaseId");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseIdIn(List<Integer> values) {
            addCriterion("crsl_database_id in", values, "crslDatabaseId");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseIdNotIn(List<Integer> values) {
            addCriterion("crsl_database_id not in", values, "crslDatabaseId");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseIdBetween(Integer value1, Integer value2) {
            addCriterion("crsl_database_id between", value1, value2, "crslDatabaseId");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("crsl_database_id not between", value1, value2, "crslDatabaseId");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameIsNull() {
            addCriterion("crsl_database_name is null");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameIsNotNull() {
            addCriterion("crsl_database_name is not null");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameEqualTo(String value) {
            addCriterion("crsl_database_name =", value, "crslDatabaseName");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameNotEqualTo(String value) {
            addCriterion("crsl_database_name <>", value, "crslDatabaseName");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameGreaterThan(String value) {
            addCriterion("crsl_database_name >", value, "crslDatabaseName");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameGreaterThanOrEqualTo(String value) {
            addCriterion("crsl_database_name >=", value, "crslDatabaseName");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameLessThan(String value) {
            addCriterion("crsl_database_name <", value, "crslDatabaseName");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameLessThanOrEqualTo(String value) {
            addCriterion("crsl_database_name <=", value, "crslDatabaseName");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameLike(String value) {
            addCriterion("crsl_database_name like", value, "crslDatabaseName");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameNotLike(String value) {
            addCriterion("crsl_database_name not like", value, "crslDatabaseName");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameIn(List<String> values) {
            addCriterion("crsl_database_name in", values, "crslDatabaseName");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameNotIn(List<String> values) {
            addCriterion("crsl_database_name not in", values, "crslDatabaseName");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameBetween(String value1, String value2) {
            addCriterion("crsl_database_name between", value1, value2, "crslDatabaseName");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameNotBetween(String value1, String value2) {
            addCriterion("crsl_database_name not between", value1, value2, "crslDatabaseName");
            return (Criteria) this;
        }

        public Criteria andCrslSessionIdIsNull() {
            addCriterion("crsl_session_id is null");
            return (Criteria) this;
        }

        public Criteria andCrslSessionIdIsNotNull() {
            addCriterion("crsl_session_id is not null");
            return (Criteria) this;
        }

        public Criteria andCrslSessionIdEqualTo(Integer value) {
            addCriterion("crsl_session_id =", value, "crslSessionId");
            return (Criteria) this;
        }

        public Criteria andCrslSessionIdNotEqualTo(Integer value) {
            addCriterion("crsl_session_id <>", value, "crslSessionId");
            return (Criteria) this;
        }

        public Criteria andCrslSessionIdGreaterThan(Integer value) {
            addCriterion("crsl_session_id >", value, "crslSessionId");
            return (Criteria) this;
        }

        public Criteria andCrslSessionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("crsl_session_id >=", value, "crslSessionId");
            return (Criteria) this;
        }

        public Criteria andCrslSessionIdLessThan(Integer value) {
            addCriterion("crsl_session_id <", value, "crslSessionId");
            return (Criteria) this;
        }

        public Criteria andCrslSessionIdLessThanOrEqualTo(Integer value) {
            addCriterion("crsl_session_id <=", value, "crslSessionId");
            return (Criteria) this;
        }

        public Criteria andCrslSessionIdIn(List<Integer> values) {
            addCriterion("crsl_session_id in", values, "crslSessionId");
            return (Criteria) this;
        }

        public Criteria andCrslSessionIdNotIn(List<Integer> values) {
            addCriterion("crsl_session_id not in", values, "crslSessionId");
            return (Criteria) this;
        }

        public Criteria andCrslSessionIdBetween(Integer value1, Integer value2) {
            addCriterion("crsl_session_id between", value1, value2, "crslSessionId");
            return (Criteria) this;
        }

        public Criteria andCrslSessionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("crsl_session_id not between", value1, value2, "crslSessionId");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameCnIsNull() {
            addCriterion("crsl_database_name_cn is null");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameCnIsNotNull() {
            addCriterion("crsl_database_name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameCnEqualTo(String value) {
            addCriterion("crsl_database_name_cn =", value, "crslDatabaseNameCn");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameCnNotEqualTo(String value) {
            addCriterion("crsl_database_name_cn <>", value, "crslDatabaseNameCn");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameCnGreaterThan(String value) {
            addCriterion("crsl_database_name_cn >", value, "crslDatabaseNameCn");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("crsl_database_name_cn >=", value, "crslDatabaseNameCn");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameCnLessThan(String value) {
            addCriterion("crsl_database_name_cn <", value, "crslDatabaseNameCn");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameCnLessThanOrEqualTo(String value) {
            addCriterion("crsl_database_name_cn <=", value, "crslDatabaseNameCn");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameCnLike(String value) {
            addCriterion("crsl_database_name_cn like", value, "crslDatabaseNameCn");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameCnNotLike(String value) {
            addCriterion("crsl_database_name_cn not like", value, "crslDatabaseNameCn");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameCnIn(List<String> values) {
            addCriterion("crsl_database_name_cn in", values, "crslDatabaseNameCn");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameCnNotIn(List<String> values) {
            addCriterion("crsl_database_name_cn not in", values, "crslDatabaseNameCn");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameCnBetween(String value1, String value2) {
            addCriterion("crsl_database_name_cn between", value1, value2, "crslDatabaseNameCn");
            return (Criteria) this;
        }

        public Criteria andCrslDatabaseNameCnNotBetween(String value1, String value2) {
            addCriterion("crsl_database_name_cn not between", value1, value2, "crslDatabaseNameCn");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table crsl_database
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
     * This class corresponds to the database table crsl_database
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