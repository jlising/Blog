package com.lisinglearning.ws.services;

import com.lisinglearning.commons.dto.PostInfo;
import com.lisinglearning.paging.PageInfo;
import org.springframework.data.domain.Pageable;

/**
 * Created by 124032 on 9/13/2016.
 */
public interface PostService {
    PageInfo<PostInfo> list(Pageable pageable);
}
