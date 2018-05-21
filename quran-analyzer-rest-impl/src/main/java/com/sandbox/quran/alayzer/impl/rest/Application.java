package com.sandbox.quran.alayzer.impl.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public DataSource dataSource() {
        String NEO4J_URL = System.getenv("NEO4J_URL");
        if (NEO4J_URL == null) NEO4J_URL = System.getProperty("NEO4J_URL", "jdbc:neo4j:http://localhost:7474");
        return new DriverManagerDataSource(NEO4J_URL);
    }
}