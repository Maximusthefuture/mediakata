package com.kata.social.mediakata.service.abstracts.dto.pagination;

import com.kata.social.mediakata.model.dto.page.PageDto;

import java.util.Map;

public interface PaginationService<T> {

    PageDto<? extends T> getPageDto(String methodName, Map<String, Object> parameters);

}
