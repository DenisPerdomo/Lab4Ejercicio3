package com.example.denis.lab4ejercicio3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class queryAllActivity extends AppCompatActivity {
    private TextView txtQueryAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_all);
        txtQueryAll = (TextView) findViewById(R.id.txtQueryAll);
        //Consulta base de datos.
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery("select codigo, nombre, precio from articulos",null);
        if(fila.moveToFirst()){
            do {
                String id = fila.getString(0);
                String name = fila.getString(1);
                String price = fila.getString(2);
                txtQueryAll.append(id +"---"+ name +"---"+price+"\n");
            }while(fila.moveToNext());
        }
        bd.close();
    }

    public void back (View v){
        finish();
    }
}
