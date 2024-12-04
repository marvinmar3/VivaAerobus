
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    Connection con;

    public static void main(String[] args) {
        Conexion cn = new Conexion();
        if(cn.getConnection() != null)
        {
            System.out.println("Conexion con bd exitosa");
        }
        else
        {
            System.out.println("Conexion fallida");
        }
    }
    public Connection getConnection()
    {
        try{
            String myBD= "jdbc:mysql://localhost:3306/Vivaerobus?serverTimezone=UTC";
            con=DriverManager.getConnection(myBD, "root","Martinez230");
        } catch (SQLException e)
        {
            System.out.println("Error al conectar a la base de datos:"+ e.getMessage());
        }
        return con;
    }  
}