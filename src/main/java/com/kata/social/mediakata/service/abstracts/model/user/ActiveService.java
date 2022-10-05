package com.kata.social.mediakata.service.abstracts.model.user;

import com.kata.social.mediakata.model.entity.user.Active;

import java.util.Optional;

public interface ActiveService {
    Optional<Active> findByName(String name);
}
