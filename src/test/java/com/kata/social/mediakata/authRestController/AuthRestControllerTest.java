package com.kata.social.mediakata.authRestController;


import com.kata.social.mediakata.AbstractSpringTest;
import com.kata.social.mediakata.exception.ApiRequestException;
import com.kata.social.mediakata.model.dto.UserRegisterDto;
import com.kata.social.mediakata.service.abstracts.model.user.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql("/sql/auth_rest_controller/data.sql")
@RunWith(SpringRunner.class)
public class AuthRestControllerTest extends AbstractSpringTest {


    @AfterAll
    @Sql("/sql/auth_rest_controller/data_clean.sql")
    static void cleanDB() {
        System.out.println("Clean up BD");
    }

    @Test
    public void addUser() throws Exception {
        UserRegisterDto userRegisterDto = new UserRegisterDto("Vasya", "Pupkin", "vasya62@mail.com", "62");
        mockMvc.perform(post("/api/auth/register")
                        .content(objectMapper.writeValueAsString(userRegisterDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void addUserWithException() throws Exception {
        UserRegisterDto userRegisterDto = new UserRegisterDto("Vasya", "Pupkin", "donna@mail.com", "62");
        mockMvc.perform(post("/api/auth/register")
                        .content(objectMapper.writeValueAsString(userRegisterDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException()
                        instanceof ApiRequestException))
                .andExpect(content().
                        string(containsString("User with mail '" + userRegisterDto.getEmail() + "' already exists")))
                .andExpect(status().isBadRequest());


    }
}
