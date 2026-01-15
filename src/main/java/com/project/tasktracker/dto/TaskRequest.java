package com.project.tasktracker.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequest {

    private String title;
    private String description;


}
