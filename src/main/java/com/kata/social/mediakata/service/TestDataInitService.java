package com.kata.social.mediakata.service;

import com.kata.social.mediakata.dao.abstracts.GenericDao;
import com.kata.social.mediakata.model.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestDataInitService implements ApplicationRunner {

    @Autowired
    GenericDao genericDao;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();
        user.setFirstName("petya");
        genericDao.create(user);
    }
}
