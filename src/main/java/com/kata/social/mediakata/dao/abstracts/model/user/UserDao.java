package com.kata.social.mediakata.dao.abstracts.model.user;

import com.kata.social.mediakata.dao.abstracts.GenericDao;
import com.kata.social.mediakata.model.entity.user.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User, Long> {
    Optional<User> getUserByEmail(String email);

    boolean existByMail(String email);
}
