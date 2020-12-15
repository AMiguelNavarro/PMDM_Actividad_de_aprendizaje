package com.example.actividadaprendizaje.Contrato;

import com.example.actividadaprendizaje.Beans.Peliculas;

import java.util.ArrayList;

public interface PeliculasPopularesContrato {

    interface vista{
        void success(ArrayList<Peliculas> listaPeliculasPopulares);
        void error(String error);
    }

    interface presentador{
        void getPeliculasPopulares();
    }



    interface modelo{

        void getPeliculasPopularesWS();

        // Programacion reactiva
        interface onPeliculasListener {
            void onResolve(ArrayList<Peliculas> listaPeliculasPopulares);
            void onReject(String error);
        }
    }

}
