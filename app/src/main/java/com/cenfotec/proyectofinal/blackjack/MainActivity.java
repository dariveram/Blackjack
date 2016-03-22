package com.cenfotec.proyectofinal.blackjack;

import com.cenfotec.proyectofinal.blackjack.model.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Baraja baraja1 = new Baraja();
        Baraja baraja2 = new Baraja();
        Baraja baraja3 = new Baraja();

        Log.d("", "baraja");

    }
}
