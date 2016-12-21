package com.example.hgmovil.intramovil.view;

import android.app.ProgressDialog;
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
import java.util.ArrayList;

public class MenuPago extends AppCompatActivity implements View.OnClickListener
{
    private Button btnVer;
    private TextView est1, est2, est3, est4, est5, est6, est7, est8,
            con1, con2, con3, con4, con5, con6, con7, con8,
            mon1, mon2, mon3, mon4, mon5, mon6, mon7, mon8,
            fech1, fech2, fech3, fech4, fech5, fech6, fech7, fech8;
    private String rutPago, nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_pago);
        rutPago = getIntent().getStringExtra("RuttMenu");
        nm= getIntent().getStringExtra("Nombre");


        btnVer = (Button) findViewById(R.id.btnVer);
        est1 = (TextView) findViewById(R.id.est1);
        est2 = (TextView) findViewById(R.id.est2);
        est3 = (TextView) findViewById(R.id.est3);
        est4 = (TextView) findViewById(R.id.est4);
        est5 = (TextView) findViewById(R.id.est5);
        est6 = (TextView) findViewById(R.id.est6);
        est7 = (TextView) findViewById(R.id.est7);
        est8 = (TextView) findViewById(R.id.est8);

        con1 = (TextView) findViewById(R.id.con1);
        con2 = (TextView) findViewById(R.id.con2);
        con3 = (TextView) findViewById(R.id.con3);
        con4 = (TextView) findViewById(R.id.con4);
        con5 = (TextView) findViewById(R.id.con5);
        con6 = (TextView) findViewById(R.id.con6);
        con7 = (TextView) findViewById(R.id.con7);
        con8 = (TextView) findViewById(R.id.con8);

        mon1 = (TextView) findViewById(R.id.mon1);
        mon2 = (TextView) findViewById(R.id.mon2);
        mon3 = (TextView) findViewById(R.id.mon3);
        mon4 = (TextView) findViewById(R.id.mon4);
        mon5 = (TextView) findViewById(R.id.mon5);
        mon6 = (TextView) findViewById(R.id.mon6);
        mon7 = (TextView) findViewById(R.id.mon7);
        mon8 = (TextView) findViewById(R.id.mon8);

        fech1 = (TextView) findViewById(R.id.fech1);
        fech2 = (TextView) findViewById(R.id.fech2);
        fech3 = (TextView) findViewById(R.id.fech3);
        fech4 = (TextView) findViewById(R.id.fech4);
        fech5 = (TextView) findViewById(R.id.fech5);
        fech6 = (TextView) findViewById(R.id.fech6);
        fech7 = (TextView) findViewById(R.id.fech7);
        fech8 = (TextView) findViewById(R.id.fech8);

        btnVer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        //CargarPago();
        BackGroundNota jj = new BackGroundNota();
        jj.execute(rutPago);

        est1.setText("");est2.setText("");est3.setText("");est4.setText("");est5.setText("");est6.setText("");est7.setText("");est8.setText("");
        fech1.setText("");fech2.setText("");fech3.setText("");fech4.setText("");fech5.setText("");fech6.setText("");fech7.setText("");fech8.setText("");
        con1.setText("");con2.setText("");con3.setText("");con4.setText("");con5.setText("");con6.setText("");con7.setText("");con8.setText("");
        mon1.setText("");mon2.setText("");mon3.setText("");mon4.setText("");mon5.setText("");mon6.setText("");mon7.setText("");mon8.setText("");
        Toast.makeText(getApplicationContext(), "Operación realizada...", Toast.LENGTH_SHORT).show();

    }

    public void CargarPago()
    {
        BDIntraMovil helper = new BDIntraMovil(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        helper.openDataBase();
        Cursor c = db.rawQuery("SELECT  estado, fechavenc, concepto, monto FROM pago as pg JOIN alumno as al ON pg.Alumno_Rut = al.Rut WHERE al.Rut='\"+rutPago+\"';", null);
        est1.setText("");est2.setText("");est3.setText("");est4.setText("");est5.setText("");est6.setText("");est7.setText("");est8.setText("");
        fech1.setText("");fech2.setText("");fech3.setText("");fech4.setText("");fech5.setText("");fech6.setText("");fech7.setText("");fech8.setText("");
        con1.setText("");con2.setText("");con3.setText("");con4.setText("");con5.setText("");con6.setText("");con7.setText("");con8.setText("");
        mon1.setText("");mon2.setText("");mon3.setText("");mon4.setText("");mon5.setText("");mon6.setText("");mon7.setText("");mon8.setText("");

        try
        {
            if(c.moveToFirst())
            {
                String estado1 = c.getString(0);
                String fecha1 = c.getString(1);
                String conce1 = c.getString(2);
                String monto1 = c.getString(3);

                est1.setText(estado1);
                fech1.setText(fecha1);
                con1.setText(conce1);
                mon1.setText("$"+monto1);

                if(c.moveToNext())
                {
                    String estado2 = c.getString(0);
                    String fecha2 = c.getString(1);
                    String conce2 = c.getString(2);
                    String monto2 = c.getString(3);

                    est2.setText(estado2);
                    fech2.setText(fecha2);
                    con2.setText(conce2);
                    mon2.setText("$"+monto2);

                    if(c.moveToNext())
                    {
                        String estado3 = c.getString(0);
                        String fecha3 = c.getString(1);
                        String conce3 = c.getString(2);
                        String monto3 = c.getString(3);

                        est3.setText(estado3);
                        fech3.setText(fecha3);
                        con3.setText(conce3);
                        mon3.setText("$"+monto3);

                        if (c.moveToNext())
                        {
                            String estado4 = c.getString(0);
                            String fecha4 = c.getString(1);
                            String conce4 = c.getString(2);
                            String monto4 = c.getString(3);

                            est4.setText(estado4);
                            fech4.setText(fecha4);
                            con4.setText(conce4);
                            mon4.setText("$"+monto4);

                            if (c.moveToNext())
                            {
                                String estado5 = c.getString(0);
                                String fecha5 = c.getString(1);
                                String conce5 = c.getString(2);
                                String monto5 = c.getString(3);

                                est5.setText(estado5);
                                fech5.setText(fecha5);
                                con5.setText(conce5);
                                mon5.setText("$"+monto5);

                                if (c.moveToNext()) {
                                    String estado6 = c.getString(0);
                                    String fecha6 = c.getString(1);
                                    String conce6 = c.getString(2);
                                    String monto6 = c.getString(3);

                                    est6.setText(estado6);
                                    fech6.setText(fecha6);
                                    con6.setText(conce6);
                                    mon6.setText("$"+monto6);

                                    if (c.moveToNext()) {
                                        String estado7 = c.getString(0);
                                        String fecha7 = c.getString(1);
                                        String conce7 = c.getString(2);
                                        String monto7 = c.getString(3);

                                        est7.setText(estado7);
                                        fech7.setText(fecha7);
                                        con7.setText(conce7);
                                        mon7.setText("$"+monto7);

                                        if (c.moveToNext()) {
                                            String estado8 = c.getString(0);
                                            String fecha8 = c.getString(1);
                                            String conce8 = c.getString(2);
                                            String monto8 = c.getString(3);

                                            est8.setText(estado8);
                                            fech8.setText(fecha8);
                                            con8.setText(conce8);
                                            mon8.setText("$"+monto8);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            c.close();
            helper.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            helper.close();
        }
    }
    class BackGroundNota extends AsyncTask<String, String, String>
    {

        @Override
        protected String doInBackground(String... params) {
            String rut1 = params[0];
            String data="";
            int tmp;

            try {
                URL url = new URL("http://www.hgmovil.cl/intramovil/pagos.php");
                String urlParams = "rut="+rut1;
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

                String estado1 = user_data1.getJSONObject(0).getString("estado");
                String fecha1 = user_data1.getJSONObject(0).getString("fecha");
                String conce1 = user_data1.getJSONObject(0).getString("concepto");
                String monto1 = user_data1.getJSONObject(0).getString("monto");

                est1.setText(estado1);
                fech1.setText(fecha1);
                con1.setText(conce1);
                mon1.setText("$"+monto1);


                    String estado2 = user_data1.getJSONObject(1).getString("estado");
                    String fecha2 = user_data1.getJSONObject(1).getString("fecha");
                    String conce2 = user_data1.getJSONObject(1).getString("concepto");
                    String monto2 = user_data1.getJSONObject(1).getString("monto");

                    est2.setText(estado2);
                    fech2.setText(fecha2);
                    con2.setText(conce2);
                    mon2.setText("$"+monto2);


                        String estado3 = user_data1.getJSONObject(2).getString("estado");
                        String fecha3 = user_data1.getJSONObject(2).getString("fecha");
                        String conce3 = user_data1.getJSONObject(2).getString("concepto");
                        String monto3 = user_data1.getJSONObject(2).getString("monto");

                        est3.setText(estado3);
                        fech3.setText(fecha3);
                        con3.setText(conce3);
                        mon3.setText("$"+monto3);

                        String estado4 = user_data1.getJSONObject(3).getString("estado");
                            String fecha4 = user_data1.getJSONObject(3).getString("fecha");
                            String conce4 = user_data1.getJSONObject(3).getString("concepto");
                            String monto4 = user_data1.getJSONObject(3).getString("monto");

                            est4.setText(estado4);
                            fech4.setText(fecha4);
                            con4.setText(conce4);
                            mon4.setText("$"+monto4);


                                String estado5 = user_data1.getJSONObject(4).getString("estado");
                                String fecha5 = user_data1.getJSONObject(4).getString("fecha");
                                String conce5 = user_data1.getJSONObject(4).getString("concepto");
                                String monto5 = user_data1.getJSONObject(4).getString("monto");

                                est5.setText(estado5);
                                fech5.setText(fecha5);
                                con5.setText(conce5);
                                mon5.setText("$"+monto5);


                                    String estado6 = user_data1.getJSONObject(5).getString("estado");
                                    String fecha6 =user_data1.getJSONObject(5).getString("fecha");
                                    String conce6 = user_data1.getJSONObject(5).getString("concepto");
                                    String monto6 = user_data1.getJSONObject(5).getString("monto");

                                    est6.setText(estado6);
                                    fech6.setText(fecha6);
                                    con6.setText(conce6);
                                    mon6.setText("$" + monto6);


                                    String estado7 = user_data1.getJSONObject(6).getString("estado");
                                    String fecha7 = user_data1.getJSONObject(6).getString("fecha");
                                    String conce7 = user_data1.getJSONObject(6).getString("concepto");
                                    String monto7 = user_data1.getJSONObject(6).getString("monto");

                                    est7.setText(estado7);
                                    fech7.setText(fecha7);
                                    con7.setText(conce7);
                                    mon7.setText("$" + monto7);


                                    String estado8 = user_data1.getJSONObject(7).getString("estado");
                                    String fecha8 = user_data1.getJSONObject(7).getString("fecha");
                                    String conce8 = user_data1.getJSONObject(7).getString("concepto");
                                    String monto8 = user_data1.getJSONObject(7).getString("monto");

                                    est8.setText(estado8);
                                    fech8.setText(fecha8);
                                    con8.setText(conce8);
                                    mon8.setText("$" + monto8);




            } catch (JSONException e) {
                e.printStackTrace();

            }
            catch (Exception f)
            {
                f.printStackTrace();
            }
        }
    }

    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(MenuPago.this, com.example.hgmovil.intramovil.view.Menu.class);
        i.putExtra("Nomb", nm);
        i.putExtra("Rutt", rutPago);
        startActivity(i);
    }
}
