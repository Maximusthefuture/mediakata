package com.kata.social.mediakata.example;


import com.kata.social.mediakata.AbstractSpringTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Sql("/sql/data.sql")
public class ExampleTest extends AbstractSpringTest{

}