package com.saidproject.saidproject.config;

import com.saidproject.saidproject.dao.mappers.DescriptionMapper;
import com.saidproject.saidproject.dao.mappers.MeasurementExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class TestConfiguration {

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
    public DescriptionMapper descriptionMapper(){
        return new DescriptionMapper();
    }
}
