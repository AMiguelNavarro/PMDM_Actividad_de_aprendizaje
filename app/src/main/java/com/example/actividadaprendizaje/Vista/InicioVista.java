package com.example.actividadaprendizaje.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.actividadaprendizaje.R;

public class InicioVista extends AppCompatActivity {

    private static final int SCREEN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lanzar proceso en 2º plano, a los 5 segundos cambia de pantalla
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            // Cargar la segunda pantalla
            Intent navegar = new Intent(getBaseContext(), PeliculasVista.class);
            //Lanzar el intent
            startActivity(navegar);
        },5000);
    }
}