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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hgmovil.intramovil.R;
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
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MenuAsist extends AppCompatActivity implements View.OnClickListener
{
    private Spinner spnenr;
    private String ry, nm;
    private ArrayAdapter adapter;
    private TextView totalhAsig,totalhAsistidas,porcentaje;
    private Button btnes;
    public String horas;
    public String horasig;
    public double horalum,horasaisg,total;
    public int horalum1,horasaisg1,total1;
    public String totalentrgar;
    Context conte = this;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_asist);
        ry = getIntent().getStringExtra("RuttMenu");
        nm= getIntent().getStringExtra("Nombre");

        spnenr = (Spinner) findViewById(R.id.spnAsis);
        BackGroundMAt b = new BackGroundMAt();
        b.execute(ry);

        btnes=(Button)findViewById(R.id.btnAsist);

        totalhAsig=(TextView)findViewById(R.id.txtTHAsig);
        totalhAsistidas=(TextView)findViewById(R.id.txtTHAsis);
        porcentaje=(TextView)findViewById(R.id.txtPDA);

        btnes.setOnClickListener(this);
    }
    public void onClick(View v)
    {
        String asignaturaSelec = spnenr.getSelectedItem().toString();
        //TotalHoras();

        BackGroundtotalhoras totales = new BackGroundtotalhoras();
        totales.execute(asignaturaSelec);

        BackGroundHorasasis horas = new BackGroundHorasasis();
         horas.execute(asignaturaSelec,ry);

        //HorasAsis();

        //porcentajecom();
        
        totalhAsig.setText("");totalhAsistidas.setText("");porcentaje.setText("");
        Toast.makeText(getApplicationContext(), "Operación realizada...", Toast.LENGTH_SHORT).show();

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

                horasig = c.getString(0);
                totalhAsig.setText(horasig+" HRS");


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
        Cursor c = db.rawQuery("SELECT sum(asis.HorasAsist)\n" +
                "FROM asistencia as asis\n" +
                "JOIN alumno_has_Seccion as ahs\n" +
                "ON asis.Alumno_has_Seccion_Id = ahs.Id\n" +
                "JOIN alumno as alum\n" +
                "ON ahs.Alumno_Rut = alum.Rut\n" +
                "JOIN seccion as sec\n" +
                "ON ahs.Seccion_Id = sec.Id\n" +
                "JOIN asignatura as asig\n" +
                "ON sec.Asignatura_Id = asig.Id\n" +
                "WHERE alum.Rut = '" +ry + "'and asig.Nombre ='"+asignaturaSelec +"';", null);
        try {
            if (c.moveToFirst())
            {
                horas = c.getString(0);
                if (c.isNull(0))
                {
                    totalhAsistidas.setText("0 HRS");
                }
                else {
                    totalhAsistidas.setText(horas+" HRS");
                }
            }
            c.close();
            helper.close();
        }catch (Exception ex)
        {
            ex.printStackTrace();
            helper.close();
        }

    }
    public void porcentajecom()
    {
        if (horas == null)
        {
            porcentaje.setText("0%");
        }
        else
        {
    horalum = Double.parseDouble(horas.trim());
    horasaisg = Double.parseDouble(horasig.trim());
    total = horalum * 100 / horasaisg;
    totalentrgar = String.valueOf(total);
    DecimalFormat df = new DecimalFormat("#.#");
    porcentaje.setText(String.valueOf(Double.valueOf(df.format(total))) + "%");

    }


    }
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(MenuAsist.this, com.example.hgmovil.intramovil.view.Menu.class);
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
                spnenr.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();

            }
            catch (Exception f)
            {
                f.printStackTrace();
            }
        }
    }
    class BackGroundHorasasis extends AsyncTask<String, String, String>
    {

        @Override
        protected String doInBackground(String... params) {
            String asigna = params[0];
            String rut1 = params[1];
            String data="";
            int tmp;

            try {
                URL url = new URL("http://www.hgmovil.cl/intramovil/horasasistidas.php");
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
                int nn=0;
                for (int i = 0; i < user_data1.length(); i++)
                {
                    String noms = user_data1.getJSONObject(i).getString("total2");
                    nn=nn+Integer.parseInt(noms.trim());
                }

                String haras1 = String.valueOf(nn);

                if (haras1.equals("")||haras1.equals(null))
                {
                    totalhAsistidas.setText("0 HRS");
                }
                else
                {
                    totalhAsistidas.setText(haras1+" HRS");
                    if (haras1 =="0")
                    {
                        porcentaje.setText("0%");
                    }
                    else {
                        String hh;
                        String[] h1;
                        horalum = Double.parseDouble(haras1);
                        hh = totalhAsig.getText().toString();
                        h1 = hh.split(" ");
                        String hor=h1[0];


                       int horasaisg1 = Integer.parseInt(hor.trim());

                        total = horalum * 100 / horasaisg1;
                        totalentrgar = String.valueOf(total);
                        DecimalFormat df = new DecimalFormat("#.#");
                        String bb = df.format(total);
                        String mm= String.valueOf(bb);
                        porcentaje.setText(mm + "%");
                    }


                }



            } catch (JSONException e) {
                e.printStackTrace();

            }
            catch (Exception f)
            {
                f.printStackTrace();
            }
        }
    }
    class BackGroundtotalhoras extends AsyncTask<String, String, String>
    {

        @Override
        protected String doInBackground(String... params) {
            String asigna = params[0];
            String data="";
            int tmp;

            try {
                URL url = new URL("http://www.hgmovil.cl/intramovil/total.php");
                String urlParams = "asig="+asigna;
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


                String horasig  = user_data1.getJSONObject(0).getString("total");
                totalhAsig.setText(horasig+" HRS");



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

