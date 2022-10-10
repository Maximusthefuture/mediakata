package com.kata.social.mediakata.dao.abstracts.model.user;

import com.kata.social.mediakata.dao.abstracts.GenericDao;
import com.kata.social.mediakata.model.entity.user.Active;
import com.kata.social.mediakata.model.entity.user.Role;

import java.util.Optional;

public interface ActiveDao extends GenericDao<Active, Long> {
    Optional<Active> findByName(String name);
}
