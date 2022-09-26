package com.kata.social.mediakata.initializer;


import lombok.experimental.UtilityClass;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@UtilityClass
public class Postgres {
   public static final PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(DockerImageName.parse("postgres:14.5"));

   public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

       @Override
       public void initialize(ConfigurableApplicationContext applicationContext) {
           TestPropertyValues.of(
                   "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                   "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                   "spring.datasource.password=" + postgreSQLContainer.getPassword()
           ).applyTo(applicationContext);
       }
   }
}
