package com.cenfotec.proyectofinal.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.cenfotec.proyectofinal.blackjack.adapter.BarajaAdapter;
import com.cenfotec.proyectofinal.blackjack.model.Jugador;
import com.cenfotec.proyectofinal.blackjack.model.Repartidor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtUsuarioNombre, txtComputadoraNombre, txtUsuarioPuntos, txtComputadoraPuntos, txtTotalPuntos;
    ListView lvUsuario, lvComputadora;
    ImageView imgCartaNueva;
    Button btnConfigurar, btnReiniciar, btnCompartir;

    Repartidor repartidor;

    Jugador computadora;
    Jugador usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuarioNombre = (TextView)findViewById(R.id.txtUsuarioNombre);
        txtComputadoraNombre = (TextView)findViewById(R.id.txtComputadoraNombre);
        txtUsuarioPuntos = (TextView)findViewById(R.id.txtUsuarioPuntos);
        txtComputadoraPuntos = (TextView)findViewById(R.id.txtComputadoraPuntos);
        txtTotalPuntos = (TextView)findViewById(R.id.txtTotalPuntos);

        lvUsuario = (ListView)findViewById(R.id.lvUsuario);
        lvComputadora = (ListView)findViewById(R.id.lvComputadora);

        imgCartaNueva = (ImageView)findViewById(R.id.imgCartaNueva);

        btnConfigurar = (Button)findViewById(R.id.btnConfigurar);
        btnReiniciar = (Button)findViewById(R.id.btnReiniciar);
        btnCompartir = (Button)findViewById(R.id.btnCompartir);

        cargarParametros();

        iniciarJuego();
        iniciarPartida();
    }

    @Override
    public void onClick(View v) {
        Object obj = findViewById(v.getId());
        if (obj instanceof ImageView) {
            ImageView img = (ImageView) findViewById(v.getId());
            switch (img.getId()) {
                case R.id.imgCartaNueva:
                    nuevaCartaUsuario();
                    break;
                default:
                    break;
            }
        } else {
            Button btn = (Button) findViewById(v.getId());
            switch (btn.getId()) {
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
    }

    private void cargarParametros(){
        //TODO: Cargar parámetros con método de Humberto.
    }

    private void nuevaCartaUsuario(){
        agregarCartaUsuario();
        refrescarListas();
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

    private void iniciarJuego(){
        repartidor = new Repartidor(4); //TODO: Parametrizar cantidad de barajas.
    }

    private void iniciarPartida(){
        computadora = new Jugador();
        usuario = new Jugador();
        agregarCartaComputadora();
        agregarCartaUsuario();
        agregarCartaComputadora();
        agregarCartaUsuario();
        refrescarListas();
    }

    private void agregarCartaComputadora(){
        computadora.Baraja().agregarCartaBaraja(repartidor.Baraja().obtenerCartaBaraja(0));
        repartidor.Baraja().eliminarCartaBaraja(0);
    }

    private void agregarCartaUsuario(){
        usuario.Baraja().agregarCartaBaraja(repartidor.Baraja().obtenerCartaBaraja(0));
        repartidor.Baraja().eliminarCartaBaraja(0);
    }

    private void refrescarListas(){
//        computadora.Baraja().setMostrarPrimeraCarta(true); //TODO: Esto no va aquí.
//        usuario.Baraja().setMostrarPrimeraCarta(true); //TODO: Esto no va aquí.

        lvComputadora.setAdapter(new BarajaAdapter(this, computadora.Baraja()));
        lvUsuario.setAdapter(new BarajaAdapter(this, usuario.Baraja()));

        txtComputadoraPuntos.setText("" + computadora.Baraja().contarCartasBaraja());
        txtUsuarioPuntos.setText(""+usuario.Baraja().contarCartasBaraja());
    }

}
