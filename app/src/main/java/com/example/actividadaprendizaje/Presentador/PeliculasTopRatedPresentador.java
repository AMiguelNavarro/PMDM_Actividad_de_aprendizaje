package com.example.actividadaprendizaje.Presentador;

import android.content.Context;

import com.example.actividadaprendizaje.Beans.Peliculas;
import com.example.actividadaprendizaje.Contrato.PeliculasContrato;
import com.example.actividadaprendizaje.Modelo.PeliculasModelo;
import com.example.actividadaprendizaje.Modelo.PeliculasTopRatedModelo;
import com.example.actividadaprendizaje.Vista.PeliculasTopRatedVista;

import java.util.ArrayList;

public class PeliculasTopRatedPresentador implements PeliculasContrato.presentador {

    private PeliculasTopRatedVista peliculasVista;
    private PeliculasTopRatedModelo peliculasModelo;

    public PeliculasTopRatedPresentador(PeliculasTopRatedVista peliculasVista) {
        this.peliculasVista = peliculasVista;
        this.peliculasModelo = new PeliculasTopRatedModelo();
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
