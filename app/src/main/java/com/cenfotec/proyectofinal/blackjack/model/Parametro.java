package com.cenfotec.proyectofinal.blackjack.model;

import java.util.ArrayList;
import java.lang.String;

/**
 * Created by drivera on 2016-04-02.
 */
public class Parametro {
    // TODO: Humberto, utiliza esta clase para administrar los parámetros.
    // TODO: Por favor crea un método publico que se llame cargarParametros(), la idea es que ese método
    // TODO: lea los valores del Internal Storage y los cargue en las variables privadas de la clase.

    public String NombreJugador;
    public int PuntosGanados;
    public int PuntosPerdidos;
    public int CantBarajas;
    public int CantManos;
    public int MinimoPuntos;
    public int Acumulado;

    public void initialize(){
        this.NombreJugador ="";
        this.PuntosGanados =0;
        this.PuntosPerdidos =0;
        this.CantBarajas =0;
        this.CantManos =0;
        this.MinimoPuntos =0;
        this.Acumulado =0;
    }

    public Parametro() {
        this.initialize();
    }

    public Parametro(Parametro Param){
        this.NombreJugador =Param.NombreJugador;
        this.PuntosGanados =Param.PuntosGanados;
        this.PuntosPerdidos =Param.PuntosPerdidos;
        this.CantBarajas =Param.CantBarajas;
        this.CantManos =Param.CantManos;
        this.MinimoPuntos =Param.MinimoPuntos;
        this.Acumulado =Param.Acumulado;
    }


}
