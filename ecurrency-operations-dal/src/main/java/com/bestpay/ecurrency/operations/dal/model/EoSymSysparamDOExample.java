package com.bestpay.ecurrency.operations.dal.model;

import java.util.ArrayList;
import java.util.List;

public class EoSymSysparamDOExample extends BaseDO {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EoSymSysparamDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andParamCodeIsNull() {
            addCriterion("PARAM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andParamCodeIsNotNull() {
            addCriterion("PARAM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andParamCodeEqualTo(String value) {
            addCriterion("PARAM_CODE =", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotEqualTo(String value) {
            addCriterion("PARAM_CODE <>", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeGreaterThan(String value) {
            addCriterion("PARAM_CODE >", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_CODE >=", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeLessThan(String value) {
            addCriterion("PARAM_CODE <", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeLessThanOrEqualTo(String value) {
            addCriterion("PARAM_CODE <=", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeLike(String value) {
            addCriterion("PARAM_CODE like", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotLike(String value) {
            addCriterion("PARAM_CODE not like", value, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeIn(List<String> values) {
            addCriterion("PARAM_CODE in", values, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotIn(List<String> values) {
            addCriterion("PARAM_CODE not in", values, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeBetween(String value1, String value2) {
            addCriterion("PARAM_CODE between", value1, value2, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamCodeNotBetween(String value1, String value2) {
            addCriterion("PARAM_CODE not between", value1, value2, "paramCode");
            return (Criteria) this;
        }

        public Criteria andParamNameIsNull() {
            addCriterion("PARAM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andParamNameIsNotNull() {
            addCriterion("PARAM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andParamNameEqualTo(String value) {
            addCriterion("PARAM_NAME =", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotEqualTo(String value) {
            addCriterion("PARAM_NAME <>", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameGreaterThan(String value) {
            addCriterion("PARAM_NAME >", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_NAME >=", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLessThan(String value) {
            addCriterion("PARAM_NAME <", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLessThanOrEqualTo(String value) {
            addCriterion("PARAM_NAME <=", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLike(String value) {
            addCriterion("PARAM_NAME like", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotLike(String value) {
            addCriterion("PARAM_NAME not like", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameIn(List<String> values) {
            addCriterion("PARAM_NAME in", values, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotIn(List<String> values) {
            addCriterion("PARAM_NAME not in", values, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameBetween(String value1, String value2) {
            addCriterion("PARAM_NAME between", value1, value2, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotBetween(String value1, String value2) {
            addCriterion("PARAM_NAME not between", value1, value2, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamValIsNull() {
            addCriterion("PARAM_VAL is null");
            return (Criteria) this;
        }

        public Criteria andParamValIsNotNull() {
            addCriterion("PARAM_VAL is not null");
            return (Criteria) this;
        }

        public Criteria andParamValEqualTo(String value) {
            addCriterion("PARAM_VAL =", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValNotEqualTo(String value) {
            addCriterion("PARAM_VAL <>", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValGreaterThan(String value) {
            addCriterion("PARAM_VAL >", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_VAL >=", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValLessThan(String value) {
            addCriterion("PARAM_VAL <", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValLessThanOrEqualTo(String value) {
            addCriterion("PARAM_VAL <=", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValLike(String value) {
            addCriterion("PARAM_VAL like", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValNotLike(String value) {
            addCriterion("PARAM_VAL not like", value, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValIn(List<String> values) {
            addCriterion("PARAM_VAL in", values, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValNotIn(List<String> values) {
            addCriterion("PARAM_VAL not in", values, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValBetween(String value1, String value2) {
            addCriterion("PARAM_VAL between", value1, value2, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamValNotBetween(String value1, String value2) {
            addCriterion("PARAM_VAL not between", value1, value2, "paramVal");
            return (Criteria) this;
        }

        public Criteria andParamDescIsNull() {
            addCriterion("PARAM_DESC is null");
            return (Criteria) this;
        }

        public Criteria andParamDescIsNotNull() {
            addCriterion("PARAM_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andParamDescEqualTo(String value) {
            addCriterion("PARAM_DESC =", value, "paramDesc");
            return (Criteria) this;
        }

        public Criteria andParamDescNotEqualTo(String value) {
            addCriterion("PARAM_DESC <>", value, "paramDesc");
            return (Criteria) this;
        }

        public Criteria andParamDescGreaterThan(String value) {
            addCriterion("PARAM_DESC >", value, "paramDesc");
            return (Criteria) this;
        }

        public Criteria andParamDescGreaterThanOrEqualTo(String value) {
            addCriterion("PARAM_DESC >=", value, "paramDesc");
            return (Criteria) this;
        }

        public Criteria andParamDescLessThan(String value) {
            addCriterion("PARAM_DESC <", value, "paramDesc");
            return (Criteria) this;
        }

        public Criteria andParamDescLessThanOrEqualTo(String value) {
            addCriterion("PARAM_DESC <=", value, "paramDesc");
            return (Criteria) this;
        }

        public Criteria andParamDescLike(String value) {
            addCriterion("PARAM_DESC like", value, "paramDesc");
            return (Criteria) this;
        }

        public Criteria andParamDescNotLike(String value) {
            addCriterion("PARAM_DESC not like", value, "paramDesc");
            return (Criteria) this;
        }

        public Criteria andParamDescIn(List<String> values) {
            addCriterion("PARAM_DESC in", values, "paramDesc");
            return (Criteria) this;
        }

        public Criteria andParamDescNotIn(List<String> values) {
            addCriterion("PARAM_DESC not in", values, "paramDesc");
            return (Criteria) this;
        }

        public Criteria andParamDescBetween(String value1, String value2) {
            addCriterion("PARAM_DESC between", value1, value2, "paramDesc");
            return (Criteria) this;
        }

        public Criteria andParamDescNotBetween(String value1, String value2) {
            addCriterion("PARAM_DESC not between", value1, value2, "paramDesc");
            return (Criteria) this;
        }

        public Criteria andStatIsNull() {
            addCriterion("STAT is null");
            return (Criteria) this;
        }

        public Criteria andStatIsNotNull() {
            addCriterion("STAT is not null");
            return (Criteria) this;
        }

        public Criteria andStatEqualTo(String value) {
            addCriterion("STAT =", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotEqualTo(String value) {
            addCriterion("STAT <>", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThan(String value) {
            addCriterion("STAT >", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThanOrEqualTo(String value) {
            addCriterion("STAT >=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThan(String value) {
            addCriterion("STAT <", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThanOrEqualTo(String value) {
            addCriterion("STAT <=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLike(String value) {
            addCriterion("STAT like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotLike(String value) {
            addCriterion("STAT not like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatIn(List<String> values) {
            addCriterion("STAT in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotIn(List<String> values) {
            addCriterion("STAT not in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatBetween(String value1, String value2) {
            addCriterion("STAT between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotBetween(String value1, String value2) {
            addCriterion("STAT not between", value1, value2, "stat");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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