
package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormateadorDeFechas {
    public static String convertirFecha(Date fechaOriginal) {
        SimpleDateFormat formatoSalida = new SimpleDateFormat("yyyy-MM-dd");
        return formatoSalida.format(fechaOriginal);
    }
}
