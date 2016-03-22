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
        String Imagen = "";
        //// TODO: 2016-03-21 Case para determinar el nombre de la imagen. 
        return Imagen;
    }
    
    public Carta(CartaTipo tipo, CartaNombre nombre, CartaValor valor) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.valor = valor;
    }
}
