package com.example.alejandro.taller1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class termino extends AppCompatActivity {
    String mensaje;
    int tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termino);
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

        tipo=getIntent().getIntExtra("tipo", 1);
        mensaje=getIntent().getStringExtra("mensaje");

        TextView t = (TextView) findViewById(R.id.msj);
        t.setText(mensaje);
    }

    public void nuevo(View view) {
        Intent i = new Intent(this, inicio.class);
        startActivity(i);
    }

    public void reinicio(View view) {
        Intent i;
        if (tipo==1)
            i = new Intent(this, unjugador.class);
        else
            i = new Intent(this, dosjugadores.class);
        startActivity(i);
    }

    public void cerrar(View view) {
        int p = android.os.Process.myPid();
        android.os.Process.killProcess(p);
    }
}
