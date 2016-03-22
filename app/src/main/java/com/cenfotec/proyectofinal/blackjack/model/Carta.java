package com.cenfotec.proyectofinal.blackjack.model;

import com.cenfotec.proyectofinal.blackjack.model.enumeration.CartaNombre;
import com.cenfotec.proyectofinal.blackjack.model.enumeration.CartaTipo;
import com.cenfotec.proyectofinal.blackjack.model.enumeration.CartaValor;

/**
 * Created by drivera on 2016-03-21.
 */
public class Carta {

    private CartaTipo tipo;
    private CartaNombre nombre;
    private CartaValor valor;

    public CartaTipo getTipo() {
        return tipo;
    }

    public void setTipo(CartaTipo tipo) {
        this.tipo = tipo;
    }

    public CartaNombre getNombre() {
        return nombre;
    }

    public void setNombre(CartaNombre nombre) {
        this.nombre = nombre;
    }

    public CartaValor getValor() {
        return valor;
    }

    public void setValor(CartaValor valor) {
        this.valor = valor;
    }

    public String getImagen(){
        String Imagen;
        switch (this.tipo){
            case CORAZON:
                Imagen = "corazon_";
                break;
            case DIAMANTE:
                Imagen = "diamante_";
                break;
            case ESPADA:
                Imagen = "espada_";
                break;
            case TREBOL:
                Imagen = "trebol_";
                break;
            default:
                Imagen = "desconocido";
                break;
        }
        switch (this.nombre){
            case CN_2:
                Imagen += "2";
                break;
            case CN_3:
                Imagen += "3";
                break;
            case CN_4:
                Imagen += "4";
                break;
            case CN_5:
                Imagen += "5";
                break;
            case CN_6:
                Imagen += "6";
                break;
            case CN_7:
                Imagen += "7";
                break;
            case CN_8:
                Imagen += "8";
                break;
            case CN_9:
                Imagen += "9";
                break;
            case CN_10:
                Imagen += "10";
                break;
            case CN_J:
                Imagen += "j";
                break;
            case CN_Q:
                Imagen += "q";
                break;
            case CN_K:
                Imagen += "k";
                break;
            case CN_A:
                Imagen += "a";
                break;
            default:
                Imagen = "desconocido";
                break;
        }
        return Imagen;
    }
    
    public Carta(CartaTipo tipo, CartaNombre nombre, CartaValor valor) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.valor = valor;
    }
}
