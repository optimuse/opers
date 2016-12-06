package com.bestpay.ecurrency.operations.dal.model;

import java.util.ArrayList;
import java.util.List;

public class EoSymErrorDOExample extends BaseDO{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EoSymErrorDOExample() {
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

        public Criteria andErrorCodeIsNull() {
            addCriterion("ERROR_CODE is null");
            return (Criteria) this;
        }

        public Criteria andErrorCodeIsNotNull() {
            addCriterion("ERROR_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andErrorCodeEqualTo(String value) {
            addCriterion("ERROR_CODE =", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotEqualTo(String value) {
            addCriterion("ERROR_CODE <>", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeGreaterThan(String value) {
            addCriterion("ERROR_CODE >", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ERROR_CODE >=", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeLessThan(String value) {
            addCriterion("ERROR_CODE <", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeLessThanOrEqualTo(String value) {
            addCriterion("ERROR_CODE <=", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeLike(String value) {
            addCriterion("ERROR_CODE like", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotLike(String value) {
            addCriterion("ERROR_CODE not like", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeIn(List<String> values) {
            addCriterion("ERROR_CODE in", values, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotIn(List<String> values) {
            addCriterion("ERROR_CODE not in", values, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeBetween(String value1, String value2) {
            addCriterion("ERROR_CODE between", value1, value2, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotBetween(String value1, String value2) {
            addCriterion("ERROR_CODE not between", value1, value2, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorInfoIsNull() {
            addCriterion("ERROR_INFO is null");
            return (Criteria) this;
        }

        public Criteria andErrorInfoIsNotNull() {
            addCriterion("ERROR_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andErrorInfoEqualTo(String value) {
            addCriterion("ERROR_INFO =", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoNotEqualTo(String value) {
            addCriterion("ERROR_INFO <>", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoGreaterThan(String value) {
            addCriterion("ERROR_INFO >", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoGreaterThanOrEqualTo(String value) {
            addCriterion("ERROR_INFO >=", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoLessThan(String value) {
            addCriterion("ERROR_INFO <", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoLessThanOrEqualTo(String value) {
            addCriterion("ERROR_INFO <=", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoLike(String value) {
            addCriterion("ERROR_INFO like", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoNotLike(String value) {
            addCriterion("ERROR_INFO not like", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoIn(List<String> values) {
            addCriterion("ERROR_INFO in", values, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoNotIn(List<String> values) {
            addCriterion("ERROR_INFO not in", values, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoBetween(String value1, String value2) {
            addCriterion("ERROR_INFO between", value1, value2, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoNotBetween(String value1, String value2) {
            addCriterion("ERROR_INFO not between", value1, value2, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andModuleCodeIsNull() {
            addCriterion("MODULE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andModuleCodeIsNotNull() {
            addCriterion("MODULE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andModuleCodeEqualTo(String value) {
            addCriterion("MODULE_CODE =", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeNotEqualTo(String value) {
            addCriterion("MODULE_CODE <>", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeGreaterThan(String value) {
            addCriterion("MODULE_CODE >", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("MODULE_CODE >=", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeLessThan(String value) {
            addCriterion("MODULE_CODE <", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeLessThanOrEqualTo(String value) {
            addCriterion("MODULE_CODE <=", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeLike(String value) {
            addCriterion("MODULE_CODE like", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeNotLike(String value) {
            addCriterion("MODULE_CODE not like", value, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeIn(List<String> values) {
            addCriterion("MODULE_CODE in", values, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeNotIn(List<String> values) {
            addCriterion("MODULE_CODE not in", values, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeBetween(String value1, String value2) {
            addCriterion("MODULE_CODE between", value1, value2, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andModuleCodeNotBetween(String value1, String value2) {
            addCriterion("MODULE_CODE not between", value1, value2, "moduleCode");
            return (Criteria) this;
        }

        public Criteria andErrorLevelIsNull() {
            addCriterion("ERROR_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andErrorLevelIsNotNull() {
            addCriterion("ERROR_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andErrorLevelEqualTo(String value) {
            addCriterion("ERROR_LEVEL =", value, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelNotEqualTo(String value) {
            addCriterion("ERROR_LEVEL <>", value, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelGreaterThan(String value) {
            addCriterion("ERROR_LEVEL >", value, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelGreaterThanOrEqualTo(String value) {
            addCriterion("ERROR_LEVEL >=", value, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelLessThan(String value) {
            addCriterion("ERROR_LEVEL <", value, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelLessThanOrEqualTo(String value) {
            addCriterion("ERROR_LEVEL <=", value, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelLike(String value) {
            addCriterion("ERROR_LEVEL like", value, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelNotLike(String value) {
            addCriterion("ERROR_LEVEL not like", value, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelIn(List<String> values) {
            addCriterion("ERROR_LEVEL in", values, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelNotIn(List<String> values) {
            addCriterion("ERROR_LEVEL not in", values, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelBetween(String value1, String value2) {
            addCriterion("ERROR_LEVEL between", value1, value2, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andErrorLevelNotBetween(String value1, String value2) {
            addCriterion("ERROR_LEVEL not between", value1, value2, "errorLevel");
            return (Criteria) this;
        }

        public Criteria andHandlerIsNull() {
            addCriterion("HANDLER is null");
            return (Criteria) this;
        }

        public Criteria andHandlerIsNotNull() {
            addCriterion("HANDLER is not null");
            return (Criteria) this;
        }

        public Criteria andHandlerEqualTo(String value) {
            addCriterion("HANDLER =", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerNotEqualTo(String value) {
            addCriterion("HANDLER <>", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerGreaterThan(String value) {
            addCriterion("HANDLER >", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerGreaterThanOrEqualTo(String value) {
            addCriterion("HANDLER >=", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerLessThan(String value) {
            addCriterion("HANDLER <", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerLessThanOrEqualTo(String value) {
            addCriterion("HANDLER <=", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerLike(String value) {
            addCriterion("HANDLER like", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerNotLike(String value) {
            addCriterion("HANDLER not like", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerIn(List<String> values) {
            addCriterion("HANDLER in", values, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerNotIn(List<String> values) {
            addCriterion("HANDLER not in", values, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerBetween(String value1, String value2) {
            addCriterion("HANDLER between", value1, value2, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerNotBetween(String value1, String value2) {
            addCriterion("HANDLER not between", value1, value2, "handler");
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

        public Criteria andCodeOutIsNull() {
            addCriterion("CODE_OUT is null");
            return (Criteria) this;
        }

        public Criteria andCodeOutIsNotNull() {
            addCriterion("CODE_OUT is not null");
            return (Criteria) this;
        }

        public Criteria andCodeOutEqualTo(String value) {
            addCriterion("CODE_OUT =", value, "codeOut");
            return (Criteria) this;
        }

        public Criteria andCodeOutNotEqualTo(String value) {
            addCriterion("CODE_OUT <>", value, "codeOut");
            return (Criteria) this;
        }

        public Criteria andCodeOutGreaterThan(String value) {
            addCriterion("CODE_OUT >", value, "codeOut");
            return (Criteria) this;
        }

        public Criteria andCodeOutGreaterThanOrEqualTo(String value) {
            addCriterion("CODE_OUT >=", value, "codeOut");
            return (Criteria) this;
        }

        public Criteria andCodeOutLessThan(String value) {
            addCriterion("CODE_OUT <", value, "codeOut");
            return (Criteria) this;
        }

        public Criteria andCodeOutLessThanOrEqualTo(String value) {
            addCriterion("CODE_OUT <=", value, "codeOut");
            return (Criteria) this;
        }

        public Criteria andCodeOutLike(String value) {
            addCriterion("CODE_OUT like", value, "codeOut");
            return (Criteria) this;
        }

        public Criteria andCodeOutNotLike(String value) {
            addCriterion("CODE_OUT not like", value, "codeOut");
            return (Criteria) this;
        }

        public Criteria andCodeOutIn(List<String> values) {
            addCriterion("CODE_OUT in", values, "codeOut");
            return (Criteria) this;
        }

        public Criteria andCodeOutNotIn(List<String> values) {
            addCriterion("CODE_OUT not in", values, "codeOut");
            return (Criteria) this;
        }

        public Criteria andCodeOutBetween(String value1, String value2) {
            addCriterion("CODE_OUT between", value1, value2, "codeOut");
            return (Criteria) this;
        }

        public Criteria andCodeOutNotBetween(String value1, String value2) {
            addCriterion("CODE_OUT not between", value1, value2, "codeOut");
            return (Criteria) this;
        }

        public Criteria andInfoOutIsNull() {
            addCriterion("INFO_OUT is null");
            return (Criteria) this;
        }

        public Criteria andInfoOutIsNotNull() {
            addCriterion("INFO_OUT is not null");
            return (Criteria) this;
        }

        public Criteria andInfoOutEqualTo(String value) {
            addCriterion("INFO_OUT =", value, "infoOut");
            return (Criteria) this;
        }

        public Criteria andInfoOutNotEqualTo(String value) {
            addCriterion("INFO_OUT <>", value, "infoOut");
            return (Criteria) this;
        }

        public Criteria andInfoOutGreaterThan(String value) {
            addCriterion("INFO_OUT >", value, "infoOut");
            return (Criteria) this;
        }

        public Criteria andInfoOutGreaterThanOrEqualTo(String value) {
            addCriterion("INFO_OUT >=", value, "infoOut");
            return (Criteria) this;
        }

        public Criteria andInfoOutLessThan(String value) {
            addCriterion("INFO_OUT <", value, "infoOut");
            return (Criteria) this;
        }

        public Criteria andInfoOutLessThanOrEqualTo(String value) {
            addCriterion("INFO_OUT <=", value, "infoOut");
            return (Criteria) this;
        }

        public Criteria andInfoOutLike(String value) {
            addCriterion("INFO_OUT like", value, "infoOut");
            return (Criteria) this;
        }

        public Criteria andInfoOutNotLike(String value) {
            addCriterion("INFO_OUT not like", value, "infoOut");
            return (Criteria) this;
        }

        public Criteria andInfoOutIn(List<String> values) {
            addCriterion("INFO_OUT in", values, "infoOut");
            return (Criteria) this;
        }

        public Criteria andInfoOutNotIn(List<String> values) {
            addCriterion("INFO_OUT not in", values, "infoOut");
            return (Criteria) this;
        }

        public Criteria andInfoOutBetween(String value1, String value2) {
            addCriterion("INFO_OUT between", value1, value2, "infoOut");
            return (Criteria) this;
        }

        public Criteria andInfoOutNotBetween(String value1, String value2) {
            addCriterion("INFO_OUT not between", value1, value2, "infoOut");
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