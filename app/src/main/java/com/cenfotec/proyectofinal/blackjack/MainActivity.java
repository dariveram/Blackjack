package com.cenfotec.proyectofinal.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.cenfotec.proyectofinal.blackjack.model.Carta;
import com.cenfotec.proyectofinal.blackjack.model.Jugador;
import com.cenfotec.proyectofinal.blackjack.model.Repartidor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtJug1Nombre, txtJug2Nombre, txtJug1Puntos, txtJug2Puntos, txtTotalPuntos;
    ListView lvJug1, lvJug2;
    ImageView imgCartaNueva;
    Button btnConfigurar, btnReiniciar, btnCompartir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtJug1Nombre = (TextView)findViewById(R.id.txtJug1Nombre);
        txtJug2Nombre = (TextView)findViewById(R.id.txtJug2Nombre);
        txtJug1Puntos = (TextView)findViewById(R.id.txtJug1Puntos);
        txtJug2Puntos = (TextView)findViewById(R.id.txtJug2Puntos);
        txtTotalPuntos = (TextView)findViewById(R.id.txtTotalPuntos);

        lvJug1 = (ListView)findViewById(R.id.lvJug1);
        lvJug2 = (ListView)findViewById(R.id.lvJug2);

        imgCartaNueva = (ImageView)findViewById(R.id.imgCartaNueva);

        btnConfigurar = (Button)findViewById(R.id.btnConfigurar);
        btnReiniciar = (Button)findViewById(R.id.btnReiniciar);
        btnCompartir = (Button)findViewById(R.id.btnCompartir);


        ////////////////////////////////////////////////////////////////////////////////////////////
        Repartidor r = new Repartidor(4);
        r.Baraja().contarCartasBaraja();

        for (Carta c:r.Baraja().obtenerBaraja()){
            String s = c.getTipo() + "|" + c.getNombre() + "|" + c.getValor() + "|" + c.getImagen();
            Log.d("baraja", s);
        }

        Jugador j = new Jugador();
        int t = j.Baraja().contarCartasBaraja();
        Log.d("baraja", Integer.toString(t));

        // prueba check-in humberto...
        // prueba check-in david...
        ////////////////////////////////////////////////////////////////////////////////////////////

    }

    @Override
    public void onClick(View v) {
        Button btn = (Button)findViewById(v.getId());

        switch (btn.getId()) {

            case R.id.imgCartaNueva:
                cartaNueva();
                break;

            case R.id.btnConfigurar:
                configurar(v);
                break;

            case R.id.btnReiniciar:
                reiniciar(v);
                break;

            case R.id.btnCompartir:
                compartir(v);
                break;

            default:
                break;
        }
    }

    private void cartaNueva(){
        //TODO:Lógica de nueva carta.
    }

    private void configurar(View v){
        Intent intent = new Intent(v.getContext(), SettingsActivity.class);
        startActivity(intent);
    }

    private void reiniciar(View v){
        Intent intent = new Intent(v.getContext(), ResetActivity.class);
        startActivity(intent);
    }

    private void compartir(View v){
        Intent intent = new Intent(v.getContext(), ShareActivity.class);
        startActivity(intent);
    }

}
