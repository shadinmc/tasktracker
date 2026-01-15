package com.project.tasktracker.controller;

import com.project.tasktracker.dto.TaskRequest;
import com.project.tasktracker.dto.TaskResponse;
import com.project.tasktracker.dto.TaskStatusUpdate;
import com.project.tasktracker.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public TaskResponse create(@RequestBody TaskRequest data){
        return taskService.createTask(data);
    }

    @GetMapping
    public List<TaskResponse> getAll(){
        return taskService.getAllTasks();
    }

    @PutMapping("/{id}/status")
        public TaskResponse updateStatus(@PathVariable Long id,@RequestBody  TaskStatusUpdate data){
            return taskService.updateStatus(id, data);
        }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
    }
