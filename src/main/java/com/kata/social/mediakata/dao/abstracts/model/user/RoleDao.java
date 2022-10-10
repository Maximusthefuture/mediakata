package com.kata.social.mediakata.dao.abstracts.model.user;

import com.kata.social.mediakata.dao.abstracts.GenericDao;
import com.kata.social.mediakata.model.entity.user.Role;

import java.util.Optional;

public interface RoleDao extends GenericDao<Role, Long> {
    Optional<Role> findByName(String name);
}
