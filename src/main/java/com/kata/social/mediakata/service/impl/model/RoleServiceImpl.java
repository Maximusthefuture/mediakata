package com.kata.social.mediakata.service.impl.model;


import com.kata.social.mediakata.dao.abstracts.model.user.RoleDao;
import com.kata.social.mediakata.model.entity.user.Role;
import com.kata.social.mediakata.service.abstracts.model.user.RoleService;
import com.kata.social.mediakata.service.impl.GenericServiceAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends GenericServiceAbstract<Role, Long> implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        super(roleDao);
        this.roleDao = roleDao;
    }
}
