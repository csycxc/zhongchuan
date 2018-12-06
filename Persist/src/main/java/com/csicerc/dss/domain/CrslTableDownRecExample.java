package com.csicerc.dss.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrslTableDownRecExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table crsl_table_down_rec
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table crsl_table_down_rec
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table crsl_table_down_rec
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_table_down_rec
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public CrslTableDownRecExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_table_down_rec
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_table_down_rec
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_table_down_rec
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_table_down_rec
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_table_down_rec
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_table_down_rec
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_table_down_rec
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
     * This method corresponds to the database table crsl_table_down_rec
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
     * This method corresponds to the database table crsl_table_down_rec
     *
     * @mbg.generated Thu Jul 19 10:33:09 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crsl_table_down_rec
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
     * This class corresponds to the database table crsl_table_down_rec
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

        public Criteria andCrslTableDownRecIdIsNull() {
            addCriterion("crsl_table_down_rec_id is null");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecIdIsNotNull() {
            addCriterion("crsl_table_down_rec_id is not null");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecIdEqualTo(Integer value) {
            addCriterion("crsl_table_down_rec_id =", value, "crslTableDownRecId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecIdNotEqualTo(Integer value) {
            addCriterion("crsl_table_down_rec_id <>", value, "crslTableDownRecId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecIdGreaterThan(Integer value) {
            addCriterion("crsl_table_down_rec_id >", value, "crslTableDownRecId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("crsl_table_down_rec_id >=", value, "crslTableDownRecId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecIdLessThan(Integer value) {
            addCriterion("crsl_table_down_rec_id <", value, "crslTableDownRecId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecIdLessThanOrEqualTo(Integer value) {
            addCriterion("crsl_table_down_rec_id <=", value, "crslTableDownRecId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecIdIn(List<Integer> values) {
            addCriterion("crsl_table_down_rec_id in", values, "crslTableDownRecId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecIdNotIn(List<Integer> values) {
            addCriterion("crsl_table_down_rec_id not in", values, "crslTableDownRecId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecIdBetween(Integer value1, Integer value2) {
            addCriterion("crsl_table_down_rec_id between", value1, value2, "crslTableDownRecId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecIdNotBetween(Integer value1, Integer value2) {
            addCriterion("crsl_table_down_rec_id not between", value1, value2, "crslTableDownRecId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStartIsNull() {
            addCriterion("crsl_table_down_start is null");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStartIsNotNull() {
            addCriterion("crsl_table_down_start is not null");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStartEqualTo(Date value) {
            addCriterion("crsl_table_down_start =", value, "crslTableDownStart");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStartNotEqualTo(Date value) {
            addCriterion("crsl_table_down_start <>", value, "crslTableDownStart");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStartGreaterThan(Date value) {
            addCriterion("crsl_table_down_start >", value, "crslTableDownStart");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStartGreaterThanOrEqualTo(Date value) {
            addCriterion("crsl_table_down_start >=", value, "crslTableDownStart");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStartLessThan(Date value) {
            addCriterion("crsl_table_down_start <", value, "crslTableDownStart");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStartLessThanOrEqualTo(Date value) {
            addCriterion("crsl_table_down_start <=", value, "crslTableDownStart");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStartIn(List<Date> values) {
            addCriterion("crsl_table_down_start in", values, "crslTableDownStart");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStartNotIn(List<Date> values) {
            addCriterion("crsl_table_down_start not in", values, "crslTableDownStart");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStartBetween(Date value1, Date value2) {
            addCriterion("crsl_table_down_start between", value1, value2, "crslTableDownStart");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStartNotBetween(Date value1, Date value2) {
            addCriterion("crsl_table_down_start not between", value1, value2, "crslTableDownStart");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownEndIsNull() {
            addCriterion("crsl_table_down_end is null");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownEndIsNotNull() {
            addCriterion("crsl_table_down_end is not null");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownEndEqualTo(Date value) {
            addCriterion("crsl_table_down_end =", value, "crslTableDownEnd");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownEndNotEqualTo(Date value) {
            addCriterion("crsl_table_down_end <>", value, "crslTableDownEnd");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownEndGreaterThan(Date value) {
            addCriterion("crsl_table_down_end >", value, "crslTableDownEnd");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownEndGreaterThanOrEqualTo(Date value) {
            addCriterion("crsl_table_down_end >=", value, "crslTableDownEnd");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownEndLessThan(Date value) {
            addCriterion("crsl_table_down_end <", value, "crslTableDownEnd");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownEndLessThanOrEqualTo(Date value) {
            addCriterion("crsl_table_down_end <=", value, "crslTableDownEnd");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownEndIn(List<Date> values) {
            addCriterion("crsl_table_down_end in", values, "crslTableDownEnd");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownEndNotIn(List<Date> values) {
            addCriterion("crsl_table_down_end not in", values, "crslTableDownEnd");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownEndBetween(Date value1, Date value2) {
            addCriterion("crsl_table_down_end between", value1, value2, "crslTableDownEnd");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownEndNotBetween(Date value1, Date value2) {
            addCriterion("crsl_table_down_end not between", value1, value2, "crslTableDownEnd");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownTableIdIsNull() {
            addCriterion("crsl_table_down_table_id is null");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownTableIdIsNotNull() {
            addCriterion("crsl_table_down_table_id is not null");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownTableIdEqualTo(Integer value) {
            addCriterion("crsl_table_down_table_id =", value, "crslTableDownTableId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownTableIdNotEqualTo(Integer value) {
            addCriterion("crsl_table_down_table_id <>", value, "crslTableDownTableId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownTableIdGreaterThan(Integer value) {
            addCriterion("crsl_table_down_table_id >", value, "crslTableDownTableId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownTableIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("crsl_table_down_table_id >=", value, "crslTableDownTableId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownTableIdLessThan(Integer value) {
            addCriterion("crsl_table_down_table_id <", value, "crslTableDownTableId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownTableIdLessThanOrEqualTo(Integer value) {
            addCriterion("crsl_table_down_table_id <=", value, "crslTableDownTableId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownTableIdIn(List<Integer> values) {
            addCriterion("crsl_table_down_table_id in", values, "crslTableDownTableId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownTableIdNotIn(List<Integer> values) {
            addCriterion("crsl_table_down_table_id not in", values, "crslTableDownTableId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownTableIdBetween(Integer value1, Integer value2) {
            addCriterion("crsl_table_down_table_id between", value1, value2, "crslTableDownTableId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownTableIdNotBetween(Integer value1, Integer value2) {
            addCriterion("crsl_table_down_table_id not between", value1, value2, "crslTableDownTableId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecQtyIsNull() {
            addCriterion("crsl_table_down_rec_qty is null");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecQtyIsNotNull() {
            addCriterion("crsl_table_down_rec_qty is not null");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecQtyEqualTo(Integer value) {
            addCriterion("crsl_table_down_rec_qty =", value, "crslTableDownRecQty");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecQtyNotEqualTo(Integer value) {
            addCriterion("crsl_table_down_rec_qty <>", value, "crslTableDownRecQty");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecQtyGreaterThan(Integer value) {
            addCriterion("crsl_table_down_rec_qty >", value, "crslTableDownRecQty");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("crsl_table_down_rec_qty >=", value, "crslTableDownRecQty");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecQtyLessThan(Integer value) {
            addCriterion("crsl_table_down_rec_qty <", value, "crslTableDownRecQty");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecQtyLessThanOrEqualTo(Integer value) {
            addCriterion("crsl_table_down_rec_qty <=", value, "crslTableDownRecQty");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecQtyIn(List<Integer> values) {
            addCriterion("crsl_table_down_rec_qty in", values, "crslTableDownRecQty");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecQtyNotIn(List<Integer> values) {
            addCriterion("crsl_table_down_rec_qty not in", values, "crslTableDownRecQty");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecQtyBetween(Integer value1, Integer value2) {
            addCriterion("crsl_table_down_rec_qty between", value1, value2, "crslTableDownRecQty");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownRecQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("crsl_table_down_rec_qty not between", value1, value2, "crslTableDownRecQty");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStatusIsNull() {
            addCriterion("crsl_table_down_status is null");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStatusIsNotNull() {
            addCriterion("crsl_table_down_status is not null");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStatusEqualTo(Integer value) {
            addCriterion("crsl_table_down_status =", value, "crslTableDownStatus");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStatusNotEqualTo(Integer value) {
            addCriterion("crsl_table_down_status <>", value, "crslTableDownStatus");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStatusGreaterThan(Integer value) {
            addCriterion("crsl_table_down_status >", value, "crslTableDownStatus");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("crsl_table_down_status >=", value, "crslTableDownStatus");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStatusLessThan(Integer value) {
            addCriterion("crsl_table_down_status <", value, "crslTableDownStatus");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStatusLessThanOrEqualTo(Integer value) {
            addCriterion("crsl_table_down_status <=", value, "crslTableDownStatus");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStatusIn(List<Integer> values) {
            addCriterion("crsl_table_down_status in", values, "crslTableDownStatus");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStatusNotIn(List<Integer> values) {
            addCriterion("crsl_table_down_status not in", values, "crslTableDownStatus");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStatusBetween(Integer value1, Integer value2) {
            addCriterion("crsl_table_down_status between", value1, value2, "crslTableDownStatus");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("crsl_table_down_status not between", value1, value2, "crslTableDownStatus");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownSchIdIsNull() {
            addCriterion("crsl_table_down_sch_id is null");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownSchIdIsNotNull() {
            addCriterion("crsl_table_down_sch_id is not null");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownSchIdEqualTo(Integer value) {
            addCriterion("crsl_table_down_sch_id =", value, "crslTableDownSchId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownSchIdNotEqualTo(Integer value) {
            addCriterion("crsl_table_down_sch_id <>", value, "crslTableDownSchId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownSchIdGreaterThan(Integer value) {
            addCriterion("crsl_table_down_sch_id >", value, "crslTableDownSchId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownSchIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("crsl_table_down_sch_id >=", value, "crslTableDownSchId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownSchIdLessThan(Integer value) {
            addCriterion("crsl_table_down_sch_id <", value, "crslTableDownSchId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownSchIdLessThanOrEqualTo(Integer value) {
            addCriterion("crsl_table_down_sch_id <=", value, "crslTableDownSchId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownSchIdIn(List<Integer> values) {
            addCriterion("crsl_table_down_sch_id in", values, "crslTableDownSchId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownSchIdNotIn(List<Integer> values) {
            addCriterion("crsl_table_down_sch_id not in", values, "crslTableDownSchId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownSchIdBetween(Integer value1, Integer value2) {
            addCriterion("crsl_table_down_sch_id between", value1, value2, "crslTableDownSchId");
            return (Criteria) this;
        }

        public Criteria andCrslTableDownSchIdNotBetween(Integer value1, Integer value2) {
            addCriterion("crsl_table_down_sch_id not between", value1, value2, "crslTableDownSchId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table crsl_table_down_rec
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
     * This class corresponds to the database table crsl_table_down_rec
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