package com.cenfotec.proyectofinal.blackjack.model;

import java.util.ArrayList;

/**
 * Created by drivera on 2016-03-22.
 */
public class Repartidor {
    private int cantidadBarajas;
    private Baraja baraja;

    public Baraja Baraja() {
        return baraja;
    }

    public Repartidor(int cantidadBarajas) {
        this.cantidadBarajas = cantidadBarajas;
        this.initialize();
    }

    private void initialize(){
        this.baraja = new Baraja(new ArrayList<Carta>());
        ArrayList<Baraja> lstBaraja = new ArrayList<>(this.cantidadBarajas);
        for (int i=0; i<this.cantidadBarajas; i++){
            lstBaraja.add(new Baraja(new ArrayList<Carta>()));
        }
        for (Baraja b:lstBaraja
                ) {
            b.initialize();
            for (Carta c:b.obtenerBaraja()
                    ) {
                this.baraja.agregarCartaBaraja(c);
            }
        }
        this.baraja.revolverBaraja();
    }

}
