package com.lisinglearning.commons.entities;

import javax.persistence.*;

/**
 * Created by 124032 on 9/8/2016.
 */
@Entity
@Table(name = "post")
public class Post extends AbstractEntity {
    private String title;
    private String body;

    //Use merge since post cannot be created without a user
    @ManyToOne(cascade = CascadeType.MERGE)//http://stackoverflow.com/questions/13370221/jpa-hibernate-detached-entity-passed-to-persist
    @JoinColumn(name = "user_id")
    private User user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
