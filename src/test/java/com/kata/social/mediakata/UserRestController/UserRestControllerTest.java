package com.kata.social.mediakata.UserRestController;

import com.kata.social.mediakata.AbstractSpringTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Sql("/UserRestController/dropUsers.sql")
public class UserRestControllerTest extends AbstractSpringTest {


    @Sql("/UserRestController/setUsers.sql")
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
                .andExpect(jsonPath("$.items[9].id").value(10))
                .andExpect(jsonPath("$.items[0].firstName").value("Petya"))
                .andExpect(jsonPath("$.items[9].firstName").value("Vasya"))
                .andExpect(jsonPath("$.items[0].lastName").value("Petrov"))
                .andExpect(jsonPath("$.items[9].lastName").value("Prostoi"))
                .andExpect(jsonPath("$.totalPages").value(2))
                .andExpect(jsonPath("$.totalItemsCount").value(20));

        currentPage = 2;
        mockMvc.perform(get("/api/user")
                        .param("currentPage", String.valueOf(currentPage))
                        .param("itemsOnPage", String.valueOf(10))
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.items", hasSize(10)))
                .andExpect(jsonPath("$.items[0].id").value(11))
                .andExpect(jsonPath("$.items[9].id").value(20))
                .andExpect(jsonPath("$.items[0].lastName").value("NeProstoi"))
                .andExpect(jsonPath("$.items[9].lastName").value("Vasiolie"));
    }

}
