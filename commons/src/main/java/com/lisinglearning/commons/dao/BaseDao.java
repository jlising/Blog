package com.lisinglearning.commons.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * @author jlising - 4/8/16.
 */
@NoRepositoryBean
public interface BaseDao<T extends PersistableData, ID extends Serializable> extends PagingAndSortingDao<T, ID> {
    T findById(ID var1);

    T deleteById(ID var1);

    List<T> findAll();

    List<T> findAll(Sort var1);

    Iterable<T> findAll(Iterable<ID> var1);

    <S extends T> List<S> save(Iterable<S> var1);

    void flush();

    <S extends T> S saveAndFlush(S var1);

    void deleteInBatch(Iterable<T> var1);

    void deleteAllInBatch();

    T getOne(ID var1);
}
