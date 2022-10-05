package com.kata.social.mediakata.dao.impl.model.user;

import com.kata.social.mediakata.dao.abstracts.model.user.ActiveDao;
import com.kata.social.mediakata.dao.impl.GenericDaoAbstract;
import com.kata.social.mediakata.dao.util.SingleResultUtil;
import com.kata.social.mediakata.model.entity.user.Active;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ActiveDaoImpl extends GenericDaoAbstract<Active, Long> implements ActiveDao {

    @Override
    public Optional<Active> findByName(String name) {
        return SingleResultUtil.getSingleResultOrNull(
                entityManager.createQuery("SELECT a FROM Active a WHERE a.name = : name", Active.class)
                        .setParameter("name", name));
    }
}
