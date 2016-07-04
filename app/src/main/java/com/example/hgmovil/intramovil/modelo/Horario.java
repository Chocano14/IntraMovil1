package com.example.hgmovil.intramovil.modelo;

import java.sql.Time;

/**
 * Created by pablo on 04-07-2016.
 */
public class Horario
{
    public int ID;
    public Time HORAINICIO;
    public Time HORAFIN;
    public int DIA_ID;
    public Horario(int id, Time horainicio,Time horafin, int dia_id)
    {
        this.ID= id;
        this.HORAINICIO=horainicio;
        this.HORAFIN=horafin;
        this.DIA_ID=dia_id;
    }
}
