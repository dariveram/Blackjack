package com.cenfotec.proyectofinal.blackjack.model;

import com.cenfotec.proyectofinal.blackjack.model.enumeration.CartaNombre;
import com.cenfotec.proyectofinal.blackjack.model.enumeration.CartaTipo;
import com.cenfotec.proyectofinal.blackjack.model.enumeration.CartaValor;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by drivera on 2016-03-21.
 */
public class Baraja {

    private ArrayList<Carta> baraja;

    public ArrayList<Carta> getBaraja() {
        return baraja;
    }

    public Baraja() {
        this.initialize();
    }

    public Baraja(ArrayList<Carta> baraja) {
        this.baraja = baraja;
    }

    private void initialize(){
        baraja = new ArrayList<>();
        generarBaraja();
        revolverBaraja();
    }

    private void generarBaraja(){
        baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_2, CartaValor.DOS));
        baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_3, CartaValor.TRES));
        baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_4, CartaValor.CUATRO));
        baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_5, CartaValor.CINCO));
        baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_6, CartaValor.SEIS));
        baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_7, CartaValor.SIETE));
        baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_8, CartaValor.OCHO));
        baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_9, CartaValor.NUEVE));
        baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_10, CartaValor.DIEZ));
        baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_J, CartaValor.DIEZ));
        baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_Q, CartaValor.DIEZ));
        baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_K, CartaValor.DIEZ));
        baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_A, CartaValor.ONCE));

        baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_2, CartaValor.DOS));
        baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_3, CartaValor.TRES));
        baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_4, CartaValor.CUATRO));
        baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_5, CartaValor.CINCO));
        baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_6, CartaValor.SEIS));
        baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_7, CartaValor.SIETE));
        baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_8, CartaValor.OCHO));
        baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_9, CartaValor.NUEVE));
        baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_10, CartaValor.DIEZ));
        baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_J, CartaValor.DIEZ));
        baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_Q, CartaValor.DIEZ));
        baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_K, CartaValor.DIEZ));
        baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_A, CartaValor.ONCE));

        baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_2, CartaValor.DOS));
        baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_3, CartaValor.TRES));
        baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_4, CartaValor.CUATRO));
        baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_5, CartaValor.CINCO));
        baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_6, CartaValor.SEIS));
        baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_7, CartaValor.SIETE));
        baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_8, CartaValor.OCHO));
        baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_9, CartaValor.NUEVE));
        baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_10, CartaValor.DIEZ));
        baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_J, CartaValor.DIEZ));
        baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_Q, CartaValor.DIEZ));
        baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_K, CartaValor.DIEZ));
        baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_A, CartaValor.ONCE));

        baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_2, CartaValor.DOS));
        baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_3, CartaValor.TRES));
        baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_4, CartaValor.CUATRO));
        baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_5, CartaValor.CINCO));
        baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_6, CartaValor.SEIS));
        baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_7, CartaValor.SIETE));
        baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_8, CartaValor.OCHO));
        baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_9, CartaValor.NUEVE));
        baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_10, CartaValor.DIEZ));
        baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_J, CartaValor.DIEZ));
        baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_Q, CartaValor.DIEZ));
        baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_K, CartaValor.DIEZ));
        baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_A, CartaValor.ONCE));
    }

    private void revolverBaraja(){
        Collections.shuffle(this.baraja);
    }

}
