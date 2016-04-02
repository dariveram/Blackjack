package com.cenfotec.proyectofinal.blackjack.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.cenfotec.proyectofinal.blackjack.R;
import com.cenfotec.proyectofinal.blackjack.model.Baraja;

import java.lang.reflect.Field;

/**
 * Created by drivera on 2016-04-02.
 */
public class BarajaAdapter extends BaseAdapter{
    Context context;
    Baraja data;

    private static LayoutInflater inflater = null;

    public BarajaAdapter(Context context, Baraja data) {
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.obtenerTamanoBaraja();
    }

    @Override
    public Object getItem(int i) {
        return data.obtenerCartaBaraja(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View currentView = view;
        if (currentView == null){
            currentView = inflater.inflate(R.layout.row, null);
        }
        ImageView imgCarta = (ImageView) currentView.findViewById(R.id.imgCarta);
        int resId;
        if (i==0){
            if (data.isMostrarPrimeraCarta()){
                resId = getResId(data.obtenerCartaBaraja(i).getImagen());
            }else{
                resId = R.drawable.back;
            }
        }else{
            resId = getResId(data.obtenerCartaBaraja(i).getImagen());
        }
        imgCarta.setImageResource(resId);
        return currentView;
    }

    public static int getResId(String resName) {
        try {
            Class res = R.drawable.class;
            Field field = res.getField(resName);
            int drawableId = field.getInt(null);
            return drawableId;
        } catch (Exception e) {
            return R.drawable.desconocido;
        }
    }

}
