package com.superplus.managementsystem.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SupplierExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SupplierExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSuppliercodeIsNull() {
            addCriterion("suppliercode is null");
            return (Criteria) this;
        }

        public Criteria andSuppliercodeIsNotNull() {
            addCriterion("suppliercode is not null");
            return (Criteria) this;
        }

        public Criteria andSuppliercodeEqualTo(Double value) {
            addCriterion("suppliercode =", value, "suppliercode");
            return (Criteria) this;
        }

        public Criteria andSuppliercodeNotEqualTo(Double value) {
            addCriterion("suppliercode <>", value, "suppliercode");
            return (Criteria) this;
        }

        public Criteria andSuppliercodeGreaterThan(Double value) {
            addCriterion("suppliercode >", value, "suppliercode");
            return (Criteria) this;
        }

        public Criteria andSuppliercodeGreaterThanOrEqualTo(Double value) {
            addCriterion("suppliercode >=", value, "suppliercode");
            return (Criteria) this;
        }

        public Criteria andSuppliercodeLessThan(Double value) {
            addCriterion("suppliercode <", value, "suppliercode");
            return (Criteria) this;
        }

        public Criteria andSuppliercodeLessThanOrEqualTo(Double value) {
            addCriterion("suppliercode <=", value, "suppliercode");
            return (Criteria) this;
        }

        public Criteria andSuppliercodeIn(List<Double> values) {
            addCriterion("suppliercode in", values, "suppliercode");
            return (Criteria) this;
        }

        public Criteria andSuppliercodeNotIn(List<Double> values) {
            addCriterion("suppliercode not in", values, "suppliercode");
            return (Criteria) this;
        }

        public Criteria andSuppliercodeBetween(Double value1, Double value2) {
            addCriterion("suppliercode between", value1, value2, "suppliercode");
            return (Criteria) this;
        }

        public Criteria andSuppliercodeNotBetween(Double value1, Double value2) {
            addCriterion("suppliercode not between", value1, value2, "suppliercode");
            return (Criteria) this;
        }

        public Criteria andShopnameIsNull() {
            addCriterion("shopname is null");
            return (Criteria) this;
        }

        public Criteria andShopnameIsNotNull() {
            addCriterion("shopname is not null");
            return (Criteria) this;
        }

        public Criteria andShopnameEqualTo(String value) {
            addCriterion("shopname =", value, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameNotEqualTo(String value) {
            addCriterion("shopname <>", value, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameGreaterThan(String value) {
            addCriterion("shopname >", value, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameGreaterThanOrEqualTo(String value) {
            addCriterion("shopname >=", value, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameLessThan(String value) {
            addCriterion("shopname <", value, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameLessThanOrEqualTo(String value) {
            addCriterion("shopname <=", value, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameLike(String value) {
            addCriterion("shopname like", value, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameNotLike(String value) {
            addCriterion("shopname not like", value, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameIn(List<String> values) {
            addCriterion("shopname in", values, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameNotIn(List<String> values) {
            addCriterion("shopname not in", values, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameBetween(String value1, String value2) {
            addCriterion("shopname between", value1, value2, "shopname");
            return (Criteria) this;
        }

        public Criteria andShopnameNotBetween(String value1, String value2) {
            addCriterion("shopname not between", value1, value2, "shopname");
            return (Criteria) this;
        }

        public Criteria andLastbrandnameIsNull() {
            addCriterion("lastbrandname is null");
            return (Criteria) this;
        }

        public Criteria andLastbrandnameIsNotNull() {
            addCriterion("lastbrandname is not null");
            return (Criteria) this;
        }

        public Criteria andLastbrandnameEqualTo(String value) {
            addCriterion("lastbrandname =", value, "lastbrandname");
            return (Criteria) this;
        }

        public Criteria andLastbrandnameNotEqualTo(String value) {
            addCriterion("lastbrandname <>", value, "lastbrandname");
            return (Criteria) this;
        }

        public Criteria andLastbrandnameGreaterThan(String value) {
            addCriterion("lastbrandname >", value, "lastbrandname");
            return (Criteria) this;
        }

        public Criteria andLastbrandnameGreaterThanOrEqualTo(String value) {
            addCriterion("lastbrandname >=", value, "lastbrandname");
            return (Criteria) this;
        }

        public Criteria andLastbrandnameLessThan(String value) {
            addCriterion("lastbrandname <", value, "lastbrandname");
            return (Criteria) this;
        }

        public Criteria andLastbrandnameLessThanOrEqualTo(String value) {
            addCriterion("lastbrandname <=", value, "lastbrandname");
            return (Criteria) this;
        }

        public Criteria andLastbrandnameLike(String value) {
            addCriterion("lastbrandname like", value, "lastbrandname");
            return (Criteria) this;
        }

        public Criteria andLastbrandnameNotLike(String value) {
            addCriterion("lastbrandname not like", value, "lastbrandname");
            return (Criteria) this;
        }

        public Criteria andLastbrandnameIn(List<String> values) {
            addCriterion("lastbrandname in", values, "lastbrandname");
            return (Criteria) this;
        }

        public Criteria andLastbrandnameNotIn(List<String> values) {
            addCriterion("lastbrandname not in", values, "lastbrandname");
            return (Criteria) this;
        }

        public Criteria andLastbrandnameBetween(String value1, String value2) {
            addCriterion("lastbrandname between", value1, value2, "lastbrandname");
            return (Criteria) this;
        }

        public Criteria andLastbrandnameNotBetween(String value1, String value2) {
            addCriterion("lastbrandname not between", value1, value2, "lastbrandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameIsNull() {
            addCriterion("brandname is null");
            return (Criteria) this;
        }

        public Criteria andBrandnameIsNotNull() {
            addCriterion("brandname is not null");
            return (Criteria) this;
        }

        public Criteria andBrandnameEqualTo(String value) {
            addCriterion("brandname =", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameNotEqualTo(String value) {
            addCriterion("brandname <>", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameGreaterThan(String value) {
            addCriterion("brandname >", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameGreaterThanOrEqualTo(String value) {
            addCriterion("brandname >=", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameLessThan(String value) {
            addCriterion("brandname <", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameLessThanOrEqualTo(String value) {
            addCriterion("brandname <=", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameLike(String value) {
            addCriterion("brandname like", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameNotLike(String value) {
            addCriterion("brandname not like", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameIn(List<String> values) {
            addCriterion("brandname in", values, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameNotIn(List<String> values) {
            addCriterion("brandname not in", values, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameBetween(String value1, String value2) {
            addCriterion("brandname between", value1, value2, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameNotBetween(String value1, String value2) {
            addCriterion("brandname not between", value1, value2, "brandname");
            return (Criteria) this;
        }

        public Criteria andShopurlIsNull() {
            addCriterion("shopurl is null");
            return (Criteria) this;
        }

        public Criteria andShopurlIsNotNull() {
            addCriterion("shopurl is not null");
            return (Criteria) this;
        }

        public Criteria andShopurlEqualTo(String value) {
            addCriterion("shopurl =", value, "shopurl");
            return (Criteria) this;
        }

        public Criteria andShopurlNotEqualTo(String value) {
            addCriterion("shopurl <>", value, "shopurl");
            return (Criteria) this;
        }

        public Criteria andShopurlGreaterThan(String value) {
            addCriterion("shopurl >", value, "shopurl");
            return (Criteria) this;
        }

        public Criteria andShopurlGreaterThanOrEqualTo(String value) {
            addCriterion("shopurl >=", value, "shopurl");
            return (Criteria) this;
        }

        public Criteria andShopurlLessThan(String value) {
            addCriterion("shopurl <", value, "shopurl");
            return (Criteria) this;
        }

        public Criteria andShopurlLessThanOrEqualTo(String value) {
            addCriterion("shopurl <=", value, "shopurl");
            return (Criteria) this;
        }

        public Criteria andShopurlLike(String value) {
            addCriterion("shopurl like", value, "shopurl");
            return (Criteria) this;
        }

        public Criteria andShopurlNotLike(String value) {
            addCriterion("shopurl not like", value, "shopurl");
            return (Criteria) this;
        }

        public Criteria andShopurlIn(List<String> values) {
            addCriterion("shopurl in", values, "shopurl");
            return (Criteria) this;
        }

        public Criteria andShopurlNotIn(List<String> values) {
            addCriterion("shopurl not in", values, "shopurl");
            return (Criteria) this;
        }

        public Criteria andShopurlBetween(String value1, String value2) {
            addCriterion("shopurl between", value1, value2, "shopurl");
            return (Criteria) this;
        }

        public Criteria andShopurlNotBetween(String value1, String value2) {
            addCriterion("shopurl not between", value1, value2, "shopurl");
            return (Criteria) this;
        }

        public Criteria andProducttypeIsNull() {
            addCriterion("producttype is null");
            return (Criteria) this;
        }

        public Criteria andProducttypeIsNotNull() {
            addCriterion("producttype is not null");
            return (Criteria) this;
        }

        public Criteria andProducttypeEqualTo(String value) {
            addCriterion("producttype =", value, "producttype");
            return (Criteria) this;
        }

        public Criteria andProducttypeNotEqualTo(String value) {
            addCriterion("producttype <>", value, "producttype");
            return (Criteria) this;
        }

        public Criteria andProducttypeGreaterThan(String value) {
            addCriterion("producttype >", value, "producttype");
            return (Criteria) this;
        }

        public Criteria andProducttypeGreaterThanOrEqualTo(String value) {
            addCriterion("producttype >=", value, "producttype");
            return (Criteria) this;
        }

        public Criteria andProducttypeLessThan(String value) {
            addCriterion("producttype <", value, "producttype");
            return (Criteria) this;
        }

        public Criteria andProducttypeLessThanOrEqualTo(String value) {
            addCriterion("producttype <=", value, "producttype");
            return (Criteria) this;
        }

        public Criteria andProducttypeLike(String value) {
            addCriterion("producttype like", value, "producttype");
            return (Criteria) this;
        }

        public Criteria andProducttypeNotLike(String value) {
            addCriterion("producttype not like", value, "producttype");
            return (Criteria) this;
        }

        public Criteria andProducttypeIn(List<String> values) {
            addCriterion("producttype in", values, "producttype");
            return (Criteria) this;
        }

        public Criteria andProducttypeNotIn(List<String> values) {
            addCriterion("producttype not in", values, "producttype");
            return (Criteria) this;
        }

        public Criteria andProducttypeBetween(String value1, String value2) {
            addCriterion("producttype between", value1, value2, "producttype");
            return (Criteria) this;
        }

        public Criteria andProducttypeNotBetween(String value1, String value2) {
            addCriterion("producttype not between", value1, value2, "producttype");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andChecktypeIsNull() {
            addCriterion("checktype is null");
            return (Criteria) this;
        }

        public Criteria andChecktypeIsNotNull() {
            addCriterion("checktype is not null");
            return (Criteria) this;
        }

        public Criteria andChecktypeEqualTo(String value) {
            addCriterion("checktype =", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeNotEqualTo(String value) {
            addCriterion("checktype <>", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeGreaterThan(String value) {
            addCriterion("checktype >", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeGreaterThanOrEqualTo(String value) {
            addCriterion("checktype >=", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeLessThan(String value) {
            addCriterion("checktype <", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeLessThanOrEqualTo(String value) {
            addCriterion("checktype <=", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeLike(String value) {
            addCriterion("checktype like", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeNotLike(String value) {
            addCriterion("checktype not like", value, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeIn(List<String> values) {
            addCriterion("checktype in", values, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeNotIn(List<String> values) {
            addCriterion("checktype not in", values, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeBetween(String value1, String value2) {
            addCriterion("checktype between", value1, value2, "checktype");
            return (Criteria) this;
        }

        public Criteria andChecktypeNotBetween(String value1, String value2) {
            addCriterion("checktype not between", value1, value2, "checktype");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceIsNull() {
            addCriterion("purchaseprice is null");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceIsNotNull() {
            addCriterion("purchaseprice is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceEqualTo(Double value) {
            addCriterion("purchaseprice =", value, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceNotEqualTo(Double value) {
            addCriterion("purchaseprice <>", value, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceGreaterThan(Double value) {
            addCriterion("purchaseprice >", value, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceGreaterThanOrEqualTo(Double value) {
            addCriterion("purchaseprice >=", value, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceLessThan(Double value) {
            addCriterion("purchaseprice <", value, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceLessThanOrEqualTo(Double value) {
            addCriterion("purchaseprice <=", value, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceIn(List<Double> values) {
            addCriterion("purchaseprice in", values, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceNotIn(List<Double> values) {
            addCriterion("purchaseprice not in", values, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceBetween(Double value1, Double value2) {
            addCriterion("purchaseprice between", value1, value2, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceNotBetween(Double value1, Double value2) {
            addCriterion("purchaseprice not between", value1, value2, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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