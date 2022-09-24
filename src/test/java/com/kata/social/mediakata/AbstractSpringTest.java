package com.kata.social.mediakata;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import  com.kata.social.mediakata.initializer.Postgres;

@AutoConfigureMockMvc
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ActiveProfiles("test")
@SpringBootTest
@ContextConfiguration(initializers = {
        Postgres.Initializer.class
})
public abstract class AbstractSpringTest {

    public MockMvc mockMvc;
    public ObjectMapper objectMapper;

    @BeforeAll
    static void init() {
        Postgres.postgreSQLContainer.start();
    }

}
