package com.lisinglearning.ws.controllers;

import com.lisinglearning.commons.dao.PostDao;
import com.lisinglearning.commons.dao.UserDao;
import com.lisinglearning.commons.dto.PostInfo;
import com.lisinglearning.commons.dto.UserInfo;
import com.lisinglearning.commons.entities.Post;
import com.lisinglearning.commons.entities.User;
import com.lisinglearning.paging.PageInfo;
import com.lisinglearning.ws.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 124032 on 9/13/2016.
 */
@RestController
@RequestMapping(value = "/posts")
public class PostsController {
    private static Logger LOG = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    PostService postService;

    @Autowired
    PostDao postDao;

    @Autowired
    UserDao userDao;

    @RequestMapping(value="/test", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public String test(@RequestParam String abc){
        LOG.debug(">>> Test...");

        return "Test";
    }

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PageInfo<PostInfo> list(Pageable pageable){
        LOG.debug(">>> Post listing...");

        return postService.list(pageable);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void add(@RequestBody Post post){
        postDao.save(post);
    }
}
