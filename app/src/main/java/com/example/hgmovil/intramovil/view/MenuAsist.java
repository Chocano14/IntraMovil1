package com.example.hgmovil.intramovil.view;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.hgmovil.intramovil.R;
import com.example.hgmovil.intramovil.sqlite.BDIntraMovil;

import java.util.ArrayList;

public class MenuAsist extends AppCompatActivity implements View.OnClickListener {
    private Spinner spnenr;
    private String ry;
    private ArrayAdapter adapter;
    private TextView totalhAsig,totalhAsistidas,porcentaje;
    private Button btnes;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_asist);
        ry = getIntent().getStringExtra("RuttMenu");
        spnenr = (Spinner) findViewById(R.id.spnAsis);
        btnes=(Button)findViewById(R.id.btnAsist);

        totalhAsig=(TextView)findViewById(R.id.txtTHAsig);
        totalhAsistidas=(TextView)findViewById(R.id.txtTHAsis);
        porcentaje=(TextView)findViewById(R.id.txtPDA);

        btnes.setOnClickListener(this);
        ArrayList<String> emp = listadoAsigxCarrera2();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, emp);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnenr.setAdapter(adapter);






    }
    public void onClick(View v)
    {
        TotalHoras();

    }
    public  void TotalHoras()
    {
        String asignaturaSelec = spnenr.getSelectedItem().toString();
        BDIntraMovil helper = new BDIntraMovil(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        helper.openDataBase();
        Cursor c = db.rawQuery("SELECT Horas FROM asignatura WHERE Nombre='" +asignaturaSelec + "';", null);
        try {
            if (c.moveToFirst())
            {

                String horasig = c.getString(0);
                totalhAsig.setText(horasig);

            }
            c.close();
            helper.close();
        }catch (Exception ex)
        {
            ex.printStackTrace();
            helper.close();
        }
    }
    public void HorasAsis()
    {
        String asignaturaSelec = spnenr.getSelectedItem().toString();
        BDIntraMovil helper = new BDIntraMovil(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        helper.openDataBase();
        Cursor c = db.rawQuery("SELECT SUM(asis.HorasAsist)\n" +
                "FROM asistencia as asis\n" +
                "JOIN alumno as alum\n" +
                "ON asis.Alumno_Rut = alum.Rut\n" +
                "JOIN alumno_has_seccion as ahs\n" +
                "ON alum.RUT = ahs.Alumno_Rut\n" +
                "JOIN seccion as sec\n" +
                "ON ahs.Seccion_Id = sec.Id\n" +
                "JOIN asignatura as asig\n" +
                "ON sec.Asignatura_Id = asig.Id\n" +
                "WHERE alum.Rut = '" +ry + "'asig.Nombre ='"+asignaturaSelec +"';", null);
        try {
            if (c.moveToFirst())
            {

                int horas = c.getInt(0);
                totalhAsistidas.setText(horas);

            }
            c.close();
            helper.close();
        }catch (Exception ex)
        {
            ex.printStackTrace();
            helper.close();
        }

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
}
