package com.maincoders.cakefactory.domain;

import java.text.DecimalFormat;

public class BasketDomain {
    private String title;
    private int qty;
    private double price;

    public BasketDomain() {
    }

    public BasketDomain(String title, int qty, double price) {
        this.title = title;
        this.qty = qty;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BasketDomain{" +
                "title='" + title + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
