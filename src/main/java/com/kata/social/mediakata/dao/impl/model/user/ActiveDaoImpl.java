package com.kata.social.mediakata.dao.impl.model;

import com.kata.social.mediakata.dao.abstracts.model.ActiveDao;
import com.kata.social.mediakata.dao.impl.GenericDaoAbstract;
import com.kata.social.mediakata.model.entity.user.Active;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ActiveDaoImpl extends GenericDaoAbstract<Active, Long> implements ActiveDao {
}
