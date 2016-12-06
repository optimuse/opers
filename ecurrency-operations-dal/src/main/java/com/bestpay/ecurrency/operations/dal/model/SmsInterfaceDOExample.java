package com.bestpay.ecurrency.operations.dal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SmsInterfaceDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmsInterfaceDOExample() {
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

        public Criteria andSmsSeqIsNull() {
            addCriterion("SMS_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andSmsSeqIsNotNull() {
            addCriterion("SMS_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andSmsSeqEqualTo(Long value) {
            addCriterion("SMS_SEQ =", value, "smsSeq");
            return (Criteria) this;
        }

        public Criteria andSmsSeqNotEqualTo(Long value) {
            addCriterion("SMS_SEQ <>", value, "smsSeq");
            return (Criteria) this;
        }

        public Criteria andSmsSeqGreaterThan(Long value) {
            addCriterion("SMS_SEQ >", value, "smsSeq");
            return (Criteria) this;
        }

        public Criteria andSmsSeqGreaterThanOrEqualTo(Long value) {
            addCriterion("SMS_SEQ >=", value, "smsSeq");
            return (Criteria) this;
        }

        public Criteria andSmsSeqLessThan(Long value) {
            addCriterion("SMS_SEQ <", value, "smsSeq");
            return (Criteria) this;
        }

        public Criteria andSmsSeqLessThanOrEqualTo(Long value) {
            addCriterion("SMS_SEQ <=", value, "smsSeq");
            return (Criteria) this;
        }

        public Criteria andSmsSeqIn(List<Long> values) {
            addCriterion("SMS_SEQ in", values, "smsSeq");
            return (Criteria) this;
        }

        public Criteria andSmsSeqNotIn(List<Long> values) {
            addCriterion("SMS_SEQ not in", values, "smsSeq");
            return (Criteria) this;
        }

        public Criteria andSmsSeqBetween(Long value1, Long value2) {
            addCriterion("SMS_SEQ between", value1, value2, "smsSeq");
            return (Criteria) this;
        }

        public Criteria andSmsSeqNotBetween(Long value1, Long value2) {
            addCriterion("SMS_SEQ not between", value1, value2, "smsSeq");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNull() {
            addCriterion("PHONENUMBER is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNotNull() {
            addCriterion("PHONENUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberEqualTo(String value) {
            addCriterion("PHONENUMBER =", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotEqualTo(String value) {
            addCriterion("PHONENUMBER <>", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThan(String value) {
            addCriterion("PHONENUMBER >", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThanOrEqualTo(String value) {
            addCriterion("PHONENUMBER >=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThan(String value) {
            addCriterion("PHONENUMBER <", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThanOrEqualTo(String value) {
            addCriterion("PHONENUMBER <=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLike(String value) {
            addCriterion("PHONENUMBER like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotLike(String value) {
            addCriterion("PHONENUMBER not like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIn(List<String> values) {
            addCriterion("PHONENUMBER in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotIn(List<String> values) {
            addCriterion("PHONENUMBER not in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberBetween(String value1, String value2) {
            addCriterion("PHONENUMBER between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotBetween(String value1, String value2) {
            addCriterion("PHONENUMBER not between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("PRIORITY is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("PRIORITY is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(String value) {
            addCriterion("PRIORITY =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(String value) {
            addCriterion("PRIORITY <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(String value) {
            addCriterion("PRIORITY >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(String value) {
            addCriterion("PRIORITY >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(String value) {
            addCriterion("PRIORITY <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(String value) {
            addCriterion("PRIORITY <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLike(String value) {
            addCriterion("PRIORITY like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotLike(String value) {
            addCriterion("PRIORITY not like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<String> values) {
            addCriterion("PRIORITY in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<String> values) {
            addCriterion("PRIORITY not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(String value1, String value2) {
            addCriterion("PRIORITY between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(String value1, String value2) {
            addCriterion("PRIORITY not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andSmsidIsNull() {
            addCriterion("SMSID is null");
            return (Criteria) this;
        }

        public Criteria andSmsidIsNotNull() {
            addCriterion("SMSID is not null");
            return (Criteria) this;
        }

        public Criteria andSmsidEqualTo(String value) {
            addCriterion("SMSID =", value, "smsid");
            return (Criteria) this;
        }

        public Criteria andSmsidNotEqualTo(String value) {
            addCriterion("SMSID <>", value, "smsid");
            return (Criteria) this;
        }

        public Criteria andSmsidGreaterThan(String value) {
            addCriterion("SMSID >", value, "smsid");
            return (Criteria) this;
        }

        public Criteria andSmsidGreaterThanOrEqualTo(String value) {
            addCriterion("SMSID >=", value, "smsid");
            return (Criteria) this;
        }

        public Criteria andSmsidLessThan(String value) {
            addCriterion("SMSID <", value, "smsid");
            return (Criteria) this;
        }

        public Criteria andSmsidLessThanOrEqualTo(String value) {
            addCriterion("SMSID <=", value, "smsid");
            return (Criteria) this;
        }

        public Criteria andSmsidLike(String value) {
            addCriterion("SMSID like", value, "smsid");
            return (Criteria) this;
        }

        public Criteria andSmsidNotLike(String value) {
            addCriterion("SMSID not like", value, "smsid");
            return (Criteria) this;
        }

        public Criteria andSmsidIn(List<String> values) {
            addCriterion("SMSID in", values, "smsid");
            return (Criteria) this;
        }

        public Criteria andSmsidNotIn(List<String> values) {
            addCriterion("SMSID not in", values, "smsid");
            return (Criteria) this;
        }

        public Criteria andSmsidBetween(String value1, String value2) {
            addCriterion("SMSID between", value1, value2, "smsid");
            return (Criteria) this;
        }

        public Criteria andSmsidNotBetween(String value1, String value2) {
            addCriterion("SMSID not between", value1, value2, "smsid");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("CONTENT =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("CONTENT <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("CONTENT >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("CONTENT <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("CONTENT <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("CONTENT like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("CONTENT not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("CONTENT in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("CONTENT not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("CONTENT between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("CONTENT not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andSubcodeIsNull() {
            addCriterion("SUBCODE is null");
            return (Criteria) this;
        }

        public Criteria andSubcodeIsNotNull() {
            addCriterion("SUBCODE is not null");
            return (Criteria) this;
        }

        public Criteria andSubcodeEqualTo(Long value) {
            addCriterion("SUBCODE =", value, "subcode");
            return (Criteria) this;
        }

        public Criteria andSubcodeNotEqualTo(Long value) {
            addCriterion("SUBCODE <>", value, "subcode");
            return (Criteria) this;
        }

        public Criteria andSubcodeGreaterThan(Long value) {
            addCriterion("SUBCODE >", value, "subcode");
            return (Criteria) this;
        }

        public Criteria andSubcodeGreaterThanOrEqualTo(Long value) {
            addCriterion("SUBCODE >=", value, "subcode");
            return (Criteria) this;
        }

        public Criteria andSubcodeLessThan(Long value) {
            addCriterion("SUBCODE <", value, "subcode");
            return (Criteria) this;
        }

        public Criteria andSubcodeLessThanOrEqualTo(Long value) {
            addCriterion("SUBCODE <=", value, "subcode");
            return (Criteria) this;
        }

        public Criteria andSubcodeIn(List<Long> values) {
            addCriterion("SUBCODE in", values, "subcode");
            return (Criteria) this;
        }

        public Criteria andSubcodeNotIn(List<Long> values) {
            addCriterion("SUBCODE not in", values, "subcode");
            return (Criteria) this;
        }

        public Criteria andSubcodeBetween(Long value1, Long value2) {
            addCriterion("SUBCODE between", value1, value2, "subcode");
            return (Criteria) this;
        }

        public Criteria andSubcodeNotBetween(Long value1, Long value2) {
            addCriterion("SUBCODE not between", value1, value2, "subcode");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNull() {
            addCriterion("SENDTIME is null");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNotNull() {
            addCriterion("SENDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andSendtimeEqualTo(String value) {
            addCriterion("SENDTIME =", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotEqualTo(String value) {
            addCriterion("SENDTIME <>", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThan(String value) {
            addCriterion("SENDTIME >", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThanOrEqualTo(String value) {
            addCriterion("SENDTIME >=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThan(String value) {
            addCriterion("SENDTIME <", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThanOrEqualTo(String value) {
            addCriterion("SENDTIME <=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLike(String value) {
            addCriterion("SENDTIME like", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotLike(String value) {
            addCriterion("SENDTIME not like", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIn(List<String> values) {
            addCriterion("SENDTIME in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotIn(List<String> values) {
            addCriterion("SENDTIME not in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeBetween(String value1, String value2) {
            addCriterion("SENDTIME between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotBetween(String value1, String value2) {
            addCriterion("SENDTIME not between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andOperTypeIsNull() {
            addCriterion("OPER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOperTypeIsNotNull() {
            addCriterion("OPER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOperTypeEqualTo(String value) {
            addCriterion("OPER_TYPE =", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotEqualTo(String value) {
            addCriterion("OPER_TYPE <>", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeGreaterThan(String value) {
            addCriterion("OPER_TYPE >", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_TYPE >=", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLessThan(String value) {
            addCriterion("OPER_TYPE <", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLessThanOrEqualTo(String value) {
            addCriterion("OPER_TYPE <=", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLike(String value) {
            addCriterion("OPER_TYPE like", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotLike(String value) {
            addCriterion("OPER_TYPE not like", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeIn(List<String> values) {
            addCriterion("OPER_TYPE in", values, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotIn(List<String> values) {
            addCriterion("OPER_TYPE not in", values, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeBetween(String value1, String value2) {
            addCriterion("OPER_TYPE between", value1, value2, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotBetween(String value1, String value2) {
            addCriterion("OPER_TYPE not between", value1, value2, "operType");
            return (Criteria) this;
        }

        public Criteria andSourceIpIsNull() {
            addCriterion("SOURCE_IP is null");
            return (Criteria) this;
        }

        public Criteria andSourceIpIsNotNull() {
            addCriterion("SOURCE_IP is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIpEqualTo(String value) {
            addCriterion("SOURCE_IP =", value, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpNotEqualTo(String value) {
            addCriterion("SOURCE_IP <>", value, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpGreaterThan(String value) {
            addCriterion("SOURCE_IP >", value, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpGreaterThanOrEqualTo(String value) {
            addCriterion("SOURCE_IP >=", value, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpLessThan(String value) {
            addCriterion("SOURCE_IP <", value, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpLessThanOrEqualTo(String value) {
            addCriterion("SOURCE_IP <=", value, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpLike(String value) {
            addCriterion("SOURCE_IP like", value, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpNotLike(String value) {
            addCriterion("SOURCE_IP not like", value, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpIn(List<String> values) {
            addCriterion("SOURCE_IP in", values, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpNotIn(List<String> values) {
            addCriterion("SOURCE_IP not in", values, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpBetween(String value1, String value2) {
            addCriterion("SOURCE_IP between", value1, value2, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andSourceIpNotBetween(String value1, String value2) {
            addCriterion("SOURCE_IP not between", value1, value2, "sourceIp");
            return (Criteria) this;
        }

        public Criteria andIsLockIsNull() {
            addCriterion("IS_LOCK is null");
            return (Criteria) this;
        }

        public Criteria andIsLockIsNotNull() {
            addCriterion("IS_LOCK is not null");
            return (Criteria) this;
        }

        public Criteria andIsLockEqualTo(Short value) {
            addCriterion("IS_LOCK =", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockNotEqualTo(Short value) {
            addCriterion("IS_LOCK <>", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockGreaterThan(Short value) {
            addCriterion("IS_LOCK >", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_LOCK >=", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockLessThan(Short value) {
            addCriterion("IS_LOCK <", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockLessThanOrEqualTo(Short value) {
            addCriterion("IS_LOCK <=", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockIn(List<Short> values) {
            addCriterion("IS_LOCK in", values, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockNotIn(List<Short> values) {
            addCriterion("IS_LOCK not in", values, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockBetween(Short value1, Short value2) {
            addCriterion("IS_LOCK between", value1, value2, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockNotBetween(Short value1, Short value2) {
            addCriterion("IS_LOCK not between", value1, value2, "isLock");
            return (Criteria) this;
        }

        public Criteria andLockTimeIsNull() {
            addCriterion("LOCK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLockTimeIsNotNull() {
            addCriterion("LOCK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLockTimeEqualTo(Date value) {
            addCriterion("LOCK_TIME =", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeNotEqualTo(Date value) {
            addCriterion("LOCK_TIME <>", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeGreaterThan(Date value) {
            addCriterion("LOCK_TIME >", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LOCK_TIME >=", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeLessThan(Date value) {
            addCriterion("LOCK_TIME <", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeLessThanOrEqualTo(Date value) {
            addCriterion("LOCK_TIME <=", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeIn(List<Date> values) {
            addCriterion("LOCK_TIME in", values, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeNotIn(List<Date> values) {
            addCriterion("LOCK_TIME not in", values, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeBetween(Date value1, Date value2) {
            addCriterion("LOCK_TIME between", value1, value2, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeNotBetween(Date value1, Date value2) {
            addCriterion("LOCK_TIME not between", value1, value2, "lockTime");
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