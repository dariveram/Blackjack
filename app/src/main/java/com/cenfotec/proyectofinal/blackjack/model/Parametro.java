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


    private String nombreJugador;
    private int puntosGanados;
    private int puntosPerdidos;
    private int cantBarajas;
    private int cantManos;

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getPuntosGanados() {
        return puntosGanados;
    }

    public void setPuntosGanados(int puntosGanados) {
        this.puntosGanados = puntosGanados;
    }

    public int getPuntosPerdidos() {
        return puntosPerdidos;
    }

    public void setPuntosPerdidos(int puntosPerdidos) {
        this.puntosPerdidos = puntosPerdidos;
    }

    public int getCantBarajas() {
        return cantBarajas;
    }

    public void setCantBarajas(int cantBarajas) {
        this.cantBarajas = cantBarajas;
    }

    public int getCantManos() {
        return cantManos;
    }

    public void setCantManos(int cantManos) {
        this.cantManos = cantManos;
    }

    public int getMinimoPuntos() {
        return minimoPuntos;
    }

    public void setMinimoPuntos(int minimoPuntos) {
        this.minimoPuntos = minimoPuntos;
    }

    public int getAcumulado() {
        return acumulado;
    }

    public void setAcumulado(int acumulado) {
        this.acumulado = acumulado;
    }

    public int minimoPuntos;
    public int acumulado;

    public void initialize(){
        this.nombreJugador ="";
        this.puntosGanados =0;
        this.puntosPerdidos =0;
        this.cantBarajas =0;
        this.cantManos =0;
        this.minimoPuntos =0;
        this.acumulado =0;
    }

    public Parametro() {
        this.initialize();
    }

    public boolean Guardar(Parametro Param){

        try{
            this.nombreJugador =Param.nombreJugador;
            this.puntosGanados =Param.puntosGanados;
            this.puntosPerdidos =Param.puntosPerdidos;
            this.cantBarajas =Param.cantBarajas;
            this.cantManos =Param.cantManos;
            this.minimoPuntos =Param.minimoPuntos;
            this.acumulado =Param.acumulado;

            return true;

        }catch (Exception e){
            return false;
        }
    }


}
