package com.example.hgmovil.intramovil.modeloDAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.hgmovil.intramovil.sqlite.BDIntraMovil;

import java.util.ArrayList;

/**
 * Created by pablo on 19-12-2016.
 */

public class MateriaDAO extends BDIntraMovil
{
    public MateriaDAO(Context context)
    {
        super(context);
    }

    public ArrayList<String> BuscarASig(String rut){
        ArrayList<String> dev = null;
        String ry = rut;
        try{
            openDataBase();
            dev = new ArrayList<String>();
            String[] campos = {"nombre"};
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
            close();

            return dev;
        }catch(Exception ex){
            close();
            return null;
        }


    }
    public boolean insertarAsig(String nombre, String hora){
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("hora", hora);

/*ContentValues valores  = new ContentValues();
            valores.put("idcliente", cliente.getidCliente());
            valores.put("nombre", cliente.getNombre());
            valores.put("direccion", cliente.getDireccion());
            valores.put("ciudad", cliente.getCiudad());
            valores.put("telefono", cliente.getTelefono());
            long insert_id=this.getWritableDatabase().insert("clientes", null, valores);*/

        try{
            openDataBase();


                db.execSQL("INSERT INTO asignatura  (Nombre, Horas) " +
                        "VALUES (" + nombre + ", '" + hora );
                //db.insert(tabla, null, valores);
                close();
                return true;


        }
        catch(Exception ex){
            close();
            return false;
        }
    }
}


