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

    public ArrayList<Carta> obtenerBaraja() {
        return this.baraja;
    }

    public Baraja() {
        this.initialize();
    }

    public Baraja(ArrayList<Carta> baraja) {
        this.baraja = baraja;
    }

    public void initialize(){
        this.baraja = new ArrayList<>();
        generarBaraja();
        revolverBaraja();
    }

    private void generarBaraja(){
        this.baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_2, CartaValor.DOS));
        this.baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_3, CartaValor.TRES));
        this.baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_4, CartaValor.CUATRO));
        this.baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_5, CartaValor.CINCO));
        this.baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_6, CartaValor.SEIS));
        this.baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_7, CartaValor.SIETE));
        this.baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_8, CartaValor.OCHO));
        this.baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_9, CartaValor.NUEVE));
        this.baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_10, CartaValor.DIEZ));
        this.baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_J, CartaValor.DIEZ));
        this.baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_Q, CartaValor.DIEZ));
        this.baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_K, CartaValor.DIEZ));
        this.baraja.add(new Carta(CartaTipo.CORAZON, CartaNombre.CN_A, CartaValor.ONCE));

        this.baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_2, CartaValor.DOS));
        this.baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_3, CartaValor.TRES));
        this.baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_4, CartaValor.CUATRO));
        this.baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_5, CartaValor.CINCO));
        this.baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_6, CartaValor.SEIS));
        this.baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_7, CartaValor.SIETE));
        this.baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_8, CartaValor.OCHO));
        this.baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_9, CartaValor.NUEVE));
        this.baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_10, CartaValor.DIEZ));
        this.baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_J, CartaValor.DIEZ));
        this.baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_Q, CartaValor.DIEZ));
        this.baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_K, CartaValor.DIEZ));
        this.baraja.add(new Carta(CartaTipo.DIAMANTE, CartaNombre.CN_A, CartaValor.ONCE));

        this.baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_2, CartaValor.DOS));
        this.baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_3, CartaValor.TRES));
        this.baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_4, CartaValor.CUATRO));
        this.baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_5, CartaValor.CINCO));
        this.baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_6, CartaValor.SEIS));
        this.baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_7, CartaValor.SIETE));
        this.baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_8, CartaValor.OCHO));
        this.baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_9, CartaValor.NUEVE));
        this.baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_10, CartaValor.DIEZ));
        this.baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_J, CartaValor.DIEZ));
        this.baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_Q, CartaValor.DIEZ));
        this.baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_K, CartaValor.DIEZ));
        this.baraja.add(new Carta(CartaTipo.ESPADA, CartaNombre.CN_A, CartaValor.ONCE));

        this.baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_2, CartaValor.DOS));
        this.baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_3, CartaValor.TRES));
        this.baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_4, CartaValor.CUATRO));
        this.baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_5, CartaValor.CINCO));
        this.baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_6, CartaValor.SEIS));
        this.baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_7, CartaValor.SIETE));
        this.baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_8, CartaValor.OCHO));
        this.baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_9, CartaValor.NUEVE));
        this.baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_10, CartaValor.DIEZ));
        this.baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_J, CartaValor.DIEZ));
        this.baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_Q, CartaValor.DIEZ));
        this.baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_K, CartaValor.DIEZ));
        this.baraja.add(new Carta(CartaTipo.TREBOL, CartaNombre.CN_A, CartaValor.ONCE));
    }

    public void revolverBaraja(){
        Collections.shuffle(this.baraja);
    }

    public Carta obtenerCartaBaraja(int i){
        return this.baraja.get(i);
    }

    public void agregarCartaBaraja(Carta carta){
        this.baraja.add(carta);
    }

    public void eliminarCartaBaraja(Carta carta){
        this.baraja.remove(carta);
    }

    public void eliminarCartaBaraja(int i){
        this.baraja.remove(i);
    }

    public int contarCartasBaraja(){
        int total = 0;
        for (Carta c:this.baraja
             ) {
            int valor;
            switch (c.getValor()){
                case UNO:
                    valor = 1;
                    break;
                case DOS:
                    valor = 2;
                    break;
                case TRES:
                    valor = 3;
                    break;
                case CUATRO:
                    valor = 4;
                    break;
                case CINCO:
                    valor = 5;
                    break;
                case SEIS:
                    valor = 6;
                    break;
                case SIETE:
                    valor = 7;
                    break;
                case OCHO:
                    valor = 8;
                    break;
                case NUEVE:
                    valor = 9;
                    break;
                case DIEZ:
                    valor = 10;
                    break;
                case ONCE:
                    valor = 11;
                    break;
                default:
                    valor = 0;
                    break;
            }
            total += valor;
        }
        return total;
    }

}
