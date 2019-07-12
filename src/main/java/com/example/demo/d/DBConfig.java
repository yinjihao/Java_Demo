package com.example.demo.d;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DBConfig {
    @Bean(name = "saleClueDataSource")
    @ConfigurationProperties(prefix = "spring.ds-manage")
    @Primary
    public DataSource saleClueDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "saleClueJdbcTemplate")
    public JdbcTemplate saleClueJdbcTemplate(@Qualifier("saleClueDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}