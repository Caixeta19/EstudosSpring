package com.example.arquiteturaspring.ToDos;

import com.example.arquiteturaspring.ToDos.entity.ToDoEntity;
import com.example.arquiteturaspring.ToDos.repository.ToDoRepository;
import org.springframework.stereotype.Component;

@Component
public class ToDoValidator {

    private ToDoRepository repository;

    public ToDoValidator(ToDoRepository repository) {
        this.repository = repository;
    }

    public void validar(ToDoEntity toDoEntity) {
        if (existeToDoComDescricao(toDoEntity.getDescricao())) {
            throw new IllegalArgumentException("ATENÇÃO! Já existe ToDo com está descrição");
        }
    }

    private boolean existeToDoComDescricao(String descricao) {
         return repository.existsByDescricao(descricao);

    }
}

