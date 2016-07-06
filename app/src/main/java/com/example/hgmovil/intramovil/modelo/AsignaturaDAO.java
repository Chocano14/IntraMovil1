package com.example.hgmovil.intramovil.modelo;

import android.content.ContentValues;
import android.content.Context;

import com.example.hgmovil.intramovil.sqlite.BDIntraMovil;

/**
 * Created by pablo on 05-07-2016.
 */
public class AsignaturaDAO extends BDIntraMovil
{

    String tabla = "asignatura";

    public AsignaturaDAO(Context context)
    {
        super(context);
    }
    public boolean insertar(String nombre, String horas){
        ContentValues valores = new ContentValues();
        valores.put("Nombre", nombre);
        valores.put("Horas", horas);
        try{
            openDataBase();
            db.insert(tabla, null, valores);
            close();
            return true;
        }
        catch(Exception ex){
            close();
            return false;
        }
    }



}
