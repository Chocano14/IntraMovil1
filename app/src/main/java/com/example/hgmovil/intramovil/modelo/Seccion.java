package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Seccion
{
    public int ID;
    public int NUMERO;
    public int DOCENTE_ID;
    public int ASIGNATURA_ID;
    public Seccion(int id, int numero,int docente_id,int asignatura_id)
    {
        this.ID= id;
        this.NUMERO=numero;
        this.DOCENTE_ID=docente_id;
        this.ASIGNATURA_ID=asignatura_id;
    }
}
