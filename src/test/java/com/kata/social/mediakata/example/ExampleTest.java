package com.kata.social.mediakata.example;


import com.kata.social.mediakata.AbstractSpringTest;
import org.springframework.test.context.jdbc.Sql;

@Sql("/sql/data.sql")
public class ExampleTest extends AbstractSpringTest {


}