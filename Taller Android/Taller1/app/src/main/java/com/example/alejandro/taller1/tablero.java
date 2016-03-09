package com.example.alejandro.taller1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class tablero extends AppCompatActivity {
    String nombre1;
    String nombre2;
    int puntaje1=0;
    int puntaje2=0;
    int tipo; //1 o 2 jugadores
    List<Integer> cartas =new ArrayList<Integer>();
    int turno=0; //turno del jugador
    int valor; //valor de la carta abierta
    int carta=0; //primer carta o segunda carta
    int parejas=0;
    Button b1;
    Button b2;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            Intent intent = new Intent(this,about.class);
            startActivity(intent);
        }
        if (id == R.id.action_new) {
            nuevo();
        }
        if (id == R.id.action_restart) {
            reinicio();
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tablero, menu);
        return true;
    }

    public void reinicio(){
        turno=0;
        puntaje1=0;
        puntaje2=0;

        Button b1 = (Button) findViewById(R.id.btn1);
        b1.setText("");
        b1.setEnabled(true);

        Button b2 = (Button) findViewById(R.id.btn2);
        b2.setText("");
        b2.setEnabled(true);

        Button b3 = (Button) findViewById(R.id.btn3);
        b3.setText("");
        b3.setEnabled(true);

        Button b4 = (Button) findViewById(R.id.btn4);
        b4.setText("");
        b4.setEnabled(true);

        Button b5 = (Button) findViewById(R.id.btn5);
        b5.setText("");
        b5.setEnabled(true);

        Button b6 = (Button) findViewById(R.id.btn6);
        b6.setText("");
        b6.setEnabled(true);

        Button b7 = (Button) findViewById(R.id.btn7);
        b7.setText("");
        b7.setEnabled(true);

        Button b8 = (Button) findViewById(R.id.btn8);
        b8.setText("");
        b8.setEnabled(true);

        Button b9 = (Button) findViewById(R.id.btn9);
        b9.setText("");
        b9.setEnabled(true);

        Button b10 = (Button) findViewById(R.id.btn10);
        b10.setText("");
        b10.setEnabled(true);

        Button b11 = (Button) findViewById(R.id.btn11);
        b11.setText("");
        b11.setEnabled(true);

        Button b12 = (Button) findViewById(R.id.btn12);
        b12.setText("");
        b12.setEnabled(true);

        Button b13 = (Button) findViewById(R.id.btn13);
        b13.setText("");
        b13.setEnabled(true);

        Button b14 = (Button) findViewById(R.id.btn14);
        b14.setText("");
        b14.setEnabled(true);

        Button b15 = (Button) findViewById(R.id.btn15);
        b15.setText("");
        b15.setEnabled(true);

        Button b16 = (Button) findViewById(R.id.btn16);
        b16.setText("");
        b16.setEnabled(true);
        actualizar();

    }

    public void nuevo(){
        reinicio();
        numeros();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        tipo=getIntent().getIntExtra("tipo",1);

        if (tipo==1){
            nombre1= getIntent().getStringExtra("nombre");
            TextView n = new TextView(this);
            n = (TextView) findViewById(R.id.textnombre);
            n.setText(nombre1);

            TextView p = new TextView(this);
            p = (TextView) findViewById(R.id.textpuntaje);
            p.setText(getString(R.string.puntaje) + String.valueOf(puntaje1));
        }
        else{
            nombre1= getIntent().getStringExtra("nombre1");
            nombre2= getIntent().getStringExtra("nombre2");
            TextView n1 = new TextView(this);
            n1 = (TextView) findViewById(R.id.textnombre);
            n1.setText(nombre1);

            TextView p1 = new TextView(this);
            p1 = (TextView) findViewById(R.id.textpuntaje);
            p1.setText(getString(R.string.puntaje) + String.valueOf(puntaje1));
        }
        numeros();
    }

    private void numeros(){
        /* Este era el planteamiento inicial de la funcion pero no funciona ya que en algunos
           casos el while se puede repetir muchas veces al punto de que el emulador lo detiene
        Random ran = new Random();
        int numero;
        int pos1;
        int pos2;
        for (int i=0;i<16;i=i+1){
            cartas.add(i, -1);
        }
        for (int j=0;j<8;j=j+1){
            numero=ran.nextInt(8);
            pos1=ran.nextInt(16);
            pos2=ran.nextInt(16);
            while (pos1==pos2 || cartas.get(pos1)!=-1 || cartas.get(pos2)!=-1){
                if (cartas.get(pos1)!=-1)
                    pos1=ran.nextInt(16);
                pos2=ran.nextInt(16);
            }
            cartas.add(pos1,numero);
            cartas.add(pos2,numero);
        }*/
        int tmp=8;
        for (int i=0;i<8;i=i+1){
            cartas.add(i, i);
        }
        for (int i=0;i<8;i=i+1){
            cartas.add(tmp, i);
            tmp=tmp+1;
        }
    }

    public void abrir(View view) throws InterruptedException{

        switch (view.getId()){
            case R.id.btn1:
                if (carta==0){
                    b1 = (Button) findViewById(R.id.btn1);
                    b1.setText(String.valueOf(cartas.get(0)));
                    b1.setEnabled(false);
                    valor=cartas.get(0);
                    carta=1;
                }
                else{
                    b2 = (Button) findViewById(R.id.btn1);
                    b2.setText(String.valueOf(cartas.get(0)));
                    b2.setEnabled(false);
                    if (valor==cartas.get(0)){
                        if (turno==0){
                            puntaje1=puntaje1+1;
                        }
                        else{
                            puntaje2=puntaje2+1;
                        }
                        parejas=parejas+1;
                    }
                    else{
                        tapar(b1, b2);
                    }
                    carta=0;
                    actualizar();
                }

                break;

            case R.id.btn2:
                if (carta==0){
                    b1 = (Button) findViewById(R.id.btn2);
                    b1.setText(String.valueOf(cartas.get(1)));
                    b1.setEnabled(false);
                    valor=cartas.get(1);
                    carta=1;
                }
                else{
                    b2 = (Button) findViewById(R.id.btn2);
                    b2.setText(String.valueOf(cartas.get(1)));
                    b2.setEnabled(false);
                    if (valor==cartas.get(1)){
                        if (turno==0){
                            puntaje1=puntaje1+1;
                        }
                        else{
                            puntaje2=puntaje2+1;
                        }
                        parejas=parejas+1;
                    }
                    else{
                        tapar(b1, b2);
                    }
                    carta=0;
                    actualizar();
                }
                break;

            case R.id.btn3:
                if (carta==0){
                    b1 = (Button) findViewById(R.id.btn3);
                    b1.setText(String.valueOf(cartas.get(2)));
                    b1.setEnabled(false);
                    valor=cartas.get(2);
                    carta=1;
                }
                else{
                    b2 = (Button) findViewById(R.id.btn3);
                    b2.setText(String.valueOf(cartas.get(2)));
                    b2.setEnabled(false);
                    if (valor==cartas.get(2)){
                        if (turno==0){
                            puntaje1=puntaje1+1;
                        }
                        else{
                            puntaje2=puntaje2+1;
                        }
                        parejas=parejas+1;
                    }
                    else{
                        tapar(b1, b2);
                    }
                    carta=0;
                    actualizar();
                }
                break;

            case R.id.btn4:
                if (carta==0){
                    b1 = (Button) findViewById(R.id.btn4);
                    b1.setText(String.valueOf(cartas.get(3)));
                    b1.setEnabled(false);
                    valor=cartas.get(3);
                    carta=1;
                }
                else{
                    b2 = (Button) findViewById(R.id.btn4);
                    b2.setText(String.valueOf(cartas.get(3)));
                    b2.setEnabled(false);
                    if (valor==cartas.get(3)){
                        if (turno==0){
                            puntaje1=puntaje1+1;
                        }
                        else{
                            puntaje2=puntaje2+1;
                        }
                        parejas=parejas+1;
                    }
                    else{
                        tapar(b1, b2);
                    }
                    carta=0;
                    actualizar();
                }
                break;

            case R.id.btn5:
                if (carta==0){
                    b1 = (Button) findViewById(R.id.btn5);
                    b1.setText(String.valueOf(cartas.get(4)));
                    b1.setEnabled(false);
                    valor=cartas.get(4);
                    carta=1;
                }
                else{
                    b2 = (Button) findViewById(R.id.btn5);
                    b2.setText(String.valueOf(cartas.get(4)));
                    b2.setEnabled(false);
                    if (valor==cartas.get(4)){
                        if (turno==0){
                            puntaje1=puntaje1+1;
                        }
                        else{
                            puntaje2=puntaje2+1;
                        }
                        parejas=parejas+1;
                    }
                    else{
                        tapar(b1, b2);
                    }
                    carta=0;
                    actualizar();
                }
                break;

            case R.id.btn6:
                if (carta==0){
                    b1 = (Button) findViewById(R.id.btn6);
                    b1.setText(String.valueOf(cartas.get(5)));
                    b1.setEnabled(false);
                    valor=cartas.get(5);
                    carta=1;
                }
                else{
                    b2 = (Button) findViewById(R.id.btn6);
                    b2.setText(String.valueOf(cartas.get(5)));
                    b2.setEnabled(false);
                    if (valor==cartas.get(5)){
                        if (turno==0){
                            puntaje1=puntaje1+1;
                        }
                        else{
                            puntaje2=puntaje2+1;
                        }
                        parejas=parejas+1;
                    }
                    else{
                        tapar(b1, b2);
                    }
                    carta=0;
                    actualizar();
                }
                break;

            case R.id.btn7:
                if (carta==0){
                    b1 = (Button) findViewById(R.id.btn7);
                    b1.setText(String.valueOf(cartas.get(6)));
                    b1.setEnabled(false);
                    valor=cartas.get(6);
                    carta=1;
                }
                else{
                    b2 = (Button) findViewById(R.id.btn7);
                    b2.setText(String.valueOf(cartas.get(6)));
                    b2.setEnabled(false);
                    if (valor==cartas.get(6)){
                        if (turno==0){
                            puntaje1=puntaje1+1;
                        }
                        else{
                            puntaje2=puntaje2+1;
                        }
                        parejas=parejas+1;
                    }
                    else{
                        tapar(b1, b2);
                    }
                    carta=0;
                    actualizar();
                }
                break;

            case R.id.btn8:
                if (carta==0){
                    b1 = (Button) findViewById(R.id.btn8);
                    b1.setText(String.valueOf(cartas.get(7)));
                    b1.setEnabled(false);
                    valor=cartas.get(7);
                    carta=1;
                }
                else{
                    b2 = (Button) findViewById(R.id.btn8);
                    b2.setText(String.valueOf(cartas.get(7)));
                    b2.setEnabled(false);
                    if (valor==cartas.get(7)){
                        if (turno==0){
                            puntaje1=puntaje1+1;
                        }
                        else{
                            puntaje2=puntaje2+1;
                        }
                        parejas=parejas+1;
                    }
                    else{
                        tapar(b1, b2);
                    }
                    carta=0;
                    actualizar();
                }
                break;

            case R.id.btn9:
                if (carta==0){
                    b1 = (Button) findViewById(R.id.btn9);
                    b1.setText(String.valueOf(cartas.get(8)));
                    b1.setEnabled(false);
                    valor=cartas.get(8);
                    carta=1;
                }
                else{
                    b2 = (Button) findViewById(R.id.btn9);
                    b2.setText(String.valueOf(cartas.get(8)));
                    b2.setEnabled(false);
                    if (valor==cartas.get(8)){
                        if (turno==0){
                            puntaje1=puntaje1+1;
                        }
                        else{
                            puntaje2=puntaje2+1;
                        }
                        parejas=parejas+1;
                    }
                    else{
                        tapar(b1, b2);
                    }
                    carta=0;
                    actualizar();
                }
                break;

            case R.id.btn10:
                if (carta==0){
                    b1 = (Button) findViewById(R.id.btn10);
                    b1.setText(String.valueOf(cartas.get(9)));
                    b1.setEnabled(false);
                    valor=cartas.get(9);
                    carta=1;
                }
                else{
                    b2 = (Button) findViewById(R.id.btn10);
                    b2.setText(String.valueOf(cartas.get(9)));
                    b2.setEnabled(false);
                    if (valor==cartas.get(9)){
                        if (turno==0){
                            puntaje1=puntaje1+1;
                        }
                        else{
                            puntaje2=puntaje2+1;
                        }
                        parejas=parejas+1;
                    }
                    else{
                        tapar(b1, b2);
                    }
                    carta=0;
                    actualizar();
                }
                break;

            case R.id.btn11:
                if (carta==0){
                    b1 = (Button) findViewById(R.id.btn11);
                    b1.setText(String.valueOf(cartas.get(10)));
                    b1.setEnabled(false);
                    valor=cartas.get(10);
                    carta=1;
                }
                else{
                    b2 = (Button) findViewById(R.id.btn11);
                    b2.setText(String.valueOf(cartas.get(10)));
                    b2.setEnabled(false);
                    if (valor==cartas.get(10)){
                        if (turno==0){
                            puntaje1=puntaje1+1;
                        }
                        else{
                            puntaje2=puntaje2+1;
                        }
                        parejas=parejas+1;
                    }
                    else{
                        tapar(b1, b2);
                    }
                    carta=0;
                    actualizar();
                }
                break;

            case R.id.btn12:
                if (carta==0){
                    b1 = (Button) findViewById(R.id.btn12);
                    b1.setText(String.valueOf(cartas.get(11)));
                    b1.setEnabled(false);
                    valor=cartas.get(11);
                    carta=1;
                }
                else{
                    b2 = (Button) findViewById(R.id.btn12);
                    b2.setText(String.valueOf(cartas.get(11)));
                    b2.setEnabled(false);
                    if (valor==cartas.get(11)){
                        if (turno==0){
                            puntaje1=puntaje1+1;
                        }
                        else{
                            puntaje2=puntaje2+1;
                        }
                        parejas=parejas+1;
                    }
                    else{
                        tapar(b1, b2);
                    }
                    actualizar();
                    carta=0;
                }
                break;

            case R.id.btn13:
                if (carta==0){
                    b1 = (Button) findViewById(R.id.btn13);
                    b1.setText(String.valueOf(cartas.get(12)));
                    b1.setEnabled(false);
                    valor=cartas.get(12);
                    carta=1;
                }
                else{
                    b2 = (Button) findViewById(R.id.btn13);
                    b2.setText(String.valueOf(cartas.get(12)));
                    b2.setEnabled(false);
                    if (valor==cartas.get(12)){
                        if (turno==0){
                            puntaje1=puntaje1+1;
                        }
                        else{
                            puntaje2=puntaje2+1;
                        }
                        parejas=parejas+1;
                    }
                    else{
                        tapar(b1, b2);
                    }
                    actualizar();
                    carta=0;
                }
                break;

            case R.id.btn14:
                if (carta==0){
                    b1 = (Button) findViewById(R.id.btn14);
                    b1.setText(String.valueOf(cartas.get(13)));
                    b1.setEnabled(false);
                    valor=cartas.get(13);
                    carta=1;
                }
                else{
                    b2 = (Button) findViewById(R.id.btn14);
                    b2.setText(String.valueOf(cartas.get(13)));
                    b2.setEnabled(false);
                    if (valor==cartas.get(13)){
                        if (turno==0){
                            puntaje1=puntaje1+1;
                        }
                        else{
                            puntaje2=puntaje2+1;
                        }
                        parejas=parejas+1;
                    }
                    else{
                        tapar(b1, b2);

                    }
                    actualizar();
                    carta=0;
                }
                break;

            case R.id.btn15:
                if (carta==0){
                    b1 = (Button) findViewById(R.id.btn15);
                    b1.setText(String.valueOf(cartas.get(14)));
                    b1.setEnabled(false);
                    valor=cartas.get(14);
                    carta=1;
                }
                else{
                    b2 = (Button) findViewById(R.id.btn15);
                    b2.setText(String.valueOf(cartas.get(14)));
                    b2.setEnabled(false);
                    if (valor==cartas.get(14)){
                        if (turno==0){
                            puntaje1=puntaje1+1;
                        }
                        else{
                            puntaje2=puntaje2+1;
                        }
                        parejas=parejas+1;
                    }
                    else{
                        tapar(b1, b2);
                    }
                    actualizar();
                    carta = 0;
                }
                break;

            case R.id.btn16:
                if (carta==0){
                    b1 = (Button) findViewById(R.id.btn16);
                    b1.setText(String.valueOf(cartas.get(15)));
                    b1.setEnabled(false);
                    valor=cartas.get(15);
                    carta=1;
                }
                else{
                    b2 = (Button) findViewById(R.id.btn16);
                    b2.setText(String.valueOf(cartas.get(15)));
                    b2.setEnabled(false);
                    if (valor==cartas.get(15)){
                        if (turno==0){
                            puntaje1=puntaje1+1;
                        }
                        else{
                            puntaje2=puntaje2+1;
                        }
                        parejas=parejas+1;
                    }
                    else{
                        tapar(b1,b2);
                    }
                    actualizar();
                    carta=0;
                }
                break;


        }

    }

    private void tapar(final Button b1, final Button b2) {
        final Handler handler = new Handler();
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        b1.setEnabled(true);
                        b2.setEnabled(true);
                        b1.setText("");
                        b2.setText("");

                    }
                });
            }
        }, 1000);
    }

    private void actualizar() {
        final Handler handler = new Handler();
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        TextView t = (TextView) findViewById(R.id.textnombre);
                        TextView p = (TextView) findViewById(R.id.textpuntaje);
                        if(tipo==2){
                            if (turno==0){
                                turno=1;
                                t.setText(String.valueOf(nombre2));
                                p.setText(Integer.toString(puntaje2));
                            }
                            else{
                                turno=0;
                                t.setText(String.valueOf(nombre1));
                                p.setText(Integer.toString(puntaje1));
                            }
                        }
                        else{
                            t.setText(String.valueOf(nombre1));
                            p.setText(Integer.toString(puntaje1));
                        }

                    }
                });
            }
        }, 1000);
    }

    public void verificar(){
        String mensaje;
        if(parejas==8){
            if (puntaje1>puntaje2){
                mensaje=nombre1+" Gano";
            }
            else if (puntaje2>puntaje1){
                mensaje=nombre2+" Gano";
            }
            else{
                mensaje="Empate";
            }
            Intent i = new Intent(this, termino.class);
            i.putExtra("mensaje", mensaje);
            startActivity(i);


        }
    }
}
