package com.superplus.managementsystem.bean;

public class Orderform {
    private Integer id;

    private String itemname;

    private String sku;

    private String size;

    private Double poqty;

    private String price;

    private String total;

    private Double purchaseprice;

    private Double rpp;

    private String purchaseorder;

    private String tlogistics;

    private String slogistics;

    private String boxcode;

    private String comment;

    private int oid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public Double getPoqty() {
        return poqty;
    }

    public void setPoqty(Double poqty) {
        this.poqty = poqty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total == null ? null : total.trim();
    }

    public Double getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(Double purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public Double getRpp() {
        return rpp;
    }

    public void setRpp(Double rpp) {
        this.rpp = rpp;
    }

    public String getPurchaseorder() {
        return purchaseorder;
    }

    public void setPurchaseorder(String purchaseorder) {
        this.purchaseorder = purchaseorder == null ? null : purchaseorder.trim();
    }

    public String getTlogistics() {
        return tlogistics;
    }

    public void setTlogistics(String tlogistics) {
        this.tlogistics = tlogistics == null ? null : tlogistics.trim();
    }

    public String getSlogistics() {
        return slogistics;
    }

    public void setSlogistics(String slogistics) {
        this.slogistics = slogistics == null ? null : slogistics.trim();
    }

    public String getBoxcode() {
        return boxcode;
    }

    public void setBoxcode(String boxcode) {
        this.boxcode = boxcode == null ? null : boxcode.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }
}