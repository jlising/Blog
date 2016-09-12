package com.lisinglearning.commons.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by 124032 on 9/8/2016.
 */
@Entity
@Table(name = "user")
public class User extends AbstractEntity {
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private String avatarUrl;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

    //@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    //private Set<Post> posts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    //public Set<Post> getPosts() {
    //    return posts;
    //}

   // public void setPosts(Set<Post> posts) {
    //    this.posts = posts;
   // }
}
