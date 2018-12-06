package com.csicerc.dss.domain;

import java.util.ArrayList;
import java.util.List;

public class CrslTableExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table crsl_table
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table crsl_table
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table crsl_table
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_table
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public CrslTableExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_table
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_table
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_table
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_table
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_table
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_table
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_table
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
     * This method corresponds to the database table crsl_table
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
     * This method corresponds to the database table crsl_table
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_table
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
     * This class corresponds to the database table crsl_table
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

        public Criteria andCrslTableIdIsNull() {
            addCriterion("crsl_table_id is null");
            return (Criteria) this;
        }

        public Criteria andCrslTableIdIsNotNull() {
            addCriterion("crsl_table_id is not null");
            return (Criteria) this;
        }

        public Criteria andCrslTableIdEqualTo(Integer value) {
            addCriterion("crsl_table_id =", value, "crslTableId");
            return (Criteria) this;
        }

        public Criteria andCrslTableIdNotEqualTo(Integer value) {
            addCriterion("crsl_table_id <>", value, "crslTableId");
            return (Criteria) this;
        }

        public Criteria andCrslTableIdGreaterThan(Integer value) {
            addCriterion("crsl_table_id >", value, "crslTableId");
            return (Criteria) this;
        }

        public Criteria andCrslTableIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("crsl_table_id >=", value, "crslTableId");
            return (Criteria) this;
        }

        public Criteria andCrslTableIdLessThan(Integer value) {
            addCriterion("crsl_table_id <", value, "crslTableId");
            return (Criteria) this;
        }

        public Criteria andCrslTableIdLessThanOrEqualTo(Integer value) {
            addCriterion("crsl_table_id <=", value, "crslTableId");
            return (Criteria) this;
        }

        public Criteria andCrslTableIdIn(List<Integer> values) {
            addCriterion("crsl_table_id in", values, "crslTableId");
            return (Criteria) this;
        }

        public Criteria andCrslTableIdNotIn(List<Integer> values) {
            addCriterion("crsl_table_id not in", values, "crslTableId");
            return (Criteria) this;
        }

        public Criteria andCrslTableIdBetween(Integer value1, Integer value2) {
            addCriterion("crsl_table_id between", value1, value2, "crslTableId");
            return (Criteria) this;
        }

        public Criteria andCrslTableIdNotBetween(Integer value1, Integer value2) {
            addCriterion("crsl_table_id not between", value1, value2, "crslTableId");
            return (Criteria) this;
        }

        public Criteria andCrslTableNameIsNull() {
            addCriterion("crsl_table_name is null");
            return (Criteria) this;
        }

        public Criteria andCrslTableNameIsNotNull() {
            addCriterion("crsl_table_name is not null");
            return (Criteria) this;
        }

        public Criteria andCrslTableNameEqualTo(String value) {
            addCriterion("crsl_table_name =", value, "crslTableName");
            return (Criteria) this;
        }

        public Criteria andCrslTableNameNotEqualTo(String value) {
            addCriterion("crsl_table_name <>", value, "crslTableName");
            return (Criteria) this;
        }

        public Criteria andCrslTableNameGreaterThan(String value) {
            addCriterion("crsl_table_name >", value, "crslTableName");
            return (Criteria) this;
        }

        public Criteria andCrslTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("crsl_table_name >=", value, "crslTableName");
            return (Criteria) this;
        }

        public Criteria andCrslTableNameLessThan(String value) {
            addCriterion("crsl_table_name <", value, "crslTableName");
            return (Criteria) this;
        }

        public Criteria andCrslTableNameLessThanOrEqualTo(String value) {
            addCriterion("crsl_table_name <=", value, "crslTableName");
            return (Criteria) this;
        }

        public Criteria andCrslTableNameLike(String value) {
            addCriterion("crsl_table_name like", value, "crslTableName");
            return (Criteria) this;
        }

        public Criteria andCrslTableNameNotLike(String value) {
            addCriterion("crsl_table_name not like", value, "crslTableName");
            return (Criteria) this;
        }

        public Criteria andCrslTableNameIn(List<String> values) {
            addCriterion("crsl_table_name in", values, "crslTableName");
            return (Criteria) this;
        }

        public Criteria andCrslTableNameNotIn(List<String> values) {
            addCriterion("crsl_table_name not in", values, "crslTableName");
            return (Criteria) this;
        }

        public Criteria andCrslTableNameBetween(String value1, String value2) {
            addCriterion("crsl_table_name between", value1, value2, "crslTableName");
            return (Criteria) this;
        }

        public Criteria andCrslTableNameNotBetween(String value1, String value2) {
            addCriterion("crsl_table_name not between", value1, value2, "crslTableName");
            return (Criteria) this;
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

        public Criteria andCrslTableCategoryIsNull() {
            addCriterion("crsl_table_category is null");
            return (Criteria) this;
        }

        public Criteria andCrslTableCategoryIsNotNull() {
            addCriterion("crsl_table_category is not null");
            return (Criteria) this;
        }

        public Criteria andCrslTableCategoryEqualTo(String value) {
            addCriterion("crsl_table_category =", value, "crslTableCategory");
            return (Criteria) this;
        }

        public Criteria andCrslTableCategoryNotEqualTo(String value) {
            addCriterion("crsl_table_category <>", value, "crslTableCategory");
            return (Criteria) this;
        }

        public Criteria andCrslTableCategoryGreaterThan(String value) {
            addCriterion("crsl_table_category >", value, "crslTableCategory");
            return (Criteria) this;
        }

        public Criteria andCrslTableCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("crsl_table_category >=", value, "crslTableCategory");
            return (Criteria) this;
        }

        public Criteria andCrslTableCategoryLessThan(String value) {
            addCriterion("crsl_table_category <", value, "crslTableCategory");
            return (Criteria) this;
        }

        public Criteria andCrslTableCategoryLessThanOrEqualTo(String value) {
            addCriterion("crsl_table_category <=", value, "crslTableCategory");
            return (Criteria) this;
        }

        public Criteria andCrslTableCategoryLike(String value) {
            addCriterion("crsl_table_category like", value, "crslTableCategory");
            return (Criteria) this;
        }

        public Criteria andCrslTableCategoryNotLike(String value) {
            addCriterion("crsl_table_category not like", value, "crslTableCategory");
            return (Criteria) this;
        }

        public Criteria andCrslTableCategoryIn(List<String> values) {
            addCriterion("crsl_table_category in", values, "crslTableCategory");
            return (Criteria) this;
        }

        public Criteria andCrslTableCategoryNotIn(List<String> values) {
            addCriterion("crsl_table_category not in", values, "crslTableCategory");
            return (Criteria) this;
        }

        public Criteria andCrslTableCategoryBetween(String value1, String value2) {
            addCriterion("crsl_table_category between", value1, value2, "crslTableCategory");
            return (Criteria) this;
        }

        public Criteria andCrslTableCategoryNotBetween(String value1, String value2) {
            addCriterion("crsl_table_category not between", value1, value2, "crslTableCategory");
            return (Criteria) this;
        }

        public Criteria andCrslTableStatusIsNull() {
            addCriterion("crsl_table_status is null");
            return (Criteria) this;
        }

        public Criteria andCrslTableStatusIsNotNull() {
            addCriterion("crsl_table_status is not null");
            return (Criteria) this;
        }

        public Criteria andCrslTableStatusEqualTo(Integer value) {
            addCriterion("crsl_table_status =", value, "crslTableStatus");
            return (Criteria) this;
        }

        public Criteria andCrslTableStatusNotEqualTo(Integer value) {
            addCriterion("crsl_table_status <>", value, "crslTableStatus");
            return (Criteria) this;
        }

        public Criteria andCrslTableStatusGreaterThan(Integer value) {
            addCriterion("crsl_table_status >", value, "crslTableStatus");
            return (Criteria) this;
        }

        public Criteria andCrslTableStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("crsl_table_status >=", value, "crslTableStatus");
            return (Criteria) this;
        }

        public Criteria andCrslTableStatusLessThan(Integer value) {
            addCriterion("crsl_table_status <", value, "crslTableStatus");
            return (Criteria) this;
        }

        public Criteria andCrslTableStatusLessThanOrEqualTo(Integer value) {
            addCriterion("crsl_table_status <=", value, "crslTableStatus");
            return (Criteria) this;
        }

        public Criteria andCrslTableStatusIn(List<Integer> values) {
            addCriterion("crsl_table_status in", values, "crslTableStatus");
            return (Criteria) this;
        }

        public Criteria andCrslTableStatusNotIn(List<Integer> values) {
            addCriterion("crsl_table_status not in", values, "crslTableStatus");
            return (Criteria) this;
        }

        public Criteria andCrslTableStatusBetween(Integer value1, Integer value2) {
            addCriterion("crsl_table_status between", value1, value2, "crslTableStatus");
            return (Criteria) this;
        }

        public Criteria andCrslTableStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("crsl_table_status not between", value1, value2, "crslTableStatus");
            return (Criteria) this;
        }

        public Criteria andCrslTableCodeIsNull() {
            addCriterion("crsl_table_code is null");
            return (Criteria) this;
        }

        public Criteria andCrslTableCodeIsNotNull() {
            addCriterion("crsl_table_code is not null");
            return (Criteria) this;
        }

        public Criteria andCrslTableCodeEqualTo(Integer value) {
            addCriterion("crsl_table_code =", value, "crslTableCode");
            return (Criteria) this;
        }

        public Criteria andCrslTableCodeNotEqualTo(Integer value) {
            addCriterion("crsl_table_code <>", value, "crslTableCode");
            return (Criteria) this;
        }

        public Criteria andCrslTableCodeGreaterThan(Integer value) {
            addCriterion("crsl_table_code >", value, "crslTableCode");
            return (Criteria) this;
        }

        public Criteria andCrslTableCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("crsl_table_code >=", value, "crslTableCode");
            return (Criteria) this;
        }

        public Criteria andCrslTableCodeLessThan(Integer value) {
            addCriterion("crsl_table_code <", value, "crslTableCode");
            return (Criteria) this;
        }

        public Criteria andCrslTableCodeLessThanOrEqualTo(Integer value) {
            addCriterion("crsl_table_code <=", value, "crslTableCode");
            return (Criteria) this;
        }

        public Criteria andCrslTableCodeIn(List<Integer> values) {
            addCriterion("crsl_table_code in", values, "crslTableCode");
            return (Criteria) this;
        }

        public Criteria andCrslTableCodeNotIn(List<Integer> values) {
            addCriterion("crsl_table_code not in", values, "crslTableCode");
            return (Criteria) this;
        }

        public Criteria andCrslTableCodeBetween(Integer value1, Integer value2) {
            addCriterion("crsl_table_code between", value1, value2, "crslTableCode");
            return (Criteria) this;
        }

        public Criteria andCrslTableCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("crsl_table_code not between", value1, value2, "crslTableCode");
            return (Criteria) this;
        }

        public Criteria andCrslTableUriIsNull() {
            addCriterion("crsl_table_uri is null");
            return (Criteria) this;
        }

        public Criteria andCrslTableUriIsNotNull() {
            addCriterion("crsl_table_uri is not null");
            return (Criteria) this;
        }

        public Criteria andCrslTableUriEqualTo(String value) {
            addCriterion("crsl_table_uri =", value, "crslTableUri");
            return (Criteria) this;
        }

        public Criteria andCrslTableUriNotEqualTo(String value) {
            addCriterion("crsl_table_uri <>", value, "crslTableUri");
            return (Criteria) this;
        }

        public Criteria andCrslTableUriGreaterThan(String value) {
            addCriterion("crsl_table_uri >", value, "crslTableUri");
            return (Criteria) this;
        }

        public Criteria andCrslTableUriGreaterThanOrEqualTo(String value) {
            addCriterion("crsl_table_uri >=", value, "crslTableUri");
            return (Criteria) this;
        }

        public Criteria andCrslTableUriLessThan(String value) {
            addCriterion("crsl_table_uri <", value, "crslTableUri");
            return (Criteria) this;
        }

        public Criteria andCrslTableUriLessThanOrEqualTo(String value) {
            addCriterion("crsl_table_uri <=", value, "crslTableUri");
            return (Criteria) this;
        }

        public Criteria andCrslTableUriLike(String value) {
            addCriterion("crsl_table_uri like", value, "crslTableUri");
            return (Criteria) this;
        }

        public Criteria andCrslTableUriNotLike(String value) {
            addCriterion("crsl_table_uri not like", value, "crslTableUri");
            return (Criteria) this;
        }

        public Criteria andCrslTableUriIn(List<String> values) {
            addCriterion("crsl_table_uri in", values, "crslTableUri");
            return (Criteria) this;
        }

        public Criteria andCrslTableUriNotIn(List<String> values) {
            addCriterion("crsl_table_uri not in", values, "crslTableUri");
            return (Criteria) this;
        }

        public Criteria andCrslTableUriBetween(String value1, String value2) {
            addCriterion("crsl_table_uri between", value1, value2, "crslTableUri");
            return (Criteria) this;
        }

        public Criteria andCrslTableUriNotBetween(String value1, String value2) {
            addCriterion("crsl_table_uri not between", value1, value2, "crslTableUri");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table crsl_table
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
     * This class corresponds to the database table crsl_table
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