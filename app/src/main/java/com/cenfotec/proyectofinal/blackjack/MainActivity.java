package com.cenfotec.proyectofinal.blackjack;

import com.cenfotec.proyectofinal.blackjack.model.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Baraja baraja1 = new Baraja();
        Baraja baraja2 = new Baraja();
        Baraja baraja3 = new Baraja();
        Baraja baraja4 = new Baraja();

        Baraja baraja = new Baraja(new ArrayList<Carta>());

        for(int i=0; i<baraja1.getBaraja().size(); i++){
            baraja.agregarCartaBaraja(baraja1.obtenerCartaBaraja(i));
            baraja.agregarCartaBaraja(baraja2.obtenerCartaBaraja(i));
            baraja.agregarCartaBaraja(baraja3.obtenerCartaBaraja(i));
            baraja.agregarCartaBaraja(baraja4.obtenerCartaBaraja(i));
        }

        baraja.revolverBaraja();
        baraja.contarCartasBaraja();

        Log.d("", "baraja");

    }
}
