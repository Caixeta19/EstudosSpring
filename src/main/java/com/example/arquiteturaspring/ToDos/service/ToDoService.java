package com.example.arquiteturaspring.ToDos.service;
import com.example.arquiteturaspring.ToDos.MailSender;
import com.example.arquiteturaspring.ToDos.ToDoValidator;
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

    private final ToDoRepository toDoRepository;
    private final ToDoValidator validator;
    private final MailSender mailSender;


    public ToDoService(ToDoRepository toDoRepository,
                       ToDoValidator validator,
                       MailSender mailSender) {
        this.toDoRepository = toDoRepository;
        this.validator = validator;
        this.mailSender = mailSender;
    }

    public ToDoEntity save(ToDoEntity toDoEntity) {
        validator.validar(toDoEntity);
        return toDoRepository.save(toDoEntity);
    }

    public void atualizarStatus(ToDoEntity toDoEntity) {
        ToDoEntity existente = toDoRepository.findById(toDoEntity.getId())
                .orElseThrow(() -> new RuntimeException("ToDo não encontrado"));

        existente.setConcluido(toDoEntity.getConcluido());
        toDoRepository.save(existente);

        String status = existente.getConcluido() == Boolean.TRUE ? "Concluido" : "Não concluído";
        mailSender.enviar("ToDo " + existente.getDescricao() + " foi atualizado para " + status);
    }

    public ToDoEntity buscarporId(Integer id) {
        return toDoRepository.findById(id).orElse(null);
    }
}

