package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Alumno_has_seccion
{
    public int ID;
    public int SECCION_ID;
    public char ALUMNO_RUT;
    public Alumno_has_seccion(int id, int seccion_id, char alumno_rut)
    {
        this.ID= id;
        this.SECCION_ID=seccion_id;
        this.ALUMNO_RUT=alumno_rut;
    }
}
