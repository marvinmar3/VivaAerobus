/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author marvin
 */
public class FormateadorDeFechas {
    public static String convertirFecha(String fechaOriginal) throws ParseException
    {
        SimpleDateFormat formatoOriginal=new SimpleDateFormat("dd MMM yyyy");
        
        SimpleDateFormat formatoDeseado= new SimpleDateFormat("yyyy-MM-dd");
        
        Date fecha = formatoOriginal.parse(fechaOriginal);
        
        return formatoDeseado.format(fecha);
    }
    
}
