package com.lisinglearning.commons.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author jlising - 4/8/16.
 */
@NoRepositoryBean
public interface BaseJpaDao<T extends PersistableData, ID extends Serializable> extends BaseDao<T,ID>, JpaRepository<T, ID>, PagingAndSortingDao<T,ID> {
    T findById(ID var1);
    T deleteById(ID var1);
}
