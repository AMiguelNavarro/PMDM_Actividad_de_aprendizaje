package com.example.actividadaprendizaje.Beans;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Peliculas {

    // Poner las etiquetas por las que me llegan los datos en JSON
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String OVERVIEW = "overview";
    private static final String POSTER_PATH = "poster_path";
    private static final String VOTE_AVERAGE = "vote_average";

    private int id;
    @SerializedName("title") private String titulo;
    @SerializedName("overview")private String sinopsis;
    @SerializedName("poster_path")private String image;
    private String vote_average;


    public int getId() { return id; }
    public void setId(int id) {this.id = id;}
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getSinopsis() {return sinopsis;}
    public void setSinopsis(String sinopsis) {this.sinopsis = sinopsis;}
    public String getImage() { return image;}
    public void setImage(String image) {this.image = image;}
    public String getVote_average() {return vote_average; }
    public void setVote_average(String vote_average) {this.vote_average = vote_average;}

    public static ArrayList<Peliculas> getArrayListFromJSON(JSONArray listaPeliculas) {
        ArrayList<Peliculas> lstPeliculas = null;
        try {
            if (listaPeliculas != null && listaPeliculas.length() > 0) {
                lstPeliculas = new ArrayList<Peliculas>();
            }

            // Se recorre la lista que llega por parámetro y se mete en un objeto Pelicula
            for (int i = 0; i < listaPeliculas.length(); i++) {
                JSONObject json_data = listaPeliculas.getJSONObject(i);
                Peliculas pelicula = new Peliculas();

                pelicula.setId(json_data.getInt(ID));
                pelicula.setTitulo(json_data.getString(TITLE));
                pelicula.setSinopsis(json_data.getString(OVERVIEW));
                pelicula.setImage(json_data.getString(POSTER_PATH));
                pelicula.setVote_average(json_data.getString(VOTE_AVERAGE));


                lstPeliculas.add(pelicula);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lstPeliculas;
    }

}
