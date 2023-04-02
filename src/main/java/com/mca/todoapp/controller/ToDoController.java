package com.mca.todoapp.controller;

import com.mca.todoapp.model.ToDoEntity;
import com.mca.todoapp.service.ToDoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todo")
public class ToDoController {
    private final ToDoService toDoService;

    @GetMapping("/findall")
    public ResponseEntity<List<ToDoEntity>> fetchAll(){
        List<ToDoEntity> todos = toDoService.findAllToDos();
        return new ResponseEntity<>(todos, OK);
    }
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<ToDoEntity> fetchById(@PathVariable("id") Long id){
        return new ResponseEntity<>(toDoService.findToDoById(id), OK);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addToDo(@RequestBody ToDoEntity toDo){
        return new ResponseEntity<>(toDoService.addTodo(toDo), CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ToDoEntity> updateTodoById(@PathVariable("id")Long id, @RequestBody ToDoEntity toDo){
        if (toDoService.isPresent(id)){
            toDo.setId(id);
            ToDoEntity updatedTodo = toDoService.updateToDo(toDo);
            return  new ResponseEntity<>(updatedTodo, OK);
        }else {
            return new ResponseEntity<>(NOT_FOUND);
        }
    }



    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteToDoById(@PathVariable("id") Long id){
        toDoService.deleteToDo(id);
        return new ResponseEntity<>(OK);
    }
}
