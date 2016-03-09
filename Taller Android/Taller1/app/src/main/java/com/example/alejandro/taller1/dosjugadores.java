package com.example.alejandro.taller1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class dosjugadores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosjugadores);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void cuadricula(View view) {
        Intent intent = new Intent(this,tablero.class);
        EditText n1   = (EditText)findViewById(R.id.editText);
        EditText n2   = (EditText)findViewById(R.id.editText2);
        String nombre1 = String.valueOf(n1.getText());
        String nombre2 = String.valueOf(n2.getText());
        if (nombre1.equals("") || nombre1.equals(null))
            intent.putExtra("nombre1", "Jugador 1");
        else
            intent.putExtra("nombre1", nombre1);

        if (nombre2.equals("") || nombre2.equals(null))
            intent.putExtra("nombre2", "Jugador 2");
        else
            intent.putExtra("nombre2", nombre2);
        intent.putExtra("tipo", 2);
        startActivity(intent);
    }
}
