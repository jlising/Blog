package com.lisinglearning.commons.dao;

import org.springframework.data.domain.Persistable;

import java.io.Serializable;

/**
 * @author jlising - 4/8/16.
 */
public interface PersistableData<ID extends Serializable> extends Persistable<ID>{
}
