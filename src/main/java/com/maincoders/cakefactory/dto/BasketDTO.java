package com.maincoders.cakefactory.dto;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * Represents the form that basket request and response data takes. Does not map
 * to the database directly.
 */
public class BasketDTO {
    private String id;
    private String title;
    private String price;
    private int qty;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getFormattedPrice() {
        DecimalFormat d = new DecimalFormat("'£'0.00");
        return d.format(price);
    }

    @Override
    public String toString() {
        return "BasketDTO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }
}
