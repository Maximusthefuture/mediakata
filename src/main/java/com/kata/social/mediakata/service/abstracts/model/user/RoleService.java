package com.kata.social.mediakata.service.abstracts.model.user;

import com.kata.social.mediakata.model.entity.user.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(String name);
}
