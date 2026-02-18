package com.example.arquiteturaspring.montadora.api;
import com.example.arquiteturaspring.montadora.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteFabricaController {

    //Injeta automaticamente uma dependência que já está gerenciada pelo Spring.
    @Autowired
    private Motor motor;

    @PostMapping
    public CarroStatus startCar(@RequestBody Chave chave) {
        var carro = new HondaHB20(motor);
       return carro.darIgnicao(chave);
    }


}
