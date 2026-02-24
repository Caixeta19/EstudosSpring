package com.example.arquiteturaspring.montadora.api;
import com.example.arquiteturaspring.montadora.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class TesteFabricaController {

    //Injeta automaticamente uma dependência que já está gerenciada pelo Spring.
    @Autowired
    //@Qualifier("motorEletrico")
    private Motor motor;

    @PostMapping
    public CarroStatus startCar(@RequestBody Chave chave) {
        var carro = new HondaHB20(motor);
       return carro.darIgnicao(chave);
    }


}
