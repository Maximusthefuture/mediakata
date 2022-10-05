package com.kata.social.mediakata.dao.abstracts.dto.pagination;

import java.util.List;
import java.util.Map;

public interface PaginationDao<T> {

    List<T> getItems(Map<String, Object> parameters);

    Long getItemsCount(Map<String, Object> parameters);

}
