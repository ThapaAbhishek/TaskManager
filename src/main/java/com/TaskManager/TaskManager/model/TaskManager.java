package com.TaskManager.TaskManager.model;

import com.TaskManager.TaskManager.Validators.ValidateDateInString;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TaskManager {

    private int id;

    @NotBlank(message = "Task title is mandatory")
    @Size(max = 255, message = "Task title must not exceed 255 characters")
    private String taskTitle;

    @NotBlank(message = "Task description is mandatory")
    private String taskDescription;

    @NotBlank(message = "Task status is mandatory")
    @Pattern(regexp = "pending|completed|in-progress|in progress", message = "Task status must be one of: pending, completed, in-progress")
    private String taskStatus;

    @ValidateDateInString
    private String taskCreatedDate;

    @ValidateDateInString
    private String taskDueDate;

}
