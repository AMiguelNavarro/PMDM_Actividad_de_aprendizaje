package com.example.actividadaprendizaje.Presentador;

import android.content.Intent;
import android.os.Handler;

import com.example.actividadaprendizaje.Beans.Usuario;
import com.example.actividadaprendizaje.Contrato.LoginContrato;
import com.example.actividadaprendizaje.Modelo.LoginModelo;
import com.example.actividadaprendizaje.Vista.LoginVista;

public class LoginPresentador {

    //Controller

    private LoginVista loginVista;
    private LoginModelo loginModelo;
    private boolean validacionCorrecta = true;


    public LoginPresentador(LoginVista loginVista) {
        this.loginVista = loginVista;
        this.loginModelo = new LoginModelo();
    }

    public void login(String nombreUsuario, String constrasenia) {

        // if is correcto la validación, llama al método del modelo que se comunica con la api
        // Clase validacione estática
        if (validacionCorrecta) {
            Usuario usuario  = new Usuario(nombreUsuario, constrasenia);
            loginModelo.loginUsuarioWS(usuario, new LoginContrato.modelo.onLoginUsuarioListener() {
                @Override
                public void onFinished(Usuario usuario) {
                    loginVista.success(usuario);
                }

                @Override
                public void onFailure(String error) {
                    loginVista.error(error);
                }
            });
        }




        //

    }

}
