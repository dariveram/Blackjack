package com.cenfotec.proyectofinal.blackjack;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cenfotec.proyectofinal.blackjack.model.Parametro;

import java.io.IOException;
import java.io.OutputStreamWriter;


public class ResetActivity extends AppCompatActivity implements View.OnClickListener {

    Parametro parametro;

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
                //
                try {
                    Reiniciar();

                } catch (Exception e) {
                    Log.d("BLACKJACK", e.toString());
                    e.printStackTrace();
                }
                break;

            case R.id.btnNO:
                try {
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }

    }

    public void Reiniciar() {
        parametro=new Parametro();
        Toast t = Toast.makeText(this, "Parámetros borrados",
        Toast.LENGTH_SHORT);
        t.show();
        finish();
    }
}
