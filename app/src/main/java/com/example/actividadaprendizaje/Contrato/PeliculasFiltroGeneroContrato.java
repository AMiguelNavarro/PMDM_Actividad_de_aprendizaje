package com.example.actividadaprendizaje.Contrato;

import com.example.actividadaprendizaje.Beans.Peliculas;

import java.util.ArrayList;

public interface PeliculasFiltroGeneroContrato {

    interface vista{
        void success(ArrayList<Peliculas> listaPeliculasGenero);
        void error(String error);
    }

    interface presentador{
        void getPeliculasFiltroGenero(String idGenero);
    }



    interface modelo{

        // Se le tiene que enviar el callback (camino de regreso)
        void getPeliculasFiltroGeneroWS(OnPeliculasFiltroGeneroListener onPeliculasFiltroGeneroListener, String idGenero);

        // Programacion reactiva
        interface OnPeliculasFiltroGeneroListener {
            void onResolve(ArrayList<Peliculas> listaPeliculasGenero);
            void onReject(String error);
        }
    }

}
