package com.example.actividadaprendizaje.Modelo;

import android.content.Context;
import android.os.AsyncTask;

import com.example.actividadaprendizaje.Beans.Peliculas;
import com.example.actividadaprendizaje.Beans.PeliculasApiResults;
import com.example.actividadaprendizaje.Contrato.PeliculasFiltroGeneroContrato;
import com.example.actividadaprendizaje.Utilidades.Post;
import com.example.actividadaprendizaje.retrofit.ApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeliculasFiltroGeneroModelo implements PeliculasFiltroGeneroContrato.modelo {

    @Override
    public void getPeliculasFiltroGeneroWS(Context context, OnPeliculasFiltroGeneroListener onPeliculasFiltroGeneroListener, String idGenero) {
        ApiClient apiClient = new ApiClient(context);
        final Call<PeliculasApiResults> peticion = apiClient.getPeliculasFilterGenre(idGenero);
        peticion.enqueue(new Callback<PeliculasApiResults>() {
            @Override
            public void onResponse(Call<PeliculasApiResults> call, Response<PeliculasApiResults> response) {
                // Si va bien
                if (response != null && response.body() != null) {
                    onPeliculasFiltroGeneroListener.onResolve(new ArrayList<Peliculas>(response.body().getResults()));
                }
            }

            @Override
            public void onFailure(Call<PeliculasApiResults> call, Throwable t) {
                // Si va mal
                t.printStackTrace();
                onPeliculasFiltroGeneroListener.onReject(t.getLocalizedMessage());
            }
        });

    }



}
