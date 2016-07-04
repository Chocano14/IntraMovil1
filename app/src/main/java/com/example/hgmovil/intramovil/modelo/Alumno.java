package com.example.hgmovil.intramovil.modelo;

/**
 * Created by pablo on 04-07-2016.
 */
public class Alumno
{
    public char Rut ;
    public char Nombre ;
    public char Contraseña ;
    public char Correo ;
    public int CarerraID ;

    public Alumno(char rut, char nombre, char contraseña, char correo, int carreraID)
    {
        this.Rut= rut;
        this.Nombre=nombre;
        this.Contraseña=contraseña;
        this.Correo=correo;
        this.CarerraID=carreraID;
    }


}
