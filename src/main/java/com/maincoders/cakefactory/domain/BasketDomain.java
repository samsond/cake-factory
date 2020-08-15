package com.maincoders.cakefactory.domain;

import java.text.DecimalFormat;

public class BasketDomain {
    private String title;
    private int qty;
    private String price;

    public BasketDomain(String title, int qty, String price) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
