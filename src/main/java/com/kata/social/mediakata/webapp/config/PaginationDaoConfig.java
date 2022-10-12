package com.kata.social.mediakata.webapp.config;


import com.kata.social.mediakata.dao.abstracts.dto.pagination.PaginationDao;
import com.kata.social.mediakata.dao.impl.dto.pagination.user.PaginationGetAllUsersDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PaginationDaoConfig {
    @Autowired
    private PaginationDao paginationDao;

    @Bean
    public  Map<String, PaginationDao> paginationDaos() {
        Map<String, PaginationDao> map = new HashMap<>();
        map.put("PaginationGetAllUsersDaoImpl", paginationDao);
        return map;
    }
}
