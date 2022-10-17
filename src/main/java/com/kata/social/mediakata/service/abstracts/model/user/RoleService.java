package com.kata.social.mediakata.service.abstracts.model.user;

import com.kata.social.mediakata.model.entity.user.Role;
import com.kata.social.mediakata.service.abstracts.GenericService;

import java.util.Optional;

public interface RoleService extends GenericService<Role, Long> {
    Optional<Role> findByName(String name);
}
