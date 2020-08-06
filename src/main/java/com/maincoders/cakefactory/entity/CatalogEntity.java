package com.maincoders.cakefactory.entity;

import com.maincoders.cakefactory.domain.CatalogDomain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.DecimalFormat;


@Entity
@Table(name = "catalog")
public class CatalogEntity extends CatalogDomain {

    @Id
    private String id;

    private String title;

    private double price;

    public CatalogEntity() {
    }

    public CatalogEntity(String id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    // getters and setters and overriding methods

//    public List<CatalogEntity> getCatalogs() {
//        return
//    }

    public String getId() {return id;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        DecimalFormat d = new DecimalFormat("'£'0.00");
        return d.format(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }



}
