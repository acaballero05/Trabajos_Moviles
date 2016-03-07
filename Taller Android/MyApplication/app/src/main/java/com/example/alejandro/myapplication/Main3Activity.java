package com.example.alejandro.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    String nombre;
    int puntaje1=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        nombre = getIntent().getStringExtra("nombre");


            TextView t = new TextView(this);
            t = (TextView) findViewById(R.id.textnombre);
            t.setText(getString(R.string.jugador1) + nombre);

            TextView s = new TextView(this);
            s = (TextView) findViewById(R.id.textpuntaje);
            s.setText(getString(R.string.puntaje) + String.valueOf(puntaje1));
    }

}
