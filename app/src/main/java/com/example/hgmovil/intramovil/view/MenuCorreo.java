package com.example.hgmovil.intramovil.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.hgmovil.intramovil.R;

public class MenuCorreo extends AppCompatActivity {

    private ImageButton btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_correo);

        btnEnviar = (ImageButton) findViewById(R.id.BtnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                Intent formnuevo1 = new Intent(MenuCorreo.this, EnviarCorreo.class);
                startActivity(formnuevo1);
                PasarvarCorreo();
            }
        });
    }
    public void PasarvarCorreo()
    {
        String rt = getIntent().getStringExtra("RuttMenu");
        Intent rt2 = new Intent(this, EnviarCorreo.class);
        rt2.putExtra("Rutt", rt);
        startActivity(rt2);
    }
}
