package com.example.actividadaprendizaje.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.actividadaprendizaje.R;
import com.squareup.picasso.Picasso;

public class PeliculaFichaDescriptivaVista extends AppCompatActivity {

    private ImageView imagen;
    private TextView sinopsis, titulo, valoracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_pelicula_ficha);

        initComponents();

        Intent navegar = getIntent();
        String image = navegar.getStringExtra("imagen");
        String tit = navegar.getStringExtra("titulo");
        String sinop = navegar.getStringExtra("sinopsis");
        String val = navegar.getStringExtra("valoracion");

        titulo.setText(tit);
        sinopsis.setText(sinop);
        valoracion.setText(val + "★");
        String urlBaseImagenes = "https://image.tmdb.org/t/p/w500";
        Picasso.get().load(urlBaseImagenes + image).into(imagen);

    }


    public void initComponents() {
        imagen = findViewById(R.id.imagen);
        sinopsis = findViewById(R.id.sinopsis);
        titulo = findViewById(R.id.titulo);
        valoracion = findViewById(R.id.valoracion);
    }
}