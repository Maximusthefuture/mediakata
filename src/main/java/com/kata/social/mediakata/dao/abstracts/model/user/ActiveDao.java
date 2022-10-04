package com.kata.social.mediakata.dao.abstracts.model.user;

import com.kata.social.mediakata.dao.abstracts.GenericDao;
import com.kata.social.mediakata.model.entity.user.Active;
import org.springframework.transaction.annotation.Transactional;


public interface ActiveDao extends GenericDao<Active, Long> {
}
