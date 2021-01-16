package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * This class need to configure Database
 */

@Configuration
@ComponentScan("com.config")
@PropertySource("classpath:db.properties")
public class DBConfig {

    @Autowired
    Environment environment;

    private final String URL = "url";
    private final String USER = "user";
    private final String DRIVER = "driver";
    private final String PASSWORD = "password";

    /**
     * Here we connect to database,
     * we use db.properties for connection
     * @return driverManagerDataSource
     */
    @Bean
    DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(environment.getProperty(URL));
        driverManagerDataSource.setUsername(environment.getProperty(USER));
        driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
        driverManagerDataSource.setPassword(environment.getProperty(DRIVER));

        return driverManagerDataSource;
    }

}
