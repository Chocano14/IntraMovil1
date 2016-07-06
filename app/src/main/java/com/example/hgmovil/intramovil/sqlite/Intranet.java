package com.example.hgmovil.intramovil.sqlite;
import java.util.Date;
import java.util.UUID;

/**
 * Created by pablo on 02-07-2016.
 */
public class Intranet
{
    interface ColumnasAlarma {
        String ID = "id";
        String ASUNTO = "Asunto";
        String DIA_HORA= "Dia_Hora";

    }
    interface ColumnasAlumno {
        String RUT = "Rut";
        String NOMBRE = "Nombre";
        String CONTRASEÑA = "Contraseña";
        String CORREO = "Correo";
        String CARRERA_ID ="Carrera_Id";
    }
    interface ColumnasAlumno_has_alarma {
        String ALUMNO_RUT = "Alumno_Rut";
        String ALARMA_ID = "Alarma_Id";
        String ID = "Id";
    }
    interface ColumnasAlumno_has_seccion {
        String ID = "Id";
        String SECCION_ID = "Seccion_Id";
        String ALUMNO_RUT = "Alumno_Rut";
    }
    interface ColumnasAsignatura {
        String ID = "Id";
        String NOMBRE = "Nombre";
        String HORAS = "Horas";
    }
    interface ColumnasAsistencia
    {
    String ID = "Id";
    String HORASASIST = "HorasAsist";
    String ALUMNO_RUT = "Alumno_rut";
    String ALUMNO_HAS_SECCION_ID = "Alunmo_has_Seccion_Id";
    }
    interface ColumnasCarrera {
        String ID = "Id";
        String NOMBRE = "Nombre";
        String MONTOANUAL = "MontoAnual";
    }
    interface ColumnasCarrera_asignatura {
        String CARRERA_ID = "Carrera_Id";
        String ASIGNATURA_ID = "Asignatura_Id";
        String ID = "Id";
    }
    interface ColumnasCarrera_jefecarrera {
        String CARRERA_ID = "Carrera_Id";
        String JEFECARRERA_ID = "JefeCarrera_ID";
        String ID = "Id";
    }
    interface ColumnasDia {
        String ID = "id";
        String DIA_SEMANA = "Dia_Semana";
    }
    interface ColumnasDocente {
        String ID = "Id";
        String NOMBRE = "Nombre";
        String CORREO = "Correo";
    }
    interface ColumnasHorario {
        String ID = "Id";
        String HORAINICIO = "HoraInicio";
        String HORAFIN = "HoraFin";
        String DIA_ID = "Dia_Id";
    }
    interface ColumnasHorario_seccion {
        String ID = "Id";
        String HORARIO_ID = "Horario_Id";
        String SECCION_ID = "Seccion_Id";
        String SALA_ID = "Sala_Id";
    }

    interface ColumnasJefecarrera {
        String ID = "Id";
        String NOMBRE = "Nombre";
        String CORREO = "Correo";
    }
    interface ColumnasMaterial {
        String ID = "Id";
        String ARCHIVO = "Archivo";
        String ASIGNATURA_ID = "Asignatura";
    }
    interface ColumnasNota {
        String ID = "Id";
        String NOTA = "Nota";
        String PONDERACION = "Ponderacion";
        String FECHA = "Fecha";
        String ALUMNO_RUT = "Alumno_Rut";
        String SECCION_ID = "Seccion_Id";
    }
    interface ColumnasPago {
        String ID = "Id";
        String ESTADO = "Estado";
        String FENCHAVENC = "FechaVenc";
        String CONCEPTO = "Concepto";
        String MONTO = "Monto";
        String ALUMNO_RUT= "Alumno_Rut";

    }
    interface ColumnasSala {
        String ID = "Id";
        String NOMBRE = "Nombre";
        String PISO = "Piso";
    }
    interface ColumnasSeccion {
        String ID = "Id";
        String NUMERO = "Numero";
        String DOCENTE_ID = "Docente_Id";
        String ASIGNATURA_ID = "Asignatura_Id";
    }
    public static class Alarma implements ColumnasAlarma
    {
        public static String generarIdAlarma()
        {
            return "Alar" + UUID.randomUUID().toString();
        }
    }
    public static class Alumno implements ColumnasAlumno
    {
        public static String generarIdAlumno()
        {
            return "Alum" + UUID.randomUUID().toString();
        }
    }
    public static class Alumno_has_alarma implements ColumnasAlumno_has_alarma
    {
        public static String generarIdAlumno_has_alarma()
        {
            return "Alum-alar" + UUID.randomUUID().toString();
        }
    }
    public static class Alumno_has_seccion implements ColumnasAlumno_has_seccion
    {
        public static String generarIdAlumno_has_seccion()
        {
            return "Alum-secc" + UUID.randomUUID().toString();
        }
    }

    public static class Asignatura implements ColumnasAsignatura
    {
        public static String generarIdAsignatura()
        {
            return "Asig" + UUID.randomUUID().toString();
        }
    }
    public static class Asistencia implements ColumnasAsistencia
    {
        public static String generarIdAsistencia()
        {
            return "Asist" + UUID.randomUUID().toString();
        }
    }
    public static class Carrera implements ColumnasCarrera
    {
        public static String generarIdCarrera()
        {
            return "Carrera" + UUID.randomUUID().toString();
        }
    }
    public static class Carrera_asignatura implements ColumnasCarrera_asignatura
    {
        public static String generarIdCarrera_asignatura()
        {
            return "Car_Asig" + UUID.randomUUID().toString();
        }
    }
    public static class Carrera_jefecarrera implements ColumnasCarrera_jefecarrera
    {
        public static String generarIdCarrera_jefecarrera()
        {
            return "Car_JefCarr" + UUID.randomUUID().toString();
        }
    }
    public static class Dia implements ColumnasDia
    {
        public static String generarIdDia()
        {
            return "Dia" + UUID.randomUUID().toString();
        }
    }
    public static class Docente implements ColumnasDocente
    {
        public static String generarIdDocente()
        {
            return "Docen" + UUID.randomUUID().toString();
        }
    }
    public static class Horario implements ColumnasHorario
    {
        public static String generarIdHorario()
        {
            return "Horar" + UUID.randomUUID().toString();
        }
    }
    public static class Horario_seccion implements ColumnasHorario_seccion
    {
        public static String generarIdHorario_seccion()
        {
            return "Horar-sec" + UUID.randomUUID().toString();
        }
    }

    public static class Jefecarrera implements ColumnasJefecarrera
    {
        public static String generarIdJefecarrera()
        {
            return "Jefcar" + UUID.randomUUID().toString();
        }
    }
    public static class Material implements ColumnasMaterial
    {
        public static String generarIdMaterial()
        {
            return "Mater" + UUID.randomUUID().toString();
        }
    }
    public static class Nota implements ColumnasNota
    {
        public static String generarIdNota()
        {
            return "Not" + UUID.randomUUID().toString();
        }
    }
    public static class Pago implements ColumnasPago
    {
        public static String generarIdPago()
        {
            return "Pag-" + UUID.randomUUID().toString();
        }
    }
    public static class Sala implements ColumnasSala
    {
        public static String generarIdSala()
        {
            return "Sal-" + UUID.randomUUID().toString();
        }
    }
    public static class Seccion implements ColumnasSeccion
    {
        public static String generarIdSeccion()
        {
            return "Secc-" + UUID.randomUUID().toString();
        }
    }
    private Intranet() {
    }
}
