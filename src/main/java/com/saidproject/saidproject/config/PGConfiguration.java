package com.saidproject.saidproject.config;

import com.saidproject.saidproject.dao.mappers.DescriptionMapper;
import com.saidproject.saidproject.dao.mappers.MeasurementExtractor;
import com.saidproject.saidproject.dao.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@Profile("prod")
@ComponentScan(basePackages={"com.saidproject.saidproject.controller", "com.saidproject.saidproject.dao", "com.saidproject.saidproject.exceptions",
                                "com.saidproject.saidproject.repo.postgres", "com.saidproject.saidproject.service"})
public class PGConfiguration {

    @Autowired
    protected DataSource dataSource;


    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public MeasurementExtractor measurementExtractor() {
        return new MeasurementExtractor();
    }

    @Bean
    public DescriptionMapper descriptionMapper() {
        return new DescriptionMapper();
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }
}