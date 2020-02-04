package com.superplus.managementsystem.bean;

import java.util.Date;

public class Product {
    private Integer id;

    private String suppliercode;

    private String itemname;

    private String skunumber;

    private String composition;

    private String colour;

    private String length;

    private Double weight;

    private String size;

    private String knitwearorwoven;

    private Double minimumorderquantity;

    private String description;

    private String season;

    private Double purchaseprice;

    private Double buyingprice;

    private Double radicalretropubicprostatectomy;

    private String purchaseurl;

    private Date updatetime;

    private Double offer;

    private Double profit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSuppliercode() {
        return suppliercode;
    }

    public void setSuppliercode(String suppliercode) {
        this.suppliercode = suppliercode;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getSkunumber() {
        return skunumber;
    }

    public void setSkunumber(String skunumber) {
        this.skunumber = skunumber == null ? null : skunumber.trim();
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition == null ? null : composition.trim();
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour == null ? null : colour.trim();
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getKnitwearorwoven() {
        return knitwearorwoven;
    }

    public void setKnitwearorwoven(String knitwearorwoven) {
        this.knitwearorwoven = knitwearorwoven == null ? null : knitwearorwoven.trim();
    }

    public Double getMinimumorderquantity() {
        return minimumorderquantity;
    }

    public void setMinimumorderquantity(Double minimumorderquantity) {
        this.minimumorderquantity = minimumorderquantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season == null ? null : season.trim();
    }

    public Double getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(Double purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public Double getBuyingprice() {
        return buyingprice;
    }

    public void setBuyingprice(Double buyingprice) {
        this.buyingprice = buyingprice;
    }

    public Double getRadicalretropubicprostatectomy() {
        return radicalretropubicprostatectomy;
    }

    public void setRadicalretropubicprostatectomy(Double radicalretropubicprostatectomy) {
        this.radicalretropubicprostatectomy = radicalretropubicprostatectomy;
    }

    public String getPurchaseurl() {
        return purchaseurl;
    }

    public void setPurchaseurl(String purchaseurl) {
        this.purchaseurl = purchaseurl == null ? null : purchaseurl.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Double getOffer() {
        return offer;
    }

    public void setOffer(Double offer) {
        this.offer = offer;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }
}