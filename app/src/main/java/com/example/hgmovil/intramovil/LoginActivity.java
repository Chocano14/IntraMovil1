package com.example.hgmovil.intramovil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity
{

    protected void onCreate(Bundle savedInstanceState)
    {super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button boton = (Button) findViewById(R.id.btnIniciar);
        final EditText Contraseña = (EditText) findViewById(R.id.txtContra);
        final EditText Rut = (EditText)findViewById(R.id.txtRut);

        boton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String usuario=Rut.getText().toString();
                String passw=Contraseña.getText().toString();







            }
        });
    }
}





