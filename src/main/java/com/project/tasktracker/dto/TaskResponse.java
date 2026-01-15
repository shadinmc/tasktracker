package com.project.tasktracker.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponse {
    private Long id;
    private  String title;
    private String description;
    private String status;

}
