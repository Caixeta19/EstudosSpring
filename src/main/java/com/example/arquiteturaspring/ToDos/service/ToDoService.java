package com.example.arquiteturaspring.ToDos.service;
import com.example.arquiteturaspring.ToDos.entity.ToDoEntity;
import com.example.arquiteturaspring.ToDos.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ToDoService {

    //@Autowired -> dispensável se houver construtor
    private ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDoEntity save(ToDoEntity toDoEntity) {
        return toDoRepository.save(toDoEntity);
    }

    public void atualizarStatus(ToDoEntity toDoEntity) {
        toDoRepository.save(toDoEntity);
    }
        public ToDoEntity buscarporId(Integer id) {
            return toDoRepository.findById(id).orElse(null);
        }

    }

