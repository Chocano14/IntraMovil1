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
//import com.example.hgmovil.intramovil.sqlite.Intranet.Horarios_has_sala;
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

        String ID_ALARMA = String.format("REFERENCES %s(%s) ON DELETE CASCADE",
                Tablas.ALARMA, Alarma.ID);

        String Rut = String.format("REFERENCES %s(%s)",
                Tablas.ALUMNO, Alumno.RUT);

        String ID_ALUMNO_HAS_ALARMA = String.format("REFERENCES %s(%s)",
                Tablas.ALUMNO_HAS_ALARMA, Alumno_has_alarma.ID);

        String ID_ALUMNO_HAS_SECCION = String.format("REFERENCES %s(%s)",
                Tablas.ALUMNO_HAS_SECCION , Alumno_has_seccion.ID);

        String ID_ASIGNATURA = String.format("REFERENCES %s(%s)",
                Tablas.ASIGNATURA, Asignatura.ID);

        String ID_ASISTENCIA = String.format("REFERENCES %s(%s)",
                Tablas.ASISTENCIA, Asistencia.ID);

        String ID_CARRERA = String.format("REFERENCES %s(%s)",
                Tablas.CARRERA, Carrera.ID);

        String ID_CARRERA_ASIGNATURA = String.format("REFERENCES %s(%s)",
                Tablas.CARRERA_ASIGNATURA , Carrera_asignatura.ID);

        String ID_CARRERA_JEFECARRERA  = String.format("REFERENCES %s(%s)",
                Tablas.CARRERA_JEFECARRERA ,Carrera_jefecarrera.ID);

        String ID_DIA = String.format("REFERENCES %s(%s)",
                Tablas.DIA ,Dia.ID);

        String ID_DOCENTE  = String.format("REFERENCES %s(%s)",
                Tablas.DOCENTE  ,Docente.ID);

        String ID_HORARIO  = String.format("REFERENCES %s(%s)",
                Tablas.HORARIO  , Horario.ID);

        String ID_HORARIO_SECCION   = String.format("REFERENCES %s(%s)",
                Tablas.HORARIO_SECCION   , Horario_seccion.ID);

        String ID_JEFECARRERA   = String.format("REFERENCES %s(%s)",
                Tablas.JEFECARRERA  , Jefecarrera.ID);

        String ID_MATERIAL   = String.format("REFERENCES %s(%s)",
                Tablas.MATERIAL  , Material.ID);

        String ID_NOTA   = String.format("REFERENCES %s(%s)",
                Tablas.NOTA  , Nota.ID);

        String ID_PAGO = String.format("REFERENCES %s(%s)",
                Tablas.PAGO  , Pago.ID);

        String ID_SALA = String.format("REFERENCES %s(%s)",
                Tablas.SALA  , Sala.ID);

        String ID_SECCION = String.format("REFERENCES %s(%s)",
                Tablas.SECCION  , Seccion.ID);

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
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        "%s VARCHAR(45)  NULL DEFAULT NULL COLLATE NOCASE, %s DATETIME  NULL DEFAULT NULL %s)",
                Tablas.ALARMA, BaseColumns._ID,
                Alarma.ID, Alarma.ASUNTO,
                Alarma.DIA_HORA));
        db.execSQL(String.format("CREATE TABLE %s (%s VARCHAR(10) PRIMARY KEY NOT NULL  COLLATE NOCASE," +
                        "%s VARCHAR(80)  NOT NULL  COLLATE NOCASE %s,%s  VARCHAR(30)  NOT NULL  COLLATE NOCASE %s,%s VARCHAR(45)  NOT NULL  COLLATE NOCASE," +
                        "%s INTEGER NOT NULL,%s REAL NOT NULL,UNIQUE (%s,%s) )",
                Tablas.ALUMNO, BaseColumns._ID,
                Alumno.RUT,Alumno.NOMBRE,Alumno.CONTRASEÑA,Alumno.CORREO,
                Alumno.CARRERA_ID, Referencias.ID_CARRERA));







    }
