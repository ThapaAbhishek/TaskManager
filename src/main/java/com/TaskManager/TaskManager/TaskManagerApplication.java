package com.TaskManager.TaskManager;

import com.TaskManager.TaskManager.dao.TaskManagerDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagerApplication {

	private static TaskManagerDAO taskManagerDAO;

	public TaskManagerApplication(TaskManagerDAO taskManagerDAO) {
		TaskManagerApplication.taskManagerDAO = taskManagerDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
		taskManagerDAO.list().forEach(System.out::println);
	}

}
