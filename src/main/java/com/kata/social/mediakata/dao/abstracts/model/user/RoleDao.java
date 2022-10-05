package com.kata.social.mediakata.dao.abstracts.model.user;

import com.kata.social.mediakata.model.entity.user.Role;

import java.util.Optional;

public interface RoleDao {
    Optional<Role> findByName(String name);
}
