package com.example.hgmovil.intramovil.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pablo on 19-12-2016.
 */
public class UsuariosSQLiteHelper extends SQLiteOpenHelper {

    //Sentencia SQL para crear la tabla de Usuarios
    String sqlCreate = "CREATE TABLE IF NOT EXISTS \"alumno\" (\"Rut\" VARCHAR(10) PRIMARY KEY NOT NULL  COLLATE NOCASE,\"Nombre\" VARCHAR(80)  NOT NULL  COLLATE NOCASE,\"Contraseña\" VARCHAR(30)  NOT NULL  COLLATE NOCASE,\"Correo\" VARCHAR(45)  NOT NULL  COLLATE NOCASE,\"Carrera_Id\" INT  NOT NULL  ,CONSTRAINT `fk_Alumno_Carrera` FOREIGN KEY (`Carrera_Id`) REFERENCES carrera (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION);\n" +
            "\n" +
            "CREATE INDEX 'fk_Alumno_Carrera_idx' ON 'alumno' (`Carrera_Id` DESC);";

    public UsuariosSQLiteHelper(Context contexto, String nombre,
                                SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior,
                          int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente
        //      la opción de eliminar la tabla anterior y crearla de nuevo
        //      vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la
        //      tabla antigua a la nueva, por lo que este método debería
        //      ser más elaborado.

        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS alumno");

        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreate);
    }
}