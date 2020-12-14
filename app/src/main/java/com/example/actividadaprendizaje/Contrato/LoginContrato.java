package com.example.actividadaprendizaje.Contrato;

import com.example.actividadaprendizaje.Beans.Usuario;

public interface LoginContrato {

    interface vista{}

    interface presentador{}



    interface modelo{
        interface onLoginUsuarioListener {
            void onFinished(Usuario usuario);
            void onFailure(String error);
        }
    }


}
