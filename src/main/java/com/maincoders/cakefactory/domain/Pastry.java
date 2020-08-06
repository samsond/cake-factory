package com.maincoders.cakefactory.domain;

import lombok.Data;

import java.util.Objects;

public class Pastry {
    private String title;
    private double price;

    public Pastry(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pastry pastry = (Pastry) o;
        return Double.compare(pastry.price, price) == 0 &&
                title.equals(pastry.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price);
    }
}

