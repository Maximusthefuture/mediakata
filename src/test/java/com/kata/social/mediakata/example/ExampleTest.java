package com.kata.social.mediakata.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.social.mediakata.AbstractSpringTest;
import com.kata.social.mediakata.dao.abstracts.GenericDao;
import com.kata.social.mediakata.model.entity.user.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Optional;


public class ExampleTest extends AbstractSpringTest {

    @Autowired
    private GenericDao dao;

    @Autowired
    public ExampleTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        super(mockMvc, objectMapper);
    }

    @Test
    void test() {
        Optional<User> user = dao.getById(1L);
        String lastName = user.get().getLastName();
        System.out.println(lastName);
        Assert.assertEquals(lastName, "petya");
    }

}