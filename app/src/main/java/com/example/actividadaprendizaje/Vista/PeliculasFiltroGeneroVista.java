package com.example.actividadaprendizaje.Vista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.actividadaprendizaje.Adaptador.PeliculasAdaptador;
import com.example.actividadaprendizaje.Beans.Peliculas;
import com.example.actividadaprendizaje.Contrato.PeliculasFiltroGeneroContrato;
import com.example.actividadaprendizaje.Presentador.PeliculasFiltroGeneroPresentador;
import com.example.actividadaprendizaje.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class PeliculasFiltroGeneroVista extends AppCompatActivity implements PeliculasFiltroGeneroContrato.vista {

    private RecyclerView recycler;
    private RecyclerView.LayoutManager gestorLayout;
    private PeliculasFiltroGeneroPresentador peliculasFiltroGeneroPresentador;
    private RelativeLayout layout;
    private BottomNavigationView bottomNavigationView;

    private Spinner spinner;
    private String [] opcionesSpinner = {" ", "Acción", "Aventura","Animación", "Comedia","Crimen", "Documental","Drama", "Familia","Fantasía", "Historia","Terror", "Música","Misterio", "Romance",
            "Ciencia Ficción", "Película de TV","Suspense", "Bélica","Western"};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas_filtradas_genero_vista_recycler);

        Intent navegar = this.getIntent();
        Bundle extra = navegar.getExtras();
        String idGender = String.valueOf(extra.getInt("idGenero"));
        String generoDescripcion = String.valueOf(extra.getString("generoDescripcion"));
//Toast.makeText(getBaseContext(), idGender, Toast.LENGTH_SHORT).show(); //COGE EL ID CORRECTAMENTE

        peliculasFiltroGeneroPresentador = new PeliculasFiltroGeneroPresentador(this);
        peliculasFiltroGeneroPresentador.getPeliculasFiltroGenero(this, idGender);

        layout = findViewById(R.id.layoutGenre);
        Snackbar snackbar = Snackbar.make(layout, "GÉNERO: " + generoDescripcion, Snackbar.LENGTH_LONG);
        snackbar.show();

        cargarSpinner();

        bottomNavigationView = findViewById(R.id.bottom_navigation_genero);
        initBottomNavigation();

    }

    @Override
    public void success(ArrayList<Peliculas> listaPeliculasGenero) {

        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        gestorLayout = new GridLayoutManager(this, 3);

        recycler.setLayoutManager(gestorLayout);

        // Crear un nuevo adaptador, que es el pintado para el usuario
        PeliculasAdaptador adaptador = new PeliculasAdaptador(listaPeliculasGenero);
        recycler.setAdapter(adaptador);
        
    }

    @Override
    public void error(String error) {

        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

    }

    private void initBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_nav1:
                        Intent navegar = new Intent(getBaseContext(), PeliculasVista.class);
                        startActivity(navegar);
                        return true;

                    case R.id.menu_nav2:
                        //TODO intent a las de mayor puntuacion
                        return true;
                }
                return false;
            }
        });
    }



    public void cargarSpinner() {
        spinner = findViewById(R.id.spinnerFiltro);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesSpinner);
        spinner.setAdapter(arrayAdapter);
        spinner.setSelected(false);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String genero = parent.getItemAtPosition(position).toString();
                int idGenero = 0;
                Intent navegar = new Intent(getBaseContext(), PeliculasFiltroGeneroVista.class);

                switch (genero) {
                    // Se pone esto ya que por defecto coge el primero nada más cargar y entra en bucle
                    case " ":
                        return;
                    case "Acción":
                        idGenero = 28;
                        navegar.putExtra("idGenero", idGenero);
                        navegar.putExtra("generoDescripcion", genero);
                        break;
                    case "Aventura":
                        idGenero = 12;
                        navegar.putExtra("idGenero", idGenero);
                        navegar.putExtra("generoDescripcion", genero);
                        break;
                    case "Animación":
                        idGenero = 16;
                        navegar.putExtra("idGenero", idGenero);
                        navegar.putExtra("generoDescripcion", genero);
                        break;
                    case "Comedia":
                        idGenero = 35;
                        navegar.putExtra("idGenero", idGenero);
                        navegar.putExtra("generoDescripcion", genero);
                        break;
                    case "Crimen":
                        idGenero = 80;
                        navegar.putExtra("idGenero", idGenero);
                        navegar.putExtra("generoDescripcion", genero);
                        break;
                    case "Documental":
                        idGenero = 99;
                        navegar.putExtra("idGenero", idGenero);
                        navegar.putExtra("generoDescripcion", genero);
                        break;
                    case "Drama":
                        idGenero = 18;
                        navegar.putExtra("idGenero", idGenero);
                        navegar.putExtra("generoDescripcion", genero);
                        break;
                    case "Familia":
                        idGenero = 10751;
                        navegar.putExtra("idGenero", idGenero);
                        navegar.putExtra("generoDescripcion", genero);
                        break;
                    case "Fantasía":
                        idGenero = 14;
                        navegar.putExtra("idGenero", idGenero);
                        navegar.putExtra("generoDescripcion", genero);
                        break;
                    case "Historia":
                        idGenero = 36;
                        navegar.putExtra("idGenero", idGenero);
                        navegar.putExtra("generoDescripcion", genero);
                        break;
                    case "Terror":
                        idGenero = 27;
                        navegar.putExtra("idGenero", idGenero);
                        navegar.putExtra("generoDescripcion", genero);
                        break;
                    case "Música":
                        idGenero = 10402;
                        navegar.putExtra("idGenero", idGenero);
                        navegar.putExtra("generoDescripcion", genero);
                        break;
                    case "Misterio":
                        idGenero = 9648;
                        navegar.putExtra("idGenero", idGenero);
                        navegar.putExtra("generoDescripcion", genero);
                        break;
                    case "Romance":
                        idGenero = 10749;
                        navegar.putExtra("idGenero", idGenero);
                        navegar.putExtra("generoDescripcion", genero);
                        break;
                    case "Ciencia ficción":
                        idGenero = 878;
                        navegar.putExtra("idGenero", idGenero);
                        navegar.putExtra("generoDescripcion", genero);
                        break;
                    case "Película de TV":
                        idGenero = 10770;
                        navegar.putExtra("idGenero", idGenero);
                        navegar.putExtra("generoDescripcion", genero);
                        break;
                    case "Suspense":
                        idGenero = 53;
                        navegar.putExtra("idGenero", idGenero);
                        navegar.putExtra("generoDescripcion", genero);
                        break;
                    case "Bélica":
                        idGenero = 10752;
                        navegar.putExtra("idGenero", idGenero);
                        navegar.putExtra("generoDescripcion", genero);
                        break;
                    case "Western":
                        idGenero = 37;
                        navegar.putExtra("idGenero", idGenero);
                        navegar.putExtra("generoDescripcion", genero);
                        break;
                    default:
                        break;

                }
                startActivity(navegar);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Snackbar snackbar = Snackbar.make(layout, "No has seleccionado ningún género", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
    }


}

