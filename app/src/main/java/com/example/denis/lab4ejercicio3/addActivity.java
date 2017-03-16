package com.example.denis.lab4ejercicio3;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addActivity extends AppCompatActivity {
    private EditText etCod;
    private EditText etName;
    private EditText etPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        //Asociamos los objetos a las variables.
        etName = (EditText) findViewById(R.id.etName);
        etCod = (EditText) findViewById(R.id.etCod);
        etPrice = (EditText) findViewById(R.id.etPrice);
    }
    public void add (View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = etCod.getText().toString();
        String name = etName.getText().toString();
        String price = etPrice.getText().toString();
        ContentValues fila = new ContentValues();
        fila.put("codigo", cod);
        fila.put("nombre", name);
        fila.put("precio", price);
        bd.insert("articulos", null, fila);
        bd.close();
        etName.setText("");
        etCod.setText("");
        etPrice.setText("");
        Toast.makeText(this, "Valor insertar correctamente.", Toast.LENGTH_SHORT).show();
    }

    public void clean (View v){
        etName.setText("");
        etCod.setText("");
        etPrice.setText("");
    }

    public void back (View v){
        finish();
    }
}
