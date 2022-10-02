package com.kata.social.mediakata.model.dto.page;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PageDto<T> {

    private int currentPage;

    private int totalPages;

    private int itemsOnPage;

    private Long totalItemsCount;

    private List<T> items;

    public PageDto(int currentPage,int itemsOnPage, Long totalItemsCount, List<T> items) {

        this.currentPage = currentPage;
        if(totalItemsCount < itemsOnPage ) {
            totalPages = 1;
        } else {
            this.totalPages = (int) Math.ceil((double)totalItemsCount / itemsOnPage);
        }
        this.itemsOnPage = itemsOnPage;
        this.totalItemsCount = totalItemsCount;
        this.items = items;
    }
}
