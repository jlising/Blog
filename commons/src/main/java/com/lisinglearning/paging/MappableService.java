package com.lisinglearning.paging;

import com.lisinglearning.commons.entities.User;
import org.springframework.core.GenericTypeResolver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

import static com.lisinglearning.paging.PageInfo.newPageInfo;

public class MappableService<T, K> {
    private Class<K> entityClass;

    private Class<T> dtoClass;

    public MappableService() {

        Class<?>[] typeArguments = GenericTypeResolver.resolveTypeArguments(getClass(), MappableService.class);
        this.dtoClass = (Class<T>) typeArguments[0];
        this.entityClass = (Class<K>) typeArguments[1];
    }

    protected K toEntity(T dto) {

        return null == dto ? null : MapperUtil.mapDTO(dto, entityClass);
    }

    protected T toDto(K entity) {

        return null == entity ? null : MapperUtil.mapDTO(entity, dtoClass);
    }

    protected List<T> toDto(Iterable<K> entities) {

        if (entities == null || !entities.iterator()
                .hasNext()) {
            return null;
        }

        return MapperUtil.mapList(entities, dtoClass);
    }

    protected PageInfo<T> toPageInfo(Page<K> page) {

        return newPageInfo(page, toDto(page));
    }
}