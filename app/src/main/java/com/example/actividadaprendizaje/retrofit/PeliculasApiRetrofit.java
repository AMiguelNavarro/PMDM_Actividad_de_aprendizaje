package com.example.actividadaprendizaje.retrofit;

import com.example.actividadaprendizaje.Beans.PeliculasApiResults;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PeliculasApiRetrofit {

    @GET("movie/popular?api_key=d9c4177bb1cc819d43088d25fbe2474c&language=en-US&page=1")
    Call<PeliculasApiResults> getPeliculas();

}
