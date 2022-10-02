package com.kata.social.mediakata.example;


import com.kata.social.mediakata.AbstractSpringTest;
import com.kata.social.mediakata.model.dto.page.PageDto;
import com.kata.social.mediakata.model.dto.user.UserDto;
import com.kata.social.mediakata.service.abstracts.dto.pagination.PaginationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Sql("/sql/data.sql")
public class ExampleTest extends AbstractSpringTest {
    @Autowired
    PaginationService paginationService;

    @Test
    void paginationTest() {
        //6 users in table

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("currentPage",1);
        parameters.put("itemsOnPage",3);
        PageDto usersPage = paginationService.getPageDto("getUsersPage",parameters);

        List users = usersPage.getItems();
        int totalPages = usersPage.getTotalPages();

        Assertions.assertEquals(users.size(),3);
        Assertions.assertEquals(totalPages,2);
    }
    @Test
    public void testGetPage_EmptyList() throws Exception {
        //6 users in table
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("currentPage",2);
        parameters.put("itemsOnPage",6);

        PageDto usersPage = paginationService.getPageDto("getUsersPage",parameters);


        int totalPages = usersPage.getTotalPages();
        List users = usersPage.getItems();

        Assertions.assertEquals(users.size(), 0);
        Assertions.assertEquals(totalPages, 1);

    }

}