package com.kata.social.mediakata.service.impl.model;

import com.kata.social.mediakata.dao.abstracts.model.user.ActiveDao;
import com.kata.social.mediakata.model.entity.user.Active;
import com.kata.social.mediakata.service.abstracts.model.user.ActiveService;
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
