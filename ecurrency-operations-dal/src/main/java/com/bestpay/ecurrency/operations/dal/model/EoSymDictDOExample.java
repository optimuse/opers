package com.bestpay.ecurrency.operations.dal.model;

import java.util.ArrayList;
import java.util.List;

public class EoSymDictDOExample extends BaseDO{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EoSymDictDOExample() {
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

        public Criteria andDictIdIsNull() {
            addCriterion("DICT_ID is null");
            return (Criteria) this;
        }

        public Criteria andDictIdIsNotNull() {
            addCriterion("DICT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDictIdEqualTo(String value) {
            addCriterion("DICT_ID =", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdNotEqualTo(String value) {
            addCriterion("DICT_ID <>", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdGreaterThan(String value) {
            addCriterion("DICT_ID >", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdGreaterThanOrEqualTo(String value) {
            addCriterion("DICT_ID >=", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdLessThan(String value) {
            addCriterion("DICT_ID <", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdLessThanOrEqualTo(String value) {
            addCriterion("DICT_ID <=", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdLike(String value) {
            addCriterion("DICT_ID like", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdNotLike(String value) {
            addCriterion("DICT_ID not like", value, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdIn(List<String> values) {
            addCriterion("DICT_ID in", values, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdNotIn(List<String> values) {
            addCriterion("DICT_ID not in", values, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdBetween(String value1, String value2) {
            addCriterion("DICT_ID between", value1, value2, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictIdNotBetween(String value1, String value2) {
            addCriterion("DICT_ID not between", value1, value2, "dictId");
            return (Criteria) this;
        }

        public Criteria andDictTypeidIsNull() {
            addCriterion("DICT_TYPEID is null");
            return (Criteria) this;
        }

        public Criteria andDictTypeidIsNotNull() {
            addCriterion("DICT_TYPEID is not null");
            return (Criteria) this;
        }

        public Criteria andDictTypeidEqualTo(String value) {
            addCriterion("DICT_TYPEID =", value, "dictTypeid");
            return (Criteria) this;
        }

        public Criteria andDictTypeidNotEqualTo(String value) {
            addCriterion("DICT_TYPEID <>", value, "dictTypeid");
            return (Criteria) this;
        }

        public Criteria andDictTypeidGreaterThan(String value) {
            addCriterion("DICT_TYPEID >", value, "dictTypeid");
            return (Criteria) this;
        }

        public Criteria andDictTypeidGreaterThanOrEqualTo(String value) {
            addCriterion("DICT_TYPEID >=", value, "dictTypeid");
            return (Criteria) this;
        }

        public Criteria andDictTypeidLessThan(String value) {
            addCriterion("DICT_TYPEID <", value, "dictTypeid");
            return (Criteria) this;
        }

        public Criteria andDictTypeidLessThanOrEqualTo(String value) {
            addCriterion("DICT_TYPEID <=", value, "dictTypeid");
            return (Criteria) this;
        }

        public Criteria andDictTypeidLike(String value) {
            addCriterion("DICT_TYPEID like", value, "dictTypeid");
            return (Criteria) this;
        }

        public Criteria andDictTypeidNotLike(String value) {
            addCriterion("DICT_TYPEID not like", value, "dictTypeid");
            return (Criteria) this;
        }

        public Criteria andDictTypeidIn(List<String> values) {
            addCriterion("DICT_TYPEID in", values, "dictTypeid");
            return (Criteria) this;
        }

        public Criteria andDictTypeidNotIn(List<String> values) {
            addCriterion("DICT_TYPEID not in", values, "dictTypeid");
            return (Criteria) this;
        }

        public Criteria andDictTypeidBetween(String value1, String value2) {
            addCriterion("DICT_TYPEID between", value1, value2, "dictTypeid");
            return (Criteria) this;
        }

        public Criteria andDictTypeidNotBetween(String value1, String value2) {
            addCriterion("DICT_TYPEID not between", value1, value2, "dictTypeid");
            return (Criteria) this;
        }

        public Criteria andDictNameIsNull() {
            addCriterion("DICT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDictNameIsNotNull() {
            addCriterion("DICT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDictNameEqualTo(String value) {
            addCriterion("DICT_NAME =", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameNotEqualTo(String value) {
            addCriterion("DICT_NAME <>", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameGreaterThan(String value) {
            addCriterion("DICT_NAME >", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameGreaterThanOrEqualTo(String value) {
            addCriterion("DICT_NAME >=", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameLessThan(String value) {
            addCriterion("DICT_NAME <", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameLessThanOrEqualTo(String value) {
            addCriterion("DICT_NAME <=", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameLike(String value) {
            addCriterion("DICT_NAME like", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameNotLike(String value) {
            addCriterion("DICT_NAME not like", value, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameIn(List<String> values) {
            addCriterion("DICT_NAME in", values, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameNotIn(List<String> values) {
            addCriterion("DICT_NAME not in", values, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameBetween(String value1, String value2) {
            addCriterion("DICT_NAME between", value1, value2, "dictName");
            return (Criteria) this;
        }

        public Criteria andDictNameNotBetween(String value1, String value2) {
            addCriterion("DICT_NAME not between", value1, value2, "dictName");
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

        public Criteria andDictDescIsNull() {
            addCriterion("DICT_DESC is null");
            return (Criteria) this;
        }

        public Criteria andDictDescIsNotNull() {
            addCriterion("DICT_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andDictDescEqualTo(String value) {
            addCriterion("DICT_DESC =", value, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescNotEqualTo(String value) {
            addCriterion("DICT_DESC <>", value, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescGreaterThan(String value) {
            addCriterion("DICT_DESC >", value, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescGreaterThanOrEqualTo(String value) {
            addCriterion("DICT_DESC >=", value, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescLessThan(String value) {
            addCriterion("DICT_DESC <", value, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescLessThanOrEqualTo(String value) {
            addCriterion("DICT_DESC <=", value, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescLike(String value) {
            addCriterion("DICT_DESC like", value, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescNotLike(String value) {
            addCriterion("DICT_DESC not like", value, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescIn(List<String> values) {
            addCriterion("DICT_DESC in", values, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescNotIn(List<String> values) {
            addCriterion("DICT_DESC not in", values, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescBetween(String value1, String value2) {
            addCriterion("DICT_DESC between", value1, value2, "dictDesc");
            return (Criteria) this;
        }

        public Criteria andDictDescNotBetween(String value1, String value2) {
            addCriterion("DICT_DESC not between", value1, value2, "dictDesc");
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

        public Criteria andShowSeqEqualTo(Short value) {
            addCriterion("SHOW_SEQ =", value, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqNotEqualTo(Short value) {
            addCriterion("SHOW_SEQ <>", value, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqGreaterThan(Short value) {
            addCriterion("SHOW_SEQ >", value, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqGreaterThanOrEqualTo(Short value) {
            addCriterion("SHOW_SEQ >=", value, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqLessThan(Short value) {
            addCriterion("SHOW_SEQ <", value, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqLessThanOrEqualTo(Short value) {
            addCriterion("SHOW_SEQ <=", value, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqIn(List<Short> values) {
            addCriterion("SHOW_SEQ in", values, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqNotIn(List<Short> values) {
            addCriterion("SHOW_SEQ not in", values, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqBetween(Short value1, Short value2) {
            addCriterion("SHOW_SEQ between", value1, value2, "showSeq");
            return (Criteria) this;
        }

        public Criteria andShowSeqNotBetween(Short value1, Short value2) {
            addCriterion("SHOW_SEQ not between", value1, value2, "showSeq");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNull() {
            addCriterion("IS_DEFAULT is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("IS_DEFAULT is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultEqualTo(String value) {
            addCriterion("IS_DEFAULT =", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotEqualTo(String value) {
            addCriterion("IS_DEFAULT <>", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThan(String value) {
            addCriterion("IS_DEFAULT >", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DEFAULT >=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThan(String value) {
            addCriterion("IS_DEFAULT <", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThanOrEqualTo(String value) {
            addCriterion("IS_DEFAULT <=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLike(String value) {
            addCriterion("IS_DEFAULT like", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotLike(String value) {
            addCriterion("IS_DEFAULT not like", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIn(List<String> values) {
            addCriterion("IS_DEFAULT in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotIn(List<String> values) {
            addCriterion("IS_DEFAULT not in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultBetween(String value1, String value2) {
            addCriterion("IS_DEFAULT between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotBetween(String value1, String value2) {
            addCriterion("IS_DEFAULT not between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andCanModifyIsNull() {
            addCriterion("CAN_MODIFY is null");
            return (Criteria) this;
        }

        public Criteria andCanModifyIsNotNull() {
            addCriterion("CAN_MODIFY is not null");
            return (Criteria) this;
        }

        public Criteria andCanModifyEqualTo(String value) {
            addCriterion("CAN_MODIFY =", value, "canModify");
            return (Criteria) this;
        }

        public Criteria andCanModifyNotEqualTo(String value) {
            addCriterion("CAN_MODIFY <>", value, "canModify");
            return (Criteria) this;
        }

        public Criteria andCanModifyGreaterThan(String value) {
            addCriterion("CAN_MODIFY >", value, "canModify");
            return (Criteria) this;
        }

        public Criteria andCanModifyGreaterThanOrEqualTo(String value) {
            addCriterion("CAN_MODIFY >=", value, "canModify");
            return (Criteria) this;
        }

        public Criteria andCanModifyLessThan(String value) {
            addCriterion("CAN_MODIFY <", value, "canModify");
            return (Criteria) this;
        }

        public Criteria andCanModifyLessThanOrEqualTo(String value) {
            addCriterion("CAN_MODIFY <=", value, "canModify");
            return (Criteria) this;
        }

        public Criteria andCanModifyLike(String value) {
            addCriterion("CAN_MODIFY like", value, "canModify");
            return (Criteria) this;
        }

        public Criteria andCanModifyNotLike(String value) {
            addCriterion("CAN_MODIFY not like", value, "canModify");
            return (Criteria) this;
        }

        public Criteria andCanModifyIn(List<String> values) {
            addCriterion("CAN_MODIFY in", values, "canModify");
            return (Criteria) this;
        }

        public Criteria andCanModifyNotIn(List<String> values) {
            addCriterion("CAN_MODIFY not in", values, "canModify");
            return (Criteria) this;
        }

        public Criteria andCanModifyBetween(String value1, String value2) {
            addCriterion("CAN_MODIFY between", value1, value2, "canModify");
            return (Criteria) this;
        }

        public Criteria andCanModifyNotBetween(String value1, String value2) {
            addCriterion("CAN_MODIFY not between", value1, value2, "canModify");
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