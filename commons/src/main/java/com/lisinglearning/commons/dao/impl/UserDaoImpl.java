package com.lisinglearning.commons.dao.impl;

import com.lisinglearning.commons.dao.UserDaoCustom;
import com.lisinglearning.commons.entities.User;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.List;

import static com.lisinglearning.commons.entities.QUser.user;

/**
 * Created by 124032 on 9/8/2016.
 */

//Implementation class to define custom method definitions
public class UserDaoImpl implements UserDaoCustom{
    @Autowired
    EntityManager entityManager;

    public User findByUserName(String username) {
        JPAQuery jpaQuery = new JPAQuery(entityManager);

        User userAccount = (User) jpaQuery.from(user).where(user.username.eq(username)).createQuery(user).getSingleResult();

        return userAccount;
    }
}
