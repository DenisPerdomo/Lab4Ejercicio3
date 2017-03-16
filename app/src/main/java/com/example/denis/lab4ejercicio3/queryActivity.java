package com.example.denis.lab4ejercicio3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class queryActivity extends AppCompatActivity {
    private EditText etCod;
    private TextView txtName, txtPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        etCod = (EditText)findViewById(R.id.etCod);
        txtName = (TextView) findViewById(R.id.txtName);
        txtPrice = (TextView) findViewById(R.id.txtPrice);
    }

    public void query (View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String id = etCod.getText().toString();
        if (!id.isEmpty()) {
            Cursor fila = bd.rawQuery("select nombre, precio from articulos where codigo =" + id, null);
            if (fila.moveToFirst()) {
                txtName.setText(fila.getString(0));
                txtPrice.setText(fila.getString(1));
            } else {
                Toast.makeText(this, "El articulo con el codigo " + id + "no existe", Toast.LENGTH_SHORT).show();
            }
            bd.close();
        }else{
            Toast.makeText(this, "Código vacío", Toast.LENGTH_SHORT).show();
        }
    }

    public void clean (View v){
        etCod.setText("");
        txtName.setText("");
        txtPrice.setText("");
    }

    public void back (View v){
        finish();
    }
}
