package com.kata.social.mediakata.example;


import com.kata.social.mediakata.AbstractSpringTest;
import com.kata.social.mediakata.model.entity.user.Role;
import com.kata.social.mediakata.service.impl.model.RoleServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


@RunWith(SpringRunner.class)
@Sql("/sql/data.sql")
public class ExampleTest extends AbstractSpringTest{

    @MockBean
    private RoleServiceImpl roleService;

    @Test
    public void test() {
        roleService.create(new Role(0L, "ADMIN"));
        Optional<Role> role = roleService.getById(0L);
        Assert.assertEquals( "ADMIN",role.get());
    }
}