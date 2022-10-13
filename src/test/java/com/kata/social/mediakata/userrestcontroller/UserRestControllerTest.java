package com.kata.social.mediakata.userrestcontroller;

import com.kata.social.mediakata.AbstractSpringTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@Sql("/userrestcontroller.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestPropertySource(properties = { "testdatainitservice.enabled = false" })
public class UserRestControllerTest extends AbstractSpringTest {

    @Test
    public void test_get_users_with_pagination_page_one() throws Exception {
        int currentPage = 1;
        mockMvc.perform(get("/api/user")
                .param("currentPage", String.valueOf(currentPage))
                .param("itemsOnPage", String.valueOf(10))
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.items", hasSize(10)))
                .andExpect(jsonPath("$.items[0].id").value(1))
                .andExpect(jsonPath("$.items[9].id").value(10));

    }

    @Test
    public void test_get_users_with_pagination_page_two() throws Exception {
        int currentPage = 2;
        mockMvc.perform(get("/api/user")
                        .param("currentPage", String.valueOf(currentPage))
                        .param("itemsOnPage", String.valueOf(10))
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.items", hasSize(10)))
                .andExpect(jsonPath("$.items[0].id").value(11))
                .andExpect(jsonPath("$.items[9].id").value(20));

    }
}
