package com.superplus.managementsystem.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andSkunumberIsNull() {
            addCriterion("skuNumber is null");
            return (Criteria) this;
        }

        public Criteria andSkunumberIsNotNull() {
            addCriterion("skuNumber is not null");
            return (Criteria) this;
        }

        public Criteria andSkunumberEqualTo(String value) {
            addCriterion("skuNumber =", value, "skunumber");
            return (Criteria) this;
        }

        public Criteria andSkunumberNotEqualTo(String value) {
            addCriterion("skuNumber <>", value, "skunumber");
            return (Criteria) this;
        }

        public Criteria andSkunumberGreaterThan(String value) {
            addCriterion("skuNumber >", value, "skunumber");
            return (Criteria) this;
        }

        public Criteria andSkunumberGreaterThanOrEqualTo(String value) {
            addCriterion("skuNumber >=", value, "skunumber");
            return (Criteria) this;
        }

        public Criteria andSkunumberLessThan(String value) {
            addCriterion("skuNumber <", value, "skunumber");
            return (Criteria) this;
        }

        public Criteria andSkunumberLessThanOrEqualTo(String value) {
            addCriterion("skuNumber <=", value, "skunumber");
            return (Criteria) this;
        }

        public Criteria andSkunumberLike(String value) {
            addCriterion("skuNumber like", value, "skunumber");
            return (Criteria) this;
        }

        public Criteria andSkunumberNotLike(String value) {
            addCriterion("skuNumber not like", value, "skunumber");
            return (Criteria) this;
        }

        public Criteria andSkunumberIn(List<String> values) {
            addCriterion("skuNumber in", values, "skunumber");
            return (Criteria) this;
        }

        public Criteria andSkunumberNotIn(List<String> values) {
            addCriterion("skuNumber not in", values, "skunumber");
            return (Criteria) this;
        }

        public Criteria andSkunumberBetween(String value1, String value2) {
            addCriterion("skuNumber between", value1, value2, "skunumber");
            return (Criteria) this;
        }

        public Criteria andSkunumberNotBetween(String value1, String value2) {
            addCriterion("skuNumber not between", value1, value2, "skunumber");
            return (Criteria) this;
        }

        public Criteria andCompositionIsNull() {
            addCriterion("composition is null");
            return (Criteria) this;
        }

        public Criteria andCompositionIsNotNull() {
            addCriterion("composition is not null");
            return (Criteria) this;
        }

        public Criteria andCompositionEqualTo(String value) {
            addCriterion("composition =", value, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionNotEqualTo(String value) {
            addCriterion("composition <>", value, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionGreaterThan(String value) {
            addCriterion("composition >", value, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionGreaterThanOrEqualTo(String value) {
            addCriterion("composition >=", value, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionLessThan(String value) {
            addCriterion("composition <", value, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionLessThanOrEqualTo(String value) {
            addCriterion("composition <=", value, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionLike(String value) {
            addCriterion("composition like", value, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionNotLike(String value) {
            addCriterion("composition not like", value, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionIn(List<String> values) {
            addCriterion("composition in", values, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionNotIn(List<String> values) {
            addCriterion("composition not in", values, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionBetween(String value1, String value2) {
            addCriterion("composition between", value1, value2, "composition");
            return (Criteria) this;
        }

        public Criteria andCompositionNotBetween(String value1, String value2) {
            addCriterion("composition not between", value1, value2, "composition");
            return (Criteria) this;
        }

        public Criteria andColourIsNull() {
            addCriterion("colour is null");
            return (Criteria) this;
        }

        public Criteria andColourIsNotNull() {
            addCriterion("colour is not null");
            return (Criteria) this;
        }

        public Criteria andColourEqualTo(String value) {
            addCriterion("colour =", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourNotEqualTo(String value) {
            addCriterion("colour <>", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourGreaterThan(String value) {
            addCriterion("colour >", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourGreaterThanOrEqualTo(String value) {
            addCriterion("colour >=", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourLessThan(String value) {
            addCriterion("colour <", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourLessThanOrEqualTo(String value) {
            addCriterion("colour <=", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourLike(String value) {
            addCriterion("colour like", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourNotLike(String value) {
            addCriterion("colour not like", value, "colour");
            return (Criteria) this;
        }

        public Criteria andColourIn(List<String> values) {
            addCriterion("colour in", values, "colour");
            return (Criteria) this;
        }

        public Criteria andColourNotIn(List<String> values) {
            addCriterion("colour not in", values, "colour");
            return (Criteria) this;
        }

        public Criteria andColourBetween(String value1, String value2) {
            addCriterion("colour between", value1, value2, "colour");
            return (Criteria) this;
        }

        public Criteria andColourNotBetween(String value1, String value2) {
            addCriterion("colour not between", value1, value2, "colour");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Double value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Double value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Double value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Double value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Double value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Double> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Double> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Double value1, Double value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Double value1, Double value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(String value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(String value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(String value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(String value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(String value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(String value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLike(String value) {
            addCriterion("size like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotLike(String value) {
            addCriterion("size not like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<String> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<String> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(String value1, String value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(String value1, String value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andKnitwearorwovenIsNull() {
            addCriterion("knitwearOrWoven is null");
            return (Criteria) this;
        }

        public Criteria andKnitwearorwovenIsNotNull() {
            addCriterion("knitwearOrWoven is not null");
            return (Criteria) this;
        }

        public Criteria andKnitwearorwovenEqualTo(String value) {
            addCriterion("knitwearOrWoven =", value, "knitwearorwoven");
            return (Criteria) this;
        }

        public Criteria andKnitwearorwovenNotEqualTo(String value) {
            addCriterion("knitwearOrWoven <>", value, "knitwearorwoven");
            return (Criteria) this;
        }

        public Criteria andKnitwearorwovenGreaterThan(String value) {
            addCriterion("knitwearOrWoven >", value, "knitwearorwoven");
            return (Criteria) this;
        }

        public Criteria andKnitwearorwovenGreaterThanOrEqualTo(String value) {
            addCriterion("knitwearOrWoven >=", value, "knitwearorwoven");
            return (Criteria) this;
        }

        public Criteria andKnitwearorwovenLessThan(String value) {
            addCriterion("knitwearOrWoven <", value, "knitwearorwoven");
            return (Criteria) this;
        }

        public Criteria andKnitwearorwovenLessThanOrEqualTo(String value) {
            addCriterion("knitwearOrWoven <=", value, "knitwearorwoven");
            return (Criteria) this;
        }

        public Criteria andKnitwearorwovenLike(String value) {
            addCriterion("knitwearOrWoven like", value, "knitwearorwoven");
            return (Criteria) this;
        }

        public Criteria andKnitwearorwovenNotLike(String value) {
            addCriterion("knitwearOrWoven not like", value, "knitwearorwoven");
            return (Criteria) this;
        }

        public Criteria andKnitwearorwovenIn(List<String> values) {
            addCriterion("knitwearOrWoven in", values, "knitwearorwoven");
            return (Criteria) this;
        }

        public Criteria andKnitwearorwovenNotIn(List<String> values) {
            addCriterion("knitwearOrWoven not in", values, "knitwearorwoven");
            return (Criteria) this;
        }

        public Criteria andKnitwearorwovenBetween(String value1, String value2) {
            addCriterion("knitwearOrWoven between", value1, value2, "knitwearorwoven");
            return (Criteria) this;
        }

        public Criteria andKnitwearorwovenNotBetween(String value1, String value2) {
            addCriterion("knitwearOrWoven not between", value1, value2, "knitwearorwoven");
            return (Criteria) this;
        }

        public Criteria andMinimumorderquantityIsNull() {
            addCriterion("minimumOrderQuantity is null");
            return (Criteria) this;
        }

        public Criteria andMinimumorderquantityIsNotNull() {
            addCriterion("minimumOrderQuantity is not null");
            return (Criteria) this;
        }

        public Criteria andMinimumorderquantityEqualTo(Integer value) {
            addCriterion("minimumOrderQuantity =", value, "minimumorderquantity");
            return (Criteria) this;
        }

        public Criteria andMinimumorderquantityNotEqualTo(Integer value) {
            addCriterion("minimumOrderQuantity <>", value, "minimumorderquantity");
            return (Criteria) this;
        }

        public Criteria andMinimumorderquantityGreaterThan(Integer value) {
            addCriterion("minimumOrderQuantity >", value, "minimumorderquantity");
            return (Criteria) this;
        }

        public Criteria andMinimumorderquantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("minimumOrderQuantity >=", value, "minimumorderquantity");
            return (Criteria) this;
        }

        public Criteria andMinimumorderquantityLessThan(Integer value) {
            addCriterion("minimumOrderQuantity <", value, "minimumorderquantity");
            return (Criteria) this;
        }

        public Criteria andMinimumorderquantityLessThanOrEqualTo(Integer value) {
            addCriterion("minimumOrderQuantity <=", value, "minimumorderquantity");
            return (Criteria) this;
        }

        public Criteria andMinimumorderquantityIn(List<Integer> values) {
            addCriterion("minimumOrderQuantity in", values, "minimumorderquantity");
            return (Criteria) this;
        }

        public Criteria andMinimumorderquantityNotIn(List<Integer> values) {
            addCriterion("minimumOrderQuantity not in", values, "minimumorderquantity");
            return (Criteria) this;
        }

        public Criteria andMinimumorderquantityBetween(Integer value1, Integer value2) {
            addCriterion("minimumOrderQuantity between", value1, value2, "minimumorderquantity");
            return (Criteria) this;
        }

        public Criteria andMinimumorderquantityNotBetween(Integer value1, Integer value2) {
            addCriterion("minimumOrderQuantity not between", value1, value2, "minimumorderquantity");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andSeasonIsNull() {
            addCriterion("season is null");
            return (Criteria) this;
        }

        public Criteria andSeasonIsNotNull() {
            addCriterion("season is not null");
            return (Criteria) this;
        }

        public Criteria andSeasonEqualTo(String value) {
            addCriterion("season =", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonNotEqualTo(String value) {
            addCriterion("season <>", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonGreaterThan(String value) {
            addCriterion("season >", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonGreaterThanOrEqualTo(String value) {
            addCriterion("season >=", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonLessThan(String value) {
            addCriterion("season <", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonLessThanOrEqualTo(String value) {
            addCriterion("season <=", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonLike(String value) {
            addCriterion("season like", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonNotLike(String value) {
            addCriterion("season not like", value, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonIn(List<String> values) {
            addCriterion("season in", values, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonNotIn(List<String> values) {
            addCriterion("season not in", values, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonBetween(String value1, String value2) {
            addCriterion("season between", value1, value2, "season");
            return (Criteria) this;
        }

        public Criteria andSeasonNotBetween(String value1, String value2) {
            addCriterion("season not between", value1, value2, "season");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceIsNull() {
            addCriterion("purchasePrice is null");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceIsNotNull() {
            addCriterion("purchasePrice is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceEqualTo(Double value) {
            addCriterion("purchasePrice =", value, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceNotEqualTo(Double value) {
            addCriterion("purchasePrice <>", value, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceGreaterThan(Double value) {
            addCriterion("purchasePrice >", value, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceGreaterThanOrEqualTo(Double value) {
            addCriterion("purchasePrice >=", value, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceLessThan(Double value) {
            addCriterion("purchasePrice <", value, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceLessThanOrEqualTo(Double value) {
            addCriterion("purchasePrice <=", value, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceIn(List<Double> values) {
            addCriterion("purchasePrice in", values, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceNotIn(List<Double> values) {
            addCriterion("purchasePrice not in", values, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceBetween(Double value1, Double value2) {
            addCriterion("purchasePrice between", value1, value2, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andPurchasepriceNotBetween(Double value1, Double value2) {
            addCriterion("purchasePrice not between", value1, value2, "purchaseprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceIsNull() {
            addCriterion("buyingPrice is null");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceIsNotNull() {
            addCriterion("buyingPrice is not null");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceEqualTo(Double value) {
            addCriterion("buyingPrice =", value, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceNotEqualTo(Double value) {
            addCriterion("buyingPrice <>", value, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceGreaterThan(Double value) {
            addCriterion("buyingPrice >", value, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("buyingPrice >=", value, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceLessThan(Double value) {
            addCriterion("buyingPrice <", value, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceLessThanOrEqualTo(Double value) {
            addCriterion("buyingPrice <=", value, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceIn(List<Double> values) {
            addCriterion("buyingPrice in", values, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceNotIn(List<Double> values) {
            addCriterion("buyingPrice not in", values, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceBetween(Double value1, Double value2) {
            addCriterion("buyingPrice between", value1, value2, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andBuyingpriceNotBetween(Double value1, Double value2) {
            addCriterion("buyingPrice not between", value1, value2, "buyingprice");
            return (Criteria) this;
        }

        public Criteria andRadicalretropubicprostatectomyIsNull() {
            addCriterion("radicalRetropubicProstatectomy is null");
            return (Criteria) this;
        }

        public Criteria andRadicalretropubicprostatectomyIsNotNull() {
            addCriterion("radicalRetropubicProstatectomy is not null");
            return (Criteria) this;
        }

        public Criteria andRadicalretropubicprostatectomyEqualTo(Double value) {
            addCriterion("radicalRetropubicProstatectomy =", value, "radicalretropubicprostatectomy");
            return (Criteria) this;
        }

        public Criteria andRadicalretropubicprostatectomyNotEqualTo(Double value) {
            addCriterion("radicalRetropubicProstatectomy <>", value, "radicalretropubicprostatectomy");
            return (Criteria) this;
        }

        public Criteria andRadicalretropubicprostatectomyGreaterThan(Double value) {
            addCriterion("radicalRetropubicProstatectomy >", value, "radicalretropubicprostatectomy");
            return (Criteria) this;
        }

        public Criteria andRadicalretropubicprostatectomyGreaterThanOrEqualTo(Double value) {
            addCriterion("radicalRetropubicProstatectomy >=", value, "radicalretropubicprostatectomy");
            return (Criteria) this;
        }

        public Criteria andRadicalretropubicprostatectomyLessThan(Double value) {
            addCriterion("radicalRetropubicProstatectomy <", value, "radicalretropubicprostatectomy");
            return (Criteria) this;
        }

        public Criteria andRadicalretropubicprostatectomyLessThanOrEqualTo(Double value) {
            addCriterion("radicalRetropubicProstatectomy <=", value, "radicalretropubicprostatectomy");
            return (Criteria) this;
        }

        public Criteria andRadicalretropubicprostatectomyIn(List<Double> values) {
            addCriterion("radicalRetropubicProstatectomy in", values, "radicalretropubicprostatectomy");
            return (Criteria) this;
        }

        public Criteria andRadicalretropubicprostatectomyNotIn(List<Double> values) {
            addCriterion("radicalRetropubicProstatectomy not in", values, "radicalretropubicprostatectomy");
            return (Criteria) this;
        }

        public Criteria andRadicalretropubicprostatectomyBetween(Double value1, Double value2) {
            addCriterion("radicalRetropubicProstatectomy between", value1, value2, "radicalretropubicprostatectomy");
            return (Criteria) this;
        }

        public Criteria andRadicalretropubicprostatectomyNotBetween(Double value1, Double value2) {
            addCriterion("radicalRetropubicProstatectomy not between", value1, value2, "radicalretropubicprostatectomy");
            return (Criteria) this;
        }

        public Criteria andPurchaseurlIsNull() {
            addCriterion("purchaseUrl is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseurlIsNotNull() {
            addCriterion("purchaseUrl is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseurlEqualTo(String value) {
            addCriterion("purchaseUrl =", value, "purchaseurl");
            return (Criteria) this;
        }

        public Criteria andPurchaseurlNotEqualTo(String value) {
            addCriterion("purchaseUrl <>", value, "purchaseurl");
            return (Criteria) this;
        }

        public Criteria andPurchaseurlGreaterThan(String value) {
            addCriterion("purchaseUrl >", value, "purchaseurl");
            return (Criteria) this;
        }

        public Criteria andPurchaseurlGreaterThanOrEqualTo(String value) {
            addCriterion("purchaseUrl >=", value, "purchaseurl");
            return (Criteria) this;
        }

        public Criteria andPurchaseurlLessThan(String value) {
            addCriterion("purchaseUrl <", value, "purchaseurl");
            return (Criteria) this;
        }

        public Criteria andPurchaseurlLessThanOrEqualTo(String value) {
            addCriterion("purchaseUrl <=", value, "purchaseurl");
            return (Criteria) this;
        }

        public Criteria andPurchaseurlLike(String value) {
            addCriterion("purchaseUrl like", value, "purchaseurl");
            return (Criteria) this;
        }

        public Criteria andPurchaseurlNotLike(String value) {
            addCriterion("purchaseUrl not like", value, "purchaseurl");
            return (Criteria) this;
        }

        public Criteria andPurchaseurlIn(List<String> values) {
            addCriterion("purchaseUrl in", values, "purchaseurl");
            return (Criteria) this;
        }

        public Criteria andPurchaseurlNotIn(List<String> values) {
            addCriterion("purchaseUrl not in", values, "purchaseurl");
            return (Criteria) this;
        }

        public Criteria andPurchaseurlBetween(String value1, String value2) {
            addCriterion("purchaseUrl between", value1, value2, "purchaseurl");
            return (Criteria) this;
        }

        public Criteria andPurchaseurlNotBetween(String value1, String value2) {
            addCriterion("purchaseUrl not between", value1, value2, "purchaseurl");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andOfferIsNull() {
            addCriterion("offer is null");
            return (Criteria) this;
        }

        public Criteria andOfferIsNotNull() {
            addCriterion("offer is not null");
            return (Criteria) this;
        }

        public Criteria andOfferEqualTo(Double value) {
            addCriterion("offer =", value, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferNotEqualTo(Double value) {
            addCriterion("offer <>", value, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferGreaterThan(Double value) {
            addCriterion("offer >", value, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferGreaterThanOrEqualTo(Double value) {
            addCriterion("offer >=", value, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferLessThan(Double value) {
            addCriterion("offer <", value, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferLessThanOrEqualTo(Double value) {
            addCriterion("offer <=", value, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferIn(List<Double> values) {
            addCriterion("offer in", values, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferNotIn(List<Double> values) {
            addCriterion("offer not in", values, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferBetween(Double value1, Double value2) {
            addCriterion("offer between", value1, value2, "offer");
            return (Criteria) this;
        }

        public Criteria andOfferNotBetween(Double value1, Double value2) {
            addCriterion("offer not between", value1, value2, "offer");
            return (Criteria) this;
        }

        public Criteria andProfitIsNull() {
            addCriterion("profit is null");
            return (Criteria) this;
        }

        public Criteria andProfitIsNotNull() {
            addCriterion("profit is not null");
            return (Criteria) this;
        }

        public Criteria andProfitEqualTo(Double value) {
            addCriterion("profit =", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotEqualTo(Double value) {
            addCriterion("profit <>", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitGreaterThan(Double value) {
            addCriterion("profit >", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitGreaterThanOrEqualTo(Double value) {
            addCriterion("profit >=", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitLessThan(Double value) {
            addCriterion("profit <", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitLessThanOrEqualTo(Double value) {
            addCriterion("profit <=", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitIn(List<Double> values) {
            addCriterion("profit in", values, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotIn(List<Double> values) {
            addCriterion("profit not in", values, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitBetween(Double value1, Double value2) {
            addCriterion("profit between", value1, value2, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotBetween(Double value1, Double value2) {
            addCriterion("profit not between", value1, value2, "profit");
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