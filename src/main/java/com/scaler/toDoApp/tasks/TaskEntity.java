package com.scaler.toDoApp.tasks;

import com.scaler.toDoApp.notes.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskEntity {
    Integer id;
    String name;
    Date dueDate;
    Boolean completed;
    List<NoteEntity> notes;
}
