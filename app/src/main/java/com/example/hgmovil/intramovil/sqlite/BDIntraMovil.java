package com.example.hgmovil.intramovil.sqlite;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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
/**
 * Created by pablo on 02-07-2016.
 */

public class BDIntraMovil extends SQLiteOpenHelper
{
    private static final String NOMBRE_BASE_DATOS = "Intra.db";

    private static final int VERSION_ACTUAL = 1;

    private final Context contexto;

    interface Tablas {
        String ALARMA = "alarma";
        String ALUMNO = "alumno";
        String ALUMNO_HAS_ALARMA = "alumno_has_alarma";
        String ALUMNO_HAS_SECCION = "alumno_has_seccion";
        String ASIGNATURA = "asignatura";
        String ASISTENCIA = "asistencia";
        String CARRERA = "carrera";
        String CARRERA_ASIGNATURA = "carrera_asignatura";
        String CARRERA_JEFECARRERA = "carrera_jefecarra";
        String DIA = "dia";
        String DOCENTE = "docente";
        String HORARIO = "horario";
        String HORARIO_SECCION = "horario_seccion";
        //String HORARIOS_HAS_SALA = "horarios_has_sala";
        String JEFECARRERA = "jefecarrera";
        String MATERIAL = "material";
        String NOTA = "nota";
        String PAGO = "pago";
        String SALA = "sala";
        String SECCION = "seccion";
    }
    interface Referencias {


        String ALUMNO_RUT = String.format("REFERENCES %s(%s)",
                Tablas.ALUMNO , Alumno.RUT);

        String ALARMA_ID = String.format("REFERENCES %s(%s)",
                Tablas.ALARMA, Alarma.ID);

        String ALUMNO_HAS_SECCION_ID = String.format("REFERENCES %s(%s)",
                Tablas.ALUMNO_HAS_SECCION, Alumno_has_seccion.ID);

        String CARRERA_ID = String.format("REFERENCES %s(%s)",
                Tablas.CARRERA, Carrera.ID);

        String JEFECARRERA_ID = String.format("REFERENCES %s(%s)",
                Tablas.JEFECARRERA , Jefecarrera.ID);

        String ASIGNATURA_ID  = String.format("REFERENCES %s(%s)",
                Tablas.ASIGNATURA ,Asignatura.ID);

        String SECCION_ID = String.format("REFERENCES %s(%s)",
                Tablas.SECCION ,Seccion.ID);

        String DOCENTE_ID  = String.format("REFERENCES %s(%s)",
                Tablas.DOCENTE  ,Docente.ID);

        String SALA_ID  = String.format("REFERENCES %s(%s)",
                Tablas.SALA  , Sala.ID);

        String DIA_ID   = String.format("REFERENCES %s(%s)",
                Tablas.DIA   , Dia.ID);

        String HORARIO_ID   = String.format("REFERENCES %s(%s)",
                Tablas.HORARIO   , Dia.ID);

    }
    public BDIntraMovil(Context contexto) {
        super(contexto, NOMBRE_BASE_DATOS, null, VERSION_ACTUAL);
        this.contexto = contexto;
    }
    @Override
    public void onOpen(SQLiteDatabase db)
    {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                db.setForeignKeyConstraintsEnabled(true);
            } else {
                db.execSQL("PRAGMA foreign_keys=ON");
            }
        }
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(String.format("CREATE TABLE %s (%s TEXT PRIMARY KEY NOT NULL," +
                        "%s TEXT UNIQUE NOT NULL,%s TEXT NOT NULL,%s TEXT NOT NULL, %s TEXT NOT NULL, " +
                        "%s INTEGER NOT NULL %s)",
                Tablas.ALUMNO, BaseColumns._ID,
                Alumno.RUT, Alumno.NOMBRE, Alumno.CONTRASEÑA, Alumno.CORREO,
                Alumno.CARRERA_ID, Referencias.CARRERA_ID));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "%s INTEGER NOT NULL,%s INTEGER NOT NULL %s, " +
                        "%s INTEGER NOT NULL %s)",
                Tablas.ALUMNO_HAS_ALARMA, BaseColumns._ID,
                Alumno_has_alarma.ID, Alumno_has_alarma.ALARMA_ID, Referencias.ALARMA_ID,
                Alumno_has_alarma.ALUMNO_RUT, Referencias.ALUMNO_RUT));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "%s INTEGER NOT NULL, %s TEXT NOT NULL,%s DATETIME NOT NULL)",
                Tablas.ALARMA, BaseColumns._ID,
                Alarma.ID, Alarma.ASUNTO, Alarma.DIA_HORA));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "%s INTEGER NOT NULL, %s TEXT NOT NULL,%s INTEGER NOT NULL)",
                Tablas.CARRERA, BaseColumns._ID,
                Carrera.ID, Carrera.NOMBRE, Carrera.MONTOANUAL));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "%s INTEGER NOT NULL,%s INTEGER NOT NULL %s, " +
                        "%s INTEGER NOT NULL %s)",
                Tablas.CARRERA_JEFECARRERA, BaseColumns._ID,
                Carrera_jefecarrera.ID, Carrera_jefecarrera.CARRERA_ID, Referencias.CARRERA_ID,
                Carrera_jefecarrera.JEFECARRERA_ID, Referencias.JEFECARRERA_ID));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "%s INTEGER NOT NULL, %s TEXT NOT NULL,%s TEXT NOT NULL)",
                Tablas.JEFECARRERA, BaseColumns._ID,
                Jefecarrera.ID, Jefecarrera.NOMBRE, Jefecarrera.CORREO));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "%s INTEGER NOT NULL,%s INTEGER NOT NULL %s, " +
                        "%s INTEGER NOT NULL %s)",
                Tablas.CARRERA_ASIGNATURA, BaseColumns._ID,
                Carrera_asignatura.ID, Carrera_asignatura.CARRERA_ID, Referencias.CARRERA_ID,
                Carrera_asignatura.ASIGNATURA_ID, Referencias.ASIGNATURA_ID));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "%s INTEGER NOT NULL, %s TEXT NOT NULL,%s INTEGER NOT NULL)",
                Tablas.ASIGNATURA, BaseColumns._ID,
                Asignatura.ID, Asignatura.NOMBRE, Asignatura.HORAS));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "%s INTEGER NOT NULL, %s TEXT NOT NULL,%s INTEGER NOT NULL %s)",
                Tablas.MATERIAL, BaseColumns._ID,
                Material.ID, Material.ARCHIVO, Material.ASIGNATURA_ID, Referencias.ASIGNATURA_ID));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "%s INTEGER NOT NULL, %s INTEGER NOT NULL,%s INTEGER NOT NULL %s, "+
                        "%s INTEGER NOT NULL %S)",
                Tablas.SECCION, BaseColumns._ID,
                Seccion.ID, Seccion.NUMERO, Seccion.DOCENTE_ID, Referencias.DOCENTE_ID,
                Seccion.ASIGNATURA_ID, Referencias.ASIGNATURA_ID));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "%s INTEGER NOT NULL, %s TEXT NOT NULL,%s TEXT NOT NULL)",
                Tablas.DOCENTE, BaseColumns._ID,
                Docente.ID, Docente.NOMBRE, Docente.CORREO));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "%s INTEGER NOT NULL,%s INTEGER NOT NULL %s, " +
                        "%s INTEGER NOT NULL %s, %s INTEGER NOT NULL %s)",
                Tablas.HORARIO_SECCION, BaseColumns._ID,
                Horario_seccion.ID, Horario_seccion.HORARIO_ID, Referencias.HORARIO_ID,
                Horario_seccion.SECCION_ID, Referencias.SECCION_ID, Horario_seccion.SALA_ID, Referencias.SALA_ID));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "%s INTEGER NOT NULL, %s TEXT NOT NULL,%s INTEGER NOT NULL)",
                Tablas.SALA, BaseColumns._ID,
                Sala.ID, Sala.NOMBRE, Sala.PISO));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "%s INTEGER NOT NULL, %s TIME NOT NULL,%s TIME NOT NULL, "+
                        "%s INTEGER NOT NULL %S)",
                Tablas.HORARIO, BaseColumns._ID,
                Horario.ID, Horario.HORAINICIO, Horario.HORAFIN,
                Horario.DIA_ID, Referencias.DIA_ID));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "%s INTEGER NOT NULL, %s TEXT NOT NULL)",
                Tablas.DIA, BaseColumns._ID,
                Dia.ID, Dia.DIA_SEMANA));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "%s INTEGER NOT NULL, %s INTEGER NOT NULL,%s INTEGER NOT NULL %s, "+
                        "%s INTEGER NOT NULL %S)",
                Tablas.ASISTENCIA, BaseColumns._ID,
                Asistencia.ID, Asistencia.HORASASIST, Asistencia.ALUMNO_RUT, Referencias.ALUMNO_RUT,
                Asistencia.ALUMNO_HAS_SECCION_ID, Referencias.ALUMNO_HAS_SECCION_ID));

        db.execSQL(String.format("CREATE TABLE %s (%s TEXT PRIMARY KEY NOT NULL," +
                        "%s INTEGER UNIQUE NOT NULL,%s TEXT NOT NULL,%s DATE NOT NULL, %s TEXT NOT NULL, " +
                        "%s INTEGER NOT NULL, %s INTEGER NOT NULL %s)",
                Tablas.PAGO, BaseColumns._ID,
                Pago.ID, Pago.ESTADO, Pago.FENCHAVENC, Pago.CONCEPTO,
                Pago.MONTO, Pago.ALUMNO_RUT, Referencias.ALUMNO_RUT));

        db.execSQL(String.format("CREATE TABLE %s (%s TEXT PRIMARY KEY NOT NULL," +
                        "%s INTEGER UNIQUE NOT NULL,%s DECIMAL NOT NULL,%s INTEGER NOT NULL, %s DATE NOT NULL, " +
                        "%s INTEGER NOT NULL %s, %s INTEGER NOT NULL %s)",
                Tablas.NOTA, BaseColumns._ID,
                Nota.ID, Nota.NOTA, Nota.PONDERACION, Nota.FECHA,
                Nota.ALUMNO_RUT, Referencias.ALUMNO_RUT, Nota.SECCION_ID, Referencias.SECCION_ID));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "%s INTEGER NOT NULL,%s INTEGER NOT NULL %s, " +
                        "%s INTEGER NOT NULL %s)",
                Tablas.ALUMNO_HAS_SECCION, BaseColumns._ID,
                Alumno_has_seccion.ID, Alumno_has_seccion.SECCION_ID, Referencias.SECCION_ID,
                Alumno_has_seccion.ALUMNO_RUT, Referencias.ALUMNO_RUT));
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Tablas.ALUMNO);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.ALUMNO_HAS_ALARMA);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.ALARMA);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.CARRERA);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.CARRERA_JEFECARRERA);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.JEFECARRERA);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.CARRERA_ASIGNATURA);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.ASIGNATURA);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.MATERIAL);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.SECCION);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.DOCENTE);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.HORARIO_SECCION);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.SALA);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.HORARIO);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.DIA);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.ASISTENCIA);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.PAGO);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.NOTA);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.ALUMNO_HAS_SECCION);

        onCreate(db);
    }
}