package com.king.model;

/**
 * Created by king on 2017/5/10.
 */
public class Order {
    private String id;
    private String csrID;
    private String productID;
    private String productAmount;
    private String orderDate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCsrID() {
        return csrID;
    }

    public void setCsrID(String csrID) {
        this.csrID = csrID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(String productAmount) {
        this.productAmount = productAmount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }


}
