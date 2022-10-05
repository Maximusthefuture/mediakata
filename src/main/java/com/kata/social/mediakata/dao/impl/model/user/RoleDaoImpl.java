package com.kata.social.mediakata.dao.impl.model.user;

import com.kata.social.mediakata.dao.abstracts.model.user.RoleDao;
import com.kata.social.mediakata.dao.impl.GenericDaoAbstract;
import com.kata.social.mediakata.dao.util.SingleResultUtil;
import com.kata.social.mediakata.model.entity.user.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RoleDaoImpl extends GenericDaoAbstract<Role, Long> implements RoleDao {

    @Override
    public Optional<Role> findByName(String name) {
        return SingleResultUtil.getSingleResultOrNull(
                entityManager.createQuery("SELECT r FROM Role r WHERE r.name = : name", Role.class)
                .setParameter("name", name));
    }
}
