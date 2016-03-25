package com.cenfotec.proyectofinal.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cenfotec.proyectofinal.blackjack.model.Carta;
import com.cenfotec.proyectofinal.blackjack.model.Jugador;
import com.cenfotec.proyectofinal.blackjack.model.Repartidor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Repartidor r = new Repartidor(4);
        r.Baraja().contarCartasBaraja();

        for (Carta c:r.Baraja().obtenerBaraja()){
            String s = c.getTipo() + "|" + c.getNombre() + "|" + c.getValor() + "|" + c.getImagen();
            Log.d("baraja", s);
        }

        Jugador j = new Jugador();
        int t = j.Baraja().contarCartasBaraja();
        Log.d("baraja", Integer.toString(t));

    }
}
