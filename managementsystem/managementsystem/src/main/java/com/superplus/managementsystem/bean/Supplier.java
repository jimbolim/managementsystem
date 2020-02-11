package com.superplus.managementsystem.bean;

import java.util.Date;

public class Supplier {
    private Integer id;

    private String suppliercode;

    private String shopname;

    private String lastbrandname;

    private String brandname;

    private String shopurl;

    private String producttype;

    private String comment;

    private Date updatetime;

    private String checktype;

    private Double purchaseprice;

    private String type;

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

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname == null ? null : shopname.trim();
    }

    public String getLastbrandname() {
        return lastbrandname;
    }

    public void setLastbrandname(String lastbrandname) {
        this.lastbrandname = lastbrandname == null ? null : lastbrandname.trim();
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname == null ? null : brandname.trim();
    }

    public String getShopurl() {
        return shopurl;
    }

    public void setShopurl(String shopurl) {
        this.shopurl = shopurl == null ? null : shopurl.trim();
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype == null ? null : producttype.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getChecktype() {
        return checktype;
    }

    public void setChecktype(String checktype) {
        this.checktype = checktype == null ? null : checktype.trim();
    }

    public Double getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(Double purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}