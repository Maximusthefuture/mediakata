package com.kata.social.mediakata.example;


import com.kata.social.mediakata.AbstractSpringTest;
import com.kata.social.mediakata.dao.abstracts.model.UserDao;
import com.kata.social.mediakata.model.entity.user.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

@Sql("/sql/data.sql")
public class ExampleTest extends AbstractSpringTest {

    @Autowired
    private UserDao dao;

    @Test
    void test() {
        Optional<User> user = dao.getById(1L);
        String lastName = user.get().getLastName();
        System.out.println(lastName);
        Assert.assertEquals(lastName, "petrov");
    }

}