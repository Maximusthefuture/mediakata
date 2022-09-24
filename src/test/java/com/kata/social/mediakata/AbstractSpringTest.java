package com.kata.social.mediakata;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import  com.kata.social.mediakata.initializer.Postgres;
import org.springframework.transaction.annotation.Transactional;

@Sql("/sql/data.sql")
@AutoConfigureMockMvc
@Getter
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {
        Postgres.Initializer.class
})
@Transactional
public abstract class AbstractSpringTest {
    protected MockMvc mockMvc;
    protected ObjectMapper objectMapper;

    @Autowired
    public AbstractSpringTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }

    @BeforeAll
    static void init() {
        Postgres.postgreSQLContainer.start();
    }

    @AfterAll
    static void deinit() {
        Postgres.postgreSQLContainer.stop();
    }

}
