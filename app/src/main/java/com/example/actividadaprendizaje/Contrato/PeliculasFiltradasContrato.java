package com.example.actividadaprendizaje.Contrato;

import com.example.actividadaprendizaje.Beans.Peliculas;

import java.util.ArrayList;

public interface PeliculasFiltradasContrato {

    interface vista{
        void success();
        void error();
    }

    interface presentador{
        void getPeliculasFiltradas();
    }



    interface modelo{

        void getPeliculasFiltradasWS();

        // Programacion reactiva
        interface onPeliculasListener {
            void onFinished(ArrayList<Peliculas> listaPeliculasFiltrada);
            void onFailure(String error);
        }
    }

}
