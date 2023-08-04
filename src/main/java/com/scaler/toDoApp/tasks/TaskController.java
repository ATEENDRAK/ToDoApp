package com.scaler.toDoApp.tasks;

import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
     private TasksService tasksService;
     public TaskController(TasksService tasksService){
         this.tasksService = tasksService;
     }

     @GetMapping("/")
    public List<TaskEntity> getAllTasks(){
         return tasksService.getTasks();
     }

     @GetMapping("/id")
    public TaskEntity getTaskById(@PathVariable Integer id){
         return tasksService.getTask(id);
     }

     @PostMapping("/")
    public ResponseEntity createTask(@RequestBody CreateTaskRequest createTaskRequest){
         tasksService.createTask(createTaskRequest.getName(),new Date());
         return ResponseEntity.status(201).body("Task created successfully");
     }
}
