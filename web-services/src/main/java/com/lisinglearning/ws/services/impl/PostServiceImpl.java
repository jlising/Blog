package com.lisinglearning.ws.services.impl;

import com.lisinglearning.commons.dao.PostDao;
import com.lisinglearning.commons.dto.PostInfo;
import com.lisinglearning.commons.entities.Post;
import com.lisinglearning.commons.entities.User;
import com.lisinglearning.paging.MappableService;
import com.lisinglearning.paging.PageInfo;
import com.lisinglearning.ws.services.PostService;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

import static com.lisinglearning.commons.entities.QPost.post;

/**
 * Created by 124032 on 9/13/2016.
 */
@Service
public class PostServiceImpl extends MappableService<PostInfo, Post> implements PostService{

    @Autowired
    PostDao postDao;

    @Autowired
    EntityManager entityManager;

    public PageInfo<PostInfo> list(Pageable pageable) {
        JPAQuery jpaQuery = new JPAQuery(entityManager);

        JPAQuery countQuery = jpaQuery.clone(entityManager);
        Long count = countQuery.from(post).count();

        List<Post> posts = jpaQuery.from(post)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .createQuery(post).getResultList();

        return  toPageInfo(new PageImpl<Post>(posts, new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort()), count));
    }
}
