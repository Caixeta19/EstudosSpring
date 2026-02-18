package com.example.arquiteturaspring.montadora;

import java.awt.*;

public class HondaHB20 extends Carro{

public HondaHB20(Motor motor) {
    super(motor);
    setModelo("HB20");
    setCor(Color.GRAY);
    setMontadora(Montadora.HONDA);
    }
}
