package com.example.hgmovil.intramovil.modelo;

import java.util.Date;

/**
 * Created by pablo on 04-07-2016.
 */
public class Nota {
    public int ID;
    public float NOTA;
    public int PONDERACION;
    public Date FECHA;
    public char ALUMNO_RUT;
    public int SECCION_ID;
    public Nota(int id, float nota,int ponderacion,Date fecha,char alumno_rut,int seccion_id)
    {
        this.ID= id;
        this.NOTA=nota;
        this.PONDERACION=ponderacion;
        this.FECHA=fecha;
        this.ALUMNO_RUT=alumno_rut;
        this.SECCION_ID=seccion_id;
    }
}
