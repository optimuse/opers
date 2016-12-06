package com.bestpay.ecurrency.operations.dal.model;

import java.util.ArrayList;
import java.util.List;

public class EoSymPrivDOExample extends BaseDO{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EoSymPrivDOExample() {
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

        public Criteria andPrivIdIsNull() {
            addCriterion("PRIV_ID is null");
            return (Criteria) this;
        }

        public Criteria andPrivIdIsNotNull() {
            addCriterion("PRIV_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPrivIdEqualTo(Integer value) {
            addCriterion("PRIV_ID =", value, "privId");
            return (Criteria) this;
        }

        public Criteria andPrivIdNotEqualTo(Integer value) {
            addCriterion("PRIV_ID <>", value, "privId");
            return (Criteria) this;
        }

        public Criteria andPrivIdGreaterThan(Integer value) {
            addCriterion("PRIV_ID >", value, "privId");
            return (Criteria) this;
        }

        public Criteria andPrivIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRIV_ID >=", value, "privId");
            return (Criteria) this;
        }

        public Criteria andPrivIdLessThan(Integer value) {
            addCriterion("PRIV_ID <", value, "privId");
            return (Criteria) this;
        }

        public Criteria andPrivIdLessThanOrEqualTo(Integer value) {
            addCriterion("PRIV_ID <=", value, "privId");
            return (Criteria) this;
        }

        public Criteria andPrivIdIn(List<Integer> values) {
            addCriterion("PRIV_ID in", values, "privId");
            return (Criteria) this;
        }

        public Criteria andPrivIdNotIn(List<Integer> values) {
            addCriterion("PRIV_ID not in", values, "privId");
            return (Criteria) this;
        }

        public Criteria andPrivIdBetween(Integer value1, Integer value2) {
            addCriterion("PRIV_ID between", value1, value2, "privId");
            return (Criteria) this;
        }

        public Criteria andPrivIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PRIV_ID not between", value1, value2, "privId");
            return (Criteria) this;
        }

        public Criteria andPrivNameIsNull() {
            addCriterion("PRIV_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPrivNameIsNotNull() {
            addCriterion("PRIV_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPrivNameEqualTo(String value) {
            addCriterion("PRIV_NAME =", value, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameNotEqualTo(String value) {
            addCriterion("PRIV_NAME <>", value, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameGreaterThan(String value) {
            addCriterion("PRIV_NAME >", value, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameGreaterThanOrEqualTo(String value) {
            addCriterion("PRIV_NAME >=", value, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameLessThan(String value) {
            addCriterion("PRIV_NAME <", value, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameLessThanOrEqualTo(String value) {
            addCriterion("PRIV_NAME <=", value, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameLike(String value) {
            addCriterion("PRIV_NAME like", value, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameNotLike(String value) {
            addCriterion("PRIV_NAME not like", value, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameIn(List<String> values) {
            addCriterion("PRIV_NAME in", values, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameNotIn(List<String> values) {
            addCriterion("PRIV_NAME not in", values, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameBetween(String value1, String value2) {
            addCriterion("PRIV_NAME between", value1, value2, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivNameNotBetween(String value1, String value2) {
            addCriterion("PRIV_NAME not between", value1, value2, "privName");
            return (Criteria) this;
        }

        public Criteria andPrivTypeIsNull() {
            addCriterion("PRIV_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPrivTypeIsNotNull() {
            addCriterion("PRIV_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPrivTypeEqualTo(String value) {
            addCriterion("PRIV_TYPE =", value, "privType");
            return (Criteria) this;
        }

        public Criteria andPrivTypeNotEqualTo(String value) {
            addCriterion("PRIV_TYPE <>", value, "privType");
            return (Criteria) this;
        }

        public Criteria andPrivTypeGreaterThan(String value) {
            addCriterion("PRIV_TYPE >", value, "privType");
            return (Criteria) this;
        }

        public Criteria andPrivTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PRIV_TYPE >=", value, "privType");
            return (Criteria) this;
        }

        public Criteria andPrivTypeLessThan(String value) {
            addCriterion("PRIV_TYPE <", value, "privType");
            return (Criteria) this;
        }

        public Criteria andPrivTypeLessThanOrEqualTo(String value) {
            addCriterion("PRIV_TYPE <=", value, "privType");
            return (Criteria) this;
        }

        public Criteria andPrivTypeLike(String value) {
            addCriterion("PRIV_TYPE like", value, "privType");
            return (Criteria) this;
        }

        public Criteria andPrivTypeNotLike(String value) {
            addCriterion("PRIV_TYPE not like", value, "privType");
            return (Criteria) this;
        }

        public Criteria andPrivTypeIn(List<String> values) {
            addCriterion("PRIV_TYPE in", values, "privType");
            return (Criteria) this;
        }

        public Criteria andPrivTypeNotIn(List<String> values) {
            addCriterion("PRIV_TYPE not in", values, "privType");
            return (Criteria) this;
        }

        public Criteria andPrivTypeBetween(String value1, String value2) {
            addCriterion("PRIV_TYPE between", value1, value2, "privType");
            return (Criteria) this;
        }

        public Criteria andPrivTypeNotBetween(String value1, String value2) {
            addCriterion("PRIV_TYPE not between", value1, value2, "privType");
            return (Criteria) this;
        }

        public Criteria andParentPrivIsNull() {
            addCriterion("PARENT_PRIV is null");
            return (Criteria) this;
        }

        public Criteria andParentPrivIsNotNull() {
            addCriterion("PARENT_PRIV is not null");
            return (Criteria) this;
        }

        public Criteria andParentPrivEqualTo(Integer value) {
            addCriterion("PARENT_PRIV =", value, "parentPriv");
            return (Criteria) this;
        }

        public Criteria andParentPrivNotEqualTo(Integer value) {
            addCriterion("PARENT_PRIV <>", value, "parentPriv");
            return (Criteria) this;
        }

        public Criteria andParentPrivGreaterThan(Integer value) {
            addCriterion("PARENT_PRIV >", value, "parentPriv");
            return (Criteria) this;
        }

        public Criteria andParentPrivGreaterThanOrEqualTo(Integer value) {
            addCriterion("PARENT_PRIV >=", value, "parentPriv");
            return (Criteria) this;
        }

        public Criteria andParentPrivLessThan(Integer value) {
            addCriterion("PARENT_PRIV <", value, "parentPriv");
            return (Criteria) this;
        }

        public Criteria andParentPrivLessThanOrEqualTo(Integer value) {
            addCriterion("PARENT_PRIV <=", value, "parentPriv");
            return (Criteria) this;
        }

        public Criteria andParentPrivIn(List<Integer> values) {
            addCriterion("PARENT_PRIV in", values, "parentPriv");
            return (Criteria) this;
        }

        public Criteria andParentPrivNotIn(List<Integer> values) {
            addCriterion("PARENT_PRIV not in", values, "parentPriv");
            return (Criteria) this;
        }

        public Criteria andParentPrivBetween(Integer value1, Integer value2) {
            addCriterion("PARENT_PRIV between", value1, value2, "parentPriv");
            return (Criteria) this;
        }

        public Criteria andParentPrivNotBetween(Integer value1, Integer value2) {
            addCriterion("PARENT_PRIV not between", value1, value2, "parentPriv");
            return (Criteria) this;
        }

        public Criteria andShowSeqIsNull() {
            addCriterion("SHOW_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andShowSeqIsNotNull() {
            addCriterion("SHOW_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andShowSeqEqualTo(Integer value) {
            addCriterion("SHOW_SEQ =", value, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqNotEqualTo(Integer value) {
            addCriterion("SHOW_SEQ <>", value, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqGreaterThan(Integer value) {
            addCriterion("SHOW_SEQ >", value, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("SHOW_SEQ >=", value, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqLessThan(Integer value) {
            addCriterion("SHOW_SEQ <", value, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqLessThanOrEqualTo(Integer value) {
            addCriterion("SHOW_SEQ <=", value, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqIn(List<Integer> values) {
            addCriterion("SHOW_SEQ in", values, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqNotIn(List<Integer> values) {
            addCriterion("SHOW_SEQ not in", values, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqBetween(Integer value1, Integer value2) {
            addCriterion("SHOW_SEQ between", value1, value2, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("SHOW_SEQ not between", value1, value2, "showSeq");
            return (Criteria) this;
        }

        public Criteria andPrivUrlIsNull() {
            addCriterion("PRIV_URL is null");
            return (Criteria) this;
        }

        public Criteria andPrivUrlIsNotNull() {
            addCriterion("PRIV_URL is not null");
            return (Criteria) this;
        }

        public Criteria andPrivUrlEqualTo(String value) {
            addCriterion("PRIV_URL =", value, "privUrl");
            return (Criteria) this;
        }

        public Criteria andPrivUrlNotEqualTo(String value) {
            addCriterion("PRIV_URL <>", value, "privUrl");
            return (Criteria) this;
        }

        public Criteria andPrivUrlGreaterThan(String value) {
            addCriterion("PRIV_URL >", value, "privUrl");
            return (Criteria) this;
        }

        public Criteria andPrivUrlGreaterThanOrEqualTo(String value) {
            addCriterion("PRIV_URL >=", value, "privUrl");
            return (Criteria) this;
        }

        public Criteria andPrivUrlLessThan(String value) {
            addCriterion("PRIV_URL <", value, "privUrl");
            return (Criteria) this;
        }

        public Criteria andPrivUrlLessThanOrEqualTo(String value) {
            addCriterion("PRIV_URL <=", value, "privUrl");
            return (Criteria) this;
        }

        public Criteria andPrivUrlLike(String value) {
            addCriterion("PRIV_URL like", value, "privUrl");
            return (Criteria) this;
        }

        public Criteria andPrivUrlNotLike(String value) {
            addCriterion("PRIV_URL not like", value, "privUrl");
            return (Criteria) this;
        }

        public Criteria andPrivUrlIn(List<String> values) {
            addCriterion("PRIV_URL in", values, "privUrl");
            return (Criteria) this;
        }

        public Criteria andPrivUrlNotIn(List<String> values) {
            addCriterion("PRIV_URL not in", values, "privUrl");
            return (Criteria) this;
        }

        public Criteria andPrivUrlBetween(String value1, String value2) {
            addCriterion("PRIV_URL between", value1, value2, "privUrl");
            return (Criteria) this;
        }

        public Criteria andPrivUrlNotBetween(String value1, String value2) {
            addCriterion("PRIV_URL not between", value1, value2, "privUrl");
            return (Criteria) this;
        }

        public Criteria andOperModeIsNull() {
            addCriterion("OPER_MODE is null");
            return (Criteria) this;
        }

        public Criteria andOperModeIsNotNull() {
            addCriterion("OPER_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andOperModeEqualTo(String value) {
            addCriterion("OPER_MODE =", value, "operMode");
            return (Criteria) this;
        }

        public Criteria andOperModeNotEqualTo(String value) {
            addCriterion("OPER_MODE <>", value, "operMode");
            return (Criteria) this;
        }

        public Criteria andOperModeGreaterThan(String value) {
            addCriterion("OPER_MODE >", value, "operMode");
            return (Criteria) this;
        }

        public Criteria andOperModeGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_MODE >=", value, "operMode");
            return (Criteria) this;
        }

        public Criteria andOperModeLessThan(String value) {
            addCriterion("OPER_MODE <", value, "operMode");
            return (Criteria) this;
        }

        public Criteria andOperModeLessThanOrEqualTo(String value) {
            addCriterion("OPER_MODE <=", value, "operMode");
            return (Criteria) this;
        }

        public Criteria andOperModeLike(String value) {
            addCriterion("OPER_MODE like", value, "operMode");
            return (Criteria) this;
        }

        public Criteria andOperModeNotLike(String value) {
            addCriterion("OPER_MODE not like", value, "operMode");
            return (Criteria) this;
        }

        public Criteria andOperModeIn(List<String> values) {
            addCriterion("OPER_MODE in", values, "operMode");
            return (Criteria) this;
        }

        public Criteria andOperModeNotIn(List<String> values) {
            addCriterion("OPER_MODE not in", values, "operMode");
            return (Criteria) this;
        }

        public Criteria andOperModeBetween(String value1, String value2) {
            addCriterion("OPER_MODE between", value1, value2, "operMode");
            return (Criteria) this;
        }

        public Criteria andOperModeNotBetween(String value1, String value2) {
            addCriterion("OPER_MODE not between", value1, value2, "operMode");
            return (Criteria) this;
        }

        public Criteria andPrivDescIsNull() {
            addCriterion("PRIV_DESC is null");
            return (Criteria) this;
        }

        public Criteria andPrivDescIsNotNull() {
            addCriterion("PRIV_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andPrivDescEqualTo(String value) {
            addCriterion("PRIV_DESC =", value, "privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescNotEqualTo(String value) {
            addCriterion("PRIV_DESC <>", value, "privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescGreaterThan(String value) {
            addCriterion("PRIV_DESC >", value, "privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescGreaterThanOrEqualTo(String value) {
            addCriterion("PRIV_DESC >=", value, "privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescLessThan(String value) {
            addCriterion("PRIV_DESC <", value, "privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescLessThanOrEqualTo(String value) {
            addCriterion("PRIV_DESC <=", value, "privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescLike(String value) {
            addCriterion("PRIV_DESC like", value, "privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescNotLike(String value) {
            addCriterion("PRIV_DESC not like", value, "privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescIn(List<String> values) {
            addCriterion("PRIV_DESC in", values, "privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescNotIn(List<String> values) {
            addCriterion("PRIV_DESC not in", values, "privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescBetween(String value1, String value2) {
            addCriterion("PRIV_DESC between", value1, value2, "privDesc");
            return (Criteria) this;
        }

        public Criteria andPrivDescNotBetween(String value1, String value2) {
            addCriterion("PRIV_DESC not between", value1, value2, "privDesc");
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

        public Criteria andPrivImgIsNull() {
            addCriterion("PRIV_IMG is null");
            return (Criteria) this;
        }

        public Criteria andPrivImgIsNotNull() {
            addCriterion("PRIV_IMG is not null");
            return (Criteria) this;
        }

        public Criteria andPrivImgEqualTo(String value) {
            addCriterion("PRIV_IMG =", value, "privImg");
            return (Criteria) this;
        }

        public Criteria andPrivImgNotEqualTo(String value) {
            addCriterion("PRIV_IMG <>", value, "privImg");
            return (Criteria) this;
        }

        public Criteria andPrivImgGreaterThan(String value) {
            addCriterion("PRIV_IMG >", value, "privImg");
            return (Criteria) this;
        }

        public Criteria andPrivImgGreaterThanOrEqualTo(String value) {
            addCriterion("PRIV_IMG >=", value, "privImg");
            return (Criteria) this;
        }

        public Criteria andPrivImgLessThan(String value) {
            addCriterion("PRIV_IMG <", value, "privImg");
            return (Criteria) this;
        }

        public Criteria andPrivImgLessThanOrEqualTo(String value) {
            addCriterion("PRIV_IMG <=", value, "privImg");
            return (Criteria) this;
        }

        public Criteria andPrivImgLike(String value) {
            addCriterion("PRIV_IMG like", value, "privImg");
            return (Criteria) this;
        }

        public Criteria andPrivImgNotLike(String value) {
            addCriterion("PRIV_IMG not like", value, "privImg");
            return (Criteria) this;
        }

        public Criteria andPrivImgIn(List<String> values) {
            addCriterion("PRIV_IMG in", values, "privImg");
            return (Criteria) this;
        }

        public Criteria andPrivImgNotIn(List<String> values) {
            addCriterion("PRIV_IMG not in", values, "privImg");
            return (Criteria) this;
        }

        public Criteria andPrivImgBetween(String value1, String value2) {
            addCriterion("PRIV_IMG between", value1, value2, "privImg");
            return (Criteria) this;
        }

        public Criteria andPrivImgNotBetween(String value1, String value2) {
            addCriterion("PRIV_IMG not between", value1, value2, "privImg");
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