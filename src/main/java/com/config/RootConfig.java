package com.config;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class RootConfig {

    private final String URL = "spring.datasource.url";
    private final String USER = "spring.datasource.user";
    private final String DRIVER = "spring.datasource.driver";
    private final String PASSWORD = "spring.datasource.password";

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
