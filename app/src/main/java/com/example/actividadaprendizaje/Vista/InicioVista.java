package com.example.actividadaprendizaje.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.actividadaprendizaje.R;

public class InicioVista extends AppCompatActivity {

    private static final int SCREEN = 1;

    // Url que muestra todos los campeones y la de filtrado
    private final String URL = "http://ddragon.leagueoflegends.com/cdn/10.24.1/data/en_US/champion.json";
    private final String URL_FILTRADO_POR_CAMPEON = "http://ddragon.leagueoflegends.com/cdn/10.24.1/data/en_US/champion/Aatrox.json";
    private final String URL_IMAGENES = "http://ddragon.leagueoflegends.com/cdn/10.24.1/img/champion/Aatrox.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lanzar proceso en 2º plano, a los 5 segundos cambia de pantalla
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            // Cargar la segunda pantalla
            Intent navegar = new Intent(getBaseContext(), AppVista.class);
            //Lanzar el intent
            startActivity(navegar);
        },5000);
    }
}