package com.bestsolution.server.config;

import liquibase.integration.spring.SpringLiquibase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class LiquibaseConfig {

    @Value("${app.liquibase.migrate:true}")
    private boolean liquibaseMigrate;

    private DataSource dataSource;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public LiquibaseConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:schema/changelog.xml");
        liquibase.setDataSource(dataSource);
        liquibase.setShouldRun(liquibaseMigrate);
        return liquibase;
    }

}