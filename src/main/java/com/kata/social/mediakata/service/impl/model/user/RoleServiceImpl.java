package com.kata.social.mediakata.service.impl.model.user;

import com.kata.social.mediakata.dao.abstracts.GenericDao;
import com.kata.social.mediakata.dao.abstracts.model.user.RoleDao;
import com.kata.social.mediakata.model.entity.user.Role;
import com.kata.social.mediakata.service.abstracts.model.user.RoleService;
import com.kata.social.mediakata.service.impl.GenericServiceAbstract;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl extends GenericServiceAbstract<Role, Long> implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(GenericDao<Role, Long> dao, RoleDao roleDao) {
        super(dao);
        this.roleDao = roleDao;
    }


    @Override
    public Optional<Role> findByName(String name) {
        return roleDao.findByName(name);
    }
}
