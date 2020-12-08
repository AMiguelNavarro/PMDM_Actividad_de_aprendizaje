package com.example.actividadaprendizaje.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.actividadaprendizaje.R;

public class AppVista extends AppCompatActivity {

    private static final int SCREEN = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_app);
    }
}