package com.TaskManager.TaskManager;

import com.TaskManager.TaskManager.dao.TaskManagerDAO;
import com.TaskManager.TaskManager.model.TaskManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskManagerController {
    private TaskManagerDAO taskManagerDAO;

    public TaskManagerController(TaskManagerDAO taskManager) {
        this.taskManagerDAO = taskManager;
    }

    @PostMapping("/addTask")
    public String addTaskManager(@RequestBody TaskManager taskManager) {
        if (taskManagerDAO.get(taskManager.getTaskTitle()).isEmpty()) {
            taskManagerDAO.create(taskManager);
            return taskManager.getTaskTitle() + " titled task added";
        } else {
            return "task already exists";
        }
    }

    @GetMapping("/allTasks")
    public List<TaskManager> allTasks() {
        System.out.println(taskManagerDAO.list());
        return taskManagerDAO.list();
    }

    @GetMapping("/taskById")
    public Optional<TaskManager> getTaskById(@RequestParam int id) {
        return taskManagerDAO.get(id);
    }

    @GetMapping("/taskByTitle")
    public Optional<TaskManager> getTaskById(@RequestParam String title) {
        return taskManagerDAO.get(title);
    }

    @PutMapping("/updateTask")
    public String updateTask(@RequestBody TaskManager taskManager) {
        if (taskManagerDAO.get(taskManager.getId()).isEmpty() && taskManagerDAO.get(taskManager.getTaskTitle()).isEmpty()) {
            taskManagerDAO.create(taskManager);
            System.out.println("Task created");
            return "Task created";
        } else {
            taskManagerDAO.update(taskManager);
            System.out.println("Task updated for id= " + taskManager.getId());
            return "Task updated for id= " + taskManager.getId();
        }
    }

    @DeleteMapping("/deleteById")
    public String deleteTaskById(@RequestParam int id) {
        if (taskManagerDAO.get(id).isPresent()) {
            taskManagerDAO.delete(String.valueOf(id));
            return "Task deleted for id= " + id;
        } else {
            return "Task with id=" + id + " not found";
        }
    }

}
