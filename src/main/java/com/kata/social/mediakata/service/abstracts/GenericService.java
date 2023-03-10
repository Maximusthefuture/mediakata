package com.kata.social.mediakata.service.abstracts;

import java.util.List;
import java.util.Optional;

public interface GenericService<T, PK> {

    List<T> getAll();

    void create(T entity);

    void update(T entity);

    Optional<T> getById(PK id);

    void delete(T entity);

    void deleteById(PK id);

    boolean existById(PK id);
}
