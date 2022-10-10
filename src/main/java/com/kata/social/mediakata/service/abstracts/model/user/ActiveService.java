package com.kata.social.mediakata.service.abstracts.model.user;

import com.kata.social.mediakata.model.entity.user.Active;
import com.kata.social.mediakata.service.abstracts.GenericService;

import java.util.Optional;

public interface ActiveService extends GenericService<Active, Long> {
    Optional<Active> findByName(String name);
}
