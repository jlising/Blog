package com.lisinglearning.commons.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by 124032 on 9/8/2016.
 */
@Entity
@Table(name = "company")
public class Company extends AbstractEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
