package com.cenfotec.proyectofinal.blackjack.model;

import java.util.ArrayList;

/**
 * Created by drivera on 2016-03-22.
 */
public class Repartidor {

    private static final int MAX_PARTIDAS = 10;

    private int cantidadBarajas;
    private int cantidadPartidas;

    private Baraja baraja;

    public Baraja Baraja() {
        return baraja;
    }

    public Repartidor(int cantidadBarajas) {
        this.cantidadBarajas = cantidadBarajas;
        this.initialize();
    }

    private void initialize(){
        this.cantidadPartidas = 0;
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

    public void aumentarPartida(){
        this.cantidadPartidas += 1;
        if (this.cantidadPartidas > MAX_PARTIDAS) {
            this.initialize();
        }
    }

}
