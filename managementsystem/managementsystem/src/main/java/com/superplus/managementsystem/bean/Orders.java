package com.superplus.managementsystem.bean;

import java.util.Date;

public class Orders {
    private Long id;

    private String ordername;

    private Date updatetime;

    private String state;

    private String comment;

    private Double orderqty;

    private Double orderamount;

    private String currency;

    private int cid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername == null ? null : ordername.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Double getOrderqty() {
        return orderqty;
    }

    public void setOrderqty(Double orderqty) {
        this.orderqty = orderqty;
    }

    public Double getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(Double orderamount) {
        this.orderamount = orderamount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}