package com.example.actividadaprendizaje.Adaptador;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.actividadaprendizaje.Beans.Peliculas;
import com.example.actividadaprendizaje.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PeliculasAdaptador extends RecyclerView.Adapter<PeliculasAdaptador.PeliculasVistaHolder> {

    private ArrayList<Peliculas> listaPeliculas;


    // Debe recibir 3 elementos: Lista de peliculas, ,
    public PeliculasAdaptador(ArrayList<Peliculas> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    @NonNull
    @Override
    // Crea el diseño por fila (Recibe el espacio donde pintar)
    public PeliculasVistaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.vista_peliculas_vista_row, parent, false);
        return new PeliculasVistaHolder(v);
    }

    // Pinta los datos en una posicion
    @Override
    public void onBindViewHolder(@NonNull PeliculasVistaHolder holder, int position) {
        Peliculas pelicula = listaPeliculas.get(position);

        String urlBaseImagenes = "https://image.tmdb.org/t/p/w500";
        Picasso.get().load(urlBaseImagenes + pelicula.getImage()).into(holder.imagen);
        holder.titulo.setText(pelicula.getTitulo());
        holder.valoracion.setText(pelicula.getVote_average() + "★");
    }

    @Override
    public int getItemCount() {
        return listaPeliculas.size();
    }




    // Obliga a definir el ViewHolder (estático para usarlo desde cualquier sitio)
    public static class PeliculasVistaHolder extends RecyclerView.ViewHolder {

        //Tantos elementos como objetos quiera mostrar en la fila
        //Aquí se deben poner los elementos que van a ser alterados por cada elemento de la lista
        public ImageView imagen;
        public TextView titulo, valoracion;

        public PeliculasVistaHolder(View v) {
            super(v);
            imagen = v.findViewById(R.id.imagen);
            titulo = v.findViewById(R.id.titulo);
            valoracion = v.findViewById(R.id.valoracion);
        }

    }

}
