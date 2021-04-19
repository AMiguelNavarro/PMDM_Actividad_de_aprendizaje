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
