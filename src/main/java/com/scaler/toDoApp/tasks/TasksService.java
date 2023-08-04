package com.scaler.toDoApp.tasks;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TasksService {

    List<TaskEntity> tasks;
    public TasksService(){
        this.tasks = new ArrayList<TaskEntity>();
    }
    /*
    Get all tasks
     */
    public List<TaskEntity> getTasks(){
        return tasks;
    }

    public void createTask(String name, Date dueDate){
        Integer id = tasks.size();
        tasks.add(new TaskEntity(id,name,dueDate,false,new ArrayList<>()));
    }

    /*
    Get task by id
     */
    public TaskEntity getTask(Integer id){
        if(id>=0 && id<tasks.size())
            return tasks.get(id);
       // return new TaskEntity(-1,null,null,false,new ArrayList<>());
        throw new TaskNotFoundException(id);
    }

    /*
    Delete task by id
     */
    public TaskEntity deleteTask(Integer id){
        if(id>=0 && id <tasks.size()){
            TaskEntity task = tasks.get(id);
            tasks.remove(id);
            return task;
        }
        else
            throw new TaskNotFoundException(id);
    }

    /*
    Update task by id
     */
    public void updateTask(Integer id,String name,Date dueDate,Boolean completed){
        if(id>=0 && id <tasks.size()){
            TaskEntity task = tasks.get(id);
            if(name != null)
                task.setName(name);
            if(dueDate != null)
                task.setDueDate(dueDate);
            if(completed != null)
                task.setCompleted(completed);
        }
        else
            throw new TaskNotFoundException(id);
    }
    static class TaskNotFoundException extends IllegalArgumentException{
        public TaskNotFoundException(Integer id){
            System.out.println("Task not present with id : "+ id);
        }
    }
}
