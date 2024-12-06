package com.TaskManager.TaskManager.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class TaskManager {

    private int id;
    private String taskTitle;
    private String taskDescription;
    private String taskStatus;
    private String taskCreatedDate;
    private String taskDueDate;

    @Override
    public String toString() {
        return "TaskManager{" +
                "id=" + id +
                ", taskTitle='" + taskTitle + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", taskCreatedDate='" + taskCreatedDate + '\'' +
                ", taskDueDate='" + taskDueDate + '\'' +
                '}';
    }
}
