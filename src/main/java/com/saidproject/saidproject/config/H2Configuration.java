package com.saidproject.saidproject.config;

import com.saidproject.saidproject.dao.mappers.DescriptionMapper;
import com.saidproject.saidproject.dao.mappers.MeasurementExtractor;
import com.saidproject.saidproject.dao.mappers.ProtocolMapper;
import com.saidproject.saidproject.dao.mappers.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@Profile("dev")
@ComponentScan(basePackages={"com.saidproject.saidproject.controller", "com.saidproject.saidproject.dao", "com.saidproject.saidproject.exceptions",
        "com.saidproject.saidproject.repo.h2", "com.saidproject.saidproject.service", "com.saidproject.saidproject.report"})
public class H2Configuration {


    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2)
                .generateUniqueName(false)
                .addScript("db/schema.sql")
                .addScript("db/test-data-base.sql")
                .build();
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

    @Bean
    public ProtocolMapper protocolMapper(){
        return new ProtocolMapper();
    }
}
