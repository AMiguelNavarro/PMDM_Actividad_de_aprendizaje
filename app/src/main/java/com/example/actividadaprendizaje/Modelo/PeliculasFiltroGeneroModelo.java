package com.example.actividadaprendizaje.Modelo;

import android.os.AsyncTask;

import com.example.actividadaprendizaje.Beans.Peliculas;
import com.example.actividadaprendizaje.Contrato.PeliculasFiltroGeneroContrato;
import com.example.actividadaprendizaje.Utilidades.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PeliculasFiltroGeneroModelo implements PeliculasFiltroGeneroContrato.modelo {

    private String URL = "https://api.themoviedb.org/3/discover/movie?api_key=9452cdfc55151f2eef8682f0e78f4a77&language=es-ES&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_genres="; // Añadir idGenero al final
    private ArrayList<Peliculas> listaPeliculasFiltroGenero;
    private OnPeliculasFiltroGeneroListener onPeliculasFiltroGeneroListener;
    private String idGenero;

    @Override
    public void getPeliculasFiltroGeneroWS(OnPeliculasFiltroGeneroListener onPeliculasFiltroGeneroListener, String idGenero) {
        this.onPeliculasFiltroGeneroListener = onPeliculasFiltroGeneroListener;
        this.idGenero = idGenero;
        URL += idGenero;
        //TODO lanzar hilo
        TareaSegundoPlanoFiltroGenero hilo = new TareaSegundoPlanoFiltroGenero();
        hilo.execute();
    }


    class TareaSegundoPlanoFiltroGenero extends AsyncTask<String, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {

            Post post = new Post();

            try {
                // Devuelve el objeto JSON
                JSONObject listaObjetosPeliculasJSON = post.getServerDataGetObject(URL);
                JSONArray listaPeliculasArraysJSON = listaObjetosPeliculasJSON.getJSONArray("results");
                listaPeliculasFiltroGenero = Peliculas.getArrayListFromJSON(listaPeliculasArraysJSON);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            // Devolver si ha ido bien o mal
            return true;
        }


        @Override
        protected void onPostExecute(Boolean respuesta) {

            if (respuesta) {
                if (listaPeliculasFiltroGenero != null && listaPeliculasFiltroGenero.size() > 0) {
                    onPeliculasFiltroGeneroListener.onResolve(listaPeliculasFiltroGenero);
                } else {
                    onPeliculasFiltroGeneroListener.onReject("No hay ninguna película de este género");
                }
            }

        }
    }


}
