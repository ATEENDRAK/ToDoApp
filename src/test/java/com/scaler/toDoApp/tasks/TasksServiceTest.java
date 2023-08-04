package com.scaler.toDoApp.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TasksServiceTest {
    private TasksService tasksService =  new TasksService();

//    public TasksServiceTest(TasksService tasksService){
//        this.tasksService = tasksService;
//    }

    @Test
    public void createNewTask(){
        tasksService.createTask("task1",null);
        Assertions.assertEquals(1,tasksService.getTasks().size());
        Assertions.assertEquals("task1",tasksService.getTask(0).getName());
    }
}
