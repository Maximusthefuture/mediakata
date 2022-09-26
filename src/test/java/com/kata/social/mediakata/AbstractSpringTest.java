package com.kata.social.mediakata;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import  com.kata.social.mediakata.initializer.Postgres;
import org.springframework.transaction.annotation.Transactional;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {
        Postgres.Initializer.class
})
@Transactional
public abstract class AbstractSpringTest {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;


    @BeforeAll
    static void init() {
        Postgres.postgreSQLContainer.start();
    }

    @AfterAll
    static void deinit() {
        Postgres.postgreSQLContainer.stop();
    }

}
