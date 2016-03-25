package com.cenfotec.proyectofinal.blackjack.model;

import java.util.ArrayList;

/**
 * Created by drivera on 2016-03-21.
 */
public class Jugador {

    private Baraja baraja;

    public Baraja Baraja() {
        return baraja;
    }

    public Jugador() {
        this.initialize();
    }

    public void initialize(){
        this.baraja = new Baraja(new ArrayList<Carta>());
    }

}
