package com.motorny.ss.chemistryservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class HibernateConfig {

    private JdbcTemplate jdbcTemplate;
}
