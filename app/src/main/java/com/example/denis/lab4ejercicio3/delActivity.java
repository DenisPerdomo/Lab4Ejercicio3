package com.example.denis.lab4ejercicio3;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class delActivity extends AppCompatActivity {
    private EditText etCod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del);
        etCod = (EditText) findViewById(R.id.etCod);
    }

    public void del (View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String id = etCod.getText().toString();
        int num = bd.delete("articulos", "codigo="+id, null);
        bd.close();
        etCod.setText("");
        if (num == 1){
            Toast.makeText(this, "Se ha eliminado el articulo código = "+id, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "No existe el articulo con codigo "+id, Toast.LENGTH_SHORT).show();
        }
    }
    public void clean (View v){
        etCod.setText("");
    }

    public void back (View v){
        finish();
    }
}
