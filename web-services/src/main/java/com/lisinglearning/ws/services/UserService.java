package com.lisinglearning.ws.services;

import com.lisinglearning.commons.dto.UserInfo;
import com.lisinglearning.paging.PageInfo;
import org.springframework.data.domain.Pageable;

/**
 * Created by 124032 on 9/8/2016.
 */
public interface UserService {
    PageInfo<UserInfo> list(Pageable pageable);
}
