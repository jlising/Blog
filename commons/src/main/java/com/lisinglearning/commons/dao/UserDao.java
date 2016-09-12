package com.lisinglearning.commons.dao;

import com.lisinglearning.commons.entities.User;

/**
 * Created by 124032 on 9/8/2016.
 */

//Extends BaseJpaDao to inherit basic dao operations
//Extends UserDaoCustom to define custom methods definitions
public interface UserDao extends BaseJpaDao<User,Integer>, UserDaoCustom{
}
