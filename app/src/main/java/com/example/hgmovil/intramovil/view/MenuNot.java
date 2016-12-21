package com.example.hgmovil.intramovil.view;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hgmovil.intramovil.R;
import com.example.hgmovil.intramovil.modeloDAO.AsignaturaDAO;
import com.example.hgmovil.intramovil.sqlite.BDIntraMovil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MenuNot extends AppCompatActivity implements View.OnClickListener
{
    private Button btn;
    private Spinner spn;
    public TextView Nota,Nota1,Nota2,Nota3,Nota4,Nota5,Nota6,nomn;
    private TextView Ponderacion,Ponderacion1,Ponderacion2,Ponderacion3,Ponderacion4,Ponderacion5,Ponderacion6;
    private TextView Fecha,Fecha1,Fecha2,Fecha3,Fecha4,Fecha5,Fecha6;
    private String ry, nm;
    Context conte = this;

    private ArrayAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_not);
        ry = getIntent().getStringExtra("RuttMenu");
        nm= getIntent().getStringExtra("Nombre");

        btn = (Button) findViewById(R.id.btn);
        spn = (Spinner) findViewById(R.id.spnAsig);
        MenuNot.BackGroundMAt b = new MenuNot.BackGroundMAt();
        b.execute(ry);


        //listNot = (ListView)findViewById(R.id.lv);

        Nota = (TextView) findViewById(R.id.txtNota);
        Ponderacion = (TextView) findViewById(R.id.txtPon);
        Fecha = (TextView) findViewById(R.id.txtFecha);

        Nota1 = (TextView) findViewById(R.id.txtNota1);
        Ponderacion1 = (TextView) findViewById(R.id.txtPon1);
        Fecha1 = (TextView) findViewById(R.id.txtFecha1);

        Nota2 = (TextView) findViewById(R.id.txtNota2);
        Ponderacion2 = (TextView) findViewById(R.id.txtPon2);
        Fecha2 = (TextView) findViewById(R.id.txtFecha2);

        Nota3 = (TextView) findViewById(R.id.txtNota3);
        Ponderacion3 = (TextView) findViewById(R.id.txtPon3);
        Fecha3 = (TextView) findViewById(R.id.txtFecha3);

        Nota4 = (TextView) findViewById(R.id.txtNota4);
        Ponderacion4 = (TextView) findViewById(R.id.txtPon4);
        Fecha4 = (TextView) findViewById(R.id.txtFecha4);

        Nota5 = (TextView) findViewById(R.id.txtNota5);
        Ponderacion5 = (TextView) findViewById(R.id.txtPon5);
        Fecha5 = (TextView) findViewById(R.id.txtFecha5);

        Nota6 = (TextView) findViewById(R.id.txtNota6);
        Ponderacion6 = (TextView) findViewById(R.id.txtPon6);
        Fecha6 = (TextView) findViewById(R.id.txtFecha6);

        btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v)

    {
        String asignaturaSelec = spn.getSelectedItem().toString();
        BackGroundNota no = new BackGroundNota();
        no.execute(asignaturaSelec,ry);
        //cargar();
        Nota.setText("");Nota1.setText("");Nota2.setText("");Nota3.setText("");Nota4.setText("");Nota5.setText("");Nota6.setText("");
        Ponderacion.setText("");Ponderacion1.setText("");Ponderacion2.setText("");;Ponderacion3.setText("");Ponderacion4.setText("");;Ponderacion5.setText("");Ponderacion6.setText("");
        Fecha.setText("");Fecha1.setText("");Fecha2.setText("");;Fecha3.setText("");Fecha4.setText("");;Fecha5.setText("");Fecha6.setText("");

        Toast.makeText(getApplicationContext(), "Operación realizada...", Toast.LENGTH_SHORT).show();



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
                    "WHERE alum.Rut='"+ry+"'ORDER BY a.Nombre ASC", null);
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

    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(MenuNot.this, com.example.hgmovil.intramovil.view.Menu.class);
        i.putExtra("Nomb", nm);
        i.putExtra("Rutt", ry);
        startActivity(i);
    }
    class BackGroundMAt extends AsyncTask<String, String, String>
    {

        @Override
        protected String doInBackground(String... params) {
            String rut1 = params[0];
            String data="";
            int tmp;

            try {
                URL url = new URL("http://www.hgmovil.cl/intramovil/asignatura.php");
                String urlParams = "name="+rut1;
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                os.write(urlParams.getBytes());
                os.flush();
                os.close();

                InputStream is = httpURLConnection.getInputStream();
                while((tmp=is.read())!=-1){
                    data+= (char)tmp;
                }

                is.close();
                httpURLConnection.disconnect();

                return data;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "Exception: "+e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "Exception: "+e.getMessage();
            }
        }
        @Override
        protected void onPostExecute(String s)
        {

            try {

                JSONObject root = new JSONObject(s);
                JSONArray user_data1 = root.getJSONArray("lista");
                ArrayList<String> emp= new ArrayList<>();
                for (int i = 0; i < user_data1.length(); i++)
                {
                    String noms = user_data1.getJSONObject(i).getString("nombre");


                    emp.add(noms);
                }

                adapter = new ArrayAdapter<>(conte, android.R.layout.simple_list_item_1, emp);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spn.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();

            }
            catch (Exception f)
            {
                f.printStackTrace();
            }
        }
    }
    class BackGroundNota extends AsyncTask<String, String, String>
    {

        @Override
        protected String doInBackground(String... params) {
            String asigna = params[0];
            String rut1 = params[1];
            String data="";
            int tmp;

            try {
                URL url = new URL("http://www.hgmovil.cl/intramovil/notas.php");
                String urlParams = "asig="+asigna+"&rut="+rut1;
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                os.write(urlParams.getBytes());
                os.flush();
                os.close();

                InputStream is = httpURLConnection.getInputStream();
                while((tmp=is.read())!=-1){
                    data+= (char)tmp;
                }

                is.close();
                httpURLConnection.disconnect();

                return data;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "Exception: "+e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "Exception: "+e.getMessage();
            }
        }
        @Override
        protected void onPostExecute(String s)
        {

            try {

                JSONObject root = new JSONObject(s);
                JSONArray user_data1 = root.getJSONArray("lista");


                    String nota1 = user_data1.getJSONObject(0).getString("nota");
                    String ponderacion1 = user_data1.getJSONObject(0).getString("ponderacion");
                    String fecha1 = user_data1.getJSONObject(0).getString("fecha");;

                    Nota1.setText(nota1);
                    Ponderacion1.setText(ponderacion1+"%");
                    Fecha1.setText(fecha1);
                     String nota2 = user_data1.getJSONObject(1).getString("nota");
                        String ponderacion2 = user_data1.getJSONObject(1).getString("ponderacion");
                        String fecha2 = user_data1.getJSONObject(1).getString("fecha");

                        Nota2.setText(nota2);
                        Ponderacion2.setText(ponderacion2+"%");
                        Fecha2.setText(fecha2);

                            String nota3 = user_data1.getJSONObject(2).getString("nota");
                            String ponderacion3 = user_data1.getJSONObject(2).getString("ponderacion");
                            String fecha3 = user_data1.getJSONObject(2).getString("fecha");

                            Nota3.setText(nota3);
                            Ponderacion3.setText(ponderacion3+"%");
                            Fecha3.setText(fecha3);

                                String nota4 = user_data1.getJSONObject(3).getString("nota");
                                String ponderacion4 = user_data1.getJSONObject(3).getString("ponderacion");
                                String fecha4 = user_data1.getJSONObject(3).getString("fecha");

                                Nota4.setText(nota4);
                                Ponderacion4.setText(ponderacion4+"%");
                                Fecha4.setText(fecha4);

                                    String nota5 = user_data1.getJSONObject(4).getString("nota");
                                    String ponderacion5 = user_data1.getJSONObject(4).getString("ponderacion");
                                    String fecha5 = user_data1.getJSONObject(4).getString("fecha");

                                    Nota5.setText(nota5);
                                    Ponderacion5.setText(ponderacion5+"%");
                                    Fecha5.setText(fecha5);

                                        String nota6 = user_data1.getJSONObject(5).getString("nota");
                                        String ponderacion6 = user_data1.getJSONObject(5).getString("ponderacion");
                                        String fecha6 = user_data1.getJSONObject(5).getString("fecha");
                                        Nota6.setText(nota6);
                                        Ponderacion6.setText(ponderacion6+"%");
                                        Fecha6.setText(fecha6);












            } catch (JSONException e) {
                e.printStackTrace();

            }
            catch (Exception f)
            {
                f.printStackTrace();
            }
        }
    }
}
