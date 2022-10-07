package com.kata.social.mediakata.example;


import com.kata.social.mediakata.AbstractSpringTest;
import com.kata.social.mediakata.webapp.controller.user.UserTestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Sql("/sql/data.sql")
public class ExampleTest extends AbstractSpringTest {

    @Autowired
    UserTestController userTestController;

    @Test
    void AdviceControllerTest() throws Exception {

        super.mockMvc.perform(get("/users/p"))
                .andDo(print())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof MethodArgumentTypeMismatchException))
                .andExpect(content().
                        string(containsString("The parameter 'userId' of value " +
                                "'p' could not be converted to type 'long'")))
                .andExpect(status().is4xxClientError());
    }

}