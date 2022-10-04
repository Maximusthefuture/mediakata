package com.kata.social.mediakata.service.impl.model;


import com.kata.social.mediakata.dao.abstracts.model.RoleDao;
import com.kata.social.mediakata.model.entity.user.Role;
import com.kata.social.mediakata.service.abstracts.model.RoleService;
import com.kata.social.mediakata.service.impl.GenericServiceAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends GenericServiceAbstract<Role, Long> implements RoleService {

    private final RoleDao userDao;

    @Autowired
    public RoleServiceImpl(RoleDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }
}
