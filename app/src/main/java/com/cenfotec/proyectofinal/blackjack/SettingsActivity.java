package com.cenfotec.proyectofinal.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cenfotec.proyectofinal.blackjack.model.Parametro;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtUsuarioNombre
            , txtComputadoraNombre
            , txtUsuarioTotalPuntos
            , txtComputadoraTotalPuntos
            , txtCantidadBarajas
            , txtCantidadPartidasBarajar
            , txtMinimoPuntosComputadora
            , txtPuntosPartidaGanada
            , txtPuntosPartidaPerdida
            , txtTwitterUsuario
            , txtTwitterClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        txtUsuarioNombre = (EditText)findViewById(R.id.txtusuarioNombre);
        txtComputadoraNombre = (EditText)findViewById(R.id.txtcomputadoraNombre);
        txtUsuarioTotalPuntos = (EditText)findViewById(R.id.txtUsuarioTotalPuntos);
        txtComputadoraTotalPuntos = (EditText)findViewById(R.id.txtComputadoraTotalPuntos);
        txtCantidadBarajas = (EditText)findViewById(R.id.txtCantidadBarajas);
        txtCantidadPartidasBarajar = (EditText)findViewById(R.id.txtCantidadPartidasBarajar);
        txtMinimoPuntosComputadora = (EditText)findViewById(R.id.txtMinimoPuntosComputadora);
        txtPuntosPartidaGanada = (EditText)findViewById(R.id.txtPuntosPartidaGanada);
        txtPuntosPartidaPerdida = (EditText)findViewById(R.id.txtPuntosPartidaPerdida);
        txtTwitterUsuario = (EditText)findViewById(R.id.txtTwitterUsuario);
        txtTwitterClave = (EditText)findViewById(R.id.txtTwitterClave);
        cargar();
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) findViewById(v.getId());
        switch (btn.getId()) {
            case R.id.btnGuardar:
                guardar();
                break;
            default:
                break;
        }
    }

    private void guardar(){
        if (validar()){
            Parametro p = new Parametro();
            p.setUsuarioNombre(txtUsuarioNombre.getText().toString());
            p.setComputadoraNombre(txtComputadoraNombre.getText().toString());
            p.setUsuarioTotalPuntos(Integer.valueOf(txtUsuarioTotalPuntos.getText().toString()));
            p.setComputadoraTotalPuntos(Integer.valueOf(txtComputadoraTotalPuntos.getText().toString()));
            p.setCantidadBarajas(Integer.valueOf(txtCantidadBarajas.getText().toString()));
            p.setCantidadPartidasBarajar(Integer.valueOf(txtCantidadPartidasBarajar.getText().toString()));
            p.setMinimoPuntosComputadora(Integer.valueOf(txtMinimoPuntosComputadora.getText().toString()));
            p.setPuntosPartidaGanada(Integer.valueOf(txtPuntosPartidaGanada.getText().toString()));
            p.setPuntosPartidaPerdida(Integer.valueOf(txtPuntosPartidaPerdida.getText().toString()));
            p.setTwitterUsuario(txtTwitterUsuario.getText().toString());
            p.setTwitterClave(txtTwitterClave.getText().toString());
            if (p.guardar(getApplicationContext())){
                Toast.makeText(getApplicationContext(), "Parámetros guardados", Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(getApplicationContext(), "Error al guardar parámetros", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void cargar(){
        txtUsuarioTotalPuntos.setText("0");
        txtComputadoraTotalPuntos.setText("0");
        Parametro p = new Parametro();
        if (p.leer(getApplicationContext())){
            txtUsuarioNombre.setText(p.getUsuarioNombre());
            txtComputadoraNombre.setText(p.getComputadoraNombre());
            txtUsuarioTotalPuntos.setText(String.valueOf(p.getUsuarioTotalPuntos()));
            txtComputadoraTotalPuntos.setText(String.valueOf(p.getComputadoraTotalPuntos()));
            txtCantidadBarajas.setText(String.valueOf(p.getCantidadBarajas()));
            txtCantidadPartidasBarajar.setText(String.valueOf(p.getCantidadPartidasBarajar()));
            txtMinimoPuntosComputadora.setText(String.valueOf(p.getMinimoPuntosComputadora()));
            txtPuntosPartidaGanada.setText(String.valueOf(p.getPuntosPartidaGanada()));
            txtPuntosPartidaPerdida.setText(String.valueOf(p.getPuntosPartidaPerdida()));
            txtTwitterUsuario.setText(p.getTwitterUsuario());
            txtTwitterClave.setText(p.getTwitterClave());
        }
    }

    private boolean validar(){
        if (txtUsuarioNombre.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "El nombre de usuario no puede estar vacío", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (txtComputadoraNombre.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "El nombre de la computadora no puede estar vacío", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (txtCantidadBarajas.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "La cantidad de barajas no puede estar vacío", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (Integer.valueOf(txtCantidadBarajas.getText().toString()) <= 0) {
            Toast.makeText(getApplicationContext(), "La cantidad de barajas debe ser mayor a cero", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (txtCantidadPartidasBarajar.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "La cantidad de partidas para barajar no puede estar vacío", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (Integer.valueOf(txtCantidadPartidasBarajar.getText().toString()) <= 0) {
            Toast.makeText(getApplicationContext(), "La cantidad de partidas para barajar debe ser mayor a cero", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (txtPuntosPartidaGanada.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "La cantidad de puntos por partida ganada no puede estar vacío", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (Integer.valueOf(txtPuntosPartidaGanada.getText().toString()) <= 0) {
            Toast.makeText(getApplicationContext(), "La cantidad de puntos por partida ganada debe ser mayor a cero", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (txtPuntosPartidaPerdida.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "La cantidad de puntos por partida perdida no puede estar vacío", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (Integer.valueOf(txtPuntosPartidaPerdida.getText().toString()) <= 0) {
            Toast.makeText(getApplicationContext(), "La cantidad de puntos por partida perdida debe ser mayor a cero", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (txtTwitterUsuario.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "El usuario Twitter no puede estar vacío", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (txtTwitterClave.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "El password Twitter no puede estar vacío", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
