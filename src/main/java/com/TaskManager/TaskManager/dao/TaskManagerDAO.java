package com.TaskManager.TaskManager.dao;

import com.TaskManager.TaskManager.model.TaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskManagerDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskManagerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<TaskManager> taskManagerRowMapper = (rs, rowNum) -> {
        TaskManager taskManager = new TaskManager();
        taskManager.setId(rs.getInt("id"));
        taskManager.setTaskTitle(rs.getString("taskTitle"));
        taskManager.setTaskDescription(rs.getString("taskDescription"));
        taskManager.setTaskStatus(rs.getString("taskStatus"));
        taskManager.setTaskCreatedDate(rs.getString("taskCreatedDate"));
        taskManager.setTaskDueDate(rs.getString("taskDueDate"));
        return taskManager;
    };


    public List<TaskManager> list() {
        String sqlCommand = "SELECT id, taskTitle, taskDescription, taskStatus, taskCreatedDate, taskDueDate FROM TaskManager";
        return jdbcTemplate.query(sqlCommand, taskManagerRowMapper);
    }


    public void create(TaskManager taskManager) {
        String sqlInsert = """
                    INSERT INTO TaskManager 
                    (taskTitle, taskDescription, taskStatus, taskCreatedDate, taskDueDate) 
                    VALUES (?, ?, ?, ?, ?);
                """;

        jdbcTemplate.update(
                sqlInsert,
                taskManager.getTaskTitle(),
                taskManager.getTaskDescription(),
                taskManager.getTaskStatus(),
                taskManager.getTaskCreatedDate(),
                taskManager.getTaskDueDate()
        );
    }


    public Optional<TaskManager> get(int id) {
        String selectQuery = """
                SELECT * FROM TaskManager WHERE id = ?;
                """;

        try {
            TaskManager taskManager = jdbcTemplate.queryForObject(
                    selectQuery,
                    (rs, rowNum) -> {
                        TaskManager tm = new TaskManager();
                        tm.setId(rs.getInt("id"));
                        tm.setTaskTitle(rs.getString("taskTitle"));
                        tm.setTaskDescription(rs.getString("taskDescription"));
                        tm.setTaskStatus(rs.getString("taskStatus"));
                        tm.setTaskCreatedDate(rs.getString("taskCreatedDate"));
                        tm.setTaskDueDate(rs.getString("taskDueDate"));
                        return tm;
                    },
                    id
            );
            return Optional.of(taskManager);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty(); // No record found, return an empty Optional
        }
    }


    public Optional<TaskManager> get(String taskTitle) {
        String selectQuery = """
                SELECT * FROM TaskManager WHERE taskTitle = ?;
                """;

        try {
            TaskManager taskManager = jdbcTemplate.queryForObject(
                    selectQuery,
                    (rs, rowNum) -> {
                        TaskManager tm = new TaskManager();
                        tm.setId(rs.getInt("id"));
                        tm.setTaskTitle(rs.getString("taskTitle"));
                        tm.setTaskDescription(rs.getString("taskDescription"));
                        tm.setTaskStatus(rs.getString("taskStatus"));
                        tm.setTaskCreatedDate(rs.getString("taskCreatedDate"));
                        tm.setTaskDueDate(rs.getString("taskDueDate"));
                        return tm;
                    },
                    taskTitle
            );
            return Optional.of(taskManager);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty(); // No record found, return an empty Optional
        }
    }


    public void update(TaskManager taskManager) {
        String updateQuery = """
                UPDATE TaskManager 
                    SET taskTitle=?, taskDescription=?, taskStatus=?, taskDueDate=?
                    WHERE id=?;
                """;
        jdbcTemplate.update(updateQuery, taskManager.getTaskTitle(), taskManager.getTaskDescription(), taskManager.getTaskStatus(), taskManager.getTaskDueDate(), taskManager.getId());
    }


    public void delete(String id) {
        String deleteQuery = """
                Delete FROM TaskManager WHERE id = ?;
                """;
        jdbcTemplate.update(deleteQuery, id);
    }
}
