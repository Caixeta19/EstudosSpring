package com.example.arquiteturaspring.ToDos.controller;
import com.example.arquiteturaspring.ToDos.entity.ToDoEntity;
import com.example.arquiteturaspring.ToDos.repository.ToDoRepository;
import com.example.arquiteturaspring.ToDos.service.ToDoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ToDo")

public class ToDoController {

    private final ToDoRepository toDoRepository;
    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService, ToDoRepository toDoRepository) {
        this.toDoService = toDoService;
        this.toDoRepository = toDoRepository;
    }
    @PostMapping
    public void save(@RequestBody ToDoEntity toDoEntity) {
        this.toDoService.save(toDoEntity);
    }
    @PutMapping("{id}")
    public void atualizarStatus(@PathVariable("id") Integer id, @RequestBody ToDoEntity toDoEntity ) {
        toDoRepository.save(toDoEntity);
    }
@GetMapping
public ToDoEntity buscarPorId(@PathVariable("id") Integer id) {
        return toDoService.buscarporId(id);

}
}
