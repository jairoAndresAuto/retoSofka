package co.com.sura.acelerador.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SumarDias {

    public static LocalDate aFecha(String fecha,int dias){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaIni = LocalDate.parse(fecha, formatter);
        return fechaIni.plusDays(dias);
    }
}
