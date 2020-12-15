package com.example.actividadaprendizaje.Vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.actividadaprendizaje.R;

public class PeliculasFiltradasGeneroVista extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.LayoutManager gestorLayout;

    private Spinner spinner;
    private String [] opcionesSpinner = {"Acción", "Aventura","Animación", "Comedia","Crimen", "Documental","Drama", "Familia","Fantasía", "Historia","Terror", "Música","Misterio", "Romance",
            "Ciencia Ficción", "Película de TV","Suspense", "Bélica","Western"};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas_filtradas_genero_vista_recycler);

        Intent navegar = getIntent();
        String idGender = navegar.getStringExtra("idGenero");

    }
}

