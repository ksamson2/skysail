package com.company.sample.application;

import java.util.Date;

public class Order {
    private ProductName productName;
    private Date salesDate;
    private double amount;
    private int orderId;

    public Order(ProductName productName, Date salesDate, double amount, int orderId) {
        this.productName = productName;
        this.salesDate = salesDate;
        this.amount = amount;
        this.orderId = orderId;
    }

    public ProductName getProductName() {
        return productName;
    }

    public void setProductName(ProductName productName) {
        this.productName = productName;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
