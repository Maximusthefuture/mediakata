package com.kata.social.mediakata.example;


import com.kata.social.mediakata.AbstractSpringTest;
import com.kata.social.mediakata.dao.abstracts.model.UserDao;
import com.kata.social.mediakata.model.entity.user.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

@Sql("/sql/data.sql")
public class ExampleTest extends AbstractSpringTest {


}