package com.lisinglearning.commons.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by 124032 on 9/8/2016.
 */
@Entity
@Table(name = "geo")
public class Geo extends AbstractEntity {
    private Double lat;
    private Double lang;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLang() {
        return lang;
    }

    public void setLang(Double lang) {
        this.lang = lang;
    }
}
