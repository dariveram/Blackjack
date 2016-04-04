package com.cenfotec.proyectofinal.blackjack;

import android.app.Activity;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cenfotec.proyectofinal.blackjack.model.Parametro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    String NombreArchivo = "BlackJackSett.txt";
    String Texto = "Prueba";
    String Sep = "|";

    EditText NombreJugador;
    EditText PuntosGanada;
    EditText PuntosPerdida;
    EditText CantBarajas;
    EditText ManosBaraja;
    EditText MinimoPuntos;

    Parametro parametro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        NombreJugador = (EditText) findViewById(R.id.txtNombreJugador);
        PuntosGanada = (EditText) findViewById(R.id.txtPuntosGanados);
        PuntosPerdida = (EditText) findViewById(R.id.txtPuntosPerdidos);
        CantBarajas = (EditText) findViewById(R.id.txtBarajas);
        ManosBaraja = (EditText) findViewById(R.id.txtManos);
        MinimoPuntos = (EditText) findViewById(R.id.txtMinimo);

    }

    @Override
    public void onClick(View view){
        Button btn = (Button) findViewById(view.getId());
        switch (btn.getId()) {

            case R.id.btnGuardar:
                //
                try {
                    Guardar();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.btnCargar:

                try {
                    Cargar();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }

    };

    private boolean existe(String[] archivos, String archbusca) {
        for (int f = 0; f < archivos.length; f++)
            if (archbusca.equals(archivos[f]))
                return true;
        return false;
    }

    public void Cargar() throws IOException {
        //etRes = (EditText) findViewById(R.id.etRes);
        String[] archivos = fileList();
        if (existe(archivos, NombreArchivo))
            try {
                InputStreamReader archivo = new InputStreamReader(
                        openFileInput(NombreArchivo));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String todo = "";
                while (linea != null) {
                    todo = todo + linea;
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                StringTokenizer tokens = new StringTokenizer(todo, Sep);//todo.split(Sep);
                //StringTokenizer tokens;
                NombreJugador.setText(tokens.nextToken());
                PuntosGanada.setText(tokens.nextToken());
                PuntosPerdida.setText(tokens.nextToken());
                CantBarajas.setText(tokens.nextToken());
                ManosBaraja.setText(tokens.nextToken());
                MinimoPuntos.setText(tokens.nextToken());
                //etRes.setText(todo);
            } catch (IOException e) {
            }
    }
    public void Guardar() throws IOException {
        try {

            parametro.initialize();

            parametro.NombreJugador=NombreJugador.toString();
            parametro.PuntosGanados= Integer.parseInt(PuntosGanada.toString());
            parametro.PuntosPerdidos= Integer.parseInt(PuntosPerdida.toString());
            parametro.CantBarajas= Integer.parseInt(CantBarajas.toString());
            parametro.CantManos= Integer.parseInt(ManosBaraja.toString());
            parametro.MinimoPuntos= Integer.parseInt(MinimoPuntos.toString());

            Texto = NombreJugador.getText().toString() + Sep +
                    PuntosGanada.getText().toString() + Sep +
                    PuntosPerdida.getText().toString() + Sep +
                    ManosBaraja.getText().toString() + Sep +
                    MinimoPuntos.getText().toString();
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(
                    NombreArchivo, Activity.MODE_PRIVATE));
            archivo.write(Texto);
            NombreJugador.setText("");
            PuntosGanada.setText("");
            PuntosPerdida.setText("");
            ManosBaraja.setText("");
            MinimoPuntos.setText("");
            archivo.flush();
            archivo.close();
        } catch (IOException e) {
        }
        Toast t = Toast.makeText(this, "Los datos fueron grabados",
                Toast.LENGTH_SHORT);
        t.show();
    }
}
