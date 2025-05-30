package com.TaskManager.TaskManager;

import com.TaskManager.TaskManager.Security.JwtUtils;
import com.TaskManager.TaskManager.dao.TaskManagerDAO;
import com.TaskManager.TaskManager.model.TaskManager;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskManagerController {
    private TaskManagerDAO taskManagerDAO;
    private JwtUtils jwtUtil;

    public TaskManagerController(TaskManagerDAO taskManager, JwtUtils jwtUtils) {
        this.taskManagerDAO = taskManager;
        this.jwtUtil = jwtUtils;
    }

    @PostMapping("/generateToken")
    public ResponseEntity<String> generateToken(@RequestParam String username) {
        // In a real app, validate username with the database
        String token = jwtUtil.generateToken(username);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/addTask")
    public String addTaskManager(@Valid @RequestBody TaskManager taskManager) {
        if (taskManagerDAO.get(taskManager.getTaskTitle()).isEmpty()) {
            taskManagerDAO.create(taskManager);
            return taskManager.getTaskTitle() + " titled task added";
        } else {
            return "task already exists";
        }
    }

    @GetMapping("/allTasks")
    public List<TaskManager> allTasks() {
        return taskManagerDAO.list();
    }

    @GetMapping("/getTaskByStatus")
    public List<TaskManager> getTaskByStatus(@RequestParam String taskStatus) {
        return taskManagerDAO.getByStatus(taskStatus);
    }

    @GetMapping("/getTaskByDueDateRange")
    public List<TaskManager> getTaskByDueDateRange(@RequestParam String startDate, @RequestParam String endDate) {
        return taskManagerDAO.getTasksByDateRange(startDate, endDate);
    }

    @GetMapping("/taskById")
    public Optional<TaskManager> getTaskById(@RequestParam int id) {
        return taskManagerDAO.get(id);
    }

    @GetMapping("/taskByTitle")
    public Optional<TaskManager> getTaskByTitle(@RequestParam String title) {
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
