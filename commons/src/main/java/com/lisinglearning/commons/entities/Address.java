package com.lisinglearning.commons.entities;

import javax.persistence.*;

/**
 * Created by 124032 on 9/8/2016.
 */
@Entity
@Table(name = "address")
public class Address extends AbstractEntity{
    private String street;
    private String suite;
    private String city;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "geo_id")
    private Geo geo;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
