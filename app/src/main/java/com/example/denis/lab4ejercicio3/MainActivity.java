package com.example.denis.lab4ejercicio3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Accion boton Alta
    public void openAdd(View v){
        //Creamos un intent para convocar la activity
        Intent addI = new Intent(this,addActivity.class);
        //Iniciamos la activity
        startActivity(addI);
    }

    //Accion boton Baja
    public void openDel(View v){
        //Creamos un intent para convocar la activity
        Intent delI = new Intent(this,delActivity.class);
        //Iniciamos la activity
        startActivity(delI);
    }

    //Accion boton Modificar
    public void openUpdate(View v){
        //Creamos un intent para convocar la activity
        Intent updateI = new Intent(this,updateActivity.class);
        //Iniciamos la activity
        startActivity(updateI);
    }

    //Accion boton Consulta por código
    public void openQuery(View v){
        //Creamos un intent para convocar la activity
        Intent queryI = new Intent(this,queryActivity.class);
        //Iniciamos la activity
        startActivity(queryI);
    }

    //Accion boton Consulta todo
    public void openQueryAll(View v){
        //Creamos un intent para convocar la activity
        Intent queryAI = new Intent(this,queryAllActivity.class);
        //Iniciamos la activity
        startActivity(queryAI);
    }
}
