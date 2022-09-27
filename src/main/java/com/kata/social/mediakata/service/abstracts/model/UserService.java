package com.kata.social.mediakata.service.abstracts.model;

import com.kata.social.mediakata.dao.abstracts.GenericDao;
import com.kata.social.mediakata.model.entity.user.User;
import com.kata.social.mediakata.service.abstracts.GenericService;

import java.util.List;
import java.util.Optional;

public interface UserService extends GenericService<User, Long> {

    Optional<User> getUserByEmail(String email);

    @Override
    List<User> getPart(int currentPage, int itemsOnPage);

    void create(User entity);

    void update(User entity);

    Optional<User> getById(Long id);

    void delete(User entity);

    void deleteById(Long id);

    boolean existById(Long id);

    List<User> getAll();
}
