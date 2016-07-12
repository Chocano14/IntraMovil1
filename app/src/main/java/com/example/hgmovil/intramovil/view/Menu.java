package com.example.hgmovil.intramovil.view;

import android.content.Intent;
        import android.os.Bundle;
        import android.provider.ContactsContract;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hgmovil.intramovil.R;

/**
 * Created by pablo on 27-04-2016.
 */
public class Menu extends AppCompatActivity
{
    private ImageButton BtnNot;
    private ImageButton BtnAsis;
    private ImageButton BtnHora;
    private ImageButton BtnCorr;
    private ImageButton BtnBusc;
    private ImageButton BtnAlarm;
    private ImageButton BtnREsumen;
    private ImageButton BtnPag;
    private ImageButton BtnMat;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        BtnNot = (ImageButton) findViewById(R.id.BtnNotas);
        String nom = getIntent().getStringExtra("Nomb");

        TextView tv = (TextView)findViewById(R.id.txtUser);
        tv.setText(nom);


        BtnNot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menunotas = new Intent(Menu.this, MenuNot.class);
                startActivity(menunotas);
                PasarvarMenunot();
            }
        });

        BtnAsis = (ImageButton) findViewById(R.id.BtnAsistencia);

        BtnAsis.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                Intent menuasis = new Intent(Menu.this, MenuAsist.class);
                startActivity(menuasis);
                PasarvarMenuasit();
            }
        });

        /*BtnHora =(ImageButton) findViewById(R.id.BtnHorario);

        BtnHora.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                Intent formnuevo1 = new Intent(MenuPrincipal.this, MenuHora.class);
                startActivity(formnuevo1);
            }
        });
        BtnCorr = (ImageButton) findViewById(R.id.BtnCorreos);
        BtnCorr.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                Intent formnuevo2 = new Intent(MenuPrincipal.this, MenuCorr.class);
                startActivity(formnuevo2);
            }
        });
        BtnBusc = (ImageButton) findViewById(R.id.BtnBusquet);
        BtnBusc.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                Intent formnuevo3 = new Intent(MenuPrincipal.this, MenuBusque.class);
                startActivity(formnuevo3);
            }
        });
        BtnAlarm = (ImageButton) findViewById(R.id.BtnAlam);
        BtnAlarm.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                Intent formnuevo4 = new Intent(MenuPrincipal.this, MenuAlarm.class);
                startActivity(formnuevo4);
            }
        });
        BtnREsumen = (ImageButton) findViewById(R.id.BtnResAc);
        BtnREsumen.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                Intent formnuevo5 = new Intent(MenuPrincipal.this, MenuResumen.class);
                startActivity(formnuevo5);
            }
        });
        BtnPag = (ImageButton) findViewById(R.id.BtnPag);
        BtnPag.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                Intent formnuevo6 = new Intent(MenuPrincipal.this, MenuPagos.class);
                startActivity(formnuevo6);
            }
        });
        BtnMat = (ImageButton) findViewById(R.id.BtnMateriales);
        BtnMat.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                Intent formnuevo7 = new Intent(MenuPrincipal.this, Menu_Materiales.class);
                startActivity(formnuevo7);
            }
        });*/
    }
    public void PasarvarMenunot()
    {
        String rt = getIntent().getStringExtra("Rutt");
        Intent rt2 = new Intent(this, MenuNot.class);
        rt2.putExtra("RuttMenu", rt);
        startActivity(rt2);

    }
    public void PasarvarMenuasit()
    {
        String rt = getIntent().getStringExtra("Rutt");
        Intent rt2 = new Intent(this, MenuAsist.class);
        rt2.putExtra("RuttMenu", rt);
        startActivity(rt2);

    }
}
