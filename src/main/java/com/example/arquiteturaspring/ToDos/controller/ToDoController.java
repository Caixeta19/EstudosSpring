package com.example.arquiteturaspring.ToDos.controller;
import com.example.arquiteturaspring.ToDos.entity.ToDoEntity;
import com.example.arquiteturaspring.ToDos.repository.ToDoRepository;
import com.example.arquiteturaspring.ToDos.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/ToDo")

public class ToDoController {

    private final ToDoRepository toDoRepository;
    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService, ToDoRepository toDoRepository) {
        this.toDoService = toDoService;
        this.toDoRepository = toDoRepository;
    }
    @PostMapping
    public ToDoEntity save(@RequestBody ToDoEntity toDoEntity) {
        try{
            return this.toDoService.save(toDoEntity);
        } catch (IllegalArgumentException e) {
            var mensagemErro = e.getMessage();
            throw new ResponseStatusException(HttpStatus.CONFLICT, mensagemErro);
        }

    }
    @PutMapping("{id}")
    public void atualizarStatus(
            @PathVariable("id") Integer id, @RequestBody ToDoEntity toDoEntity) {
        toDoEntity.setId(id);
        toDoService.atualizarStatus(toDoEntity);
    }

    @GetMapping("/{id}")
    public ToDoEntity buscarPorId(@PathVariable("id") Integer id) {
        return toDoService.buscarporId(id);
    }
}
