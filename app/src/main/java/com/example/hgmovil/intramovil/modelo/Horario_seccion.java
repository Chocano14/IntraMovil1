package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Horario_seccion
{
    public int ID;
    public int HORARIO_ID;
    public int SECCION_ID;
    public int SALA_ID;
    public Horario_seccion(int id, int horario_id, int seccion_id,int sala_id)
    {
        this.ID= id;
        this.HORARIO_ID=horario_id;
        this.SECCION_ID=seccion_id;
        this.SALA_ID=sala_id;
    }
}
