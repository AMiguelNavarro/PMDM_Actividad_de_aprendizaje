package com.example.actividadaprendizaje.retrofit;

import android.content.Context;

import com.example.actividadaprendizaje.Beans.PeliculasApiResults;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private Retrofit retrofit;
    private Context context;

    private final String URL_BASE = "https://api.themoviedb.org/3/";

    public ApiClient(Context context) {
        this.context = context;

        retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                // Permite parsear de JSON a nuestros Beans de forma automática
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // ENDPOINTS
    public Call<PeliculasApiResults> getPeliculas() {
        PeliculasApiRetrofit service= retrofit.create(PeliculasApiRetrofit.class);
        return service.getPeliculas();
    }

}
