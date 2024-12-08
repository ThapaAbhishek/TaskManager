package com.TaskManager.TaskManager.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TaskManager {

    private int id;
    private String taskTitle;
    private String taskDescription;
    private String taskStatus;
    private String taskCreatedDate;
    private String taskDueDate;

}
