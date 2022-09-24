package com.kata.social.mediakata.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.social.mediakata.AbstractSpringTest;
import com.kata.social.mediakata.model.entity.user.User;
import com.kata.social.mediakata.service.abstracts.GenericService;
import com.kata.social.mediakata.service.impl.GenericServiceAbstract;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Optional;

public class ExampleTest extends AbstractSpringTest {

    @Autowired
    private GenericService service;

    @Test
    void test() {
        User us = new User();
        us.setFirstName("petya");
         service.create(us);

        Optional<User> user = service.getById(1);
        if (user.get().getFirstName() != "petya") {
            throw new RuntimeException();
        }
    }

}
