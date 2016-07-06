package com.example.hgmovil.intramovil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hgmovil.intramovil.modelo.AsignaturaDAO;
import com.example.hgmovil.intramovil.sqlite.OperacionesBaseDatos;

public class LoginActivity extends AppCompatActivity
{
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn = (Button) findViewById(R.id.btn);




    }
    public void onClick(View v)
    {
        try
        {
            AsignaturaDAO Op = new AsignaturaDAO(this);
            Op.insertar("Juan Zamorano","22");
            Toast t =  Toast.makeText(getApplicationContext(),"si se pudo",Toast.LENGTH_LONG);
            t.show();



        }
        catch(Exception e)
        {
            Toast t =  Toast.makeText(getApplicationContext(),"si nose pudo",Toast.LENGTH_LONG);
            t.show();

        }




    }


}


