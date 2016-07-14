package com.example.hgmovil.intramovil.view;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.hgmovil.intramovil.R;
import com.example.hgmovil.intramovil.sqlite.BDIntraMovil;

import java.util.ArrayList;

public class MenuMat extends AppCompatActivity implements View.OnClickListener
{
    private Button btnMat1;
    private Spinner spnMat1;
    private ArrayAdapter adapter;
    private String ry;
    private TextView url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_mat);
        ry = getIntent().getStringExtra("RuttMenu");

        btnMat1 = (Button) findViewById(R.id.btnMat);
        spnMat1 = (Spinner) findViewById(R.id.spnMat);
        url = (TextView) findViewById(R.id.txtUrl);

        btnMat1.setOnClickListener(this);

        ArrayList<String> emp = listadoAsigxCarrera2();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, emp);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnMat1.setAdapter(adapter);
    }


    @Override
    public void onClick(View v)
    {
        cargarMat();
    }

    public ArrayList<String> listadoAsigxCarrera2()
    {
        BDIntraMovil helper = new BDIntraMovil(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        ArrayList<String> dev = null;
        try{
            helper.openDataBase();
            dev = new ArrayList<String>();
            Cursor c = db.rawQuery("SELECT a.Nombre\n" +
                    "FROM asignatura as a\n" +
                    "JOIN seccion as sec\n" +
                    "ON a.Id=sec.Asignatura_Id\n" +
                    "JOIN Alumno_has_Seccion as ahs\n" +
                    "ON sec.Id= ahs.Seccion_Id\n" +
                    "JOIN Alumno as alum\n" +
                    "ON ahs.Alumno_Rut = alum.Rut\n" +
                    "WHERE alum.Rut='"+ry+"'", null);
            if (c.moveToFirst()) {
                do {
                    String nombre = c.getString(0);
                    dev.add(nombre);
                } while(c.moveToNext());
            }
            c.close();
            helper.close();

        }catch(Exception ex){
            ex.printStackTrace();
            helper.close();
            return null;
        }
        return dev;
    }
    public void cargarMat()
    {

        String asignaturaSelec = spnMat1.getSelectedItem().toString();
        BDIntraMovil helper = new BDIntraMovil(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        helper.openDataBase();
        Cursor c = db.rawQuery("SELECT mat.Archivo \n" +
                "FROM material as mat\n" +
                "JOIN asignatura as asig\n" +
                "ON mat.Asignatura_Id = asig.Id\n" +
                "WHERE asig.Nombre ='"+asignaturaSelec+"'", null);
        if(c.moveToNext())
        {
            String mat = c.getString(0);

            url.setText(Html.fromHtml("Guia de "

                    + "<a href=" + mat + ">Ejercicio</a>"));
            url.setMovementMethod(LinkMovementMethod.getInstance());

        }

    }
}