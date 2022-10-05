package com.kata.social.mediakata.service.impl.model.user;

import com.kata.social.mediakata.dao.abstracts.model.user.UserDao;
import com.kata.social.mediakata.model.entity.user.User;
import com.kata.social.mediakata.service.abstracts.model.user.UserService;
import com.kata.social.mediakata.service.impl.GenericServiceAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends GenericServiceAbstract<User, Long> implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public boolean existByMail(String email) {
        return userDao.existByMail(email);
    }
}
