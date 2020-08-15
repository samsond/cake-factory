package com.maincoders.cakefactory.domain;

public abstract class CatalogDomain {
    protected abstract String getTitle();
    protected abstract void setTitle(String title);
    protected abstract double getPrice();
    protected abstract void setPrice(double price);

    // business methods

}
