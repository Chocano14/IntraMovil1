package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Asistencia
{
    public int ID;
    public int HORASASIST;
    public char ALUMNO_RUT;
    public int ALUMNO_HAS_SECCION_ID;
    public Asistencia(int id, int horasasit, char alumno_rut,int alumno_has_seccion_id)
    {
        this.ID= id;
        this.HORASASIST=horasasit;
        this.ALUMNO_RUT=alumno_rut;
        this.ALUMNO_HAS_SECCION_ID=alumno_has_seccion_id;
    }
}
