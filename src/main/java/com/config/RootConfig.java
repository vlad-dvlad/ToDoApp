package com.config;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class RootConfig {

    private final String URL = "jdbc:postgresql://127.0.0.1:5432/todo_db";
    private final String USER = "usr";
    private final String DRIVER = "org.postgresql.Driver";
    private final String PASSWORD = "admin";

    /**
     * Here we connect to database,
     * we use application.properties for connection
     * @return driverManagerDataSource
     */

    @Bean
    DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName(DRIVER);
        driverManagerDataSource.setUrl(URL);
        driverManagerDataSource.setUsername(USER);
        driverManagerDataSource.setPassword(PASSWORD);

        return driverManagerDataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
}
