package com.kata.social.mediakata.service.impl.model.user;

import com.kata.social.mediakata.dao.abstracts.GenericDao;
import com.kata.social.mediakata.dao.abstracts.model.user.ActiveDao;
import com.kata.social.mediakata.model.entity.user.Active;
import com.kata.social.mediakata.service.abstracts.model.user.ActiveService;
import com.kata.social.mediakata.service.impl.GenericServiceAbstract;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActiveServiceImpl extends GenericServiceAbstract<Active, Long> implements ActiveService {

    private final ActiveDao activeDao;

    public ActiveServiceImpl(GenericDao<Active, Long> dao, ActiveDao activeDao) {
        super(dao);
        this.activeDao = activeDao;
    }

    @Override
    public Optional<Active> findByName(String name) {
        return activeDao.findByName(name);
    }
}
