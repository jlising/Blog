package com.lisinglearning.commons.dto;

import com.lisinglearning.commons.entities.User;

/**
 * Created by 124032 on 9/13/2016.
 */
public class PostInfo {
    private Integer id;
    private String title;
    private String body;
    private UserInfo userInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
