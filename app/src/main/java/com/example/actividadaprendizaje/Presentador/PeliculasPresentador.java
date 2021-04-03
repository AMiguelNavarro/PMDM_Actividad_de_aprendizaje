package com.example.actividadaprendizaje.Presentador;

import android.content.Context;

import com.example.actividadaprendizaje.Beans.Peliculas;
import com.example.actividadaprendizaje.Contrato.PeliculasContrato;
import com.example.actividadaprendizaje.Modelo.PeliculasModelo;

import java.util.ArrayList;


public class PeliculasPresentador implements PeliculasContrato.presentador{

    private PeliculasContrato.vista peliculasVista;
    private PeliculasModelo peliculasModelo;

    public PeliculasPresentador(PeliculasContrato.vista peliculasVista) {
        this.peliculasVista = peliculasVista;
        this.peliculasModelo = new PeliculasModelo();
    }



    @Override
    public void getPeliculas(Context context) {

        peliculasModelo.getPeliculasWS(context, new PeliculasContrato.modelo.OnPeliculasListener() {
            @Override
            public void onResolve(ArrayList<Peliculas> listaPeliculas) {
                peliculasVista.success(listaPeliculas);
            }

            @Override
            public void onReject(String error) {
                peliculasVista.error(error);
            }
        });

    }
}
