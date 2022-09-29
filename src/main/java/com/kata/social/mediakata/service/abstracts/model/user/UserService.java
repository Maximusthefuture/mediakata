package com.kata.social.mediakata.service.abstracts.model.user;

import com.kata.social.mediakata.dao.abstracts.GenericDao;
import com.kata.social.mediakata.model.entity.user.User;
import com.kata.social.mediakata.service.abstracts.GenericService;

import java.util.List;
import java.util.Optional;

public interface UserService extends GenericService<User, Long> {

    Optional<User> getUserByEmail(String email);

}
