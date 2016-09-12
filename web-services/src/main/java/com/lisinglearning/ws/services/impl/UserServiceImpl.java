package com.lisinglearning.ws.services.impl;

import com.lisinglearning.commons.dao.UserDao;
import com.lisinglearning.commons.dto.UserInfo;
import com.lisinglearning.commons.entities.User;
import com.lisinglearning.paging.MappableService;
import com.lisinglearning.paging.PageInfo;
import com.lisinglearning.ws.services.UserService;
import com.mysema.query.jpa.impl.JPAQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

import static com.lisinglearning.commons.entities.QUser.user;

/**
 * Created by 124032 on 9/8/2016.
 */
@Service
public class UserServiceImpl extends MappableService<UserInfo, User> implements UserService{
    private static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserDao userDao;

    @Autowired
    EntityManager entityManager;

    public PageInfo<UserInfo> list(Pageable pageable) {
        JPAQuery jpaQuery = new JPAQuery(entityManager);

        JPAQuery countQuery = jpaQuery.clone(entityManager);
        Long count = countQuery.from(user).count();

        List<User> users = jpaQuery.from(user)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .createQuery(user).getResultList();

        return  toPageInfo(new PageImpl<User>(users, new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort()), count));
    }
}
