package com.example.hgmovil.intramovil.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hgmovil.intramovil.R;
import com.example.hgmovil.intramovil.modeloDAO.MateriaDAO;
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

public class MenuMat extends AppCompatActivity implements View.OnClickListener
{
    private Button btnMat1;
    private Spinner spnMat1;
    private ArrayAdapter adapter;
    private String ry, nm;
    private TextView url;
    Context conte = this;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_mat);
        ry = getIntent().getStringExtra("RuttMenu");
        nm= getIntent().getStringExtra("Nombre");
        BackGroundMAt b = new BackGroundMAt();
        b.execute(ry);

        //insertarasig(ry);

        btnMat1 = (Button) findViewById(R.id.btnMat);
        spnMat1 = (Spinner) findViewById(R.id.spnMat);
        url = (TextView) findViewById(R.id.txtUrl);

        btnMat1.setOnClickListener(this);






    }


    @Override
    public void onClick(View v)
    {
        //cargarMat();

        Toast.makeText(getApplicationContext(), "Operación realizada...", Toast.LENGTH_SHORT).show();
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
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(MenuMat.this, com.example.hgmovil.intramovil.view.Menu.class);
        i.putExtra("Nomb", nm);
        i.putExtra("Rutt", ry);
        startActivity(i);
    }
    public void insertarasig(String rut)
    {
        try
        {
        String Rut = rut;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
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
                spnMat1.setAdapter(adapter);

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