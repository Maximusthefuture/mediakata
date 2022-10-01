package com.kata.social.mediakata.service.impl.dto.pagination;

import com.kata.social.mediakata.dao.abstracts.dto.pagination.PaginationDao;
import com.kata.social.mediakata.dao.impl.dto.UserDtoDaoImpl;
import com.kata.social.mediakata.model.dto.page.PageDto;
import com.kata.social.mediakata.service.abstracts.dto.pagination.PaginationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class PaginationServiceImpl<T> implements PaginationService<Object> {


    UserDtoDaoImpl userDtoDao;
    Map<String, PaginationDao> paginationDaos;

    @Autowired
    public PaginationServiceImpl(UserDtoDaoImpl userDtoDao) {
        this.userDtoDao = userDtoDao;
        paginationDaos.put("users", userDtoDao);
    }


    @Override
    public PageDto<?> getPageDto(String methodName, Map<String, Object> parameters) {

        int currentPage = (int) parameters.get("currentPage");
        int itemsOnPage = (int) parameters.get("itemsOnPage");

        List items = paginationDaos.get(methodName).getItems(parameters);
        Long totalItemsCount = paginationDaos.get(methodName).getItemsCount(parameters);

        return new PageDto(currentPage,itemsOnPage,totalItemsCount,items);

    }
}
