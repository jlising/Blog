package com.lisinglearning.config;

import com.lisinglearning.paging.DataMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Orika Mapper configuration
 */
@Configuration
public class DataMappingConfig {
	@Bean
    public MapperFactory mapperFactory() {
        return new DefaultMapperFactory.Builder().build();
    }

    @Bean
    public DataMapper mapper(MapperFactory mapperFactory) {
        return new DataMapper(mapperFactory);
    }
}
