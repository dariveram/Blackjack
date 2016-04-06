package com.cenfotec.proyectofinal.blackjack.model;

import android.content.Context;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/*import org.apache.commons.codec.binary.Base64;*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by drivera on 2016-04-05.
 */
public class Parametro {
    private static final String key = "Bar12345Bar12345"; // 128 bit key
    private static final String initVector = "RandomInitVector"; // 16 bytes IV

    private static final String nombreArchivo = "BlackJack.Config".toLowerCase();
    private static final String separador = "|";

    private String usuarioNombre;
    private String computadoraNombre;
    private int usuarioTotalPuntos;
    private int computadoraTotalPuntos;
    private int cantidadBarajas;
    private int cantidadPartidasBarajar;
    private int minimoPuntosComputadora;
    private int puntosPartidaGanada;
    private int puntosPartidaPerdida;
    private String twitterUsuario;
    private String twitterClave;

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getComputadoraNombre() {
        return computadoraNombre;
    }

    public void setComputadoraNombre(String computadoraNombre) {
        this.computadoraNombre = computadoraNombre;
    }

    public int getUsuarioTotalPuntos() {
        return usuarioTotalPuntos;
    }

    public void setUsuarioTotalPuntos(int usuarioTotalPuntos) {
        this.usuarioTotalPuntos = usuarioTotalPuntos;
    }

    public int getComputadoraTotalPuntos() {
        return computadoraTotalPuntos;
    }

    public void setComputadoraTotalPuntos(int computadoraTotalPuntos) {
        this.computadoraTotalPuntos = computadoraTotalPuntos;
    }

    public int getCantidadBarajas() {
        return cantidadBarajas;
    }

    public void setCantidadBarajas(int cantidadBarajas) {
        this.cantidadBarajas = cantidadBarajas;
    }

    public int getCantidadPartidasBarajar() {
        return cantidadPartidasBarajar;
    }

    public void setCantidadPartidasBarajar(int cantidadPartidasBarajar) {
        this.cantidadPartidasBarajar = cantidadPartidasBarajar;
    }

    public int getMinimoPuntosComputadora() {
        return minimoPuntosComputadora;
    }

    public void setMinimoPuntosComputadora(int minimoPuntosComputadora) {
        this.minimoPuntosComputadora = minimoPuntosComputadora;
    }

    public int getPuntosPartidaGanada() {
        return puntosPartidaGanada;
    }

    public void setPuntosPartidaGanada(int puntosPartidaGanada) {
        this.puntosPartidaGanada = puntosPartidaGanada;
    }

    public int getPuntosPartidaPerdida() {
        return puntosPartidaPerdida;
    }

    public void setPuntosPartidaPerdida(int puntosPartidaPerdida) {
        this.puntosPartidaPerdida = puntosPartidaPerdida;
    }

    public String getTwitterUsuario() {
        return twitterUsuario;
    }

    public void setTwitterUsuario(String twitterUsuario) {
        this.twitterUsuario = twitterUsuario;
    }

    public String getTwitterClave() {
        return twitterClave;
    }

    public void setTwitterClave(String twitterClave) {
        this.twitterClave = twitterClave;
    }

    public Parametro() {
        this.initialize();
    }

    public void initialize(){
        this.usuarioNombre = "";
        this.computadoraNombre = "";
        this.usuarioTotalPuntos = 0;
        this.computadoraTotalPuntos = 0;
        this.cantidadBarajas = 0;
        this.cantidadPartidasBarajar = 0;
        this.minimoPuntosComputadora = 0;
        this.puntosPartidaGanada = 0;
        this.puntosPartidaPerdida = 0;
        this.twitterUsuario = "";
        this.twitterClave = "";
    }

    public boolean guardar(Context ctx){
        String s = usuarioNombre
                + separador + computadoraNombre
                + separador + usuarioTotalPuntos
                + separador + computadoraTotalPuntos
                + separador + cantidadBarajas
                + separador + cantidadPartidasBarajar
                + separador + minimoPuntosComputadora
                + separador + puntosPartidaGanada
                + separador + puntosPartidaPerdida
                + separador + twitterUsuario
                + separador + twitterClave;
        return guardarArchivo(ctx, encriptar(s));
    }

    private boolean guardarArchivo(Context ctx, String s){
        try {
            FileOutputStream fOut = ctx.openFileOutput(nombreArchivo, Context.MODE_PRIVATE);
            fOut.write(s.getBytes());
            fOut.close();
            return true;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean leer(Context ctx){
        String a = leerArchivo(ctx);
        if (!a.trim().equals("")){
            String s = desencriptar(a);
            if (s != null){
                String[] d = s.trim().split("\\"+separador);
                this.usuarioNombre = d[0];
                this.computadoraNombre = d[1];
                this.usuarioTotalPuntos = Integer.valueOf(d[2]);
                this.computadoraTotalPuntos = Integer.valueOf(d[3]);
                this.cantidadBarajas = Integer.valueOf(d[4]);
                this.cantidadPartidasBarajar = Integer.valueOf(d[5]);
                this.minimoPuntosComputadora = Integer.valueOf(d[6]);
                this.puntosPartidaGanada = Integer.valueOf(d[7]);
                this.puntosPartidaPerdida = Integer.valueOf(d[8]);
                this.twitterUsuario = d[9];
                this.twitterClave = d[10];
                return true;
            }else {return false;}
        }else {return false;}
    }

    private String leerArchivo(Context ctx){
        try {
            FileInputStream fin = ctx.openFileInput(nombreArchivo);
            int c;
            String s = "";
            while( (c = fin.read()) != -1){
                s += Character.toString((char)c);
            }
            fin.close();
            return s;
        }catch(IOException e){
            e.printStackTrace();
            return "";
        }
    }

    public boolean borrar(Context ctx){
        ctx.deleteFile(nombreArchivo);
        return true;
    }

    private static String encriptar(String s) {
        return s;
//        try {
//            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
//            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
//
//            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
//            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
//
//            byte[] encrypted = cipher.doFinal(s.getBytes());
//
//            return Base64.encodeBase64String(encrypted);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//        }
    }

    private static String desencriptar(String s) {
        return s;
//        try {
//            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
//            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
//
//            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
//            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
//
//            byte[] original = cipher.doFinal(Base64.decodeBase64(s));
//
//            return new String(original);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//        }
    }

}
