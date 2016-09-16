package com.lisinglearning.commons.dao;

import com.lisinglearning.commons.entities.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by 124032 on 9/8/2016.
 */
//Custom Dao to define custom methods
public interface UserDaoCustom {
    User findByUserName(String username);
}
