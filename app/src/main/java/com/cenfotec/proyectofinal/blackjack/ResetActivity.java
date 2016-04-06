package com.cenfotec.proyectofinal.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cenfotec.proyectofinal.blackjack.model.Parametro;

public class ResetActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
    }

    @Override
    public void onClick(View view){
        Button btn = (Button) findViewById(view.getId());
        switch (btn.getId()) {
            case R.id.btnSI:
                borrar();
                break;
            case R.id.btnNO:
                finish();
                break;
            default:
                break;
        }
    }

    public void borrar() {
        Parametro p = new Parametro();
        if (p.borrar(getApplicationContext())){
            Toast.makeText(getApplicationContext(), "Parámetros borrados", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(getApplicationContext(), "Error al borrar parámetros", Toast.LENGTH_SHORT).show();
        }
    }

}
