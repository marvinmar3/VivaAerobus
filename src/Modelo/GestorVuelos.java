/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


/**
 *
 * @author marvin
 */
public class GestorVuelos {
    
   

    
    
    public void guardarVuelo(String origen, String destino, String fechaSalida, String horaSalida, String duracion, double precio) throws SQLException
    {
        String sql= "insert into vuelos(origen, destino, fechaSalida, horaSalida, duracionVuelo, precio) values (?,?,?,?,?,?)";
        
        Conexion conexion = new Conexion();
        
        try(Connection conn= conexion.getConnection(); PreparedStatement stmt=conn.prepareStatement(sql))
        {
            stmt.setString(1, origen);
            stmt.setString(2, destino);
            stmt.setString(3, fechaSalida);
            stmt.setString(4, horaSalida);
            stmt.setString(5, duracion);
            stmt.setDouble(6, precio);
            
            
            stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println("Error al guardar el vuelo:"+ e.getMessage());
            throw e; // propaga la excepcion para que pueda manejarse en otro lugar si es necesario
        }
                
    }
    
    public ResultSet buscarVueloPorID(String idVuelo) throws SQLException
    {
        String sql= "select * from vuelos where id_vuelo = ?";
        
        //obtiene la conexion desde classe conexion
        Conexion conexion = new Conexion(); //instanciar la conexion
        Connection conn = conexion.getConnection();
        
        try
        ( //prepara el statement
                PreparedStatement stmt = conn.prepareStatement(sql) // cierr el preparedstatement
        ) {
            stmt.setString(1, idVuelo);
            return stmt.executeQuery();
        }
        catch(SQLException e)
        {
            System.out.println("Error al buscar el vuelo: "+ e.getMessage());
            throw e;
        }
    }   
}
