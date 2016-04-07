package com.cenfotec.proyectofinal.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cenfotec.proyectofinal.blackjack.model.Parametro;
import io.fabric.sdk.android.Fabric;

import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.models.User;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

public class ShareActivity extends AppCompatActivity implements View.OnClickListener {
    private static String ID_FB="510565259148680";
    Parametro parametro;
    private TwitterLoginButton loginButton;
    TwitterSession session;
    ImageView user_picture;
    String screenname,username,twitterImage,location,timeZone,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parametro p = new Parametro();
        if (p.leer(getApplicationContext())){
            TwitterAuthConfig authConfig = new TwitterAuthConfig(p.getTwitterUsuario(), p.getTwitterClave());
            Fabric.with(this, new Twitter(authConfig));
            setContentView(R.layout.activity_share);
            loginButton = (TwitterLoginButton) findViewById(R.id.login_button);
            loginButton.setCallback(new Callback<TwitterSession>() {
                @Override
                public void success(Result<TwitterSession> result) {
                    session = Twitter.getSessionManager().getActiveSession();
                    Twitter.getApiClient(session).getAccountService()
                            .verifyCredentials(true, false, new Callback<User>() {
                                @Override
                                public void success(Result<User> userResult) {
                                    User user = userResult.data;
                                    Parametro p = new Parametro();
                                    if (p.leer(getApplicationContext())) {

                                        twitterImage = user.profileImageUrl;
                                        screenname = user.screenName;
                                        username = p.getTwitterUsuario();
                                        location = user.location;
                                        timeZone = user.timeZone;
                                        description = user.description;
                                    }
                                    user_picture = (ImageView) findViewById(R.id.ivTwitterImageChoose);
                                    Picasso.with(getApplicationContext()).load(twitterImage.toString())
                                            .into(user_picture);
                                }
                                @Override
                                public void failure(TwitterException e) {
                                }
                            });
                    loginButton.setVisibility(View.GONE);
                }
                @Override
                public void failure(TwitterException exception) {
                    Log.d("TwitterKit", "Login with Twitter failure", exception);
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Make sure that the loginButton hears the result from any
        // Activity that it triggered.
        loginButton.onActivityResult(requestCode, resultCode, data);
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
                    e.printStackTrace();
                }
                break;
            case R.id.login_button:
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
        Parametro p = new Parametro();
        if (p.leer(getApplicationContext())){
            TwitterAuthConfig authConfig =  new TwitterAuthConfig(p.getTwitterUsuario(), p.getTwitterClave());
            Fabric.with(this, new TwitterCore(authConfig), new TweetComposer());
            TweetComposer.Builder builder = new TweetComposer.Builder(this)
                    .text("Hola! He ganado un total de " + p.getUsuarioTotalPuntos() + " puntos en Blackjack!");
            builder.show();
        }
    }
}
