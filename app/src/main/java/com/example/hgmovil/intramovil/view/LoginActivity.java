package com.example.hgmovil.intramovil.view;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import com.example.hgmovil.intramovil.R;
import com.example.hgmovil.intramovil.sqlite.BDIntraMovil;

public class LoginActivity extends AppCompatActivity
{
    EditText txRut, txPass;
    private Cursor fila;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txRut = (EditText) findViewById(R.id.txtRut);
        txPass = (EditText) findViewById(R.id.txtContra);
    }

    public void ingresar (View v)
    {
        BDIntraMovil admin = new BDIntraMovil(this);
        SQLiteDatabase db = admin.getReadableDatabase();
        admin.openDataBase();

        String user = txRut.getText().toString();
        String contra = txPass.getText().toString();

        try
        {
            if(v.getId() == R.id.btnIniciar)
            {

                fila = db.rawQuery("select rut, contraseña from alumno where rut='"+user+"' and contraseña='"+contra+"'", null);
                if (fila.moveToFirst()) {
                    String usua = fila.getString(0);
                    String pass = fila.getString(1);

                    if (user.equals(usua) && contra.equals(pass)) {
                        Intent i = new Intent(LoginActivity.this, com.example.hgmovil.intramovil.view.Menu.class);
                        startActivity(i);
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        }
        catch (Exception ex)
                {
                    Toast.makeText(getApplicationContext(), "Error en busqueda", Toast.LENGTH_SHORT).show();
                    ex.printStackTrace();
                    admin.close();
                }

    }
}





