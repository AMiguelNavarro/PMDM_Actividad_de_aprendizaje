package com.example.actividadaprendizaje.retrofit;

import com.example.actividadaprendizaje.Beans.PeliculasApiResults;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PeliculasApiRetrofit {

    @GET("movie/popular")
    Call<PeliculasApiResults> getPeliculas(
            @Query("api_key") String apiKey,
            @Query("language") String language
    );

    //"movie?api_key=9452cdfc55151f2eef8682f0e78f4a77&language=es-ES&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_genres="
    @GET("discover/movie")
    Call<PeliculasApiResults> getPeliculasGenre(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("sort_by") String sortBy,
            @Query("include_adult") boolean includeAdult,
            @Query("include_video") boolean includeVideo,
            @Query("with_genres") String idGenre
    );


}
