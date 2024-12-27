
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/Vivaerobus?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Martinez230";
    
    //metodo para obtener la conexion
    public static Connection getConnection()
    {
        try
        {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        }catch(SQLException e)
        {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            return null;
        }
    }
}