package com.kata.social.mediakata.service.impl.model;

import com.kata.social.mediakata.dao.abstracts.GenericDao;
import com.kata.social.mediakata.dao.abstracts.model.ActiveDao;
import com.kata.social.mediakata.dao.abstracts.model.RoleDao;
import com.kata.social.mediakata.model.entity.user.Active;
import com.kata.social.mediakata.service.abstracts.model.ActiveService;
import com.kata.social.mediakata.service.impl.GenericServiceAbstract;
import org.springframework.stereotype.Service;

@Service
public class ActiveServiceImpl extends GenericServiceAbstract<Active, Long> implements ActiveService {

    private ActiveDao roleDao;

    public ActiveServiceImpl(ActiveDao dao) {
        super(dao);
        this.roleDao = dao;
    }
}
