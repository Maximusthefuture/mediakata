package com.kata.social.mediakata.dao.abstracts.model.user;

import com.kata.social.mediakata.model.entity.user.Active;

import java.util.Optional;

public interface ActiveDao {
    Optional<Active> findByName(String name);
}
