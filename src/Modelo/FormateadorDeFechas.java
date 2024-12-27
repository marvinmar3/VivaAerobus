/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormateadorDeFechas {
    public static String convertirFecha(Date fechaOriginal) {
        SimpleDateFormat formatoSalida = new SimpleDateFormat("yyyy-MM-dd");
        return formatoSalida.format(fechaOriginal);
    }
}
