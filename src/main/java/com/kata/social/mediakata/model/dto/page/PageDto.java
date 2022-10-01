package com.kata.social.mediakata.model.dto.page;

import lombok.Setter;

import java.util.List;

@Setter
public class PageDto<T> {

    int currentPage;

    int totalPages;

    int itemsOnPage;

    Long totalItemsCount;

    List<T> items;

    public PageDto(int currentPage,int itemsOnPage, Long totalItemsCount, List<T> items) {

        this.currentPage = currentPage;
        this.totalPages = (int) (totalItemsCount % itemsOnPage);
        this.itemsOnPage = itemsOnPage;
        this.totalItemsCount = totalItemsCount;
        this.items = items;
    }


}
