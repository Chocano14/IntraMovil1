package com.example.hgmovil.intramovil.sqlite;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.provider.BaseColumns;
import com.example.hgmovil.intramovil.sqlite.Intranet.Alarma;
import com.example.hgmovil.intramovil.sqlite.Intranet.Alumno;
import com.example.hgmovil.intramovil.sqlite.Intranet.Alumno_has_alarma;
import com.example.hgmovil.intramovil.sqlite.Intranet.Alumno_has_seccion;
import com.example.hgmovil.intramovil.sqlite.Intranet.Asignatura;
import com.example.hgmovil.intramovil.sqlite.Intranet.Asistencia;
import com.example.hgmovil.intramovil.sqlite.Intranet.Carrera;
import com.example.hgmovil.intramovil.sqlite.Intranet.Carrera_asignatura;
import com.example.hgmovil.intramovil.sqlite.Intranet.Carrera_jefecarrera;
import com.example.hgmovil.intramovil.sqlite.Intranet.Dia;
import com.example.hgmovil.intramovil.sqlite.Intranet.Docente;
import com.example.hgmovil.intramovil.sqlite.Intranet.Horario;
import com.example.hgmovil.intramovil.sqlite.Intranet.Horario_seccion;
import com.example.hgmovil.intramovil.sqlite.Intranet.Jefecarrera;
import com.example.hgmovil.intramovil.sqlite.Intranet.Material;
import com.example.hgmovil.intramovil.sqlite.Intranet.Nota;
import com.example.hgmovil.intramovil.sqlite.Intranet.Pago;
import com.example.hgmovil.intramovil.sqlite.Intranet.Sala;
import com.example.hgmovil.intramovil.sqlite.Intranet.Seccion;

import java.io.IOException;

/**
 * Created by pablo on 02-07-2016.
 */

public class BDIntraMovil extends SQLiteOpenHelper
{

    //private static final String DB_NAME = "tesisbd.sqlite";
    private static final int DB_SCHEME_VERSION = 1;
    private static String DB_PATH = "/data/data/com.example.hgmovil.intramovil/databases/";
    private static String DB_NAME = "Intra";
    protected SQLiteDatabase db;
    private final Context context;

    public BDIntraMovil(Context context) {

        super(context, DB_NAME, null, DB_SCHEME_VERSION);
        this.context = context;
        try {
            createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();

        if (dbExist) {
            // Si existe, no haemos nada!
        } else {
            // Llamando a este método se crea la base de datos vacía en la ruta
            // por defecto del sistema de nuestra aplicación por lo que
            // podremos sobreescribirla con nuestra base de datos.
            this.getReadableDatabase();
        }
        try {

            copyDataBase();

        } catch (Exception e) {

            throw new Error("Error copiando database");
        }
    }


    private boolean checkDataBase() {

        SQLiteDatabase checkDB = null;

        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        } catch (SQLiteException e) {
            // Base de datos no creada todavia
        }

        if (checkDB != null) {

            checkDB.close();
        }

        return checkDB != null ? true : false;

    }

    public void openDataBase() throws SQLException {

        // Open the database
        String myPath = DB_PATH + DB_NAME;
        db = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    @Override
    public synchronized void close() {

        if (db != null)
            db.close();

        super.close();
    }

    private void copyDataBase() {

        try{
            openDataBase();

            String CREATE_ALARMA = "CREATE TABLE \"alarma\" (\"Id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL  ,\"Asunto\" VARCHAR(45)  NULL DEFAULT NULL COLLATE NOCASE,\"Dia_Hora\" DATETIME  NULL DEFAULT NULL );";
            db.execSQL(CREATE_ALARMA);

            String CREATE_ALUMNO = "CREATE TABLE \"alumno\" (\"Rut\" VARCHAR(10) PRIMARY KEY NOT NULL  COLLATE NOCASE,\"Nombre\" VARCHAR(80)  NOT NULL  COLLATE NOCASE,\"Contraseña\" VARCHAR(30)  NOT NULL  COLLATE NOCASE,\"Correo\" VARCHAR(45)  NOT NULL  COLLATE NOCASE,\"Carrera_Id\" INT  NOT NULL  ,CONSTRAINT `fk_Alumno_Carrera` FOREIGN KEY (`Carrera_Id`) REFERENCES carrera (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION);";
            db.execSQL(CREATE_ALUMNO);

            String CREATE_ALUMNO_HAS_ALARMA = "CREATE TABLE \"alumno_has_alarma\" (\"Alumno_Rut\" VARCHAR(10)  NOT NULL  COLLATE NOCASE,\"Alarma_Id\" INT  NOT NULL  ,\"Id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL  ,CONSTRAINT `fk_Alumno_has_Alarma_Alarma1` FOREIGN KEY (`Alarma_Id`) REFERENCES alarma (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,CONSTRAINT `fk_Alumno_has_Alarma_Alumno1` FOREIGN KEY (`Alumno_Rut`) REFERENCES alumno (`Rut`) ON DELETE NO ACTION ON UPDATE NO ACTION);";
            db.execSQL(CREATE_ALUMNO_HAS_ALARMA);

            String CREATE_ALUMNO_HAS_SECCION = "CREATE TABLE \"alumno_has_seccion\" (\"Id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL  ,\"Seccion_Id\" INT  NOT NULL  ,\"Alumno_Rut\" VARCHAR(10)  NOT NULL  COLLATE NOCASE,CONSTRAINT `fk_Alumno_has_Seccion_Alumno1` FOREIGN KEY (`Alumno_Rut`) REFERENCES alumno (`Rut`) ON DELETE NO ACTION ON UPDATE NO ACTION,CONSTRAINT `fk_Alumno_has_Seccion_Seccion1` FOREIGN KEY (`Seccion_Id`) REFERENCES seccion (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION);";
            db.execSQL(CREATE_ALUMNO_HAS_SECCION);

            String CREATE_ASIGNATURA = "CREATE TABLE \"asignatura\" (\"Id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL  ,\"Nombre\" VARCHAR(80)  NULL DEFAULT NULL COLLATE NOCASE,\"Horas\" INT  NULL DEFAULT NULL );";
            db.execSQL(CREATE_ASIGNATURA);

            String CREATE_ASISTENCIA = "CREATE TABLE \"asistencia\" (\"Id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL  ,\"HorasAsist\" INT  NULL DEFAULT NULL ,\"Alumno_Rut\" VARCHAR(12)  NOT NULL  COLLATE NOCASE,\"Alumno_has_Seccion_Id\" INT  NOT NULL  ,CONSTRAINT `fk_Asistencia_Alumno1` FOREIGN KEY (`Alumno_Rut`) REFERENCES alumno (`Rut`) ON DELETE NO ACTION ON UPDATE NO ACTION,CONSTRAINT `fk_Asistencia_Alumno_has_Seccion1` FOREIGN KEY (`Alumno_has_Seccion_Id`) REFERENCES alumno_has_seccion (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION);";
            db.execSQL(CREATE_ASISTENCIA);

            String CREATE_CARRERA = "CREATE TABLE \"carrera\" (\"Id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL  ,\"Nombre\" VARCHAR(50)  NULL DEFAULT NULL COLLATE NOCASE,\"MontoAnual\" INT  NULL DEFAULT NULL );";
            db.execSQL(CREATE_CARRERA);

            String CREATE_CARRERA_ASIGNATURA = "CREATE TABLE \"carrera_asignatura\" (\"Carrera_Id\" INT  NOT NULL  ,\"Asignatura_Id\" INT  NOT NULL  ,\"Id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL  ,CONSTRAINT `fk_Carrera_has_Asignatura_Asignatura1` FOREIGN KEY (`Asignatura_Id`) REFERENCES asignatura (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,CONSTRAINT `fk_Carrera_has_Asignatura_Carrera1` FOREIGN KEY (`Carrera_Id`) REFERENCES carrera (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION);";
            db.execSQL(CREATE_CARRERA_ASIGNATURA);

            String CREATE_CARRERA_JEFECARRERA = "CREATE TABLE \"carrera_jefecarrera\" (\"Carrera_Id\" INT  NOT NULL  ,\"JefeCarrera_Id\" INT  NOT NULL  ,\"Id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL  ,CONSTRAINT `fk_Carrera_has_JefeCarrera_Carrera1` FOREIGN KEY (`Carrera_Id`) REFERENCES carrera (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,CONSTRAINT `fk_Carrera_has_JefeCarrera_JefeCarrera1` FOREIGN KEY (`JefeCarrera_Id`) REFERENCES jefecarrera (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION);";
            db.execSQL(CREATE_CARRERA_JEFECARRERA);

            String CREATE_DIA = "CREATE TABLE \"dia\" (\"Id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL  ,\"Dia_Semana\" VARCHAR(9)  NULL DEFAULT NULL COLLATE NOCASE);";
            db.execSQL(CREATE_DIA);

            String CREATE_DOCENTE = "CREATE TABLE \"docente\" (\"Id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL  ,\"Nombre\" VARCHAR(80)  NULL DEFAULT NULL COLLATE NOCASE,\"Correo\" VARCHAR(45)  NULL DEFAULT NULL COLLATE NOCASE);";
            db.execSQL(CREATE_DOCENTE);

            String CREATE_HORARIO = "CREATE TABLE \"horario\" (\"Id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL  ,\"HoraInicio\" TIME  NULL DEFAULT NULL ,\"HoraFin\" TIME  NULL DEFAULT NULL ,\"Dia_Id\" INT  NOT NULL  ,CONSTRAINT `fk_Horario_Dia1` FOREIGN KEY (`Dia_Id`) REFERENCES dia (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION);";
            db.execSQL(CREATE_HORARIO);

            String CREATE_HORARIO_SECCION = "CREATE TABLE \"horario_seccion\" (\"Id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL  ,\"Horario_Id\" INT  NOT NULL  ,\"Seccion_Id\" INT  NOT NULL  ,\"Sala_Id\" INT  NOT NULL  ,CONSTRAINT `fk_Horario_Seccion_Horario1` FOREIGN KEY (`Horario_Id`) REFERENCES horario (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,CONSTRAINT `fk_Horario_Seccion_Sala1` FOREIGN KEY (`Sala_Id`) REFERENCES sala (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,CONSTRAINT `fk_Horario_Seccion_Seccion1` FOREIGN KEY (`Seccion_Id`) REFERENCES seccion (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION);";
            db.execSQL(CREATE_HORARIO_SECCION);

            String CREATE_HORARIOS_HAS_SECCION = "CREATE TABLE \"horarios_has_sala\" (\"Sala_Id\" INT PRIMARY KEY NOT NULL  ,\"Horarios_has_Seccion_Horarios_Id\" INT  NOT NULL  ,\"Horarios_has_Seccion_Seccion_Id\" INT  NOT NULL  ,CONSTRAINT `fk_Horarios_has_Sala_Sala1` FOREIGN KEY (`Sala_Id`) REFERENCES sala (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION);";
            db.execSQL(CREATE_HORARIOS_HAS_SECCION);


            String CREATE_JEFECARRERA = "CREATE TABLE \"jefecarrera\" (\"Id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL  ,\"Nombre\" VARCHAR(80)  NULL DEFAULT NULL COLLATE NOCASE,\"Correo\" VARCHAR(45)  NULL DEFAULT NULL COLLATE NOCASE);";
            db.execSQL(CREATE_JEFECARRERA);

            String CREATE_MATERIAL = "CREATE TABLE \"material\" (\"Id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL  ,\"Archivo\" VARCHAR(45)  NULL DEFAULT NULL COLLATE NOCASE,\"Asignatura_Id\" INT  NOT NULL  ,CONSTRAINT `fk_Materiales_Asignatura1` FOREIGN KEY (`Asignatura_Id`) REFERENCES asignatura (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION);";
            db.execSQL(CREATE_MATERIAL);

            String CREATE_NOTA = "CREATE TABLE \"nota\" (\"Id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL  ,\"Nota\" FLOAT(2,1)  NULL DEFAULT NULL ,\"Ponderacion\" INT  NULL DEFAULT NULL ,\"Fecha\" DATE  NULL DEFAULT NULL ,\"Alumno_Rut\" VARCHAR(12)  NOT NULL  COLLATE NOCASE,\"Seccion_Id\" INT  NOT NULL  ,CONSTRAINT `fk_Notas_Alumno1` FOREIGN KEY (`Alumno_Rut`) REFERENCES alumno (`Rut`) ON DELETE NO ACTION ON UPDATE NO ACTION,CONSTRAINT `fk_Notas_Seccion1` FOREIGN KEY (`Seccion_Id`) REFERENCES seccion (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION);";
            db.execSQL(CREATE_NOTA);

            String CREATE_PAGO = "CREATE TABLE \"pago\" (\"Id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL  ,\"Estado\" VARCHAR(15)  NULL DEFAULT NULL COLLATE NOCASE,\"FechaVenc\" DATE  NULL DEFAULT NULL ,\"Concepto\" VARCHAR(45)  NULL DEFAULT NULL COLLATE NOCASE,\"Monto\" INT  NULL DEFAULT NULL ,\"Alumno_Rut\" VARCHAR(12)  NOT NULL  COLLATE NOCASE,CONSTRAINT `fk_Pagos_Alumno1` FOREIGN KEY (`Alumno_Rut`) REFERENCES alumno (`Rut`) ON DELETE NO ACTION ON UPDATE NO ACTION);";
            db.execSQL(CREATE_PAGO);

            String CREATE_SALA = "CREATE TABLE \"sala\" (\"Id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL  ,\"Nombre\" VARCHAR(45)  NULL DEFAULT NULL COLLATE NOCASE,\"Piso\" INT  NULL DEFAULT NULL );";
            db.execSQL(CREATE_SALA);

            String CREATE_SECCION = "CREATE TABLE \"seccion\" (\"Id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL  ,\"Numero\" INT  NULL DEFAULT NULL ,\"Docente_Id\" INT  NOT NULL  ,\"Asignatura_Id\" INT  NOT NULL  ,CONSTRAINT `fk_Seccion_Asignatura1` FOREIGN KEY (`Asignatura_Id`) REFERENCES asignatura (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,CONSTRAINT `fk_Seccion_Docente1` FOREIGN KEY (`Docente_Id`) REFERENCES docente (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION);";
            db.execSQL(CREATE_SECCION);


            close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}