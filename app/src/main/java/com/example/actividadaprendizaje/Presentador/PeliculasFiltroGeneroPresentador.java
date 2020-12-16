package com.example.actividadaprendizaje.Presentador;

import com.example.actividadaprendizaje.Beans.Peliculas;
import com.example.actividadaprendizaje.Contrato.PeliculasFiltroGeneroContrato;
import com.example.actividadaprendizaje.Modelo.PeliculasFiltroGeneroModelo;

import java.util.ArrayList;

public class PeliculasFiltroGeneroPresentador implements PeliculasFiltroGeneroContrato.presentador{

    private PeliculasFiltroGeneroContrato.vista peliculasFiltroGeneroVista;
    private PeliculasFiltroGeneroModelo peliculasFiltroGeneroModelo;
    private String idGenero;


    public PeliculasFiltroGeneroPresentador (PeliculasFiltroGeneroContrato.vista peliculasFiltroGeneroVista) {
        this.peliculasFiltroGeneroVista = peliculasFiltroGeneroVista;
        peliculasFiltroGeneroModelo = new PeliculasFiltroGeneroModelo();
    }

    @Override
    public void getPeliculasFiltroGenero(String idGenero) {
        peliculasFiltroGeneroModelo.getPeliculasFiltroGeneroWS(new PeliculasFiltroGeneroContrato.modelo.OnPeliculasFiltroGeneroListener() {
            @Override
            public void onResolve(ArrayList<Peliculas> listaPeliculasGenero) {
                peliculasFiltroGeneroVista.success(listaPeliculasGenero);
            }

            @Override
            public void onReject(String error) {
                peliculasFiltroGeneroVista.error(error);
            }
        }, idGenero);
    }
}
