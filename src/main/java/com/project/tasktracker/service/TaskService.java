package com.project.tasktracker.service;

import com.project.tasktracker.dto.TaskRequest;
import com.project.tasktracker.dto.TaskResponse;
import com.project.tasktracker.dto.TaskStatusUpdate;
import com.project.tasktracker.entity.Task;
import com.project.tasktracker.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository ;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponse createTask(TaskRequest data){
        Task task = new Task();
        task.setTitle(data.getTitle());
        task.setDescription(data.getDescription());
        task.setStatus("Pending");

        Task saved = taskRepository.save(task);
        return mapToResponse(saved);
    }
    public List<TaskResponse> getAllTasks(){
        return taskRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
    public TaskResponse updateStatus(Long id, TaskStatusUpdate dto){
        Task task = taskRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Task not found"));

        task.setStatus(dto.getStatus());
        Task updated = taskRepository.save(task);
        return mapToResponse(updated);

    }

    private TaskResponse mapToResponse(Task task) {
        TaskResponse dto = new TaskResponse();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        return dto;
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
