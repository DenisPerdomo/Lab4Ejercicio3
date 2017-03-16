package com.example.denis.lab4ejercicio3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class updateActivity extends AppCompatActivity {
    private EditText etCod;
    private EditText etName;
    private EditText etPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        etName = (EditText) findViewById(R.id.etName);
        etCod = (EditText) findViewById(R.id.etCod);
        etPrice = (EditText) findViewById(R.id.etPrice);
    }

    public void query (View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String id = etCod.getText().toString();
        if (!id.isEmpty()) {
            Cursor fila = bd.rawQuery("select nombre, precio from articulos where codigo =" + id, null);
            if (fila.moveToFirst()) {
                etName.setText(fila.getString(0));
                etPrice.setText(fila.getString(1));
            } else {
                Toast.makeText(this, "El articulo con el codigo " + id + "no existe", Toast.LENGTH_SHORT).show();
            }
            bd.close();
        }else{
            Toast.makeText(this, "Código vacío", Toast.LENGTH_SHORT).show();
        }
    }

    public void update (View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String id = etCod.getText().toString();
        String name = etName.getText().toString();
        String price = etPrice.getText().toString();
        ContentValues fila = new ContentValues();
        fila.put("codigo", id);
        if(!name.isEmpty()){
            fila.put("nombre", name);
        }
        if (!price.isEmpty()){
            fila.put("precio", price);
        }
        int num = bd.update("articulos", fila, "codigo=" + id, null);
        bd.close();
        if (num == 1){
            Toast.makeText(this, "Se ha modificado el articulo código = "+id, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "No existe el articulo con codigo "+id, Toast.LENGTH_SHORT).show();
        }
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
