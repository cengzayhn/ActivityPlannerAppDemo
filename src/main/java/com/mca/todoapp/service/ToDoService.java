package com.mca.todoapp.service;

import com.mca.todoapp.model.ToDoEntity;
import com.mca.todoapp.repositories.ToDoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepo toDoRepo;

    public boolean isPresent(Long id){
        return toDoRepo.findToDoEntityById(id).isPresent();
    }
    public List<ToDoEntity> findAllToDos(){
        return toDoRepo.findAll();
    }
    public ToDoEntity findToDoById(Long id){
        return toDoRepo.findToDoEntityById(id).orElseThrow(()->(new RuntimeException("Task "+id+" not found")));
    }
    public ToDoEntity addTodo(ToDoEntity toDo){
        return toDoRepo.save(toDo);
    }

    public ToDoEntity updateToDo(ToDoEntity toDo){
        return toDoRepo.save(toDo);
    }


    public void deleteToDo(Long id){
        toDoRepo.deleteToDoEntityById(id);
    }



}
