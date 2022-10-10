package com.kata.social.mediakata.dao.impl.model.user;

import com.kata.social.mediakata.dao.abstracts.model.user.RoleDao;
import com.kata.social.mediakata.dao.impl.GenericDaoAbstract;
import com.kata.social.mediakata.model.entity.user.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends GenericDaoAbstract<Role, Long> implements RoleDao {
}
