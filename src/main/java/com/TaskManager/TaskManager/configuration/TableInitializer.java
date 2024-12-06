package com.TaskManager.TaskManager.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TableInitializer {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TableInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //@PostConstruct is to execute this piece of code only after initialization of code.
    @PostConstruct
    public void initializeTables() {
        String createTableSql ="""
                CREATE TABLE IF NOT EXISTS TaskManager (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    taskTitle VARCHAR(255) NOT NULL,
                    taskDescription TEXT,
                    taskStatus VARCHAR(50),
                    taskCreatedDate DATETIME,
                    taskDueDate DATETIME
                );

                """;
        jdbcTemplate.execute(createTableSql);
        System.out.println("TaskManager table initialized.");
    }
}

