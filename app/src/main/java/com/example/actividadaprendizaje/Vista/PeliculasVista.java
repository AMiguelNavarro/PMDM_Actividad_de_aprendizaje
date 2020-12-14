package com.example.actividadaprendizaje.Vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.actividadaprendizaje.Adaptador.PeliculasAdaptador;
import com.example.actividadaprendizaje.Beans.Peliculas;
import com.example.actividadaprendizaje.Contrato.PeliculasContrato;
import com.example.actividadaprendizaje.Presentador.PeliculasPresentador;
import com.example.actividadaprendizaje.R;

import java.util.ArrayList;

public class PeliculasVista extends AppCompatActivity implements PeliculasContrato.vista {

    private PeliculasPresentador peliculasPresentador;
    private RecyclerView recycler;
    private RecyclerView.LayoutManager gestorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas_vista_recycler);

        peliculasPresentador = new PeliculasPresentador(this);
        peliculasPresentador.getPeliculas();
    }


    @Override
    public void success(ArrayList<Peliculas> listaPeliculas) {
        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        gestorLayout = new GridLayoutManager(this, 3);

        recycler.setLayoutManager(gestorLayout);

        // Crear un nuevo adaptador, que es el pintado para el usuario
        PeliculasAdaptador adaptador = new PeliculasAdaptador(listaPeliculas);
        recycler.setAdapter(adaptador);

    }

    @Override
    public void error(String mensajeError) {
        Toast.makeText(this, mensajeError, Toast.LENGTH_SHORT).show();
    }


}





