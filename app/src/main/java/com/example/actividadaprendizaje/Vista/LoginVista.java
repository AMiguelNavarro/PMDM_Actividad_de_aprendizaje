package com.example.actividadaprendizaje.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.actividadaprendizaje.Beans.Usuario;
import com.example.actividadaprendizaje.Presentador.LoginPresentador;
import com.example.actividadaprendizaje.R;

public class LoginVista extends AppCompatActivity {

    private static final int SCREEN = 2;


    private Button btIniciarSesion;
    private EditText etUsuario, etContrasenia;

    private LoginPresentador loginPresentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_login);

        iniciarComponentes();

        loginPresentador = new LoginPresentador(this);

        btIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vista) {
                // En lugar de crear aquí el objeto usuario y pasar los datos como atributos del objeto, primero se llama al metodo login, que valida
                // y si está bien crea el objeto usuario
                loginPresentador.login(String.valueOf(etUsuario.getText()), String.valueOf(etContrasenia.getText()));
            }
        });

    }



    public void iniciarComponentes() {
        btIniciarSesion = findViewById(R.id.btIniciarSesion);
        etContrasenia = findViewById(R.id.etContrasenia);
        etUsuario = findViewById(R.id.etUsuario);
    }


    public void success(Usuario usuario) {
        Toast.makeText(this, "Usuario Correcto", Toast.LENGTH_SHORT).show();
        Intent navegar = new Intent(this.getBaseContext(), PeliculasVista.class);
        startActivity(navegar);
    }

    public void error(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

}