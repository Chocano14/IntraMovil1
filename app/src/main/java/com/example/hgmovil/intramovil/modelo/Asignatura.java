package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Asignatura
{
    public int ID;
    public char NOMBRE;
    public int HORAS;
    public Asignatura(int id, char nombre,int horas)
    {
        this.ID= id;
        this.NOMBRE=nombre;
        this.HORAS=horas;
    }
}
