package com.example.arquiteturaspring;

import com.example.arquiteturaspring.ToDos.ToDoValidator;
import com.example.arquiteturaspring.ToDos.entity.ToDoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class BeanGerenciado {

    @Autowired
    private ToDoValidator validator;

    public void utilizar(){
        var ToDo = new ToDoEntity();
        validator.validar(ToDo);
    }

public void setValidator(ToDoValidator validator){
        this.validator = validator;
}
}
