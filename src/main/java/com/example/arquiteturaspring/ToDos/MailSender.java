package com.example.arquiteturaspring.ToDos;

import org.springframework.stereotype.Component;

@Component
public class MailSender {

    public void enviar(String mensagem){
        System.out.println("Enviando email: " + mensagem);
    }




}
