package com.cenfotec.proyectofinal.blackjack;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



import com.cenfotec.proyectofinal.blackjack.model.Parametro;
import com.facebook.FacebookSdk;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;


public class ShareActivity extends AppCompatActivity implements View.OnClickListener {

    private static String ID_FB="510565259148680";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        FacebookSdk.sdkInitialize(getApplicationContext());
        /*try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.facebook.samples.hellofacebook",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }*/


    }

    @Override
    public void onClick(View view){
        Button btn = (Button) findViewById(view.getId());
        switch (btn.getId()) {

            case R.id.btnSI:
                //
                try {
                    Compartir();

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

    public void Compartir() {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "BLACKJACKD&H");
        startActivity(Intent.createChooser(intent, "Share with"));
    }
}
