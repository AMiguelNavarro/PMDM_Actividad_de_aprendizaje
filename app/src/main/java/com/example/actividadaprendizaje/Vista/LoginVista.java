package com.example.actividadaprendizaje.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.actividadaprendizaje.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginVista extends AppCompatActivity {

    private TextInputEditText user;
    private TextInputEditText pass;
    private Button btLogIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_vista);
        initComponents();
    }

    private void initComponents() {
        user = findViewById(R.id.user_name_et);
        pass = findViewById(R.id.password_et);
        btLogIn = findViewById(R.id.btLogIn);
    }


    public void validateUser(View v) {
        user.setError(null);
        pass.setError(null);

        String username = String.valueOf(user.getText());
        String password = String.valueOf(pass.getText());

        if (!username.equals(password)) {
            user.setError("Error de usuario");
            pass.setError("Error de contraseña");
            return;
        }

        Intent navegar = new Intent(getBaseContext(), PeliculasVista.class);
        startActivity(navegar);

    }

}