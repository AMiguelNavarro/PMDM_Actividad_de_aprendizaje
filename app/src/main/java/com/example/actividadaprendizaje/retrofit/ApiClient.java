package com.example.actividadaprendizaje.retrofit;

import android.content.Context;

import com.example.actividadaprendizaje.Beans.PeliculasApiResults;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.actividadaprendizaje.Utilidades.Contants.API_KEY;
import static com.example.actividadaprendizaje.Utilidades.Contants.INCLUDE_ADULT;
import static com.example.actividadaprendizaje.Utilidades.Contants.INCLUDE_VIDEO;
import static com.example.actividadaprendizaje.Utilidades.Contants.LANGUAGE;
import static com.example.actividadaprendizaje.Utilidades.Contants.SORT_BY;
import static com.example.actividadaprendizaje.Utilidades.Contants.URL_BASE;

public class ApiClient {

    private Retrofit retrofit;
    private Context context;

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
        return service.getPeliculas(API_KEY, LANGUAGE);
    }



    public Call<PeliculasApiResults> getPeliculasFilterGenre(String idGenre) {
        PeliculasApiRetrofit service= retrofit.create(PeliculasApiRetrofit.class);
        return service.getPeliculasGenre(API_KEY, LANGUAGE, SORT_BY, INCLUDE_ADULT, INCLUDE_VIDEO, idGenre);
    }

}
