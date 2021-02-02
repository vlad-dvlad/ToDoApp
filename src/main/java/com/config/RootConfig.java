package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author vlad-dvlad
 */

@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class RootConfig {

    @Value("${spring.datasource.url}")
    private String URL;

    @Value("${spring.datasource.user}")
    private String USER;

    @Value("${spring.datasource.driver}")
    private String DRIVER;

    @Value("${spring.datasource.password}")
    private String PASSWORD;

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
