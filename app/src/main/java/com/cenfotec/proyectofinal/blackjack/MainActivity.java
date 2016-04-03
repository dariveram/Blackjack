package com.cenfotec.proyectofinal.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cenfotec.proyectofinal.blackjack.adapter.BarajaAdapter;
import com.cenfotec.proyectofinal.blackjack.model.Jugador;
import com.cenfotec.proyectofinal.blackjack.model.Repartidor;
import com.cenfotec.proyectofinal.blackjack.model.enumeration.CartaValor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static int _CantidadBarajas = 3;
    private final static int _CantidadPartidasBarajar = 10;
    private final static int _MinimoPuntosComputadora = 16;

    private final static int _PuntosGana = 21;
    private int contPartidas;

    TextView txtUsuarioNombre, txtComputadoraNombre, txtUsuarioPuntos, txtComputadoraPuntos, txtTotalPuntos, txtPartidasJugadas, txtCartasRestantes;
    ListView lvUsuario, lvComputadora;
    ImageView imgCartaNueva;
    Button btnJugar, btnConfigurar, btnReiniciar, btnCompartir;

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
        txtPartidasJugadas = (TextView)findViewById(R.id.txtPartidasJugadas);
        txtCartasRestantes = (TextView)findViewById(R.id.txtCartasRestantes);

        lvUsuario = (ListView)findViewById(R.id.lvUsuario);
        lvComputadora = (ListView)findViewById(R.id.lvComputadora);

        imgCartaNueva = (ImageView)findViewById(R.id.imgCartaNueva);

        btnJugar = (Button)findViewById(R.id.btnJugar);
        btnConfigurar = (Button)findViewById(R.id.btnConfigurar);
        btnReiniciar = (Button)findViewById(R.id.btnReiniciar);
        btnCompartir = (Button)findViewById(R.id.btnCompartir);

        contPartidas = 0;

        cargarParametros();
        iniciarJuego();
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
                case R.id.btnJugar:
                    jugar();
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
    }

    private void cargarParametros(){
        //TODO: Cargar parámetros con método de Humberto.
    }

    private void jugar(){
        if (btnJugar.getText().toString().trim().toLowerCase().equals("jugar")){
            //Usuario inicia juego.
            btnJugar.setText("Listo");
            contPartidas += 1;
            if (contPartidas > _CantidadPartidasBarajar){
                iniciarJuego();
                contPartidas = 1;
            }
            iniciarPartida();
            txtPartidasJugadas.setText(String.valueOf(contPartidas));
        }else{
            //Usuario finaliza juego.
            btnJugar.setText("Jugar");
            //Juega la computadora.
            jugarComputadora();
        }
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
        repartidor = new Repartidor(_CantidadBarajas);
        txtCartasRestantes.setText(String.valueOf(repartidor.Baraja().obtenerTamanoBaraja()));
        Toast.makeText(getApplicationContext(), "Nueva Baraja", Toast.LENGTH_SHORT).show();
    }

    private void iniciarPartida(){
        computadora = new Jugador();
        usuario = new Jugador();

        agregarCarta("Computadora");
        agregarCarta("Usuario");
        agregarCarta("Computadora");
        agregarCarta("Usuario");

        verificaValorAs();
        refrescarListas();
    }

    private void verificaValorAs(){
        //Control de valor As:
        //      El As toma valor de 1 solamente cuando las 2 primeras cartas son As.
        //      En dada situación, la 1er carta toma valor de 1.
        CartaValor valorAs = CartaValor.ONCE;
        if ((computadora.Baraja().obtenerCartaBaraja(0).getValor() == valorAs) && (computadora.Baraja().obtenerCartaBaraja(1).getValor() == valorAs)){
            computadora.Baraja().obtenerCartaBaraja(0).setValor(CartaValor.UNO);
        }
        if ((usuario.Baraja().obtenerCartaBaraja(0).getValor() == valorAs) && (usuario.Baraja().obtenerCartaBaraja(1).getValor() == valorAs)){
            usuario.Baraja().obtenerCartaBaraja(0).setValor(CartaValor.UNO);
        }
    }

    private void nuevaCartaUsuario(){
        if (!btnJugar.getText().toString().trim().toLowerCase().equals("jugar")){
            agregarCarta("Usuario");
            refrescarListas();
            if (usuario.Baraja().contarCartasBaraja()>_PuntosGana){
                asignarGanador();
            }
        }
    }

    private void nuevaCartaComputadora(){
        agregarCarta("Computadora");
        refrescarListas();
    }

    private void jugarComputadora(){
        boolean nuevaCartaComputadora = false;
        do {
            int puntosComputadora = computadora.Baraja().contarCartasBaraja();
            int puntosUsuario = usuario.Baraja().contarCartasBaraja();
            nuevaCartaComputadora = ((puntosComputadora<_MinimoPuntosComputadora) || (puntosComputadora<puntosUsuario)) && (puntosComputadora<_PuntosGana) && !(puntosUsuario>_PuntosGana);
            if (nuevaCartaComputadora){
                nuevaCartaComputadora();
            }
        } while (nuevaCartaComputadora);
        asignarGanador();
    }

    private void asignarGanador(){
        String ganador = "";

        int puntosComputadora = computadora.Baraja().contarCartasBaraja();
        int puntosUsuario = usuario.Baraja().contarCartasBaraja();

        if ((puntosComputadora>_PuntosGana) && (puntosUsuario>_PuntosGana)){
            //Los 2 perdieron.
            ganador = "Empate x Perdida";
        }else{
            if (puntosComputadora>_PuntosGana){
                ganador = "Usuario";
            }else if (puntosUsuario > _PuntosGana){
                ganador = "Computadora";
            }else{
                if (puntosComputadora<puntosUsuario){
                    ganador = "Usuario";
                }else{
                    ganador = "Computadora";
                }
            }
        }

        if (!ganador.equals("")){
            computadora.Baraja().setMostrarPrimeraCarta(true);
            usuario.Baraja().setMostrarPrimeraCarta(true);
            refrescarListas();
            Toast.makeText(getApplicationContext(), "Ganador: " + ganador, Toast.LENGTH_SHORT).show();
            asignarPuntosGanador(ganador);
            btnJugar.setText("Jugar");
        }
    }

    private void asignarPuntosGanador(String ganador){
        switch (ganador.trim().toLowerCase()) {
            case "usuario":
                //TODO
                break;
            case "computadora":
                //TODO
                break;
            default:
                break;
        }
    }

    private void agregarCarta(String j){
        if (j.trim().toLowerCase().equals("usuario")){
            usuario.Baraja().agregarCartaBaraja(repartidor.Baraja().obtenerCartaBaraja(0));
        }else{
            computadora.Baraja().agregarCartaBaraja(repartidor.Baraja().obtenerCartaBaraja(0));
        }
        repartidor.Baraja().eliminarCartaBaraja(0);
        txtCartasRestantes.setText(String.valueOf(repartidor.Baraja().obtenerTamanoBaraja()));
    }

    private void refrescarListas(){
        lvComputadora.setAdapter(new BarajaAdapter(this, computadora.Baraja()));
        lvUsuario.setAdapter(new BarajaAdapter(this, usuario.Baraja()));
        txtComputadoraPuntos.setText(String.valueOf(computadora.Baraja().contarCartasBaraja()));
        txtUsuarioPuntos.setText(String.valueOf(usuario.Baraja().contarCartasBaraja()));
    }

}
