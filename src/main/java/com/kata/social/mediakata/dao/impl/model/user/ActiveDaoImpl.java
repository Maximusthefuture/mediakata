package com.kata.social.mediakata.dao.impl.model.user;

import com.kata.social.mediakata.dao.abstracts.model.user.ActiveDao;
import com.kata.social.mediakata.dao.impl.GenericDaoAbstract;
import com.kata.social.mediakata.model.entity.user.Active;
import org.springframework.stereotype.Repository;

@Repository
public class ActiveDaoImpl extends GenericDaoAbstract<Active, Long> implements ActiveDao {
}
