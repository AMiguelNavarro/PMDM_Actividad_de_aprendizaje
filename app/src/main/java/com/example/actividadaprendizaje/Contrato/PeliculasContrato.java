package com.example.actividadaprendizaje.Contrato;

import com.example.actividadaprendizaje.Beans.Peliculas;

import java.util.ArrayList;

public interface PeliculasContrato {

    interface vista{
        void success(ArrayList<Peliculas> listaPeliculas);
        void error(String mensajeError);
    }

    interface presentador{
        void getPeliculas();
    }



    interface modelo{

        // Se le tiene que enviar el callback (camino de regreso)
        void getPeliculasWS(OnPeliculasListener onPeliculasListener);

        // Programacion reactiva
        interface OnPeliculasListener {
            void onResolve(ArrayList<Peliculas> listaPeliculas);
            void onReject(String error);
        }
    }

}
