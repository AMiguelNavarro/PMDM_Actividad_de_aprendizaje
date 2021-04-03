package com.example.actividadaprendizaje.Modelo;

import android.content.Context;

import com.example.actividadaprendizaje.Beans.Peliculas;
import com.example.actividadaprendizaje.Beans.PeliculasApiResults;
import com.example.actividadaprendizaje.Contrato.PeliculasContrato;
import com.example.actividadaprendizaje.retrofit.ApiClient;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PeliculasModelo implements PeliculasContrato.modelo {


    private ArrayList<Peliculas> listaPeliculasArrayList;
    private OnPeliculasListener onPeliculasListener;

    private final String URL = "https://api.themoviedb.org/3/movie/popular?api_key=9452cdfc55151f2eef8682f0e78f4a77&language=es-ES&page=1";
//    private final String URL = "https://api.themoviedb.org/3/movie/popular?api_key=d9c4177bb1cc819d43088d25fbe2474c&language=en-US&page=1";
//            final String URL = "http://ddragon.leagueoflegends.com/cdn/10.24.1/data/en_US/champion.json"; // TODO probar con the API LOL si funciona

    @Override
    public void getPeliculasWS(Context context, OnPeliculasListener onPeliculasListener) {
        ApiClient apiClient = new ApiClient(context);
        final Call<PeliculasApiResults> peticion = apiClient.getPeliculas();

        // Al hacer enque retrofit lo mete en su cola de peticiones en un thread aparte y no en el principal
        // Siempre hay que pasarle el Callback
        peticion.enqueue(new Callback<PeliculasApiResults>() {
            @Override
            public void onResponse(Call<PeliculasApiResults> call, Response<PeliculasApiResults> response) {
                // Si va bien
                if (response != null && response.body() != null) {
                    onPeliculasListener.onResolve(new ArrayList<Peliculas>(response.body().getResults()));
                }
            }

            @Override
            public void onFailure(Call<PeliculasApiResults> call, Throwable t) {
                // Si va mal
                t.printStackTrace();
                onPeliculasListener.onReject(t.getLocalizedMessage());
            }
        });
    }

}
