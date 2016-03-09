package com.example.alejandro.taller1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class unjugador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unjugador);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void cuadricula(View view) {
        Intent intent = new Intent(this,tablero.class);
        EditText n   = (EditText)findViewById(R.id.editText);
        String nombre = String.valueOf(n.getText());
        if (nombre.equals("") || nombre.equals(null))
            intent.putExtra("nombre", "Jugador 1");
        else
            intent.putExtra("nombre", nombre);
        intent.putExtra("tipo", 1);
        startActivity(intent);
    }
}
