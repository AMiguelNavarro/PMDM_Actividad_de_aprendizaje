package com.example.actividadaprendizaje.Beans;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Peliculas {

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

}
