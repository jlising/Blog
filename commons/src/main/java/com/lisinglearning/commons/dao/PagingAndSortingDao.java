package com.lisinglearning.commons.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * @author jlising - 4/8/16.
 */
public interface PagingAndSortingDao <T, ID extends Serializable> extends CrudDao<T, ID> {
    Iterable<T> findAll(Sort var1);

    Page<T> findAll(Pageable var1);
}

