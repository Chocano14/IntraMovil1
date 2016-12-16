package com.example.hgmovil.intramovil.view;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hgmovil.intramovil.R;
import com.example.hgmovil.intramovil.sqlite.BDIntraMovil;

import java.util.ArrayList;

public class MenuSala extends AppCompatActivity implements View.OnClickListener
{
    private Button btn;
    private Spinner spn;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_sala);

        btn = (Button) findViewById(R.id.btnBusqueda);
        spn = (Spinner) findViewById(R.id.spnSala);


        ArrayList<String> emp = ListaSala();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, emp);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        cargaSala();
        Toast.makeText(getApplicationContext(), "Operación realizada...", Toast.LENGTH_SHORT).show();

    }

    public void cargaSala()
    {
        BDIntraMovil helper = new BDIntraMovil(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        String ss = spn.getSelectedItem().toString();
        helper.openDataBase();
        Cursor c = db.rawQuery("SELECT Nombre FROM sala WHERE Nombre='" +ss + "';", null);
        try
        {
            if (c.moveToFirst())
            {
                String pi = c.getString(0);
                if (pi.equals("Sala A1"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sa1);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala A2"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sa2);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala A3"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sa3);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala A4"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sa4);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala A5"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sa5);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala A6"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sa6);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala A7"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sa7);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala A8"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sa8);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala A9"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sa9);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala A10"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sa10);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala A11"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.s11);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala A12"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.s12);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala A13"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.s11);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala B1"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sb1);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala B2"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sb2);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala B3"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sb3);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala B4"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sb4);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala B5"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sb5);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala B6"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sb6);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala B7"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sb7);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala B8"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sb8);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala B9"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sb9);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala B10"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sb10);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala B11"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sb11);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala B12"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sb12);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala B13"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sb13);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Laboratorio PG01"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.lbpg01);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Laboratorio TC3"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.lbtc3);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala C1"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sc1);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala C2"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sc2);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala C4"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sc3);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala C4"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sc4);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala C5"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sc5);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala C6"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sc6);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala C7"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sc7);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala C8"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sc8);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala C9"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sc9);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala C10"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sc10);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala C11"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sc11);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala C12"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sc12);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala C13"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sc13);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala D1"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sd1);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
                }
                if (pi.equals("Sala F1"))
                {
                    Matrix matrix = new Matrix();
                    matrix.postRotate(90.0f);
                    Bitmap original = BitmapFactory.decodeResource(getResources(), R.drawable.sf1);
                    Bitmap rotatedBitmap = Bitmap.createBitmap(original, 0, 0, original.getWidth(), original.getHeight(), matrix, true);
                    ImageView imgRotate = (ImageView) findViewById(R.id.MapaSala);
                    imgRotate.setImageBitmap(rotatedBitmap);
                    imgRotate.setVisibility(View.VISIBLE);
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

    public ArrayList<String> ListaSala()
    {
        BDIntraMovil helper = new BDIntraMovil(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        ArrayList<String> dev = null;
        try{
            helper.openDataBase();
            dev = new ArrayList<String>();
            Cursor c = db.rawQuery("SELECT nombre FROM sala ORDER BY nombre ASC", null);
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

