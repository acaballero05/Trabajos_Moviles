package com.example.alejandro.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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
    }

    public void cuadricula(View view) {
        Intent intent = new Intent(this,Main3Activity.class);
        EditText edit   = (EditText)findViewById(R.id.editText);
        String nombre = String.valueOf(edit.getText());
        if (nombre.equals("") || nombre.equals(null))
            intent.putExtra("Nombre", "Jugador 1");
        else
            intent.putExtra("Nombre", nombre);
        startActivity(intent);
    }
}
