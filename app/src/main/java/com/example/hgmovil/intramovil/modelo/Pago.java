package com.example.hgmovil.intramovil.modelo;

import java.util.Date;

/**
 * Created by pablo on 04-07-2016.
 */
public class Pago
{
    public int ID;
    public char ESTADO;
    public Date FENCHAVENC;
    public char CONCEPTO;
    public int MONTO;
    public char ALUMNO_RUT;
    public Pago (int id, char estado, Date fenchavenc,char concepto,int monto,char alumno_rut)
    {
        this.ID= id;
        this.ESTADO=estado;
        this.FENCHAVENC=fenchavenc;
        this.CONCEPTO=concepto;
        this.MONTO=monto;
        this.ALUMNO_RUT=alumno_rut;
    }

}
