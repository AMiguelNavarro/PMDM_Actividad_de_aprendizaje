package com.example.actividadaprendizaje.Modelo;

import android.content.Intent;
import android.os.Handler;

import com.example.actividadaprendizaje.Beans.Usuario;
import com.example.actividadaprendizaje.Contrato.LoginContrato;

public class LoginModelo {

    private static final String URL = ""; // Se envia por get(URL) el acceso a la API


    public void loginUsuarioWS(Usuario usuario, LoginContrato.modelo.onLoginUsuarioListener onLoginUsuarioListener) {
        // Aquí iria la consulta a la BD o al WS o APi
        // 2 Consulta API (Simulacion, a los 5 seg trae los datos)
        boolean respuesta = true;
        final Handler manejador = new Handler();
        manejador.postDelayed(() -> {
            if (respuesta) {
                // Al presentador decirle que ha ido bien
                onLoginUsuarioListener.onFinished(usuario);
            }
        }, 5000);

    }

}
