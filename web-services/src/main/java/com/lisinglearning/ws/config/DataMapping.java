package com.lisinglearning.ws.config;

import com.lisinglearning.commons.dto.AddressInfo;
import com.lisinglearning.commons.dto.UserInfo;
import com.lisinglearning.commons.entities.Address;
import com.lisinglearning.commons.entities.User;
import com.lisinglearning.paging.DataMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by 124032 on 9/8/2016.
 */
@Configuration
public class DataMapping {
    @Autowired
    private DataMapper dataMapper;

    @PostConstruct
    public void init() {

        MapperFactory mapperFactory = dataMapper.getMapperFactory();

        mapperFactory.classMap(User.class, UserInfo.class)
                //.exclude("product")
                .field("address", "addressInfo")
                .field("address.geo","addressInfo.geoInfo")
                .field("company", "companyInfo")
                .byDefault()
                .register();
    }
}
