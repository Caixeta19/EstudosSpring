package com.example.arquiteturaspring.ToDos.repository;

import com.example.arquiteturaspring.ToDos.entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoEntity,Integer> {
}
