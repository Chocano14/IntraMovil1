package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Material
{
    public int ID;
    public char ARCHIVO;
    public int ASIGNATURA_ID;
    public Material(int id, char archivo, int asignatura_id)
    {
        this.ID= id;
        this.ARCHIVO=archivo;
        this.ASIGNATURA_ID=asignatura_id;
    }
}
