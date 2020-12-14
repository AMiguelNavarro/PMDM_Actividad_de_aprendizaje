package com.example.actividadaprendizaje.Modelo;

import android.os.AsyncTask;
import android.os.Handler;

import com.example.actividadaprendizaje.Beans.Peliculas;
import com.example.actividadaprendizaje.Contrato.PeliculasContrato;
import com.example.actividadaprendizaje.Utilidades.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class PeliculasModelo implements PeliculasContrato.modelo {


    private ArrayList<Peliculas> listaPeliculasArrayList;
    private OnPeliculasListener onPeliculasListener;

    private final String URL = "https://api.themoviedb.org/3/movie/popular?api_key=9452cdfc55151f2eef8682f0e78f4a77&language=es-ES&page=1";
//    private final String URL = "https://api.themoviedb.org/3/movie/popular?api_key=d9c4177bb1cc819d43088d25fbe2474c&language=en-US&page=1";
//            final String URL = "http://ddragon.leagueoflegends.com/cdn/10.24.1/data/en_US/champion.json"; // TODO probar con the API LOL si funciona

    @Override
    public void getPeliculasWS(OnPeliculasListener onPeliculasListener) {
        this.onPeliculasListener = onPeliculasListener;
        TareaEnSegundoPLano hilo = new TareaEnSegundoPLano();
        hilo.execute();
    }


    // Aquí va la cápsula que permite ir a la API, se pone un parámetro para cada parte del semaforo (rojo, amarillo y verde)
    class TareaEnSegundoPLano extends AsyncTask<String, Integer, Boolean> {

        /*
         * SEMAFORO
         *   ROJO -> doInBackground(); // STRING porque es la url donde va a ir la API
         *   AMARILLO -> Notificar el % de cumplimiento // INTEGER porque es el progreso en numero entero
         *   VERDE -> onPOstExecute(); Mostrar si ha ido bien o ha ido un error // BOOLEAN porque es ha ido bien, o ha ido mal
         * */

        @Override
        protected Boolean doInBackground(String... strings) {

            Post post = new Post();

            try {
                // Devuelve el objeto JSON
                JSONObject listaObjetosPeliculasJSON = post.getServerDataGetObject(URL);
                JSONArray listaPeliculasArraysJSON = listaObjetosPeliculasJSON.getJSONArray("results");
                listaPeliculasArrayList = Peliculas.getArrayListFromJSON(listaPeliculasArraysJSON);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            // Devolver si ha ido bien o mal
            return true;
        }

        @Override
        protected void onPostExecute(Boolean respuesta) {

            if (respuesta) {
                if (listaPeliculasArrayList != null && listaPeliculasArrayList.size() > 0) {
                    onPeliculasListener.onResolve(listaPeliculasArrayList);
                } else {
                    onPeliculasListener.onReject("Error al traer los datos del servidor");
                }
            }
        }


    }
}
