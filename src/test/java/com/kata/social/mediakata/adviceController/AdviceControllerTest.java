package com.kata.social.mediakata.adviceController;

import com.kata.social.mediakata.AbstractSpringTest;
import org.junit.jupiter.api.Test;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class AdviceControllerTest extends AbstractSpringTest {

    @Test
    void AdviceControllerMethodArgumentTypeMismatchExceptionTest() throws Exception {

        super.mockMvc.perform(get("/api/user/p"))
                .andDo(print())
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof MethodArgumentTypeMismatchException))
                .andExpect(content().
                        string(containsString("The parameter 'userId' of value " +
                                "'p' could not be converted to type 'Long'")))
                .andExpect(status().is4xxClientError());
    }
}
