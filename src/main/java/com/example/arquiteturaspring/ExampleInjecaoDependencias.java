package com.example.arquiteturaspring;

import com.example.arquiteturaspring.ToDos.MailSender;
import com.example.arquiteturaspring.ToDos.ToDoValidator;
import com.example.arquiteturaspring.ToDos.entity.ToDoEntity;
import com.example.arquiteturaspring.ToDos.repository.ToDoRepository;
import com.example.arquiteturaspring.ToDos.service.ToDoService;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class ExampleInjecaoDependencias {
    public static void main(String[] args) throws Exception {

        DataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("url");
        dataSource.setUsername("user");
        dataSource.setPassword("password");

        Connection connection = dataSource.getConnection();

        ToDoRepository repository = null; // new SimpleJpaRepository<ToDoEntity,Integer>();
        ToDoValidator validator = new ToDoValidator(repository);
        MailSender sender = new MailSender();

        ToDoService toDoService = new ToDoService(repository,validator,sender);
    }
}
