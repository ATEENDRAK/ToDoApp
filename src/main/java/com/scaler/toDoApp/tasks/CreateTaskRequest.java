package com.scaler.toDoApp.tasks;

import lombok.Data;

@Data
public class CreateTaskRequest {
    String name;
    String dueDate;
}
