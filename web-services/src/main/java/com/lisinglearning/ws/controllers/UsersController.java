package com.lisinglearning.ws.controllers;

import com.lisinglearning.commons.dao.UserDao;
import com.lisinglearning.commons.dto.UserInfo;
import com.lisinglearning.commons.entities.User;
import com.lisinglearning.paging.PageInfo;
import com.lisinglearning.ws.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 124032 on 9/8/2016.
 */
@RestController
@RequestMapping(value = "/users")
public class UsersController {
    private static Logger LOG = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<User> test(){
        return userDao.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PageInfo<UserInfo> list(Pageable pageable){
        LOG.debug(">>> User listing...");

        return userService.list(pageable);
    }

    //{ "name" : "Jesus Lising", "username" : "jlising", "email" : "j_lising@yahoo.com", "phone" : "+639232104978", "website" : "http://www.google.com",  "address" : { "street" : "Purok 2 Lacmit", "suite" : "", "city" : "Arayat Pampanga" , "geo" : { "lat" : 0, "lang" : 0 }}, "company": { "name" :  "IBM Solutions Delivery Inc."}}
    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void add(@RequestBody User user){
        userDao.save(user);
    }
}
