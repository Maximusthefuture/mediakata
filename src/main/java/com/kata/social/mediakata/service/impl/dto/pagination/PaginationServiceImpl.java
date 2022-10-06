package com.kata.social.mediakata.service.impl.dto.pagination;

import com.kata.social.mediakata.dao.abstracts.dto.pagination.PaginationDao;
import com.kata.social.mediakata.exception.PaginationException;
import com.kata.social.mediakata.model.dto.page.PageDto;
import com.kata.social.mediakata.service.abstracts.dto.pagination.PaginationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaginationServiceImpl<T> implements PaginationService<Object> {

    private  Map<String, PaginationDao<T>> paginationDaos = new HashMap<>();

    @Autowired
    public void setPaginationDaos(Map<String, PaginationDao<T>> paginationDaos) {
        this.paginationDaos = paginationDaos;
    }

    @Override
    public PageDto<T> getPageDto(String methodName, Map<String, Object> parameters) {

        int currentPage = (int) parameters.get("currentPage");
        int itemsOnPage = (int) parameters.get("itemsOnPage");

        if(currentPage <= 0 || itemsOnPage <= 0 ) {
            throw new PaginationException("Invalid pagination parameters.");
        }

        PaginationDao<T> paginationDao = paginationDaos.get(methodName);

        List<T> items = paginationDao.getItems(parameters);
        Long totalItemsCount = paginationDao.getItemsCount(parameters);



        return new PageDto<>(currentPage, itemsOnPage, totalItemsCount, items);

    }
}
