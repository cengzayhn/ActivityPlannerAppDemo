package com.mca.todoapp.repositories;

import com.mca.todoapp.model.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToDoRepo extends JpaRepository<ToDoEntity,Long> {
    Optional<ToDoEntity> findToDoEntityById(Long id);

    void deleteToDoEntityById(Long id);
}
