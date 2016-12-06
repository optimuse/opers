package com.bestpay.ecurrency.operations.dal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EoSymStaffDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EoSymStaffDOExample() {
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

        public Criteria andStaffIdIsNull() {
            addCriterion("STAFF_ID is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdIsNotNull() {
            addCriterion("STAFF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdEqualTo(String value) {
            addCriterion("STAFF_ID =", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotEqualTo(String value) {
            addCriterion("STAFF_ID <>", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThan(String value) {
            addCriterion("STAFF_ID >", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdGreaterThanOrEqualTo(String value) {
            addCriterion("STAFF_ID >=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThan(String value) {
            addCriterion("STAFF_ID <", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLessThanOrEqualTo(String value) {
            addCriterion("STAFF_ID <=", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdLike(String value) {
            addCriterion("STAFF_ID like", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotLike(String value) {
            addCriterion("STAFF_ID not like", value, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdIn(List<String> values) {
            addCriterion("STAFF_ID in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotIn(List<String> values) {
            addCriterion("STAFF_ID not in", values, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdBetween(String value1, String value2) {
            addCriterion("STAFF_ID between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffIdNotBetween(String value1, String value2) {
            addCriterion("STAFF_ID not between", value1, value2, "staffId");
            return (Criteria) this;
        }

        public Criteria andStaffCodeIsNull() {
            addCriterion("STAFF_CODE is null");
            return (Criteria) this;
        }

        public Criteria andStaffCodeIsNotNull() {
            addCriterion("STAFF_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andStaffCodeEqualTo(String value) {
            addCriterion("STAFF_CODE =", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeNotEqualTo(String value) {
            addCriterion("STAFF_CODE <>", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeGreaterThan(String value) {
            addCriterion("STAFF_CODE >", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeGreaterThanOrEqualTo(String value) {
            addCriterion("STAFF_CODE >=", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeLessThan(String value) {
            addCriterion("STAFF_CODE <", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeLessThanOrEqualTo(String value) {
            addCriterion("STAFF_CODE <=", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeLike(String value) {
            addCriterion("STAFF_CODE like", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeNotLike(String value) {
            addCriterion("STAFF_CODE not like", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeIn(List<String> values) {
            addCriterion("STAFF_CODE in", values, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeNotIn(List<String> values) {
            addCriterion("STAFF_CODE not in", values, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeBetween(String value1, String value2) {
            addCriterion("STAFF_CODE between", value1, value2, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeNotBetween(String value1, String value2) {
            addCriterion("STAFF_CODE not between", value1, value2, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNull() {
            addCriterion("STAFF_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNotNull() {
            addCriterion("STAFF_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNameEqualTo(String value) {
            addCriterion("STAFF_NAME =", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotEqualTo(String value) {
            addCriterion("STAFF_NAME <>", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThan(String value) {
            addCriterion("STAFF_NAME >", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("STAFF_NAME >=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThan(String value) {
            addCriterion("STAFF_NAME <", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThanOrEqualTo(String value) {
            addCriterion("STAFF_NAME <=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLike(String value) {
            addCriterion("STAFF_NAME like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotLike(String value) {
            addCriterion("STAFF_NAME not like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameIn(List<String> values) {
            addCriterion("STAFF_NAME in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotIn(List<String> values) {
            addCriterion("STAFF_NAME not in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameBetween(String value1, String value2) {
            addCriterion("STAFF_NAME between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotBetween(String value1, String value2) {
            addCriterion("STAFF_NAME not between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(Long value) {
            addCriterion("ORG_ID =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(Long value) {
            addCriterion("ORG_ID <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(Long value) {
            addCriterion("ORG_ID >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ORG_ID >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(Long value) {
            addCriterion("ORG_ID <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(Long value) {
            addCriterion("ORG_ID <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<Long> values) {
            addCriterion("ORG_ID in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<Long> values) {
            addCriterion("ORG_ID not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(Long value1, Long value2) {
            addCriterion("ORG_ID between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(Long value1, Long value2) {
            addCriterion("ORG_ID not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("SEX is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("SEX is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("SEX =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("SEX <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("SEX >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("SEX >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("SEX <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("SEX <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("SEX like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("SEX not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("SEX in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("SEX not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("SEX between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("SEX not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNull() {
            addCriterion("PHOTO is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNotNull() {
            addCriterion("PHOTO is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoEqualTo(String value) {
            addCriterion("PHOTO =", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotEqualTo(String value) {
            addCriterion("PHOTO <>", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThan(String value) {
            addCriterion("PHOTO >", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("PHOTO >=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThan(String value) {
            addCriterion("PHOTO <", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThanOrEqualTo(String value) {
            addCriterion("PHOTO <=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLike(String value) {
            addCriterion("PHOTO like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotLike(String value) {
            addCriterion("PHOTO not like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoIn(List<String> values) {
            addCriterion("PHOTO in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotIn(List<String> values) {
            addCriterion("PHOTO not in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoBetween(String value1, String value2) {
            addCriterion("PHOTO between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotBetween(String value1, String value2) {
            addCriterion("PHOTO not between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("MOBILE =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("MOBILE <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("MOBILE >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("MOBILE <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("MOBILE <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("MOBILE like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("MOBILE not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("MOBILE in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("MOBILE not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("MOBILE between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("MOBILE not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andZipIsNull() {
            addCriterion("ZIP is null");
            return (Criteria) this;
        }

        public Criteria andZipIsNotNull() {
            addCriterion("ZIP is not null");
            return (Criteria) this;
        }

        public Criteria andZipEqualTo(String value) {
            addCriterion("ZIP =", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotEqualTo(String value) {
            addCriterion("ZIP <>", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipGreaterThan(String value) {
            addCriterion("ZIP >", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipGreaterThanOrEqualTo(String value) {
            addCriterion("ZIP >=", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLessThan(String value) {
            addCriterion("ZIP <", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLessThanOrEqualTo(String value) {
            addCriterion("ZIP <=", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLike(String value) {
            addCriterion("ZIP like", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotLike(String value) {
            addCriterion("ZIP not like", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipIn(List<String> values) {
            addCriterion("ZIP in", values, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotIn(List<String> values) {
            addCriterion("ZIP not in", values, "zip");
            return (Criteria) this;
        }

        public Criteria andZipBetween(String value1, String value2) {
            addCriterion("ZIP between", value1, value2, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotBetween(String value1, String value2) {
            addCriterion("ZIP not between", value1, value2, "zip");
            return (Criteria) this;
        }

        public Criteria andCertTypeIsNull() {
            addCriterion("CERT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCertTypeIsNotNull() {
            addCriterion("CERT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCertTypeEqualTo(String value) {
            addCriterion("CERT_TYPE =", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotEqualTo(String value) {
            addCriterion("CERT_TYPE <>", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeGreaterThan(String value) {
            addCriterion("CERT_TYPE >", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_TYPE >=", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLessThan(String value) {
            addCriterion("CERT_TYPE <", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLessThanOrEqualTo(String value) {
            addCriterion("CERT_TYPE <=", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeLike(String value) {
            addCriterion("CERT_TYPE like", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotLike(String value) {
            addCriterion("CERT_TYPE not like", value, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeIn(List<String> values) {
            addCriterion("CERT_TYPE in", values, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotIn(List<String> values) {
            addCriterion("CERT_TYPE not in", values, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeBetween(String value1, String value2) {
            addCriterion("CERT_TYPE between", value1, value2, "certType");
            return (Criteria) this;
        }

        public Criteria andCertTypeNotBetween(String value1, String value2) {
            addCriterion("CERT_TYPE not between", value1, value2, "certType");
            return (Criteria) this;
        }

        public Criteria andCertNbrIsNull() {
            addCriterion("CERT_NBR is null");
            return (Criteria) this;
        }

        public Criteria andCertNbrIsNotNull() {
            addCriterion("CERT_NBR is not null");
            return (Criteria) this;
        }

        public Criteria andCertNbrEqualTo(String value) {
            addCriterion("CERT_NBR =", value, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrNotEqualTo(String value) {
            addCriterion("CERT_NBR <>", value, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrGreaterThan(String value) {
            addCriterion("CERT_NBR >", value, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrGreaterThanOrEqualTo(String value) {
            addCriterion("CERT_NBR >=", value, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrLessThan(String value) {
            addCriterion("CERT_NBR <", value, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrLessThanOrEqualTo(String value) {
            addCriterion("CERT_NBR <=", value, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrLike(String value) {
            addCriterion("CERT_NBR like", value, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrNotLike(String value) {
            addCriterion("CERT_NBR not like", value, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrIn(List<String> values) {
            addCriterion("CERT_NBR in", values, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrNotIn(List<String> values) {
            addCriterion("CERT_NBR not in", values, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrBetween(String value1, String value2) {
            addCriterion("CERT_NBR between", value1, value2, "certNbr");
            return (Criteria) this;
        }

        public Criteria andCertNbrNotBetween(String value1, String value2) {
            addCriterion("CERT_NBR not between", value1, value2, "certNbr");
            return (Criteria) this;
        }

        public Criteria andEffDateIsNull() {
            addCriterion("EFF_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEffDateIsNotNull() {
            addCriterion("EFF_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEffDateEqualTo(Date value) {
            addCriterion("EFF_DATE =", value, "effDate");
            return (Criteria) this;
        }

        public Criteria andEffDateNotEqualTo(Date value) {
            addCriterion("EFF_DATE <>", value, "effDate");
            return (Criteria) this;
        }

        public Criteria andEffDateGreaterThan(Date value) {
            addCriterion("EFF_DATE >", value, "effDate");
            return (Criteria) this;
        }

        public Criteria andEffDateGreaterThanOrEqualTo(Date value) {
            addCriterion("EFF_DATE >=", value, "effDate");
            return (Criteria) this;
        }

        public Criteria andEffDateLessThan(Date value) {
            addCriterion("EFF_DATE <", value, "effDate");
            return (Criteria) this;
        }

        public Criteria andEffDateLessThanOrEqualTo(Date value) {
            addCriterion("EFF_DATE <=", value, "effDate");
            return (Criteria) this;
        }

        public Criteria andEffDateIn(List<Date> values) {
            addCriterion("EFF_DATE in", values, "effDate");
            return (Criteria) this;
        }

        public Criteria andEffDateNotIn(List<Date> values) {
            addCriterion("EFF_DATE not in", values, "effDate");
            return (Criteria) this;
        }

        public Criteria andEffDateBetween(Date value1, Date value2) {
            addCriterion("EFF_DATE between", value1, value2, "effDate");
            return (Criteria) this;
        }

        public Criteria andEffDateNotBetween(Date value1, Date value2) {
            addCriterion("EFF_DATE not between", value1, value2, "effDate");
            return (Criteria) this;
        }

        public Criteria andExpDateIsNull() {
            addCriterion("EXP_DATE is null");
            return (Criteria) this;
        }

        public Criteria andExpDateIsNotNull() {
            addCriterion("EXP_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andExpDateEqualTo(Date value) {
            addCriterion("EXP_DATE =", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateNotEqualTo(Date value) {
            addCriterion("EXP_DATE <>", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateGreaterThan(Date value) {
            addCriterion("EXP_DATE >", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateGreaterThanOrEqualTo(Date value) {
            addCriterion("EXP_DATE >=", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateLessThan(Date value) {
            addCriterion("EXP_DATE <", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateLessThanOrEqualTo(Date value) {
            addCriterion("EXP_DATE <=", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateIn(List<Date> values) {
            addCriterion("EXP_DATE in", values, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateNotIn(List<Date> values) {
            addCriterion("EXP_DATE not in", values, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateBetween(Date value1, Date value2) {
            addCriterion("EXP_DATE between", value1, value2, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateNotBetween(Date value1, Date value2) {
            addCriterion("EXP_DATE not between", value1, value2, "expDate");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPwdStatIsNull() {
            addCriterion("PWD_STAT is null");
            return (Criteria) this;
        }

        public Criteria andPwdStatIsNotNull() {
            addCriterion("PWD_STAT is not null");
            return (Criteria) this;
        }

        public Criteria andPwdStatEqualTo(String value) {
            addCriterion("PWD_STAT =", value, "pwdStat");
            return (Criteria) this;
        }

        public Criteria andPwdStatNotEqualTo(String value) {
            addCriterion("PWD_STAT <>", value, "pwdStat");
            return (Criteria) this;
        }

        public Criteria andPwdStatGreaterThan(String value) {
            addCriterion("PWD_STAT >", value, "pwdStat");
            return (Criteria) this;
        }

        public Criteria andPwdStatGreaterThanOrEqualTo(String value) {
            addCriterion("PWD_STAT >=", value, "pwdStat");
            return (Criteria) this;
        }

        public Criteria andPwdStatLessThan(String value) {
            addCriterion("PWD_STAT <", value, "pwdStat");
            return (Criteria) this;
        }

        public Criteria andPwdStatLessThanOrEqualTo(String value) {
            addCriterion("PWD_STAT <=", value, "pwdStat");
            return (Criteria) this;
        }

        public Criteria andPwdStatLike(String value) {
            addCriterion("PWD_STAT like", value, "pwdStat");
            return (Criteria) this;
        }

        public Criteria andPwdStatNotLike(String value) {
            addCriterion("PWD_STAT not like", value, "pwdStat");
            return (Criteria) this;
        }

        public Criteria andPwdStatIn(List<String> values) {
            addCriterion("PWD_STAT in", values, "pwdStat");
            return (Criteria) this;
        }

        public Criteria andPwdStatNotIn(List<String> values) {
            addCriterion("PWD_STAT not in", values, "pwdStat");
            return (Criteria) this;
        }

        public Criteria andPwdStatBetween(String value1, String value2) {
            addCriterion("PWD_STAT between", value1, value2, "pwdStat");
            return (Criteria) this;
        }

        public Criteria andPwdStatNotBetween(String value1, String value2) {
            addCriterion("PWD_STAT not between", value1, value2, "pwdStat");
            return (Criteria) this;
        }

        public Criteria andPwdCtrlIsNull() {
            addCriterion("PWD_CTRL is null");
            return (Criteria) this;
        }

        public Criteria andPwdCtrlIsNotNull() {
            addCriterion("PWD_CTRL is not null");
            return (Criteria) this;
        }

        public Criteria andPwdCtrlEqualTo(String value) {
            addCriterion("PWD_CTRL =", value, "pwdCtrl");
            return (Criteria) this;
        }

        public Criteria andPwdCtrlNotEqualTo(String value) {
            addCriterion("PWD_CTRL <>", value, "pwdCtrl");
            return (Criteria) this;
        }

        public Criteria andPwdCtrlGreaterThan(String value) {
            addCriterion("PWD_CTRL >", value, "pwdCtrl");
            return (Criteria) this;
        }

        public Criteria andPwdCtrlGreaterThanOrEqualTo(String value) {
            addCriterion("PWD_CTRL >=", value, "pwdCtrl");
            return (Criteria) this;
        }

        public Criteria andPwdCtrlLessThan(String value) {
            addCriterion("PWD_CTRL <", value, "pwdCtrl");
            return (Criteria) this;
        }

        public Criteria andPwdCtrlLessThanOrEqualTo(String value) {
            addCriterion("PWD_CTRL <=", value, "pwdCtrl");
            return (Criteria) this;
        }

        public Criteria andPwdCtrlLike(String value) {
            addCriterion("PWD_CTRL like", value, "pwdCtrl");
            return (Criteria) this;
        }

        public Criteria andPwdCtrlNotLike(String value) {
            addCriterion("PWD_CTRL not like", value, "pwdCtrl");
            return (Criteria) this;
        }

        public Criteria andPwdCtrlIn(List<String> values) {
            addCriterion("PWD_CTRL in", values, "pwdCtrl");
            return (Criteria) this;
        }

        public Criteria andPwdCtrlNotIn(List<String> values) {
            addCriterion("PWD_CTRL not in", values, "pwdCtrl");
            return (Criteria) this;
        }

        public Criteria andPwdCtrlBetween(String value1, String value2) {
            addCriterion("PWD_CTRL between", value1, value2, "pwdCtrl");
            return (Criteria) this;
        }

        public Criteria andPwdCtrlNotBetween(String value1, String value2) {
            addCriterion("PWD_CTRL not between", value1, value2, "pwdCtrl");
            return (Criteria) this;
        }

        public Criteria andPwdNewtimeIsNull() {
            addCriterion("PWD_NEWTIME is null");
            return (Criteria) this;
        }

        public Criteria andPwdNewtimeIsNotNull() {
            addCriterion("PWD_NEWTIME is not null");
            return (Criteria) this;
        }

        public Criteria andPwdNewtimeEqualTo(Date value) {
            addCriterion("PWD_NEWTIME =", value, "pwdNewtime");
            return (Criteria) this;
        }

        public Criteria andPwdNewtimeNotEqualTo(Date value) {
            addCriterion("PWD_NEWTIME <>", value, "pwdNewtime");
            return (Criteria) this;
        }

        public Criteria andPwdNewtimeGreaterThan(Date value) {
            addCriterion("PWD_NEWTIME >", value, "pwdNewtime");
            return (Criteria) this;
        }

        public Criteria andPwdNewtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PWD_NEWTIME >=", value, "pwdNewtime");
            return (Criteria) this;
        }

        public Criteria andPwdNewtimeLessThan(Date value) {
            addCriterion("PWD_NEWTIME <", value, "pwdNewtime");
            return (Criteria) this;
        }

        public Criteria andPwdNewtimeLessThanOrEqualTo(Date value) {
            addCriterion("PWD_NEWTIME <=", value, "pwdNewtime");
            return (Criteria) this;
        }

        public Criteria andPwdNewtimeIn(List<Date> values) {
            addCriterion("PWD_NEWTIME in", values, "pwdNewtime");
            return (Criteria) this;
        }

        public Criteria andPwdNewtimeNotIn(List<Date> values) {
            addCriterion("PWD_NEWTIME not in", values, "pwdNewtime");
            return (Criteria) this;
        }

        public Criteria andPwdNewtimeBetween(Date value1, Date value2) {
            addCriterion("PWD_NEWTIME between", value1, value2, "pwdNewtime");
            return (Criteria) this;
        }

        public Criteria andPwdNewtimeNotBetween(Date value1, Date value2) {
            addCriterion("PWD_NEWTIME not between", value1, value2, "pwdNewtime");
            return (Criteria) this;
        }

        public Criteria andPwdValiddayIsNull() {
            addCriterion("PWD_VALIDDAY is null");
            return (Criteria) this;
        }

        public Criteria andPwdValiddayIsNotNull() {
            addCriterion("PWD_VALIDDAY is not null");
            return (Criteria) this;
        }

        public Criteria andPwdValiddayEqualTo(Integer value) {
            addCriterion("PWD_VALIDDAY =", value, "pwdValidday");
            return (Criteria) this;
        }

        public Criteria andPwdValiddayNotEqualTo(Integer value) {
            addCriterion("PWD_VALIDDAY <>", value, "pwdValidday");
            return (Criteria) this;
        }

        public Criteria andPwdValiddayGreaterThan(Integer value) {
            addCriterion("PWD_VALIDDAY >", value, "pwdValidday");
            return (Criteria) this;
        }

        public Criteria andPwdValiddayGreaterThanOrEqualTo(Integer value) {
            addCriterion("PWD_VALIDDAY >=", value, "pwdValidday");
            return (Criteria) this;
        }

        public Criteria andPwdValiddayLessThan(Integer value) {
            addCriterion("PWD_VALIDDAY <", value, "pwdValidday");
            return (Criteria) this;
        }

        public Criteria andPwdValiddayLessThanOrEqualTo(Integer value) {
            addCriterion("PWD_VALIDDAY <=", value, "pwdValidday");
            return (Criteria) this;
        }

        public Criteria andPwdValiddayIn(List<Integer> values) {
            addCriterion("PWD_VALIDDAY in", values, "pwdValidday");
            return (Criteria) this;
        }

        public Criteria andPwdValiddayNotIn(List<Integer> values) {
            addCriterion("PWD_VALIDDAY not in", values, "pwdValidday");
            return (Criteria) this;
        }

        public Criteria andPwdValiddayBetween(Integer value1, Integer value2) {
            addCriterion("PWD_VALIDDAY between", value1, value2, "pwdValidday");
            return (Criteria) this;
        }

        public Criteria andPwdValiddayNotBetween(Integer value1, Integer value2) {
            addCriterion("PWD_VALIDDAY not between", value1, value2, "pwdValidday");
            return (Criteria) this;
        }

        public Criteria andPwdErrtimesIsNull() {
            addCriterion("PWD_ERRTIMES is null");
            return (Criteria) this;
        }

        public Criteria andPwdErrtimesIsNotNull() {
            addCriterion("PWD_ERRTIMES is not null");
            return (Criteria) this;
        }

        public Criteria andPwdErrtimesEqualTo(Short value) {
            addCriterion("PWD_ERRTIMES =", value, "pwdErrtimes");
            return (Criteria) this;
        }

        public Criteria andPwdErrtimesNotEqualTo(Short value) {
            addCriterion("PWD_ERRTIMES <>", value, "pwdErrtimes");
            return (Criteria) this;
        }

        public Criteria andPwdErrtimesGreaterThan(Short value) {
            addCriterion("PWD_ERRTIMES >", value, "pwdErrtimes");
            return (Criteria) this;
        }

        public Criteria andPwdErrtimesGreaterThanOrEqualTo(Short value) {
            addCriterion("PWD_ERRTIMES >=", value, "pwdErrtimes");
            return (Criteria) this;
        }

        public Criteria andPwdErrtimesLessThan(Short value) {
            addCriterion("PWD_ERRTIMES <", value, "pwdErrtimes");
            return (Criteria) this;
        }

        public Criteria andPwdErrtimesLessThanOrEqualTo(Short value) {
            addCriterion("PWD_ERRTIMES <=", value, "pwdErrtimes");
            return (Criteria) this;
        }

        public Criteria andPwdErrtimesIn(List<Short> values) {
            addCriterion("PWD_ERRTIMES in", values, "pwdErrtimes");
            return (Criteria) this;
        }

        public Criteria andPwdErrtimesNotIn(List<Short> values) {
            addCriterion("PWD_ERRTIMES not in", values, "pwdErrtimes");
            return (Criteria) this;
        }

        public Criteria andPwdErrtimesBetween(Short value1, Short value2) {
            addCriterion("PWD_ERRTIMES between", value1, value2, "pwdErrtimes");
            return (Criteria) this;
        }

        public Criteria andPwdErrtimesNotBetween(Short value1, Short value2) {
            addCriterion("PWD_ERRTIMES not between", value1, value2, "pwdErrtimes");
            return (Criteria) this;
        }

        public Criteria andPwdTrytimesIsNull() {
            addCriterion("PWD_TRYTIMES is null");
            return (Criteria) this;
        }

        public Criteria andPwdTrytimesIsNotNull() {
            addCriterion("PWD_TRYTIMES is not null");
            return (Criteria) this;
        }

        public Criteria andPwdTrytimesEqualTo(Short value) {
            addCriterion("PWD_TRYTIMES =", value, "pwdTrytimes");
            return (Criteria) this;
        }

        public Criteria andPwdTrytimesNotEqualTo(Short value) {
            addCriterion("PWD_TRYTIMES <>", value, "pwdTrytimes");
            return (Criteria) this;
        }

        public Criteria andPwdTrytimesGreaterThan(Short value) {
            addCriterion("PWD_TRYTIMES >", value, "pwdTrytimes");
            return (Criteria) this;
        }

        public Criteria andPwdTrytimesGreaterThanOrEqualTo(Short value) {
            addCriterion("PWD_TRYTIMES >=", value, "pwdTrytimes");
            return (Criteria) this;
        }

        public Criteria andPwdTrytimesLessThan(Short value) {
            addCriterion("PWD_TRYTIMES <", value, "pwdTrytimes");
            return (Criteria) this;
        }

        public Criteria andPwdTrytimesLessThanOrEqualTo(Short value) {
            addCriterion("PWD_TRYTIMES <=", value, "pwdTrytimes");
            return (Criteria) this;
        }

        public Criteria andPwdTrytimesIn(List<Short> values) {
            addCriterion("PWD_TRYTIMES in", values, "pwdTrytimes");
            return (Criteria) this;
        }

        public Criteria andPwdTrytimesNotIn(List<Short> values) {
            addCriterion("PWD_TRYTIMES not in", values, "pwdTrytimes");
            return (Criteria) this;
        }

        public Criteria andPwdTrytimesBetween(Short value1, Short value2) {
            addCriterion("PWD_TRYTIMES between", value1, value2, "pwdTrytimes");
            return (Criteria) this;
        }

        public Criteria andPwdTrytimesNotBetween(Short value1, Short value2) {
            addCriterion("PWD_TRYTIMES not between", value1, value2, "pwdTrytimes");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("MEMO is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("MEMO is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("MEMO =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("MEMO <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("MEMO >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("MEMO >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("MEMO <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("MEMO <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("MEMO like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("MEMO not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("MEMO in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("MEMO not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("MEMO between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("MEMO not between", value1, value2, "memo");
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

        public Criteria andErrTimeCursorIsNull() {
            addCriterion("ERR_TIME_CURSOR is null");
            return (Criteria) this;
        }

        public Criteria andErrTimeCursorIsNotNull() {
            addCriterion("ERR_TIME_CURSOR is not null");
            return (Criteria) this;
        }

        public Criteria andErrTimeCursorEqualTo(Date value) {
            addCriterion("ERR_TIME_CURSOR =", value, "errTimeCursor");
            return (Criteria) this;
        }

        public Criteria andErrTimeCursorNotEqualTo(Date value) {
            addCriterion("ERR_TIME_CURSOR <>", value, "errTimeCursor");
            return (Criteria) this;
        }

        public Criteria andErrTimeCursorGreaterThan(Date value) {
            addCriterion("ERR_TIME_CURSOR >", value, "errTimeCursor");
            return (Criteria) this;
        }

        public Criteria andErrTimeCursorGreaterThanOrEqualTo(Date value) {
            addCriterion("ERR_TIME_CURSOR >=", value, "errTimeCursor");
            return (Criteria) this;
        }

        public Criteria andErrTimeCursorLessThan(Date value) {
            addCriterion("ERR_TIME_CURSOR <", value, "errTimeCursor");
            return (Criteria) this;
        }

        public Criteria andErrTimeCursorLessThanOrEqualTo(Date value) {
            addCriterion("ERR_TIME_CURSOR <=", value, "errTimeCursor");
            return (Criteria) this;
        }

        public Criteria andErrTimeCursorIn(List<Date> values) {
            addCriterion("ERR_TIME_CURSOR in", values, "errTimeCursor");
            return (Criteria) this;
        }

        public Criteria andErrTimeCursorNotIn(List<Date> values) {
            addCriterion("ERR_TIME_CURSOR not in", values, "errTimeCursor");
            return (Criteria) this;
        }

        public Criteria andErrTimeCursorBetween(Date value1, Date value2) {
            addCriterion("ERR_TIME_CURSOR between", value1, value2, "errTimeCursor");
            return (Criteria) this;
        }

        public Criteria andErrTimeCursorNotBetween(Date value1, Date value2) {
            addCriterion("ERR_TIME_CURSOR not between", value1, value2, "errTimeCursor");
            return (Criteria) this;
        }

        public Criteria andPwdChange1IsNull() {
            addCriterion("PWD_CHANGE1 is null");
            return (Criteria) this;
        }

        public Criteria andPwdChange1IsNotNull() {
            addCriterion("PWD_CHANGE1 is not null");
            return (Criteria) this;
        }

        public Criteria andPwdChange1EqualTo(String value) {
            addCriterion("PWD_CHANGE1 =", value, "pwdChange1");
            return (Criteria) this;
        }

        public Criteria andPwdChange1NotEqualTo(String value) {
            addCriterion("PWD_CHANGE1 <>", value, "pwdChange1");
            return (Criteria) this;
        }

        public Criteria andPwdChange1GreaterThan(String value) {
            addCriterion("PWD_CHANGE1 >", value, "pwdChange1");
            return (Criteria) this;
        }

        public Criteria andPwdChange1GreaterThanOrEqualTo(String value) {
            addCriterion("PWD_CHANGE1 >=", value, "pwdChange1");
            return (Criteria) this;
        }

        public Criteria andPwdChange1LessThan(String value) {
            addCriterion("PWD_CHANGE1 <", value, "pwdChange1");
            return (Criteria) this;
        }

        public Criteria andPwdChange1LessThanOrEqualTo(String value) {
            addCriterion("PWD_CHANGE1 <=", value, "pwdChange1");
            return (Criteria) this;
        }

        public Criteria andPwdChange1Like(String value) {
            addCriterion("PWD_CHANGE1 like", value, "pwdChange1");
            return (Criteria) this;
        }

        public Criteria andPwdChange1NotLike(String value) {
            addCriterion("PWD_CHANGE1 not like", value, "pwdChange1");
            return (Criteria) this;
        }

        public Criteria andPwdChange1In(List<String> values) {
            addCriterion("PWD_CHANGE1 in", values, "pwdChange1");
            return (Criteria) this;
        }

        public Criteria andPwdChange1NotIn(List<String> values) {
            addCriterion("PWD_CHANGE1 not in", values, "pwdChange1");
            return (Criteria) this;
        }

        public Criteria andPwdChange1Between(String value1, String value2) {
            addCriterion("PWD_CHANGE1 between", value1, value2, "pwdChange1");
            return (Criteria) this;
        }

        public Criteria andPwdChange1NotBetween(String value1, String value2) {
            addCriterion("PWD_CHANGE1 not between", value1, value2, "pwdChange1");
            return (Criteria) this;
        }

        public Criteria andPwdChange2IsNull() {
            addCriterion("PWD_CHANGE2 is null");
            return (Criteria) this;
        }

        public Criteria andPwdChange2IsNotNull() {
            addCriterion("PWD_CHANGE2 is not null");
            return (Criteria) this;
        }

        public Criteria andPwdChange2EqualTo(String value) {
            addCriterion("PWD_CHANGE2 =", value, "pwdChange2");
            return (Criteria) this;
        }

        public Criteria andPwdChange2NotEqualTo(String value) {
            addCriterion("PWD_CHANGE2 <>", value, "pwdChange2");
            return (Criteria) this;
        }

        public Criteria andPwdChange2GreaterThan(String value) {
            addCriterion("PWD_CHANGE2 >", value, "pwdChange2");
            return (Criteria) this;
        }

        public Criteria andPwdChange2GreaterThanOrEqualTo(String value) {
            addCriterion("PWD_CHANGE2 >=", value, "pwdChange2");
            return (Criteria) this;
        }

        public Criteria andPwdChange2LessThan(String value) {
            addCriterion("PWD_CHANGE2 <", value, "pwdChange2");
            return (Criteria) this;
        }

        public Criteria andPwdChange2LessThanOrEqualTo(String value) {
            addCriterion("PWD_CHANGE2 <=", value, "pwdChange2");
            return (Criteria) this;
        }

        public Criteria andPwdChange2Like(String value) {
            addCriterion("PWD_CHANGE2 like", value, "pwdChange2");
            return (Criteria) this;
        }

        public Criteria andPwdChange2NotLike(String value) {
            addCriterion("PWD_CHANGE2 not like", value, "pwdChange2");
            return (Criteria) this;
        }

        public Criteria andPwdChange2In(List<String> values) {
            addCriterion("PWD_CHANGE2 in", values, "pwdChange2");
            return (Criteria) this;
        }

        public Criteria andPwdChange2NotIn(List<String> values) {
            addCriterion("PWD_CHANGE2 not in", values, "pwdChange2");
            return (Criteria) this;
        }

        public Criteria andPwdChange2Between(String value1, String value2) {
            addCriterion("PWD_CHANGE2 between", value1, value2, "pwdChange2");
            return (Criteria) this;
        }

        public Criteria andPwdChange2NotBetween(String value1, String value2) {
            addCriterion("PWD_CHANGE2 not between", value1, value2, "pwdChange2");
            return (Criteria) this;
        }

        public Criteria andPwdChange3IsNull() {
            addCriterion("PWD_CHANGE3 is null");
            return (Criteria) this;
        }

        public Criteria andPwdChange3IsNotNull() {
            addCriterion("PWD_CHANGE3 is not null");
            return (Criteria) this;
        }

        public Criteria andPwdChange3EqualTo(String value) {
            addCriterion("PWD_CHANGE3 =", value, "pwdChange3");
            return (Criteria) this;
        }

        public Criteria andPwdChange3NotEqualTo(String value) {
            addCriterion("PWD_CHANGE3 <>", value, "pwdChange3");
            return (Criteria) this;
        }

        public Criteria andPwdChange3GreaterThan(String value) {
            addCriterion("PWD_CHANGE3 >", value, "pwdChange3");
            return (Criteria) this;
        }

        public Criteria andPwdChange3GreaterThanOrEqualTo(String value) {
            addCriterion("PWD_CHANGE3 >=", value, "pwdChange3");
            return (Criteria) this;
        }

        public Criteria andPwdChange3LessThan(String value) {
            addCriterion("PWD_CHANGE3 <", value, "pwdChange3");
            return (Criteria) this;
        }

        public Criteria andPwdChange3LessThanOrEqualTo(String value) {
            addCriterion("PWD_CHANGE3 <=", value, "pwdChange3");
            return (Criteria) this;
        }

        public Criteria andPwdChange3Like(String value) {
            addCriterion("PWD_CHANGE3 like", value, "pwdChange3");
            return (Criteria) this;
        }

        public Criteria andPwdChange3NotLike(String value) {
            addCriterion("PWD_CHANGE3 not like", value, "pwdChange3");
            return (Criteria) this;
        }

        public Criteria andPwdChange3In(List<String> values) {
            addCriterion("PWD_CHANGE3 in", values, "pwdChange3");
            return (Criteria) this;
        }

        public Criteria andPwdChange3NotIn(List<String> values) {
            addCriterion("PWD_CHANGE3 not in", values, "pwdChange3");
            return (Criteria) this;
        }

        public Criteria andPwdChange3Between(String value1, String value2) {
            addCriterion("PWD_CHANGE3 between", value1, value2, "pwdChange3");
            return (Criteria) this;
        }

        public Criteria andPwdChange3NotBetween(String value1, String value2) {
            addCriterion("PWD_CHANGE3 not between", value1, value2, "pwdChange3");
            return (Criteria) this;
        }

        public Criteria andPwdChange4IsNull() {
            addCriterion("PWD_CHANGE4 is null");
            return (Criteria) this;
        }

        public Criteria andPwdChange4IsNotNull() {
            addCriterion("PWD_CHANGE4 is not null");
            return (Criteria) this;
        }

        public Criteria andPwdChange4EqualTo(String value) {
            addCriterion("PWD_CHANGE4 =", value, "pwdChange4");
            return (Criteria) this;
        }

        public Criteria andPwdChange4NotEqualTo(String value) {
            addCriterion("PWD_CHANGE4 <>", value, "pwdChange4");
            return (Criteria) this;
        }

        public Criteria andPwdChange4GreaterThan(String value) {
            addCriterion("PWD_CHANGE4 >", value, "pwdChange4");
            return (Criteria) this;
        }

        public Criteria andPwdChange4GreaterThanOrEqualTo(String value) {
            addCriterion("PWD_CHANGE4 >=", value, "pwdChange4");
            return (Criteria) this;
        }

        public Criteria andPwdChange4LessThan(String value) {
            addCriterion("PWD_CHANGE4 <", value, "pwdChange4");
            return (Criteria) this;
        }

        public Criteria andPwdChange4LessThanOrEqualTo(String value) {
            addCriterion("PWD_CHANGE4 <=", value, "pwdChange4");
            return (Criteria) this;
        }

        public Criteria andPwdChange4Like(String value) {
            addCriterion("PWD_CHANGE4 like", value, "pwdChange4");
            return (Criteria) this;
        }

        public Criteria andPwdChange4NotLike(String value) {
            addCriterion("PWD_CHANGE4 not like", value, "pwdChange4");
            return (Criteria) this;
        }

        public Criteria andPwdChange4In(List<String> values) {
            addCriterion("PWD_CHANGE4 in", values, "pwdChange4");
            return (Criteria) this;
        }

        public Criteria andPwdChange4NotIn(List<String> values) {
            addCriterion("PWD_CHANGE4 not in", values, "pwdChange4");
            return (Criteria) this;
        }

        public Criteria andPwdChange4Between(String value1, String value2) {
            addCriterion("PWD_CHANGE4 between", value1, value2, "pwdChange4");
            return (Criteria) this;
        }

        public Criteria andPwdChange4NotBetween(String value1, String value2) {
            addCriterion("PWD_CHANGE4 not between", value1, value2, "pwdChange4");
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


    public enum PwdStat{
        S0A("有效"),S0L("锁定"),S0E("过期"),S0R("重置");

        private String desc;

        PwdStat(String desc) {
            this.desc = desc;
        }

        public String desc() {
            return desc;
        }
    }

    public enum Stat{
        S0A("有效"),
        S0X("无效"),
        S0F("冻结"),
        ;

        private String desc;

        Stat(String desc) {
            this.desc = desc;
        }

        public String desc() {
            return desc;
        }

        public static String getDesc(String code){
            for(Stat stat:Stat.values()){
                if(stat.name().equals(code)){
                    return stat.desc;
                }
            }
            return "未知";
        }
    }

    public enum Sex{
        M("男"),
        F("女"),
        ;

        private String desc;

        Sex(String desc) {
            this.desc = desc;
        }

        public String desc() {
            return desc;
        }

        public static String getDesc(String code){
            for(Sex sex:Sex.values()){
                if(sex.name().equals(code)){
                    return sex.desc;
                }
            }
            return "未知";
        }
    }
}